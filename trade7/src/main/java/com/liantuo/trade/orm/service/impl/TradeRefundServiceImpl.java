package com.liantuo.trade.orm.service.impl;

import com.github.pagehelper.PageHelper;
import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeRefundMapper;
import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.pojo.TradeRefundExample;
import com.liantuo.trade.orm.service.TradeRefundService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "tradeRefundService")
public class TradeRefundServiceImpl implements TradeRefundService {

    private static final Log LOG = LogFactory.getLog(TradeRefundServiceImpl.class);

    @Resource
    private TradeRefundMapper tradeRefundMapper;

    @Override
    public List<TradeRefund> pageQueryByExample(TradeRefundExample example, Paging page) {
        PageHelper.startPage(
                (0 == Integer.valueOf(page.getPage())) ? 1 : (Integer.valueOf(page.getPage()) + 1),
                Integer.valueOf(page.getPage_size()),
                false,
                false,
                false
        );
        return tradeRefundMapper.pageQueryByExample(example);
    }

    public TradeRefund insertTradeRefund(TradeRefund tradeRefund) {
        tradeRefundMapper.insertSelective(tradeRefund);
        return tradeRefundMapper.selectByPrimaryKey(tradeRefund.getId());
    }

    public void updateTradeRefund(TradeRefund tradeRefund) {
        int count = tradeRefundMapper.updateByPrimaryKeySelective(tradeRefund);
        if (count != 1) {
            LOG.error(String.format("乐观锁更新失败 id=%d, version=%d", tradeRefund.getId(), tradeRefund.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
    }

    public List<TradeRefund> queryTradeRefundByOriginalTradeNo(String originalTradeNo, String fundPoolNo, String coreMerchantNo) {
        TradeRefundExample example = new TradeRefundExample();
        example.createCriteria().andOriginalTradeNoEqualTo(originalTradeNo)
                .andFundPoolNoEqualTo(fundPoolNo).andCoreMerchantNoEqualTo(coreMerchantNo);
        return tradeRefundMapper.selectByExample(example);
    }

    public List<TradeRefund> queryTradeRefundByOutTradeNoExt(String outTradeNoExt, String fundPoolNo, String coreMerchantNo) {
        TradeRefundExample example = new TradeRefundExample();
        example.createCriteria().andOutTradeNoExtEqualTo(outTradeNoExt)
                .andFundPoolNoEqualTo(fundPoolNo).andCoreMerchantNoEqualTo(coreMerchantNo);
        return tradeRefundMapper.selectByExample(example);
    }

    public List<TradeRefund> queryTradeRefund(TradeRefundExample query) {
        return tradeRefundMapper.selectByExample(query);
    }


    public int selectCountByExample(TradeRefundExample query) {
        return tradeRefundMapper.selectCountByExample(query);
    }

    public TradeRefund queryTradeRefund(Long id) {
        return tradeRefundMapper.selectByPrimaryKey(id);
    }

}
