package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeAdjustAccountLog;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeAdjustAccountLogMapper {
    int insert(TradeAdjustAccountLog record);

    int insertSelective(TradeAdjustAccountLog record);

    List<TradeAdjustAccountLog> selectByExample(TradeAdjustAccountLogExample example);

    TradeAdjustAccountLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeAdjustAccountLog record, @Param("example") TradeAdjustAccountLogExample example);

    int updateByExample(@Param("record") TradeAdjustAccountLog record, @Param("example") TradeAdjustAccountLogExample example);

    int updateByPrimaryKeySelective(TradeAdjustAccountLog record);

    int updateByPrimaryKey(TradeAdjustAccountLog record);
}