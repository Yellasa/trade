package com.liantuo.trade.orm.service;

import java.util.List;

import com.liantuo.trade.orm.pojo.TradeWithdrawErrorinfo;
import com.liantuo.trade.orm.pojo.TradeWithdrawErrorinfoExample;

public interface TradeWithdrawErrorinfoService {

    List<TradeWithdrawErrorinfo> query(TradeWithdrawErrorinfoExample example);
    
    List<TradeWithdrawErrorinfo> queryBy(String payChannel, String channelNo, String errorCode);
    
}
