package com.liantuo.deposit.advanceaccount.orm.mapper;

import java.util.List;

import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountAccountRecord;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisPageQueryInnerVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisPageQueryVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisQueryVo;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccountTradeHistory;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord;

public interface CreditAccountTradeHistoryMapper {

    int insert(CreditAccountTradeHistory record);

    CreditAccountTradeHistory selectByPrimaryKey(Integer id);
    
    /**
     * 外部系统使用的单账户账务历史查询接口（完全版本）
     * @param reqVo
     * @return
     */
    List<SingleAccountAccountingRecord> selectSingleAccountHisPageQuery(SingleAccountHisPageQueryVo reqVo);
    
    Integer selectCountSingleAccountHis(SingleAccountHisPageQueryVo requVo);
    
    /**
     * 内部系统使用的单账户账务历史查询接口（完全版本）
     * @param reqVo
     * @return
     */
    List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> selectSingleInnerCAHisPageQuery(SingleAccountHisPageQueryInnerVo reqVo);
    
    Integer selectCountSingleInnerCAHis(SingleAccountHisPageQueryInnerVo requVo);

	/**
	 * 外部系统使用的单账户账务历史查询接口（标准版本）
	 * @param queryVo
	 * @return
	 */
	List<SingleAccountAccountRecord> singleAccountHisPageQueryStand(SingleAccountHisQueryVo queryVo);

	Integer countSingleAccountHisQueryStand(SingleAccountHisQueryVo queryVo);

}