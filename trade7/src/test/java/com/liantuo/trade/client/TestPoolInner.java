package com.liantuo.trade.client;

import org.junit.Assert;
import org.junit.Test;

import com.liantuo.deposit.innerclient.advanceaccount.vo.req.HttpConfig;
import com.liantuo.deposit.innerclient.advanceaccount.vo.req.PoolQueryInnerReq;
import com.liantuo.deposit.innerclient.advanceaccount.vo.rsp.PoolQueryInnerRsp;
import com.liantuo.deposit.innerclient.pool.PoolClient;
import com.payment.util.JsonUtil;

public class TestPoolInner {
	@Test
	public void testPoolInnerQuery() {
		try {
			PoolQueryInnerReq req = new PoolQueryInnerReq();
			PoolQueryInnerRsp rsp = new PoolQueryInnerRsp();
			req.setCoreMerchantNo("DC_C3878585775");
			req.setPoolNo("PN01000000000010429");
			//req.setShowCount("");
			//req.setCurrentPage("010");
			HttpConfig httpConfig = new HttpConfig();
			httpConfig.setHost("http://192.168.19.63:8000/");
			httpConfig.setConnectionTimeout(100000);
			httpConfig.setSoTimeout(200000);
			httpConfig.setCharset("UTF-8");
			long start=System.currentTimeMillis();
			rsp =  PoolClient.poolQuery(req, httpConfig);
			System.out.println("调用接口消耗【"+(System.currentTimeMillis()-start)+"】");
			Assert.assertEquals("S", rsp.getSuccess());
			String result=JsonUtil.object2String(rsp);
			System.out.println("resultjason="+result);
			System.out.println("查出条数："+rsp.getList().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
