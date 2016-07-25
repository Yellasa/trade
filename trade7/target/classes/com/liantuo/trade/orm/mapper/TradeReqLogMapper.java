package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeReqLog;
import com.liantuo.trade.orm.pojo.TradeReqLogExample;
import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeReqLogMapper {
    int insert(TradeReqLogWithBLOBs record);

    int insertSelective(TradeReqLogWithBLOBs record);

    List<TradeReqLogWithBLOBs> selectByExampleWithBLOBs(TradeReqLogExample example);

    List<TradeReqLog> selectByExample(TradeReqLogExample example);

    TradeReqLogWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TradeReqLogWithBLOBs record, @Param("example") TradeReqLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TradeReqLogWithBLOBs record, @Param("example") TradeReqLogExample example);

    int updateByExample(@Param("record") TradeReqLog record, @Param("example") TradeReqLogExample example);

    int updateByPrimaryKeySelective(TradeReqLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TradeReqLogWithBLOBs record);

    int updateByPrimaryKey(TradeReqLog record);
}