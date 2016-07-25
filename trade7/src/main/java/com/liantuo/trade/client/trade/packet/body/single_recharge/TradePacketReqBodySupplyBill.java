package com.liantuo.trade.client.trade.packet.body.single_recharge;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author jiangkun
 * @version V1.0
 * @ClassName: TradePacketReqBodySupplyBill 补充入账-公用
 * @Description: 0005_001_002 V1.0
 * Company:联拓金融信息服务有限公司
 * @Date 2016-4-26
 */
public class TradePacketReqBodySupplyBill extends TradeRequestBody {

    /**
     * 参数名：交易编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "trade_no is required", groups = {Required.class})
    @Pattern(message = "trade_no format error", regexp = "[\\d|a-zA-Z|_]{8,64}", groups = Format.class)
    private String trade_no;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
}