package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedgerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeProfitLossLedgerMapper {
    int insert(TradeProfitLossLedger record);

    Long insertSelective(TradeProfitLossLedger record);

    List<TradeProfitLossLedger> selectByExample(TradeProfitLossLedgerExample example);

    TradeProfitLossLedger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeProfitLossLedger record, @Param("example") TradeProfitLossLedgerExample example);

    int updateByExample(@Param("record") TradeProfitLossLedger record, @Param("example") TradeProfitLossLedgerExample example);

    int updateByPrimaryKeySelective(TradeProfitLossLedger record);

    int updateByPrimaryKey(TradeProfitLossLedger record);
    
    /**
     * 根据版本号更新
     * @param record
     * @return
     */
    int updateByKeyVersionSelective(TradeProfitLossLedger record);
}