package com.liantuo.trade.orm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;

public interface TradeSinglePaymentMapper {
//    int insert(TradeSinglePayment record);

    int insertSelective(TradeSinglePayment record);

    List<TradeSinglePayment> selectByExample(TradeSinglePaymentExample example);

    TradeSinglePayment selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") TradeSinglePayment record, @Param("example") TradeSinglePaymentExample example);
//
//    int updateByExample(@Param("record") TradeSinglePayment record, @Param("example") TradeSinglePaymentExample example);
//
//    int updateByPrimaryKeySelective(TradeSinglePayment record);
//
//    int updateByPrimaryKey(TradeSinglePayment record);
    
    /**
     * 根据版本号做更新
     * @param record
     * @return
     */
    int updateByKeyVersionSelective(TradeSinglePayment record);
    /**
     * @Title:pageQueryByExample 
     * @Description: 分页查询 
     * @param example 查询条件
     * @return
     * @return:List<TradeRecharge>
     * @author:zoran.huang
     * @date:2016年6月2日 下午4:11:10
     */
    List<TradeRecharge> pageQueryByExample(TradeSinglePaymentExample example);
    /**
     * @Title:selectCountByExample 
     * @Description: 根据查询条件获取总条数
     * @param example 查询条件
     * @return
     * @return:int
     * @author:zoran.huang
     * @date:2016年6月2日 下午4:11:53
     */
    int selectCountByExample(TradeSinglePaymentExample example);
}