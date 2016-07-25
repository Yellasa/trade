package com.liantuo.trade.seqno;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IdTable
{

	private static final Log log;
	private DataSource dataSource;
	private String tableName;
	private String idColName;
	private String typeColName;
	private String rangeColName;
	private String _insert;
	private String _update;
	private String _update1;
	private String _select;

	public IdTable()
	{
	}

	public void setTableName(String tname)
	{
		tableName = tname;
	}

	public void setIdColName(String idName)
	{
		idColName = idName;
	}

	public void setTypeColName(String typeName)
	{
		typeColName = typeName;
	}

	public void setRangeColName(String rangeName)
	{
		rangeColName = rangeName;
	}

	public void setDataSource(DataSource src)
	{
		dataSource = src;
	}

	public void init()
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			String sql = "create table " + tableName + "(" + typeColName + " char(2) not null, " + (rangeColName == null ? "" : rangeColName + " char(10) not null, ") + idColName + " bigint, primary key(" + typeColName + (rangeColName == null ? "" : ", " + rangeColName) + "))";
			stmt.execute(sql);
			stmt.close();
		}
		catch (SQLException sqle)
		{
			System.out.println(sqle);
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch (Exception e) { }
		}
	}

	public Connection getConnection()
		throws SQLException
	{
		return dataSource.getConnection();
	}

	public long doSelect(Connection conn, String type, String range)
		throws SQLException
	{
		if (range != null && rangeColName == null)
			throw new IllegalArgumentException("you must define rangeColName.");
		if (range == null && rangeColName != null)
			throw new IllegalArgumentException("you must input range value.");
		long result = -1L;
		PreparedStatement qps = conn.prepareStatement(getSelectSql());
		try
		{
			qps.setString(1, type);
			if (range != null)
				qps.setString(2, range);
			ResultSet rs = qps.executeQuery();
			if (rs.next())
				result = rs.getLong(1);
			rs.close();
		}
		catch (SQLException sqle)
		{
			log.error("could not read a id value!", sqle);
			throw sqle;
		}
		finally
		{
			qps.close();
		}
		return result;
	}

	public void doInsert(Connection conn, String type, String range, long start)
		throws SQLException
	{
		if (range != null && rangeColName == null)
			throw new IllegalArgumentException("you must define rangeColName.");
		if (range == null && rangeColName != null)
			throw new IllegalArgumentException("you must input range value.");
		PreparedStatement ups = conn.prepareStatement(getInsertSql());
		try
		{
			ups.setString(1, type);
			ups.setLong(2, start);
			if (range != null)
				ups.setString(3, range);
			int rows = ups.executeUpdate();
			if (rows != 1)
				throw new SQLException("IdTable insert fail.");
		}
		catch (SQLException sqle)
		{
			log.error("could not insert id value for initialize!", sqle);
			throw sqle;
		}
		finally
		{
			ups.close();
		}
	}

	public int doUpdate(Connection conn, String type, String range, long seq, int count)
		throws SQLException
	{
		if (range != null && rangeColName == null)
			throw new IllegalArgumentException("you must define rangeColName.");
		if (range == null && rangeColName != null)
			throw new IllegalArgumentException("you must input range value.");
//		System.out.println(getUpdateSql());
		PreparedStatement ups = conn.prepareStatement(getUpdateSql());
		try
		{
			long next = seq + (long)count;
			if (next < 0L)
				next = 0L;
			ups.setLong(1, next);
			ups.setString(2, type);
			ups.setLong(3, seq);
			if (range != null)
				ups.setString(4, range);
//			System.out.println("next="+next);
//			System.out.println("type="+type);
//			System.out.println("seq="+seq);
//			System.out.println("range="+range);
			int i = ups.executeUpdate();
			return i;
		}
		catch (SQLException sqle)
		{
			log.error("could not update id value!", sqle);
			throw sqle;
		}
		finally
		{
			ups.close();
		}
	}

	public int doUpdate(Connection conn, String type, String range, int count)
		throws SQLException
	{
		if (range != null && rangeColName == null)
			throw new IllegalArgumentException("you must define rangeColName.");
		if (range == null && rangeColName != null)
			throw new IllegalArgumentException("you must input range value.");
		PreparedStatement ups = conn.prepareStatement(getUpdateSql1());
		try
		{
			ups.setLong(1, count);
			ups.setString(2, type);
			if (range != null)
				ups.setString(3, range);
			int i = ups.executeUpdate();
			return i;
		}
		catch (SQLException sqle)
		{
			log.error("could not update id value!", sqle);
			throw sqle;
		}
		finally
		{
			ups.close();
		}
	}

	private String getSelectSql()
	{
		if (_select == null)
			_select = "select " + idColName + " from " + tableName + " where " + typeColName + "=?" + (rangeColName == null ? "" : " and " + rangeColName + "=?");
		return _select;
	}

	private String getUpdateSql()
	{
		if (_update == null)
			_update = "update " + tableName + " set " + idColName + "=? where " + typeColName + "=? and " + idColName + "=?" + (rangeColName == null ? "" : " and " + rangeColName + "=?");
		return _update;
	}

	private String getUpdateSql1()
	{
		if (_update1 == null)
			_update1 = "update " + tableName + " set " + idColName + "=" + idColName + "+? where " + typeColName + "=?" + (rangeColName == null ? "" : " and " + rangeColName + "=?");
		return _update1;
	}

	private String getInsertSql()
	{
		if (_insert == null)
			_insert = "insert into " + tableName + " (" + typeColName + "," + idColName + (rangeColName == null ? "" : "," + rangeColName) + ") values (?,?" + (rangeColName == null ? "" : ",?") + ")";
		return _insert;
	}

	static 
	{
		log = LogFactory.getLog(IdTable.class);
	}
}
