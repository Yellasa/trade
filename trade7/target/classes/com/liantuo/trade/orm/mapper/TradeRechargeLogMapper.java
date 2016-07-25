package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeRechargeLog;
import com.liantuo.trade.orm.pojo.TradeRechargeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeRechargeLogMapper {
    int insert(TradeRechargeLog record);

    int insertSelective(TradeRechargeLog record);

    List<TradeRechargeLog> selectByExampleWithBLOBs(TradeRechargeLogExample example);

    List<TradeRechargeLog> selectByExample(TradeRechargeLogExample example);

    TradeRechargeLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeRechargeLog record, @Param("example") TradeRechargeLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeRechargeLog record, @Param("example") TradeRechargeLogExample example);

    int updateByExample(@Param("record") TradeRechargeLog record, @Param("example") TradeRechargeLogExample example);

    int updateByPrimaryKeySelective(TradeRechargeLog record);

    int updateByPrimaryKeyWithBLOBs(TradeRechargeLog record);

    int updateByPrimaryKey(TradeRechargeLog record);
}