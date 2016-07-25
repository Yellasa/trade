package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLog;
import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLogExample;
import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeNotifyPaymentLogMapper {
    int insert(TradeNotifyPaymentLogWithBLOBs record);

    int insertSelective(TradeNotifyPaymentLogWithBLOBs record);

    List<TradeNotifyPaymentLogWithBLOBs> selectByExampleWithBLOBs(TradeNotifyPaymentLogExample example);

    List<TradeNotifyPaymentLog> selectByExample(TradeNotifyPaymentLogExample example);

    TradeNotifyPaymentLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeNotifyPaymentLogWithBLOBs record, @Param("example") TradeNotifyPaymentLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeNotifyPaymentLogWithBLOBs record, @Param("example") TradeNotifyPaymentLogExample example);

    int updateByExample(@Param("record") TradeNotifyPaymentLog record, @Param("example") TradeNotifyPaymentLogExample example);

    int updateByPrimaryKeySelective(TradeNotifyPaymentLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TradeNotifyPaymentLogWithBLOBs record);

    int updateByPrimaryKey(TradeNotifyPaymentLog record);
}