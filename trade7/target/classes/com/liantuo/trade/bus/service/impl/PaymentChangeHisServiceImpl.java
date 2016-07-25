package com.liantuo.trade.bus.service.impl;

import com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1.GenMerchantFreezeProcess;
import com.liantuo.trade.bus.service.TradeChangeHisService;
import com.liantuo.trade.bus.vo.TradePaymentBizVO;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.service.TradePaymentLogService;
import com.liantuo.trade.orm.service.TradePaymentService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "paymentChangeHisServiceImpl")
public class PaymentChangeHisServiceImpl implements TradeChangeHisService<TradePaymentBizVO> {
	private final Log LOGGER = LogFactory.getLog(GenMerchantFreezeProcess.class);
	
	@Resource(name = "tradePaymentLogService")
    private TradePaymentLogService tradePaymentLogService;
	
	@Resource
    private TradePaymentService tradePaymentService;

    @Override
    public void create(TradePaymentBizVO trade){
        TradePaymentLog his = new TradePaymentLog();
        //为了插入version的变更所以需要重新查询交易
        TradePayment tradePayment = getTradePayment(trade.getPayment());
        trade.setPayment(tradePayment);
        BeanUtils.copyProperties(tradePayment, his);
        his.setId(null);
        tradePaymentLogService.insertTradePaymentLog(his);
    }
    
    /**
     * @param pay
     * @return
     */
    private TradePayment getTradePayment(TradePayment pay){
         return tradePaymentService.selectByPrimaryKey(pay.getId());
    }
}
