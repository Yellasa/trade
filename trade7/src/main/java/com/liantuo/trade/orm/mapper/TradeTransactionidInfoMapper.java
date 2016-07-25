package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeTransactionidInfo;
import com.liantuo.trade.orm.pojo.TradeTransactionidInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeTransactionidInfoMapper {
    int insert(TradeTransactionidInfo record);

    int insertSelective(TradeTransactionidInfo record);

    List<TradeTransactionidInfo> selectByExample(TradeTransactionidInfoExample example);

    TradeTransactionidInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransactionidInfo record, @Param("example") TradeTransactionidInfoExample example);

    int updateByExample(@Param("record") TradeTransactionidInfo record, @Param("example") TradeTransactionidInfoExample example);

    int updateByPrimaryKeySelective(TradeTransactionidInfo record);

    int updateByPrimaryKey(TradeTransactionidInfo record);
}