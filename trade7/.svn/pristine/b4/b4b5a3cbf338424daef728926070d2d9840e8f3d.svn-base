package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeTransferAccount;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeTransferAccountMapper {
    long insert(TradeTransferAccount record);

    int insertSelective(TradeTransferAccount record);
    
    int selectCountByExample(TradeTransferAccountExample example);
    
    List<TradeTransferAccount> pageQueryByExample(TradeTransferAccountExample example);

    List<TradeTransferAccount> selectByExample(TradeTransferAccountExample example);

    TradeTransferAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeTransferAccount record, @Param("example") TradeTransferAccountExample example);

    int updateByExample(@Param("record") TradeTransferAccount record, @Param("example") TradeTransferAccountExample example);

    int updateByPrimaryKeySelective(TradeTransferAccount record);

    int updateByPrimaryKey(TradeTransferAccount record);

	int updateByKeyVersionSelective(TradeTransferAccount item);
}