package com.liantuo.deposit.advanceaccount.web.inner.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebill.framework.exception.BusinessException;
import com.ebill.framework.res.JsonUtil;
import com.ebill.framework.validator.ValidatorUtil;
import com.liantuo.deposit.advanceaccount.bus.service.AccountForbidTradeService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.web.inner.vo.req.AccountForbidQueryInnerReqVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.AccountForbidQueryInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.AccountForbidRspVo;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.common.constants.RspConstants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode014Constants;
import com.liantuo.trade.exception.BusinessUncheckedException;

/**
 * @类名: AccountForbidQueryInnerController
 * @类说明: 
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年3月24日 下午15:49:32
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */

@Controller
@RequestMapping("/accountForbidService")
public class AccountForbidQueryInnerController{
	
	private static final Logger Logger = LoggerFactory.getLogger(AccountForbidQueryInnerController.class);
	@Resource
	private CreditAccountService creditAccountService;
	@Resource
	private AccountForbidTradeService accountForbidTradeService;

	/**
	 * 
	* @Title: accountForbidInnerQuery 
	* @Description: 预存款账户批量禁止结构内部查询接口
	* @param @param request
	* @param @param response
	* @param @param req
	* @return void
	* @throws 
	* @author shihb
	* @date 2016-4-6 下午1:54:30
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping( value="/accountForbidInnerQuery.in" , method=RequestMethod.POST)
	public void accountForbidInnerQuery(HttpServletRequest request,HttpServletResponse response,AccountForbidQueryInnerReqVo req){
		AccountForbidQueryInnerRspVo rspVo = null;
		String success = RspConstants.SUCCESS_F;
		String retCode = "";
		String retInfo = "";
		List<AccountForbidRspVo> returnlist = new ArrayList<AccountForbidRspVo>();
		try {
			Logger.info("预存款账户批量禁止结构内部查询接口请求参数是"+JsonUtil.object2String(req));
			String parasErrorInfo = ValidatorUtil.validateResult(req,AccountForbidQueryReqVo.class);
			if(parasErrorInfo!=null && !parasErrorInfo.trim().equals("")){
				Logger.error("参数错误信息" + parasErrorInfo);
				throw new BusinessUncheckedException(ErrorCode014Constants.ACCOUNT_FORBID_INNER_QUERY_CHECK_NOT_PASS,"格式校验未通过："+ parasErrorInfo);
			}
			CreditAccount accountVo = creditAccountService.selectByAccountNo(req.getAccountNo());
			if(null==accountVo){
				throw new BusinessException(ErrorCode014Constants.ACCOUNT_FORBID_INNER_QUERY_COREMERCHANNO_NOT_PASS,"账户编号不属于该核心商户编号");
			}else if(!accountVo.getCoreMerchantNo().equals(req.getCoreMerchantNo())){
				throw new BusinessException(ErrorCode014Constants.ACCOUNT_FORBID_INNER_QUERY_COREMERCHANNO_NOT_PASS,"账户编号不属于该核心商户编号");
			}
			List<AccountForbidTrade> list = accountForbidTradeService.selectByCA(req.getAccountNo());
			for(AccountForbidTrade voo:list){
				AccountForbidRspVo returnVo = new AccountForbidRspVo();
				returnVo.setAccountNo(voo.getAccountNo());
				returnVo.setType(voo.getType());
				returnVo.setForbidCode(voo.getForbidCode());
				returnlist.add(returnVo);
			}
			success = RspConstants.SUCCESS_S;
			retCode = RspConstants.SUCCESS_S;
			retInfo = "";
		}catch(BusinessUncheckedException e){
			Logger.error(e.getMessage(),e);
			success = RspConstants.SUCCESS_F;
			retCode = e.getErrorCode();
			retInfo = e.getMessage();
		
		} catch(BusinessException e){
			Logger.error(e.getMessage(),e);
			success = RspConstants.SUCCESS_F;
			retCode = e.getErrorCode();
			retInfo = e.getMessage();
		
		}catch (Exception e) {
			Logger.error(e.getMessage(), e);
			success = RspConstants.SUCCESS_F;
			retCode = ErrorCode001Constants.SYSTEM_EXCEPTION;
			retInfo = e.getMessage();
		}
		
		/**组织返回*/
		try {
			if(rspVo == null){
				rspVo = new AccountForbidQueryInnerRspVo();
				rspVo.setList(returnlist);
			}
			rspVo.setResult(success, retCode, retInfo);
			response.getWriter().print(JsonUtil.object2String(rspVo));
				
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}
}
