package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeLedgerLog;
import com.liantuo.trade.orm.pojo.TradeLedgerLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeLedgerLogMapper {
    int insert(TradeLedgerLog record);

    int insertSelective(TradeLedgerLog record);

    List<TradeLedgerLog> selectByExample(TradeLedgerLogExample example);

    TradeLedgerLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeLedgerLog record, @Param("example") TradeLedgerLogExample example);

    int updateByExample(@Param("record") TradeLedgerLog record, @Param("example") TradeLedgerLogExample example);

    int updateByPrimaryKeySelective(TradeLedgerLog record);

    int updateByPrimaryKey(TradeLedgerLog record);
}