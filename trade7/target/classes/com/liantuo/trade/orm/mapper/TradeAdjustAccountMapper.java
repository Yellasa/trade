package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeAdjustAccountMapper {
    int insert(TradeAdjustAccount record);

    int insertSelective(TradeAdjustAccount record);

    List<TradeAdjustAccount> selectByExample(TradeAdjustAccountExample example);

    TradeAdjustAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeAdjustAccount record, @Param("example") TradeAdjustAccountExample example);

    int updateByExample(@Param("record") TradeAdjustAccount record, @Param("example") TradeAdjustAccountExample example);

    int updateByPrimaryKeySelective(TradeAdjustAccount record);

    int updateByPrimaryKey(TradeAdjustAccount record);
    
    /**
     * 根据版本号更新
     * @param record
     * @return
     */
    int updateByKeyVersionSelective(TradeAdjustAccount record);
    
    /**
     * 查询总条数
     * @param example
     * @return
     */
    int selectCountByExample(TradeAdjustAccountExample example);
}