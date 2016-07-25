package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeTransferAccountLog;
import com.liantuo.trade.orm.pojo.TradeTransferAccountLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeTransferAccountLogMapper {
    int insert(TradeTransferAccountLog record);

    int insertSelective(TradeTransferAccountLog record);

    List<TradeTransferAccountLog> selectByExample(TradeTransferAccountLogExample example);

    TradeTransferAccountLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransferAccountLog record, @Param("example") TradeTransferAccountLogExample example);

    int updateByExample(@Param("record") TradeTransferAccountLog record, @Param("example") TradeTransferAccountLogExample example);

    int updateByPrimaryKeySelective(TradeTransferAccountLog record);

    int updateByPrimaryKey(TradeTransferAccountLog record);
}