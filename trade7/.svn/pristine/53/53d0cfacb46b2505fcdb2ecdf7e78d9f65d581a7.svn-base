package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundLog;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeSinglePaymentRefundLogMapper {
//    int insert(TradeSinglePaymentRefundLog record);

    int insertSelective(TradeSinglePaymentRefundLog record);

    List<TradeSinglePaymentRefundLog> selectByExample(TradeSinglePaymentRefundLogExample example);

    TradeSinglePaymentRefundLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeSinglePaymentRefundLog record, @Param("example") TradeSinglePaymentRefundLogExample example);

//    int updateByExample(@Param("record") TradeSinglePaymentRefundLog record, @Param("example") TradeSinglePaymentRefundLogExample example);

    int updateByPrimaryKeySelective(TradeSinglePaymentRefundLog record);

//    int updateByPrimaryKey(TradeSinglePaymentRefundLog record);
}