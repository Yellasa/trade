package com.liantuo.trade.orm.service.impl;

import com.github.pagehelper.PageHelper;
import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeWithdrawMapper;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;
import com.liantuo.trade.orm.service.TradeWithdrawService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 提现交易
 */
@Service(value = "tradeWithdrawService")
public class TradeWithdrawServiceImpl implements TradeWithdrawService {

    private static final Log LOG = LogFactory.getLog(TradeWithdrawServiceImpl.class);

    @Resource
    private TradeWithdrawMapper tradeWithdrawMapper;

    public TradeWithdraw insertTradeWithdraw(TradeWithdraw trade) {
        trade.setVersion(TradeConstants.DEFAULT_LOCK_VRESION);
        tradeWithdrawMapper.insertSelective(trade);
        return tradeWithdrawMapper.selectByPrimaryKey(trade.getId());
    }

    public void updateTradeWithdrawById(TradeWithdraw trade) {
        int result = tradeWithdrawMapper.updateByPrimaryKeySelective(trade);
        if (result != 1) {
            LOG.error(String.format("乐观锁更新失败 id=%d, version=%d", trade.getId(), trade.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
    }

    public List<TradeWithdraw> queryByTradeNo(String tradeNo) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andTradeNoEqualTo(tradeNo);
        List<TradeWithdraw> list = tradeWithdrawMapper.selectByExample(query);
        return list;
    }

    public List<TradeWithdraw> queryByBatchNo(String batchNo) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andWithdrawBatchNoEqualTo(batchNo);
        List<TradeWithdraw> list = tradeWithdrawMapper.selectByExample(query);
        return list;
    }

    public List<TradeWithdraw> queryByPayThirdTradeNo(String payThirdTradeNo, String fundPoolNo, String coreMerchantNo) {
        TradeWithdrawExample query = new TradeWithdrawExample();
        query.createCriteria().andPayThirdTradeNoEqualTo(payThirdTradeNo)
                .andFundPoolNoEqualTo(fundPoolNo).andCoreMerchantNoEqualTo(coreMerchantNo);
        List<TradeWithdraw> list = tradeWithdrawMapper.selectByExample(query);
        return list;
    }

    public TradeWithdraw queryById(Long id) {
        return tradeWithdrawMapper.selectByPrimaryKey(id);
    }

    public List<TradeWithdraw> queryByExample(TradeWithdrawExample example) {
        return tradeWithdrawMapper.selectByExample(example);
    }

    public Long queryCount(TradeWithdrawExample example) {
        return tradeWithdrawMapper.selectCountByExample(example);
    }

    public List<TradeWithdraw> queryPageByExample(TradeWithdrawExample example, Paging page) {
        PageHelper.startPage(
                (0 == Integer.valueOf(page.getPage())) ? 1 : (Integer.valueOf(page.getPage()) + 1),
                Integer.valueOf(page.getPage_size()),
                false,
                false,
                false
        );
        return tradeWithdrawMapper.queryPageByExample(example);
    }

    @Override
    public List<TradeWithdraw> queryPageByExample(TradeWithdrawExample example) {
        return tradeWithdrawMapper.queryPageByExample(example);
    }
}
