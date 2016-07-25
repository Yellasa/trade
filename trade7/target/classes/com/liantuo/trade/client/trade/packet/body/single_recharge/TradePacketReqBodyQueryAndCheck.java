package com.liantuo.trade.client.trade.packet.body.single_recharge;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.WeakRequired;
import com.liantuo.trade.validator.AssociateWeak;
import com.liantuo.trade.validator.ConflictWeak;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author jiangkun
 * @version V1.0
 * @ClassName: NotifyRspBodyRechargeOnline
 * @Description: 0005_001_006 V1.0  支付宝批量付款-查询接口
 * Company:联拓金融信息服务有限公司
 * @Date 2016-4-26
 */
public class TradePacketReqBodyQueryAndCheck extends TradeRequestBody {

    /**
     * 参数名：交易编号<br/>
     * 参数类型:必填<br/>
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