package com.liantuo.trade.bus.service.impl;

import com.liantuo.trade.bus.service.RechargeService;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import com.liantuo.trade.orm.pojo.TradeRechargeLog;
import com.liantuo.trade.orm.service.TradeRechargeLogService;
import com.liantuo.trade.orm.service.TradeRechargeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component(value = "rechargeServiceImpl")
public class RechargeServiceImpl implements RechargeService {
    /*private Logger logger = Logger.getLogger(RechargeServiceImpl.class);*/
    @Resource
    private TradeRechargeService tradeRechargeService;
    @Resource
    private TradeRechargeLogService tradeRechargeLogService;

    @Override
    public TradeRecharge createTradeForPayOfWait(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.createTradeForPayOfWait(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    @Override
    public TradeRecharge updateForEnterOfWait(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.updateForEnterOfWait(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    @Override
    public TradeRecharge createTradeFailureRecode(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.createTradeFailureRecode(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    @Override
    public TradeRecharge updateTradeSuccess(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.updateTradeSuccess(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    @Override
    public TradeRecharge updateTradeFail(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.updateTradeFail(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    @Override
    public TradeRecharge createForEnterOfWait(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.createForEnterOfWait(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    /**
     * 创建历史的交易记录
     *
     * @param tradeRecharge
     * @Title:createTradeRechargeHistory
     * @Description:创建历史的交易记录
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午2:48:10
     */
    private TradeRecharge createTradeRechargeHistory(TradeRecharge tradeRecharge) {
        TradeRechargeLog log = new TradeRechargeLog();
        TradeRechargeExample example = new TradeRechargeExample();
        example.createCriteria().andTradeNoEqualTo(tradeRecharge.getTradeNo());
        TradeRecharge newTradeRecharge = tradeRechargeService.queryByExample(example).get(0);
        BeanUtils.copyProperties(newTradeRecharge, log);
//		logger.info("插入交易记录："+ObjectXmlUtil.marshal(log));
        log.setId(null);
        log.setLatestTradeReqType(tradeRecharge.getLatestTradeReqType());
        newTradeRecharge.setLatestTradeReqType(tradeRecharge.getLatestTradeReqType());
        tradeRechargeLogService.insertTradeRechargeLog(log);
        return newTradeRecharge;
    }

    @Override
    public List<TradeRecharge> queryBy(TradeRecharge querytradeRecharge) throws Exception {
        TradeRechargeExample tradeRechargeExample = new TradeRechargeExample();
        tradeRechargeExample.createCriteria().andFundPoolNoEqualTo(querytradeRecharge.getFundPoolNo()).andOutTradeNoExtEqualTo(querytradeRecharge.getOutTradeNoExt());
        List<TradeRecharge> list = tradeRechargeService.queryByExample(tradeRechargeExample);
        return list;
    }

    @Override
    public TradeRecharge createTradeFail(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.createTradeFailureRecode(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }

    @Override
    public List<TradeRecharge> queryByExample(TradeRechargeExample example) {
        return tradeRechargeService.queryByExample(example);
    }

    @Override
    public TradeRecharge updateForPayOfWait(TradeRecharge tradeRecharge)
            throws Exception {
        tradeRechargeService.updateForPayOfWait(tradeRecharge);
        tradeRecharge = createTradeRechargeHistory(tradeRecharge);
        return tradeRecharge;
    }
}