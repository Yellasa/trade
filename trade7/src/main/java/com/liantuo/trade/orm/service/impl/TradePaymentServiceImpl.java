package com.liantuo.trade.orm.service.impl;

import com.github.pagehelper.PageHelper;
import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradePaymentMapper;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.service.TradePaymentService;
import com.liantuo.trade.seqno.IdFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kelly
 * @version V1.0
 * @Description: <p>Company:联拓金融信息服务有限公司</p>
 * @Date 2015-12-16 上午10:54:18
 */
@Service(value = "tradePaymentService")
public class TradePaymentServiceImpl implements TradePaymentService {
    private final Log LOG4J = LogFactory.getLog("trade");

    @Resource(name = "idFactoryTradePaymentTradeNo")
    private IdFactory idFactoryTradePaymentTradeNo;

    @Resource
    private TradePaymentMapper tradePaymentMapper;

    @Override
    public List<TradePayment> pageQueryByExample(TradePaymentExample example, Paging page) {
        PageHelper.startPage(
                (0 == Integer.valueOf(page.getPage())) ? 1 : (Integer.valueOf(page.getPage()) + 1),
                Integer.valueOf(page.getPage_size()),
                false,
                false,
                false
        );
        return tradePaymentMapper.pageQueryByExample(example);
    }

    @Override
    public List<TradePayment> queryExample(TradePaymentExample tradePaymentExample) {
        List<TradePayment> list = tradePaymentMapper.selectByExample(tradePaymentExample);
        return list;
    }

    @Override
    public void insertTradePayment(TradePayment payment) {
        tradePaymentMapper.insertSelective(payment);
    }

    @Override
    public void updateTradePayment(TradePayment payment) {
        int count = tradePaymentMapper.updateByKeyVersionSelective(payment);
        if (count != 1) {
            LOG4J.error(String.format("乐观锁更新失败 id=%d, version=%d", payment.getId(), payment.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
    }

    @Override
    public int selectCountByPaymentExample(
            TradePaymentExample tradePaymentExample) {
        return tradePaymentMapper.selectCountByExample(tradePaymentExample);
    }

    @Override
    public TradePayment selectByPrimaryKey(Long id) {
        return tradePaymentMapper.selectByPrimaryKey(id);
    }


}
