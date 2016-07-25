package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeServiceInfo;
import com.liantuo.trade.orm.pojo.TradeServiceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeServiceInfoMapper {
    int insert(TradeServiceInfo record);

    int insertSelective(TradeServiceInfo record);

    List<TradeServiceInfo> selectByExample(TradeServiceInfoExample example);

    TradeServiceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeServiceInfo record, @Param("example") TradeServiceInfoExample example);

    int updateByExample(@Param("record") TradeServiceInfo record, @Param("example") TradeServiceInfoExample example);

    int updateByPrimaryKeySelective(TradeServiceInfo record);

    int updateByPrimaryKey(TradeServiceInfo record);
}