package com.liantuo.trade.client.trade.packet.body.single_payment;

import javax.validation.constraints.Pattern;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;

/**
 * @author zzd
 * @version V1.0
 * @ClassName: TradePacketReqBodyExternalQuePayment 外部收款支付查询
 * @Description: 0006_001_009 V1.0
 * Company:联拓金融信息服务有限公司
 * @Date 2016-7-7
 */
public class TradePacketReqBodyExternalQuePayment extends TradeRequestBody {
	
	//交易编号
	@Pattern(message = "trade_no format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
	private String trade_no;
	//交易发起方发起请求编号

	@Pattern(message = "out_trade_no_ext format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
	private String out_trade_no_ext;
	
	private String other_attachment_group_json;//支付中心
	
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String tradeNo) {
		trade_no = tradeNo;
	}
	public String getOut_trade_no_ext() {
		return out_trade_no_ext;
	}
	public void setOut_trade_no_ext(String outTradeNoExt) {
		out_trade_no_ext = outTradeNoExt;
	}
	public String getOther_attachment_group_json() {
		return other_attachment_group_json;
	}
	public void setOther_attachment_group_json(String otherAttachmentGroupJson) {
		other_attachment_group_json = otherAttachmentGroupJson;
	}
	
}