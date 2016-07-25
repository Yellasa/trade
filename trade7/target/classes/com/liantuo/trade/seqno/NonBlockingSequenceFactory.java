package com.liantuo.trade.seqno;

import java.sql.Connection;

public class NonBlockingSequenceFactory extends AbstractSequenceFactory
{
	
	
	public NonBlockingSequenceFactory()
	{
	}

	protected synchronized long internalGenerate(String range, int count) throws Exception
	{
			Connection conn = table.getConnection();
			try
			{
				long result = -1L;
				int rows = 0;
				do
				{
					
					result = table.doSelect(conn, type, range);
					if (result == -1L)
					{
						result = 0L;
						table.doInsert(conn, type, range, result);
					}
					rows = table.doUpdate(conn, type, range, result, count);
				} while (rows == 0);
				return result;
//				long l = result + 1L;
//				return l;
			}
			finally
			{
				conn.close();
			}
		
	}

}
