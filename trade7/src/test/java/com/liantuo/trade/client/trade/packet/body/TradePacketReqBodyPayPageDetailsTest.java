package com.liantuo.trade.client.trade.packet.body;


import com.liantuo.trade.client.trade.packet.req.TradePacketReqPayPageDetails;
import com.liantuo.trade.common.validate.ValidationUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TradePacketReqBodyPayPageDetailsTest {
    private static TradePacketReqPayPageDetails req;
    private static TradePacketReqBodyPayPageDetails body;

    @BeforeClass
    public static void init() {
        req = new TradePacketReqPayPageDetails();
        body = new TradePacketReqBodyPayPageDetails();
        req.setBody(body);
    }

    @Before
    public void clear() {
        body.setTrade_no(null);
        body.setOut_trade_no_ext(null);
    }

    @Test
    public void trade_no_success() {
        body.setTrade_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setTrade_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ1");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setTrade_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ_1");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setTrade_no("012345678901234567890123456789");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setTrade_no(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void trade_no_failue() {
        body.setTrade_no("");
        Assert.assertEquals("trade_no format error", ValidationUtil.validateBodyFormat(req));
        body.setTrade_no("0");
        Assert.assertEquals("trade_no format error", ValidationUtil.validateBodyFormat(req));
        body.setTrade_no("0123456789012345678901234567890123456789012345678901234567890123456789");
        Assert.assertEquals("trade_no format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void out_trade_no_ext_success() {
        body.setOut_trade_no_ext("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no_ext("ABCDEFGHIJKLMNOPQRSTUVWXYZ1");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no_ext("ABCDEFGHIJKLMNOPQRSTUVWXYZ_1");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no_ext("012345678901234567890123456789");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no_ext(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void out_trade_no_ext_failue() {
        body.setOut_trade_no_ext("");
        Assert.assertEquals("out_trade_no_ext format error", ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no_ext("0");
        Assert.assertEquals("out_trade_no_ext format error", ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no_ext("0123456789012345678901234567890123456789012345678901234567890123456789");
        Assert.assertEquals("out_trade_no_ext format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void out_trade_no_success() {
        body.setOut_trade_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ1");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ_1");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no("012345678901234567890123456789");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void out_trade_no_failue() {
        body.setOut_trade_no("");
        Assert.assertEquals("out_trade_no format error", ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no("0");
        Assert.assertEquals("out_trade_no format error", ValidationUtil.validateBodyFormat(req));
        body.setOut_trade_no("0123456789012345678901234567890123456789012345678901234567890123456789");
        Assert.assertEquals("out_trade_no format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void payment_merchant_no_success() {
        body.setPayment_merchant_no("AB");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("12");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEF");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("_BCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("_BCDEFGHIJKLMNOPQRSTUVWXY_");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void payment_merchant_no_failue() {
        /*body.setPayment_merchant_no("1_");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("_1");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));*/

        body.setPayment_merchant_no("");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("*");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("1");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("A");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("A ");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no(" A");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345678");
        Assert.assertEquals("payment_merchant_no format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void payment_account_no_success() {
        body.setPayment_account_no("AB");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("12");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEF");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("ABCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("_BCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("_BCDEFGHIJKLMNOPQRSTUVWXY_");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void payment_account_no_failue() {
        /*body.setPayment_merchant_no("1_");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_merchant_no("_1");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));*/

        body.setPayment_account_no("");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("*");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("1");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("A");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("A ");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no(" A");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setPayment_account_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345678");
        Assert.assertEquals("payment_account_no format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void receive_merchant_no_success() {
        body.setReceive_merchant_no("AB");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("12");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEF");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("_BCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("_BCDEFGHIJKLMNOPQRSTUVWXY_");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void receive_merchant_no_failue() {
        /*body.setReceive_merchant_no("1_");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("_1");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));*/

        body.setReceive_merchant_no("");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("*");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("1");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("A");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("A ");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no(" A");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345678");
        Assert.assertEquals("receive_merchant_no format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void receive_account_no_success() {
        body.setReceive_account_no("AB");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("12");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEF");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("ABCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("_BCDEFGHIJKLMNOPQRSTUVWXY_0123");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("_BCDEFGHIJKLMNOPQRSTUVWXY_");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void receive_account_no_failue() {
        /*body.setReceive_merchant_no("1_");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_merchant_no("_1");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));*/

        body.setReceive_account_no("");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("*");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("1");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("A");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("A ");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no(" A");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
        body.setReceive_account_no("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345678");
        Assert.assertEquals("receive_account_no format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void status_success() {
        body.setStatus("01");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setStatus("12");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setStatus(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void status_failue() {
        body.setStatus("");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus("*");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus("1");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus("A");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus("A ");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus(" A");
        body.setStatus("1_");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus("_1");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
        body.setStatus("ABCDEFGHIJKLMNOPQRSTUVWXYZ012345678");
        Assert.assertEquals("status format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void gmt_created_start_success() {

        body.setGmt_created_start("2016-03-14 15:57:30");
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void gmt_created_start_failue() {
        body.setGmt_created_start("0");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start("A");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start("_");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start("yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start("16-03-14 15:57:30");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start("16-03-14 15:57:30.123");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
        body.setGmt_created_start("16-03-14");
        Assert.assertEquals("gmt_created_start format error", ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void page_success() {
        body.setPage(null);
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPage(String.valueOf(0));
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPage(String.valueOf(01)); //TODO
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
        body.setPage(String.valueOf(123456789));
        Assert.assertNull(ValidationUtil.validateBodyFormat(req));
    }

    @Test
    public void page_failue() {
        body.setPage("");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("A");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("_");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("A1");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("1A");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("A_");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("_A");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("_1");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("_1");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
        body.setPage("1234567890");
        Assert.assertEquals("page format error", ValidationUtil.validateBodyFormat(req));
    }
}