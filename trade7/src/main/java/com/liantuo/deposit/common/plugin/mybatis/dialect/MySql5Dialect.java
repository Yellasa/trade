package com.liantuo.deposit.common.plugin.mybatis.dialect;

public class MySql5Dialect extends Dialect
{

    protected static final String SQL_END_DELIMITER = ";";

    public String getLimitString(String sql, boolean hasOffset)
    {
        return MySql5PageUtil.getLimitString(sql, -1, -1);
    }

    public String getLimitString(String sql, int offset, int limit)
    {
        return MySql5PageUtil.getLimitString(sql, offset, limit);
    }

    public boolean supportsLimit()
    {
        return true;
    }
}
