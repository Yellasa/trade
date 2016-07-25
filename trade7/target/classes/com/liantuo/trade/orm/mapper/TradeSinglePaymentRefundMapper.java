package com.liantuo.trade.orm.mapper;

import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefund;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentRefundExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TradeSinglePaymentRefundMapper {
//    int insert(TradeSinglePaymentRefund record);

    int insertSelective(TradeSinglePaymentRefund record);

    List<TradeSinglePaymentRefund> selectByExample(TradeSinglePaymentRefundExample example);

    TradeSinglePaymentRefund selectByPrimaryKey(Long id);

//    int updateByExampleSelective(@Param("record") TradeSinglePaymentRefund record, @Param("example") TradeSinglePaymentRefundExample example);
//
//    int updateByExample(@Param("record") TradeSinglePaymentRefund record, @Param("example") TradeSinglePaymentRefundExample example);
//
//    int updateByPrimaryKeySelective(TradeSinglePaymentRefund record);
//
//    int updateByPrimaryKey(TradeSinglePaymentRefund record);
    /**
     * 根据版本号做更新
     * @param record
     * @return
     */
    int updateByKeyVersionSelective(TradeSinglePaymentRefund record);
    /**
     * @Title:pageQueryByExample 
     * @Description: 分页查询 
     * @param example 查询条件
     * @return
     * @return:List<TradeRecharge>
     * @author:zoran.huang
     * @date:2016年6月2日 下午4:11:10
     */
    List<TradeRecharge> pageQueryByExample(TradeSinglePaymentRefundExample example);
    /**
     * @Title:selectCountByExample 
     * @Description: 根据查询条件获取总条数
     * @param example 查询条件
     * @return
     * @return:int
     * @author:zoran.huang
     * @date:2016年6月2日 下午4:11:53
     */
    int selectCountByExample(TradeSinglePaymentRefundExample example);
}