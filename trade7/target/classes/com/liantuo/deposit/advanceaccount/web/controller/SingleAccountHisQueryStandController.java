package com.liantuo.deposit.advanceaccount.web.controller;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebill.framework.datatype.TimeUtil;
import com.ebill.framework.res.JsonUtil;
import com.ebill.framework.validator.ValidatorUtil;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountTradeHistoryService;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountAccountRecord;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.web.vo.req.CreditAccountPageQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingHistoryRecord;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisQueryRspVo;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.common.constants.RspConstants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode021Constants;
import com.liantuo.deposit.common.plugin.mybatis.vo.Page;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.exception.BusinessUncheckedException;

/**
 * @类名: SingleAccountQueryController
 * @类说明: 
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年3月23日 下午15:49:32
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */

@Controller
@RequestMapping("/singleAccountQuery")
public class SingleAccountHisQueryStandController{
	
	private static final Logger Logger = LoggerFactory.getLogger(SingleAccountHisQueryStandController.class);
    @Autowired
    private CreditAccountService creditAccountService;
    @Resource
	private CreditAccountTradeHistoryService creditAccountTradeHistoryService;
    
    
    /**
     * 
    * @Title: accountQuery 
    * @Description: 单账户历史查询(标准版)
    * @param @param request
    * @param @param response
    * @param @param req
    * @return void
    * @throws 
    * @author shihb
    * @date 2016-4-28 上午11:27:52
     */
	@SuppressWarnings("deprecation")
	@RequestMapping( value="/accountQuery.in" , method=RequestMethod.POST)
	public void accountQuery(HttpServletRequest request,HttpServletResponse response,SingleAccountHisQueryReqVo req){
		SingleAccountHisQueryRspVo rspVo = null;
		String success = RspConstants.SUCCESS_F;
		String retCode = "";
		String retInfo = "";
		Integer totalSize=0;
		List<SingleAccountAccountRecord> list = new ArrayList<SingleAccountAccountRecord>();
	    List<SingleAccountAccountingHistoryRecord> listRecords=new ArrayList<SingleAccountAccountingHistoryRecord>();
		try {
			
			Logger.info("单账户账务历史查询接口-数据标准版请求参数是"+JsonUtil.object2String(req));
			String parasErrorInfo = ValidatorUtil.validateResult(req,CreditAccountPageQueryReqVo.class);
			if(parasErrorInfo!=null && !parasErrorInfo.trim().equals("")){
				Logger.error("参数错误信息" + parasErrorInfo);
				throw new BusinessUncheckedException(ErrorCode021Constants.ACCOUNT_QUERY_DATA_FORMATE_ERR,"格式校验未通过："+ parasErrorInfo);
			}
			diffDay(req.getGmtCreateBegin(),req.getGmtCreateEnd());
			pagePropertySetting(req);
			CreditAccount accountVo = creditAccountService.selectByAccountNo(req.getAccountNo());
			if(null== accountVo){
				throw new BusinessUncheckedException(ErrorCode021Constants.ACCOUNT_QUERY_DATA_NOT_EXIST,"账户编号不属于该核心商户编号");
			}else if (null==accountVo.getCoreMerchantNo()){
				throw new BusinessUncheckedException(ErrorCode021Constants.ACCOUNT_QUERY_DATA_NOT_EXIST,"账户编号不属于该核心商户编号");
			}else if(!req.getCoreMerchantNo().equals(accountVo.getCoreMerchantNo())){
				throw new BusinessUncheckedException(ErrorCode021Constants.ACCOUNT_QUERY_DATA_NOT_EXIST,"账户编号不属于该核心商户编号");
			}
			req.setAccountNo(String.valueOf(accountVo.getId()));
			totalSize= creditAccountTradeHistoryService.countSingleAccountHisQuery(req);
			list = creditAccountTradeHistoryService.singleAccountHisPageQueryStand(req);
			for(SingleAccountAccountRecord vo :list){
			  vo.setAccountNo(accountVo.getAccountNo());
			  SingleAccountAccountingHistoryRecord singleAccountAccountingHistoryRecord=new SingleAccountAccountingHistoryRecord();
			  BeanUtils.copyProperties(singleAccountAccountingHistoryRecord,vo);
			  singleAccountAccountingHistoryRecord.setAvlBalIncrAmt(AmountUtils.longConvertToBizAmountTwo(vo.getAvlBalIncrAmt()==null?0:vo.getAvlBalIncrAmt()));
			  singleAccountAccountingHistoryRecord.setAvlBalDecrAmt(AmountUtils.longConvertToBizAmountTwo(vo.getAvlBalDecrAmt()==null?0:vo.getAvlBalDecrAmt()));
			  singleAccountAccountingHistoryRecord.setFrozenBalIncrAmt(AmountUtils.longConvertToBizAmountTwo(vo.getFrozenBalIncrAmt()==null?0:vo.getFrozenBalIncrAmt()));
			  singleAccountAccountingHistoryRecord.setFrozenBalDecrAmt(AmountUtils.longConvertToBizAmountTwo(vo.getFrozenBalDecrAmt()==null?0:vo.getFrozenBalDecrAmt()));
			  singleAccountAccountingHistoryRecord.setAvailibleBalance(AmountUtils.longConvertToBizAmountTwo(vo.getAvailibleBalance()==null?0:vo.getAvailibleBalance()));
			  singleAccountAccountingHistoryRecord.setFrozenBalance(AmountUtils.longConvertToBizAmountTwo(vo.getFrozenBalance()==null?0:vo.getFrozenBalance()));
			  listRecords.add(singleAccountAccountingHistoryRecord);
			}
			success = RspConstants.SUCCESS_S;
			retCode = RspConstants.SUCCESS_S;
			retInfo = "";
		}catch(BusinessUncheckedException e){
			Logger.error(e.getMessage(),e);
			success = RspConstants.SUCCESS_F;
			retCode = e.getErrorCode();
			retInfo = e.getMessage();
		
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
			success = RspConstants.SUCCESS_F;
			retCode = ErrorCode001Constants.SYSTEM_EXCEPTION;
			retInfo = e.getMessage();
		}
		
		/**组织返回*/
		try {
			if(rspVo == null){
				rspVo = new SingleAccountHisQueryRspVo();
				rspVo.setTotalResult(ErrorCode001Constants.ERROR_NUMBER_OF_RECORD);
			}
			rspVo.setResult(success, retCode, retInfo);
			rspVo.setList(listRecords);
			rspVo.setTotalResult(String.valueOf(totalSize));
			response.getWriter().print(JsonUtil.object2String(rspVo));
				
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}
	public void diffDay (String beginTime,String endTime)
	{
		long diffday=TimeUtil.dateDiff(beginTime, endTime, TimeUtil.DATE_FORMAT, TimeUtil.DATE_TYPE_DAY);
		Logger.info("beginTime: "+beginTime+"  endTime: "+endTime);
		Logger.info("diffday: "+diffday+"  diffday>=186L :"+(diffday>=186L));
		if(diffday>=186L){
			throw new BusinessUncheckedException(ErrorCode021Constants.ACCOUNT_QUERY_DATA_FORMATE_ERR,
					"格式校验未通过:开始时间与结束时间范围不超过186天");
		}
	}
	
	private void pagePropertySetting(SingleAccountHisQueryReqVo req) {
		Page page = new Page();
		req.setPage(page);
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(req.getCurrentPage())){
			req.getPage().setCurrentPage(Integer.valueOf(req.getCurrentPage())+1);
		}else {
			req.getPage().setCurrentPage(0);
		}
		
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(req.getShowCount())){
			req.getPage().setShowCount(Integer.valueOf(req.getShowCount()));
		}else {
			req.getPage().setShowCount(50);
		}
	}
	 
}
