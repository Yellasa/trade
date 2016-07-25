package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeWithdrawLog;
import com.liantuo.trade.orm.pojo.TradeWithdrawLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeWithdrawLogMapper {
    int insert(TradeWithdrawLog record);

    int insertSelective(TradeWithdrawLog record);

    List<TradeWithdrawLog> selectByExample(TradeWithdrawLogExample example);

    TradeWithdrawLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeWithdrawLog record, @Param("example") TradeWithdrawLogExample example);

    int updateByExample(@Param("record") TradeWithdrawLog record, @Param("example") TradeWithdrawLogExample example);

    int updateByPrimaryKeySelective(TradeWithdrawLog record);

    int updateByPrimaryKey(TradeWithdrawLog record);
}