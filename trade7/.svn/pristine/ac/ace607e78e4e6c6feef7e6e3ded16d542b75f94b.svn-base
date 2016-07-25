package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeLedgerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeLedgerMapper {
    int insert(TradeLedger record);

    /**
     * 创建生效台账
     * @param record
     * @return
     */
    int insertSelective(TradeLedger record);
    
    /**
     * 创建空白台账
     * @param record
     * @return
     */
    int insertSelectiveBlank(TradeLedger record);

    List<TradeLedger> selectByExample(TradeLedgerExample example);

    TradeLedger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeLedger record, @Param("example") TradeLedgerExample example);

    int updateByExample(@Param("record") TradeLedger record, @Param("example") TradeLedgerExample example);

    int updateByPrimaryKeySelective(TradeLedger record);

    int updateByPrimaryKey(TradeLedger record);
}