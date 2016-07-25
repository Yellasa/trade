package com.liantuo.trade.bus.process;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.bus.vo.ZFPaymentAsynNotifyDetail;
import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestBody;
import org.springframework.transaction.annotation.Transactional;

/**
 * @param <B>
 * @author zoran.huang
 * @version V1.0
 * @ClassName: TradeOnlineAsynPaymentNotifyInterface.java
 * @Description: 处理线上支付，异步通知数据处理
 * @Company: 联拓金融信息服务有限公司
 * @date 2016年7月11日 上午10:32:43
 */
public interface TradeOnlineAsynPaymentNotifyInterface<B extends TradeNotifyRequestBody> {
    /**
     * @param notify
     * @param ip
     * @Title:setRequestDetail
     * @Description: 根据支付渠道，获取相应的返回数据
     * @return:void
     * @author:zoran.huang
     * @date:2016年7月11日 下午12:20:31
     */
    TradeNotifyRequestBody setRequestDetail(PaymentNotify notify, String ip);

    /**
     * @param notify
     * @throws Exception
     * @Title:validateClearChannel
     * @Description: 根据空白台账是否找到对应渠道流程
     * @return:void
     * @author:zoran.huang
     * @date:2016年7月11日 下午1:04:27
     */
    void validateClearChannel(PaymentNotify notify) throws Exception;

    /**
     * @throws Exception
     * @Title:parsePaymentNotify
     * @Description: 根据渠道编号解析对应的渠道接收对象
     * @return:void
     * @author:zoran.huang
     * @date:2016年7月11日 下午1:09:26
     */
    void parsePaymentNotify(PaymentNotify notify, TradeNotifyRequestBody requestBody) throws Exception;
    /**
     * @Title:getTradeRequest
     * @Description: 获取对应渠道编号，对应的返回信息
     * @return
     * @return:TradeNotifyRequestPacket
     * @author:zoran.huang
     * @date:2016年7月11日 下午1:13:03
     */
//	public TradeNotifyRequestBody getTradeRequest() ;

    /**
     * @Description: 格式与业务校验
     */
    void validateThirdData(B tradeRquest) throws Exception;

    void validateTradeDate(B tradeRquest) throws Exception;

    /**
     * 获取支付状态
     */
    TradeState getTradePaymentStatus(B tradeRquest);

    /**
     * @Description: 支付成功：执行第一步事务
     */
    @Transactional
    void transactionReceipt(B tradeRquest) throws Exception;

    /**
     * @Description: 支付成功： 执行第二步事务
     */
    @Transactional
    void transactionEntry(B tradeRquest) throws Exception;


    void setReqNo(String reqNo);


    /**
     * @Description: 处理支付失败的事物
     */
    @Transactional
    void transactionFailure(B tradeRquest) throws Exception;


    ZFPaymentAsynNotifyDetail getFailureMessage();

    /**
     * @param result
     * @param errorCode
     * @param errorMessage
     * @Title:getNotifyFrontDetailsInfo
     * @Description: 组织通知前置的信息
     * @return:NotifyPacketResultInfo
     * @author:zoran.huang
     * @date:2016年7月11日 下午1:20:33
     */
    NotifyPacketResultInfo getNotifyFrontDetailsInfo(B tradeRquest, String result, String errorCode, String errorMessage) throws Exception;
    /**
     * @Title:getNotice
     * @Description: 组织通知前置的报文信息
     * @return:NotifyPacketResultInfo
     * @author:zoran.huang
     * @date:2016年7月11日 上午10:37:43
     */
//	public NotifyPacketResultInfo getNotice();

    /**
     * @param @return
     * @return String
     * @throws
     * @Description: 获取本接口服务编号
     * @author zzd
     * @date 2016-5-11
     */
    String getServiceName();

    /**
     * @return
     * @Title:getUnknownErrorCode
     * @Description:获取支付中心状态不明的错误码
     * @return:String
     * @author:zoran.huang
     * @date:2016年7月11日 下午1:31:27
     */
    String getUnknownErrorCode();

    /**
     * @throws Exception
     * @Title:notifyFront
     * @Description:将交易结果通知前置系统
     * @return:void
     * @author:zoran.huang
     * @date:2016年7月11日 下午1:43:31
     */
    void notifyFront(NotifyPacketResultInfo info) throws Exception;

    String getFrontServiceName() throws Exception;

    void prepareFailureLedger(B tradeRquest) throws Exception;

    void prepareEffectLedger(B tradeRquest) throws Exception;
}
