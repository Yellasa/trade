package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.pojo.TradePaymentLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePaymentLogMapper {
    int insert(TradePaymentLog record);

    int insertSelective(TradePaymentLog record);

    List<TradePaymentLog> selectByExample(TradePaymentLogExample example);

    TradePaymentLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradePaymentLog record, @Param("example") TradePaymentLogExample example);

    int updateByExample(@Param("record") TradePaymentLog record, @Param("example") TradePaymentLogExample example);

    int updateByPrimaryKeySelective(TradePaymentLog record);

    int updateByPrimaryKey(TradePaymentLog record);
}