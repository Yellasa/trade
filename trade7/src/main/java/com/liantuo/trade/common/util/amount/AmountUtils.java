package com.liantuo.trade.common.util.amount;


import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.trade.exception.AmountConvertException;

public class AmountUtils {
    private static long MILLION = 1000000;
    private static long HUNDRED = 100;
    
    public static long bizDoubleAmtConvertToLong(Double bizAmount){
    	  long result;
    	  if(bizAmount==null){
    		  result=0;
    	  }else{
    		  result= new BigDecimal(bizAmount).multiply(new BigDecimal(MILLION)).longValue();
    	  }
          return result;
    }
    
    public static long bizAmountConvertToLong(String bizAmount) throws AmountConvertException {
        long result;
        try {
            result = (new BigDecimal(bizAmount).multiply(new BigDecimal(MILLION))).longValue();
        } catch (NumberFormatException e) {
            throw new AmountConvertException("金额转换异常，输入金额：" + bizAmount, e);
        }
        return result;
    }

    public static String longConvertToBizAmount(long longAmount) throws AmountConvertException {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal1;
        BigDecimal result;
        String strResult;
        try {
            bigDecimal = new BigDecimal(longAmount);
            bigDecimal1 = new BigDecimal(MILLION);
            result = bigDecimal.divide(bigDecimal1);
            strResult = result.toString();
        } catch (Exception e) {
            throw new AmountConvertException("金额转换异常，输入金额：" + longAmount, e);
        }
        return strResult;
    }
    
    public static String longConvertToBizAmountTwo(long longAmount) throws AmountConvertException {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal1;
        BigDecimal result;
        String strResult;
        DecimalFormat f=new DecimalFormat("0.00");
        try {
            bigDecimal = new BigDecimal(longAmount);
            bigDecimal1 = new BigDecimal(MILLION);
            result = bigDecimal.divide(bigDecimal1);
            strResult = (f.format(result)).toString();
        } catch (Exception e) {
            throw new AmountConvertException("金额转换异常，输入金额：" + longAmount, e);
        }
        return strResult;
    }

	public static Long ifNullOrElse(Long t){
		if(t==null){
			return 0l;
		}
		return t;
		
	}
	
	/**
     * @Description: 将字符串转换为数字
     * catch (AmountConvertException e) {
        e.printStackTrace();
        LOGGER.error("-->金额转换异常，输入金额：" + str, e);
        throw exceptionService.buildBusinessException("JY000000000000201");
     */
    public static long str2long(String str) throws AmountConvertException{
        long parseNum = 0;
        if (!StringUtils.isEmpty(str)) {
        	parseNum = AmountUtils.bizAmountConvertToLong(str);
        }
        return parseNum;
    }
    
    public static Long str2Long(String str) throws AmountConvertException{
    	Long parseNum = null;
        if (!StringUtils.isEmpty(str)) {
        	parseNum = AmountUtils.bizAmountConvertToLong(str);
        }
        return parseNum;
    }
    /**
	 * 
	 * @Description: 金额比较
	 * 
	 */
	private boolean compareAmt(String receiveFeeAccountOutAccountingAmt,String receiveAccountInAccountingAmt) {
		long receive_fee_amt = str2long(receiveFeeAccountOutAccountingAmt);
		long receive_account_amt = str2long(receiveAccountInAccountingAmt);
		return receive_fee_amt <= receive_account_amt;
	}
    
    /**
     * 
     * @Title:Long2Str 
     * @Description:长整形准换为支付串 
     * @param l
     * @return:String
     * @author:zoran.huang
     * @date:2016年6月15日 下午12:01:07
     */
    public static String long2Str(Long l){
    	String result = null ; 
    	if(l != null ){
    		result  = l.toString();
    	}
    	return result;
    }
    /**
     * @Title:bizYuan2Fen 
     * @Description: 元转换为分
     * @param bizAmount
     * @return
     * @return:long
     * @author:zoran.huang
     * @date:2016年7月7日 下午1:56:49
     */
    public static String bizYuan2Fen(String bizAmount){
    	String result = null;
    	if(bizAmount != null){
    		try {
        		result= new BigDecimal(bizAmount).multiply(new BigDecimal(HUNDRED)).toString();
            } catch (NumberFormatException e) {
                throw new AmountConvertException("金额转换异常，输入金额：" + bizAmount, e);
            }
    	}
        return result;
    }
    /**
     * @Title:bizFen2Yuan 
     * @Description: 分转换元（需要传入整数的分）
     * @param bizAmount
     * @return
     * @return:String
     * @author:zoran.huang
     * @date:2016年7月12日 上午10:38:34
     */
    public static String bizFen2Yuan(String bizAmount){
    	String result = null;
    	if(bizAmount != null){
    		try {
        		result= new BigDecimal(bizAmount).divide(new BigDecimal(HUNDRED)).toString();
            } catch (NumberFormatException e) {
                throw new AmountConvertException("金额转换异常，输入金额：" + bizAmount, e);
            }
    	}
        return result;
    }
}