package com.liantuo.trade.orm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeWithdrawErrorinfoMapper;
import com.liantuo.trade.orm.pojo.TradeWithdrawErrorinfo;
import com.liantuo.trade.orm.pojo.TradeWithdrawErrorinfoExample;
import com.liantuo.trade.orm.service.TradeWithdrawErrorinfoService;

@Service(value = "tradeWithdrawErrorinfoService")
public class TradeWithdrawErrorinfoServiceImpl implements TradeWithdrawErrorinfoService{

    @Resource
    private TradeWithdrawErrorinfoMapper tradeWithdrawErrorinfoMapper;
    
    @Override
    public List<TradeWithdrawErrorinfo> query(TradeWithdrawErrorinfoExample example) {
        return tradeWithdrawErrorinfoMapper.selectByExample(example);
    }

    public List<TradeWithdrawErrorinfo> queryBy(String payChannel, String channelNo, String errorCode){
        TradeWithdrawErrorinfoExample query = new TradeWithdrawErrorinfoExample();
        query.createCriteria().andPayChannelEqualTo(payChannel)
            .andChannelNoEqualTo(channelNo).andErrorCodeEqualTo(errorCode);
        return query(query);
    }
    
}
