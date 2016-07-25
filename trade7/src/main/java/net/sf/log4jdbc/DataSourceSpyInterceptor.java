package net.sf.log4jdbc;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.mysql.jdbc.Connection;

public class DataSourceSpyInterceptor implements MethodInterceptor {

	/**
     * rdbmsSpecifics
    */
    private RdbmsSpecifics rdbmsSpecifics = null;
	
    /**
     * 取得 rdbmsSpecifics
     * 
     * @param conn
     *            jdbc链接
     * @return
     */
    private RdbmsSpecifics getRdbmsSpecifics(Connection conn) {  
        if(rdbmsSpecifics == null) {  
            rdbmsSpecifics = DriverSpy.getRdbmsSpecifics(conn);
        }  
        return rdbmsSpecifics;  
    }
    
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		 Object result = invocation.proceed();  
	        if(SpyLogFactory.getSpyLogDelegator().isJdbcLoggingEnabled()) {  
	            if(result instanceof Connection) {  
	                Connection conn = (Connection)result;  
	                return new ConnectionSpy(conn,getRdbmsSpecifics(conn));  
	            }  
	        }  
	        return result;  
	    }  
}
