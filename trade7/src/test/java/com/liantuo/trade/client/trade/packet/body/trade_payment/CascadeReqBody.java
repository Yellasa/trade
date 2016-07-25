package com.liantuo.trade.client.trade.packet.body.trade_payment;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.ValidationUtil;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CascadeReqBody {
    @Pattern(message = "pay_type format error", regexp = "[012]", groups = Format.class)
    private String pay_type;

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    @Valid
    private List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list;

    public List<TradePacketReqBodyOtherPofitLossLedger> getProfit_loss_list() {
        return profit_loss_list;
    }

    public void setProfit_loss_list(List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list) {
        this.profit_loss_list = profit_loss_list;
    }

    public static void main(String[] args) {
        CascadeReqBody cascadeReqBody = new CascadeReqBody();
        cascadeReqBody.setPay_type("a");
        TradePacketReqBodyOtherPofitLossLedger ledger1 = new TradePacketReqBodyOtherPofitLossLedger();
        TradePacketReqBodyOtherPofitLossLedger ledger2 = new TradePacketReqBodyOtherPofitLossLedger();

        List<TradePacketReqBodyOtherPofitLossLedger> list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
        ledger1.setIncome_incr("abc");
        list.add(ledger1);
        ledger2.setIncome_incr("abc");
        list.add(ledger2);

        cascadeReqBody.setProfit_loss_list(list);

        String err_msg = ValidationUtil.validateObject(cascadeReqBody, "*", Format.class);

        System.err.println(err_msg);

    }
}
