package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeRechargeMapper {
    int insert(TradeRecharge record);

    int insertSelective(TradeRecharge record);

    List<TradeRecharge> selectByExampleWithBLOBs(TradeRechargeExample example);

    List<TradeRecharge> selectByExample(TradeRechargeExample example);

    List<TradeRecharge> pageQueryByExample(TradeRechargeExample example);
    
    TradeRecharge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeRecharge record, @Param("example") TradeRechargeExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeRecharge record, @Param("example") TradeRechargeExample example);

    int updateByExample(@Param("record") TradeRecharge record, @Param("example") TradeRechargeExample example);

    int updateByPrimaryKeySelective(TradeRecharge record);

    int updateByPrimaryKeyWithBLOBs(TradeRecharge record);

    int updateByPrimaryKey(TradeRecharge record);
    
    int selectCountByExample(TradeRechargeExample example);
    
    /**
     * 根据版本号做更新
     * @param record
     * @return
     */
    int updateByKeyVersionSelective(TradeRecharge record);
    
    
}