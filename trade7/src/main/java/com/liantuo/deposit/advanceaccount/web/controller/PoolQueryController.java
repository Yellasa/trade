package com.liantuo.deposit.advanceaccount.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebill.framework.res.JsonUtil;
import com.ebill.framework.validator.ValidatorUtil;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.PoolQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolQueryRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.common.constants.RspConstants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode006Constants;
import com.liantuo.deposit.pool.bus.service.PoolService;
import com.liantuo.trade.exception.BusinessUncheckedException;

/**
 * @类名: AccountServiceController
 * @类说明: 
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: liujingbei
 * @创建时间: 2016年3月24日 下午15:49:32
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */

@Controller
@RequestMapping("/poolQuery")
public class PoolQueryController{
	
	private static final Logger Logger = LoggerFactory.getLogger(PoolQueryController.class);
    @Autowired
    private PoolService poolService;
	/**
	 * @方法名: accountQuery
	 * @方法说明: 资金池查询接口
	 * @param request
	 * @param response
	 * @param req
	 * @返回类型 void
	 * @创建人: liujingbei
	 * @创建时间: 2016年3月23日 下午11:56:55
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping( value="/poolQuery.in" , method=RequestMethod.POST)
	public void poolQuery(HttpServletRequest request,HttpServletResponse response,PoolQueryReqVo req){
		PoolQueryRspVo rspVo = null;
		List<PoolRspVo> list=new ArrayList<PoolRspVo>();
		String success = RspConstants.SUCCESS_F;
		String retCode = "";
		String retInfo = "";
		int totalSize=0;
		try {
			Logger.info("资金池查询接口请求参数是"+JsonUtil.object2String(req));
			Logger.info("资金池查询接口请求参数是2222"+JsonUtil.object2String(req));
			String parasErrorInfo = ValidatorUtil.validateResult(req,PoolQueryReqVo.class);
			if(parasErrorInfo!=null && !parasErrorInfo.trim().equals("")){
				Logger.error("参数错误信息" + parasErrorInfo);
				throw new BusinessUncheckedException(ErrorCode006Constants.POOL_PARAS_CHECK_NOT_PASS,"格式校验未通过："+ parasErrorInfo);
			}
			/**组件查询vo并且分页属性设置*/
			PoolQueryVo poolQueryVo=buildParamter(req);
			Logger.info("资金池查询接口数据库请求参数:"+JsonUtil.object2String(poolQueryVo));
			/**资金池总条数和资金池账户结构*/
			list= poolService.findPoolsByQueryVO(poolQueryVo);
			totalSize=poolService.countPoolsByQueryVO(poolQueryVo);
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
				rspVo = new PoolQueryRspVo();
				rspVo.setTotalResult(ErrorCode001Constants.ERROR_NUMBER_OF_RECORD);
			}
			rspVo.setResult(success, retCode, retInfo);
			rspVo.setList(list);
			rspVo.setTotalResult(String.valueOf(totalSize));
			response.getWriter().print(JsonUtil.object2String(rspVo));
				
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}
	
	/**
	 * 组件查询vo
	 * @Title:  buildParamter 
	 * @author: liujingbei
	 * @Date:   2016-3-23 下午4:43:57
	 */
	private PoolQueryVo buildParamter(PoolQueryReqVo req) {
		
		PoolQueryVo vo=new PoolQueryVo();
		vo.setPoolNo(req.getPoolNo());
		vo.setCoreMerchantNo(req.getCoreMerchantNo());
		vo.setPartnerId(req.getPartnerId());
		vo.setPoolName(req.getPoolName());
		if(StringUtils.isEmpty(req.getCurrentPage())){
			vo.setCurrentPage(0);
		}else {
			vo.setCurrentPage(Integer.parseInt(req.getCurrentPage()));
		}
		if(StringUtils.isEmpty(req.getShowCount())){
			vo.setShowCount(50);
		}else {
			vo.setShowCount(Integer.parseInt(req.getShowCount()));
		}
		vo.setStartCount(vo.getCurrentPage()*vo.getShowCount());
		return vo;
	}
}
