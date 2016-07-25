package com.liantuo.trade.bus.service;

import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;

import java.util.List;

/**
 * ClassName:   ProfitLossLedgerService.java	<br>
 * Description: 损益台账业务操作	<br>
 * Company:     联拓金融信息服务有限公司	<br>
 * author       zoran.huang	<br>
 * version      V1.0	<br>
 * date         2016年4月26日 下午4:29:39	<br>
 */
public interface ProfitLossLedgerService {
    /**
     * title:createEffectiveProfitLossLedger
     *
     * @param ledger
     * @return String
     * @Description:创建生效的损益台账
     * @author zoran.huang
     * @date:2016年4月26日 下午4:31:07
     */
    String createEffectiveProfitLossLedger(TradeProfitLossLedger ledger);

    /**
     * @param ledger
     * @return String
     * @Title:createBlankLegder
     * @Description: 创建空白台账
     * @author:zoran.huang
     * @date:2016年4月26日 下午4:31:21
     */
    String createBlankProfitLossLedger(TradeProfitLossLedger ledger);

    /**
     * @param ledger
     * @return
     * @Title:createBlankLegder
     * @Description: 空白的损益台账生效
     * @author:zoran.huang
     * @date:2016年4月26日 下午4:31:21
     */
    void updateBlankLegderEffective(TradeProfitLossLedger ledger);

    /**
     * @param ledger
     * @Title:updateBlankLegderFail
     * @Description: 空白的损益台账失败
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月26日 下午4:33:24
     */
    void updateBlankLegderFail(TradeProfitLossLedger ledger);


    /**
     * @param ledgerNo 损益台账编号
     * @param tradeNo  交易编号
     * @return
     * @Title:queryByLedgerNo
     * @Description:根据台账编号和交易编号查询对应损益台账
     * @return:TradeProfitLossLedger
     * @author:zoran.huang
     * @date:2016年6月6日 下午5:07:13
     */
    TradeProfitLossLedger queryByLedgerNoAndTradeNo(String ledgerNo, String tradeNo);

    List<TradeProfitLossLedger> queryProfitLossLedgerByTradeNo(String tradeNo);
}
