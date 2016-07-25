package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeOutPaymentLog;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogExample;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOutPaymentLogMapper {
    int insert(TradeOutPaymentLogWithBLOBs record);

    int insertSelective(TradeOutPaymentLogWithBLOBs record);

    List<TradeOutPaymentLogWithBLOBs> selectByExampleWithBLOBs(TradeOutPaymentLogExample example);

    List<TradeOutPaymentLog> selectByExample(TradeOutPaymentLogExample example);

    TradeOutPaymentLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeOutPaymentLogWithBLOBs record, @Param("example") TradeOutPaymentLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeOutPaymentLogWithBLOBs record, @Param("example") TradeOutPaymentLogExample example);

    int updateByExample(@Param("record") TradeOutPaymentLog record, @Param("example") TradeOutPaymentLogExample example);

    int updateByPrimaryKeySelective(TradeOutPaymentLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TradeOutPaymentLogWithBLOBs record);

    int updateByPrimaryKey(TradeOutPaymentLog record);
}