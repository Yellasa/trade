package com.liantuo.trade.client.trade.packet.body.single_payment;

import javax.validation.constraints.Pattern;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;

/**
 * 0006_001_003 补充入账VO
 *
 * @author yangting
 *2016年7月12日 下午1:56:32
 */
public class TradePacketReqBodyExternalAddRecorded extends TradeRequestBody{

	/**
     * 参数名：交易编号<br/>
     */
    @Pattern(message = "trade_no format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String trade_no;
    
    @Pattern(message = "out_trade_no_ext format error", regexp = ".{0}|[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

	public String getOut_trade_no_ext() {
		return out_trade_no_ext;
	}

	public void setOut_trade_no_ext(String out_trade_no_ext) {
		this.out_trade_no_ext = out_trade_no_ext;
	}

    
}
