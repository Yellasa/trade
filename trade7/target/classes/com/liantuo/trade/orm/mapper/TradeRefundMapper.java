package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.pojo.TradeRefundExample;

import java.util.List;

public interface TradeRefundMapper {
//    int insert(TradeRefund record);

    List<TradeRefund> pageQueryByExample(TradeRefundExample example);

    int insertSelective(TradeRefund record);

    List<TradeRefund> selectByExample(TradeRefundExample example);
    
    int selectCountByExample(TradeRefundExample example);

    TradeRefund selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") TradeRefund record, @Param("example") TradeRefundExample example);

//    int updateByExample(@Param("record") TradeRefund record, @Param("example") TradeRefundExample example);

    int updateByPrimaryKeySelective(TradeRefund record);

//    int updateByPrimaryKey(TradeRefund record);
}