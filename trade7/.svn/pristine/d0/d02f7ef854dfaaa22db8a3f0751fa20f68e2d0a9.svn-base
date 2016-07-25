package com.liantuo.trade.orm.service;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;

import java.util.List;

/**
 * @author kelly
 * @version V1.0
 * @Description: TODO
 * <p>Company:联拓金融信息服务有限公司</p>
 * @Date 2015-12-16 上午10:53:46
 */
public interface TradePaymentService {
    List<TradePayment> pageQueryByExample(TradePaymentExample example, Paging page);

    List<TradePayment> queryExample(TradePaymentExample tradePaymentExample);

    void insertTradePayment(TradePayment payment);

    void updateTradePayment(TradePayment payment);

    int selectCountByPaymentExample(TradePaymentExample tradePaymentExample);

    TradePayment selectByPrimaryKey(Long id);
}
