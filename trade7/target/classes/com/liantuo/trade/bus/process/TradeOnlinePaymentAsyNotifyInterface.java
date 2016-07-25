package com.liantuo.trade.bus.process;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.bus.vo.AliPaymentAsyNotifyDetailVo;
import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestPacket;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: TradeOnlinePaymentAsyNotifyInterface
 *
 * @author zzd
 * @Description: TODO 可以自行增加需要的获取成员变量的方法
 * @date 2016-4-20
 */
public interface TradeOnlinePaymentAsyNotifyInterface<B extends TradeNotifyRequestPacket> {

    /**
     * @Description: 格式与业务校验
     */
    void validate(B tradeRquest) throws Exception;

    /**
     * @Description: 付款成功：执行第一步事务
     */
    @Transactional
    void transactionReceipt(B tradeRquest) throws Exception;

    /**
     * @Description: 付款成功： 执行第二步事务
     */
    @Transactional
    void transactionEntry(B tradeRquest) throws Exception;

    /**
     * @Description: 付款失败：执行第一步事务
     */
    @Transactional
    void transactionFailure(B tradeRquest) throws Exception;


    /**
     * 调用方法向前置发出通知
     */
    void notifyFrontPaymentResult(NotifyPacketResultInfo notice) throws Exception;

    /**
     * 获取需要进行返回的具体实体内容
     */
    NotifyPacketResultInfo getNotifyFrontDetailsInfo(String result, String errorCode, String errorMessage, String tradeCode) throws Exception;

    /**
     * 获取需要进行返回的具体实体内容
     */
    TradeState getTradePaymentStatus();

    void setReqNo(String reqNo);

    NotifyPacketResultInfo getNotice();

    TradeRecharge getTradeInfo();

    AliPaymentAsyNotifyDetailVo getAliPaymentAsyNotifyDetail();

    /**
     * @param @param notify
     * @param @param ip
     * @return void
     * @throws
     * @Description: 将传入的值copy到process中具体调用的传值实体类中
     * @author zzd
     * @date 2016-5-10
     */
    void setRequestDetail(PaymentNotify notify, String ip);

    /**
     * @param @return
     * @return B
     * @throws
     * @Description: 获取process中具体使用的传值实体类
     * @author zzd
     * @date 2016-5-10
     */
    B getTradeRequest();

    /**
     * @param @return
     * @return String
     * @throws
     * @Description: 获取本接口服务编号
     * @author zzd
     * @date 2016-5-11
     */
    String getServiceName();
}