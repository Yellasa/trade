package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeOutFrontLog;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogExample;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOutFrontLogMapper {
    int insert(TradeOutFrontLogWithBLOBs record);

    int insertSelective(TradeOutFrontLogWithBLOBs record);

    List<TradeOutFrontLogWithBLOBs> selectByExampleWithBLOBs(TradeOutFrontLogExample example);

    List<TradeOutFrontLog> selectByExample(TradeOutFrontLogExample example);

    TradeOutFrontLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeOutFrontLogWithBLOBs record, @Param("example") TradeOutFrontLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeOutFrontLogWithBLOBs record, @Param("example") TradeOutFrontLogExample example);

    int updateByExample(@Param("record") TradeOutFrontLog record, @Param("example") TradeOutFrontLogExample example);

    int updateByPrimaryKeySelective(TradeOutFrontLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TradeOutFrontLogWithBLOBs record);

    int updateByPrimaryKey(TradeOutFrontLog record);
}