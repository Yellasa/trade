/**
 * 
 */
package com.liantuo.trade.orm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeServiceInfoMapper;
import com.liantuo.trade.orm.pojo.TradeServiceInfo;
import com.liantuo.trade.orm.pojo.TradeServiceInfoExample;
import com.liantuo.trade.orm.service.TradeServiceInfoService;

/**
 * @ClassName:     TradeServiceInfoServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2015-12-16 下午12:19:16 
 */
@Service(value = "tradeServiceInfo")
public class TradeServiceInfoServiceImpl implements TradeServiceInfoService {

	private final Log LOG4J = LogFactory.getLog("trade");
	@Resource
	private TradeServiceInfoMapper tradeServiceInfoMapper;
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.service.TradeServiceInfoService#queryExample(java.lang.String)
	 */
	@Override
    public TradeServiceInfo queryExample(String request_code) throws Exception
    {
		TradeServiceInfoExample tradeServiceInfoExample = new TradeServiceInfoExample();
		tradeServiceInfoExample.createCriteria().andTradeTypeEqualTo(request_code);
		List<TradeServiceInfo> list = tradeServiceInfoMapper.selectByExample(tradeServiceInfoExample);
        if (list.size() > 0)
            return list.get(0);
        return null;
    }
	
	
}
