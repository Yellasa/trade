package com.liantuo.deposit.common.plugin.mybatis.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySql5PageUtil
{
    /**
     * 得到查询总数的sql
     */
    public static String getCountString(String querySelect)
    {

        querySelect = getLineSql(querySelect);
        int orderIndex = getLastOrderInsertPoint(querySelect);

        int formIndex = getAfterFormInsertPoint(querySelect);
        String select = querySelect.substring(0, formIndex);

        // 如果SELECT 中包含 DISTINCT 只能在外层包含COUNT
        if (select.toLowerCase().indexOf(" distinct ") != -1 || querySelect.toLowerCase().indexOf("group by") != -1)
        {
            return new StringBuffer(querySelect.length()).append("select count(1) count from (").append(querySelect.substring(0, orderIndex)).append(" ) t").toString();
        }
        else
        {
            return new StringBuffer(querySelect.length()).append("select count(1) count ").append(querySelect.substring(formIndex, orderIndex)).toString();
        }
    }

    /**
     * 得到最后一个Order By的插入点位置
     * 
     * @return 返回最后一个Order By插入点的位置
     */
    private static int getLastOrderInsertPoint(String querySelect)
    {
        int orderIndex = querySelect.toLowerCase().lastIndexOf("order by");
        if (orderIndex == -1 || !isBracketCanPartnership(querySelect.substring(orderIndex, querySelect.length())))
        {
            throw new RuntimeException("My SQL 分页必须要有Order by 语句!");
        }
        return orderIndex;
    }

    /**
     * 得到分页的SQL
     * 
     * @param offset
     *            偏移量
     * @param limit
     *            位置
     * @return 分页SQL
     */
    public static String getLimitString(String querySelect, int offset, int limit)
    {
        StringBuffer sb = new StringBuffer(querySelect);
        return sb.append(" limit ").append(offset + "").append(" ," + limit).toString();
    }

    /**
     * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
     * 
     * @param sql
     *            SQL语句
     * @return 如果sql是NULL返回空，否则返回转化后的SQL
     */
    private static String getLineSql(String sql)
    {
        return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
    }

    /**
     * 得到SQL第一个正确的FROM的的插入点
     */
    private static int getAfterFormInsertPoint(String querySelect)
    {
        String regex = "\\s+FROM\\s+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(querySelect);
        while (matcher.find())
        {
            int fromStartIndex = matcher.start(0);
            String text = querySelect.substring(0, fromStartIndex);
            if (isBracketCanPartnership(text))
            {
                return fromStartIndex;
            }
        }
        return 0;
    }

    /**
     * 判断括号"()"是否匹配,并不会判断排列顺序是否正确
     * 
     * @param text
     *            要判断的文本
     * @return 如果匹配返回TRUE,否则返回FALSE
     */
    private static boolean isBracketCanPartnership(String text)
    {
        if (text == null || (getIndexOfCount(text, '(') != getIndexOfCount(text, ')')))
        {
            return false;
        }
        return true;
    }

    /**
     * 得到一个字符在另一个字符串中出现的次数
     * 
     * @param text
     *            文本
     * @param ch
     *            字符
     */
    private static int getIndexOfCount(String text, char ch)
    {
        int count = 0;
        for (int i = 0; i < text.length(); i++)
        {
            count = (text.charAt(i) == ch) ? count + 1 : count;
        }
        return count;
    }
    
    public static void main(String[] args)
    {
        String sql = "SELECT f.*,daf.third_account_no FROM ( "+
           "SELECT th.id as id,th.credit_account_id,th.income,th.payout,th.balance,th.credit_line,th.rmk,th.gmt_created,th.created_cn,th.trade_id,"+
        "th.trade_type,th.applicant_agency_id,th.sequence_no,th.super_agency_code_name,th.super_agency_name,th.owner_code_name,th.owner_name,"+
       " th.mode_track,th.pnr,th.flight_info,th.superior_open_id,th.deposit_record_no,th.trade_no,th.trade_step_no,th.third_trade_no,th.pay_no,"+
        "th.organization_no,th.core_merchant_no,th.merchant_no,th.pool_no,th.wallet_no,th.subject_no,th.creator_no,th.modifier_no,th.modifier_cn,"+
        "th.trade_amt,ca.account_no,th.data_flag,th.pay_mark,th.gmt_modified,th.biz_type FROM credit_account_trade_history th,"+
        "credit_account ca "+
        " WHERE  th.superior_open_id=?"+
    "and th.credit_account_id= ca.id"+
       " and ca.account_type=0"+
   " and th.trade_type<100 order by th.id DESC) f LEFT OUTER JOIN dep_account_fund daf ON f.account_no=daf.account_no;";
        String sqlHead = sql.substring(0, sql.indexOf("(") + 1);
        String sqlTail = sql.substring(sql.indexOf(")"));
        sql = sql.substring(sql.indexOf("(")+1, sql.lastIndexOf(")"));
        
        System.err.println(sql);
        System.err.println(sqlHead);
        System.err.println(sqlTail);
        int orderIndex = MySql5PageUtil.getLastOrderInsertPoint(sql);
        System.err.println(orderIndex);
        
    }
}
