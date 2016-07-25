package com.liantuo.deposit.common.plugin.mybatis;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebill.framework.datatype.ReflectUtil;
import com.ebill.framework.datatype.StringUtil;
import com.liantuo.deposit.common.plugin.mybatis.dialect.Dialect;
import com.liantuo.deposit.common.plugin.mybatis.dialect.MySql5Dialect;
import com.liantuo.deposit.common.plugin.mybatis.dialect.MySql5PageUtil;
import com.liantuo.deposit.common.plugin.mybatis.vo.Page;
/** 
 * 
 * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。 
 * 利用拦截器实现Mybatis分页的原理： 
 * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句 
 * 是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。在Mybatis中Statement语句是通过RoutingStatementHandler对象的 
 * prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用 
 * StatementHandler对象的prepare方法，即调用invocation.proceed()。 
 * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设 
 * 置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。 
 * 
 */  

@Intercepts(
{ @Signature(type = StatementHandler.class, method = "prepare", args =
{ Connection.class }) })
public class PagePlugin implements Interceptor
{

    private static final Logger LOGGER = LoggerFactory.getLogger(PagePlugin.class);
    private  String dialect = ""; // 数据库方言
    private static String pageSqlId = ""; // mapper.xml中需要拦截的ID(正则匹配)

    public Object intercept(Invocation ivk) throws Throwable
    {
        if (ivk.getTarget() instanceof RoutingStatementHandler)
        {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectUtil.getValueByFieldName(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getValueByFieldName(delegate, "mappedStatement");

            if (mappedStatement.getId().matches(pageSqlId))
            { // 拦截需要分页的SQL
                BoundSql boundSql = delegate.getBoundSql();
                Object parameterObject = boundSql.getParameterObject();// 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
                if (parameterObject == null)
                {
                    throw new NullPointerException("parameterObject尚未实例化！");
                }
                else
                {
                    Dialect.Type databaseType = null;
                    try
                    {
                        databaseType = Dialect.Type.valueOf(dialect.toUpperCase());
                    }
                    catch (Exception e)
                    {
                        // ignore
                    }
                    if (databaseType == null)
                    {
                        throw new RuntimeException("the value of the dialect property in configuration is not defined : " + dialect);
                    }
                    Dialect dialect = null;
                    switch (databaseType)
                    {// 不同的数据库的方言处理类
                        case MYSQL:
                            dialect = new MySql5Dialect();
                    }
                    Connection connection = (Connection) ivk.getArgs()[0];
                    String sql = boundSql.getSql();
                    String sqlHead = "";
                    String sqlTail = "";
                    String sqlBody = "";
                    if(mappedStatement.getId().indexOf("listPageByTradeHistory") != -1) {
                        sqlHead = sql.substring(0, sql.indexOf("(") + 1);
                        sqlTail = sql.substring(sql.lastIndexOf(")"));
                        sql = sql.substring(sql.indexOf("(") + 1, sql.lastIndexOf(")"));
                    }
                    
                    // String countSql = "select count(0) from (" + sql+
                    // ") as tmp_count"; //记录统计
                    String countSql = MySql5PageUtil.getCountString(sql);// 记录统计
                    PreparedStatement countStmt = connection.prepareStatement(countSql);
                    BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                    setParameters(countStmt, mappedStatement, countBS, parameterObject);
                    ResultSet rs = countStmt.executeQuery();
                    int count = 0;
                    if (rs.next())
                    {
                        count = rs.getInt(1);
                    }
                    rs.close();
                    countStmt.close();
                    // System.out.println(count);
                    Page page = null;
                    if (parameterObject instanceof Page)
                    { // 参数就是Page实体
                        page = (Page) parameterObject;
                        page.setEntityOrField(true); // 见com.liantuo.ebill.entity.Page.entityOrField
                        // 注释
                        page.setTotalResult(count);
                    }
                    else if (parameterObject instanceof Map)
                    {
                        // 参数为Map
                        Map para = (Map) parameterObject;
                        Object o = para.get("page");
                        if (o == null)
                        {
                            page = new Page();
                            page.setEntityOrField(false); // 见com.liantuo.ebill.entity.Page.entityOrField
                            // 注释
                            // ReflectHelper.setValueByFieldName(parameterObject,"page",
                            // page); //通过反射，对实体对象设置分页对象
                            para.put("page", page);
                        }
                        else if (o instanceof Page)
                        {
                            page = (Page) o;
                        }
                        else
                        {
                            throw new NoSuchFieldException(parameterObject.getClass().getName() + "Key值为page的属性类型不正确！");
                        }
                    }
                    else
                    { // 参数为某个实体，该实体拥有Page属性
                        Field pageField = ReflectUtil.getFieldByFieldName(parameterObject, "page");
                        if (pageField != null)
                        {
                            page = (Page) ReflectUtil.getValueByFieldName(parameterObject, "page");
                            if (page == null)
                                page = new Page();
                            page.setEntityOrField(false); // 见com.liantuo.ebill.entity.Page.entityOrField
                            // 注释
                            ReflectUtil.setValueByFieldName(parameterObject, "page", page); // 通过反射，对实体对象设置分页对象
                        }
                        else
                        {
                            throw new NoSuchFieldException(parameterObject.getClass().getName() + "不存在 page 属性！");
                        }
                    }
                    page.setTotalResult(count);
                   String pageSql = dialect.getLimitString(sql, page.getCurrentResult(), page.getShowCount());
//                    String pageSql = dialect.getLimitString(sql, page.getCurrentResult(), page.getEndIndex());
                    if(mappedStatement.getId().indexOf("PageQuery") != -1) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(sqlHead);
                        sb.append(pageSql);
                        sb.append(sqlTail);
                        pageSql = sb.toString();
                    }
                    ReflectUtil.setValueByFieldName(boundSql, "sql", pageSql); // 将分页sql语句反射回BoundSql.
                }
            }
        }
        return ivk.proceed();
    }

    /**
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.
     * DefaultParameterHandler
     * 
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException
    {
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings != null)
        {
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++)
            {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT)
                {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null)
                    {
                        value = null;
                    }
                    else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass()))
                    {
                        value = parameterObject;
                    }
                    else if (boundSql.hasAdditionalParameter(propertyName))
                    {
                        value = boundSql.getAdditionalParameter(propertyName);
                        // } else if
                        // (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)&&
                        // boundSql.hasAdditionalParameter(prop.getName())) {
                    }
                    else if (propertyName.startsWith("__frch_") && boundSql.hasAdditionalParameter(prop.getName()))
                    {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null)
                        {
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
                        }
                    }
                    else
                    {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null)
                    {
                        throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName + " of statement " + mappedStatement.getId());
                    }
                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
                }
            }
        }
    }

    public Object plugin(Object arg0)
    {
        // TODO Auto-generated method stub
        return Plugin.wrap(arg0, this);
    }

    @Override
    public void setProperties(Properties p)
    {
        dialect = p.getProperty("dialect");
        if (StringUtil.isEmpty(dialect))
        {
            try
            {
                throw new PropertyException("dialect property is not found!");
            }
            catch (PropertyException e)
            {
                LOGGER.error(e.getMessage(), e);
            }
        }
        pageSqlId = p.getProperty("pageSqlId");
        if (StringUtil.isEmpty(pageSqlId))
        {
            try
            {
                throw new PropertyException("pageSqlId property is not found!");
            }
            catch (PropertyException e)
            {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

}
