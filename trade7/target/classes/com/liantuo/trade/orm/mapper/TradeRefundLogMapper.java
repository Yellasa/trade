package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeRefundLog;
import com.liantuo.trade.orm.pojo.TradeRefundLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeRefundLogMapper {
    int insert(TradeRefundLog record);

    int insertSelective(TradeRefundLog record);

    List<TradeRefundLog> selectByExample(TradeRefundLogExample example);

    TradeRefundLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeRefundLog record, @Param("example") TradeRefundLogExample example);

    int updateByExample(@Param("record") TradeRefundLog record, @Param("example") TradeRefundLogExample example);

    int updateByPrimaryKeySelective(TradeRefundLog record);

    int updateByPrimaryKey(TradeRefundLog record);
}