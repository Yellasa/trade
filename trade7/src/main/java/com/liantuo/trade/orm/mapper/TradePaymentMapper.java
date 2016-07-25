package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;

import java.util.List;

public interface TradePaymentMapper {
    int insertSelective(TradePayment record);

    List<TradePayment> selectByExample(TradePaymentExample example);

    List<TradePayment> pageQueryByExample(TradePaymentExample example);

    TradePayment selectByPrimaryKey(Long id);

    int selectCountByExample(TradePaymentExample example);

    /**
     * 根据版本号做更新
     *
     * @param record
     * @return
     */
    int updateByKeyVersionSelective(TradePayment record);
}