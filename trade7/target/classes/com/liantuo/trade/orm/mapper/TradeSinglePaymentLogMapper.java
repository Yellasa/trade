package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeSinglePaymentLog;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeSinglePaymentLogMapper {
//    int insert(TradeSinglePaymentLog record);

    int insertSelective(TradeSinglePaymentLog record);

    List<TradeSinglePaymentLog> selectByExample(TradeSinglePaymentLogExample example);

    TradeSinglePaymentLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeSinglePaymentLog record, @Param("example") TradeSinglePaymentLogExample example);

//    int updateByExample(@Param("record") TradeSinglePaymentLog record, @Param("example") TradeSinglePaymentLogExample example);

    int updateByPrimaryKeySelective(TradeSinglePaymentLog record);

//    int updateByPrimaryKey(TradeSinglePaymentLog record);
}