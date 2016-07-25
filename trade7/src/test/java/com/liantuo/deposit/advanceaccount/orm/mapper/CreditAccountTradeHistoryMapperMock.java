package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;





import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountAccountRecord;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisPageQueryInnerVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisPageQueryVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisQueryVo;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccountTradeHistory;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord;
import com.liantuo.unittest.mockito.IsTClass;

public class CreditAccountTradeHistoryMapperMock {
   public static void mockInsert(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(1).when(creditAccountTradeHistoryMapper).insert(argThat(new IsTClass<CreditAccountTradeHistory>(new CreditAccountTradeHistory())));
   }
   public static void mockInsertException(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(0).when(creditAccountTradeHistoryMapper).insert(argThat(new IsTClass<CreditAccountTradeHistory>(new CreditAccountTradeHistory())));  
   }
   public static void mockSelectByPrimaryKey(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper,CreditAccountTradeHistory cath){
	 doReturn(cath).when(creditAccountTradeHistoryMapper).selectByPrimaryKey(cath.getId());
   }
   public static void mockSelectByPrimaryKeyException(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doThrow(new RuntimeException()).when(creditAccountTradeHistoryMapper).selectByPrimaryKey(argThat(new IsTClass<Integer>(1)));
   }
   public static void mockSingleAccountHisPageQueryStand(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper,List<SingleAccountAccountRecord> list){
	 doReturn(list).when(creditAccountTradeHistoryMapper).singleAccountHisPageQueryStand(argThat(new IsTClass<SingleAccountHisQueryVo>(new SingleAccountHisQueryVo())));
   }
   public static void mockSingleAccountHisPageQueryStandException(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doThrow(new RuntimeException()).when(creditAccountTradeHistoryMapper).singleAccountHisPageQueryStand(argThat(new IsTClass<SingleAccountHisQueryVo>(new SingleAccountHisQueryVo())));
   }
   public static void mockCountSingleAccountHisQuery(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(1).when(creditAccountTradeHistoryMapper).countSingleAccountHisQueryStand(argThat(new IsTClass<SingleAccountHisQueryVo>(new SingleAccountHisQueryVo())));
   }
   public static void mockCountSingleAccountHisQueryNoCount(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(0).when(creditAccountTradeHistoryMapper).countSingleAccountHisQueryStand(argThat(new IsTClass<SingleAccountHisQueryVo>(new SingleAccountHisQueryVo())));
   }
   public static void mockSingleAccountHisPageQuery(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper,List<SingleAccountAccountingRecord> list){
	 doReturn(list).when(creditAccountTradeHistoryMapper).selectSingleAccountHisPageQuery(argThat(new IsTClass<SingleAccountHisPageQueryVo>(new SingleAccountHisPageQueryVo())));
   }
   public static void mockSingleAccountHisPageQueryNoResult(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(null).when(creditAccountTradeHistoryMapper).selectSingleAccountHisPageQuery(argThat(new IsTClass<SingleAccountHisPageQueryVo>(new SingleAccountHisPageQueryVo())));
   }
   public static void mockSelectCountSingleAccountHis(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(1).when(creditAccountTradeHistoryMapper).selectCountSingleAccountHis(argThat(new IsTClass<SingleAccountHisPageQueryVo>(new SingleAccountHisPageQueryVo())));
   }
   public static void mockSelectCountSingleInnerCAHis(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper){
	 doReturn(1).when(creditAccountTradeHistoryMapper).selectCountSingleInnerCAHis(argThat(new IsTClass<SingleAccountHisPageQueryInnerVo>(new SingleAccountHisPageQueryInnerVo())));
   }
   public static void mockSelectSingleInnerCAHisPageQuery(CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper,List<SingleAccountAccountingRecord> list){
	 doReturn(list).when(creditAccountTradeHistoryMapper).selectSingleInnerCAHisPageQuery(argThat(new IsTClass<SingleAccountHisPageQueryInnerVo>(new SingleAccountHisPageQueryInnerVo())));
   }
}
