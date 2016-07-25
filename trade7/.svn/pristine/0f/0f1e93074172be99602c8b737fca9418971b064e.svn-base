package com.liantuo.deposit.advanceaccount.web.controller;


import java.util.Date;

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
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.PoolOpenReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolOpenRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.deposit.common.constants.RspConstants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode005Constants;
import com.liantuo.deposit.pool.bus.service.PoolService;
import com.liantuo.trade.exception.BusinessUncheckedException;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;


/**
 * @类名: PoolOpenController
 * @类说明: 
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年1月8日 下午11:49:32
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */

@Controller
@RequestMapping("/poolOpenService")
public class PoolOpenController{
	
	private static final Logger Logger = LoggerFactory.getLogger(PoolOpenController.class);
	
	@Resource
	private PoolService poolService;
    @Resource(name = "idFactoryPoolNo")
    private StepSequenceFactoryForSpdb idFactoryPoolNo;
	
	/**
	 * 
	* @Title: openPool 
	* @Description: 开通资金池
	* @param @param request
	* @param @param response
	* @param @param req
	* @return void
	* @throws 
	* @author shihb
	* @date 2016-3-28 下午2:09:53
	 */
	@RequestMapping( value="/poolOpen.in" , method=RequestMethod.POST)
	public void poolOpen(HttpServletRequest request,HttpServletResponse response,PoolOpenReqVo req){
		
		PoolOpenRspVo rspVo = null;
		String success = RspConstants.SUCCESS_F;
		String retCode = "";
		String retInfo = "";
		PoolRspVo returnVo = new PoolRspVo();
		
		try {
			Logger.info("开通资金池接口请求参数是"+JsonUtil.object2String(req));
			String parasErrorInfo = ValidatorUtil.validateResult(req,PoolOpenReqVo.class);
			if(parasErrorInfo!=null && !parasErrorInfo.trim().equals("")){
				Logger.error("参数错误信息" + parasErrorInfo);
				throw new BusinessUncheckedException(ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS,"格式校验未通过:"+ parasErrorInfo);
			}
			/**账务历史总条数和账务历史明细查询*/
			PoolQueryVo poolQueryVo = new PoolQueryVo();
			poolQueryVo.setCoreMerchantNo(req.getCoreMerchantNo());
			poolQueryVo.setPoolName(req.getPoolName());
			PoolRspVo vo = poolService.findByMerchantNoAndPoolName(poolQueryVo );
			if(null!=vo){
				throw new BusinessException(ErrorCode005Constants.POOL_OPEN_NAME_REPEAT, "资金池名称重复");
			}
			String poolNo= idFactoryPoolNo.generate().toString();
			Pool record = new Pool();
			record = generateVo(req,record,poolNo);
			record = poolService.createPool(record);
            returnVo = generateReturnVo(record,returnVo,poolNo);
			success = RspConstants.SUCCESS_S;
			retCode = "";
			retInfo = "";
		}catch(BusinessUncheckedException e){
			Logger.error(e.getMessage(),e);
			success = RspConstants.SUCCESS_F;
			retCode = e.getErrorCode();
			retInfo = e.getMessage();
		
		}catch(BusinessException e){
			Logger.error(e.getErrorMessage(),e);
			success = RspConstants.SUCCESS_F;
			retCode = e.getErrorCode();
			retInfo = e.getErrorMessage();
		
		}catch (Exception e) {
			Logger.error(e.getMessage(), e);
			success = RspConstants.SUCCESS_F;
			retCode = ErrorCode005Constants.POOL_OPEN_FAIL;
			retInfo = e.getMessage();
		}
		
		/**组织返回*/
		try {
			if(rspVo == null){
				rspVo = new PoolOpenRspVo();
				rspVo.setPool(returnVo);
			}
			rspVo.setResult(success, retCode, retInfo);
			response.getWriter().print(JsonUtil.object2String(rspVo));
				
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
		
	}
	
	
	private PoolRspVo generateReturnVo(Pool poolVo, PoolRspVo returnVo,String poolNo) {
		returnVo.setPoolNo(poolNo);
		returnVo.setCoreMerchantNo(poolVo.getMerchantNo());
		returnVo.setGmtCreated(poolVo.getGmtCreated());
		returnVo.setPoolName(poolVo.getPoolName());
		returnVo.setStatus(poolVo.getStatus());
		returnVo.setRmk(poolVo.getRmk());
		return returnVo;
	}


	private Pool generateVo(PoolOpenReqVo req, Pool record,String poolNo) throws Exception {
		record.setPoolNo(poolNo);
		record.setMerchantNo(req.getCoreMerchantNo());
		record.setGmtCreated(new Date());
		record.setCreatorCn(req.getCoreMerchantNo());
		record.setCreatorNo(req.getCoreMerchantNo());
		record.setPoolName(req.getPoolName());
		record.setGmtModified(new Date());
		record.setRmk(req.getRmk());
		record.setStatus("1");
		record.setModifierCn(req.getCoreMerchantNo());
		record.setModifierNo(req.getCoreMerchantNo());
		return record;
	}

 
}
