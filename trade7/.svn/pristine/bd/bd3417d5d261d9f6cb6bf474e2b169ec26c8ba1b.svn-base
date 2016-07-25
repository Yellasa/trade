package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeProfitLossLedgerLog;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedgerLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeProfitLossLedgerLogMapper {
    int insert(TradeProfitLossLedgerLog record);

    int insertSelective(TradeProfitLossLedgerLog record);

    List<TradeProfitLossLedgerLog> selectByExample(TradeProfitLossLedgerLogExample example);

    TradeProfitLossLedgerLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeProfitLossLedgerLog record, @Param("example") TradeProfitLossLedgerLogExample example);

    int updateByExample(@Param("record") TradeProfitLossLedgerLog record, @Param("example") TradeProfitLossLedgerLogExample example);

    int updateByPrimaryKeySelective(TradeProfitLossLedgerLog record);

    int updateByPrimaryKey(TradeProfitLossLedgerLog record);
}