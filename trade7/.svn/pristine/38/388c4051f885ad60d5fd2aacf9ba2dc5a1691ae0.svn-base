package com.liantuo.trade.client.trade.packet.body.trade_payment;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyInnerPayment;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.ValidationUtil;
import org.hibernate.validator.constraints.NotBlank;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.xml.bind.JAXBException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
public class TradePacketReqBodyInnerPaymentTest {

    private TradePacketReqBodyInnerPayment tradePacketReqBodyInnerPayment;

    static String error_message(Class clz, String field_name) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Annotation validate_annotation = TradePacketReqBodyInnerPayment.class.getDeclaredField(field_name).getAnnotation(clz);
        if (null == validate_annotation) {
            System.err.println("未找到属性：" + field_name + "所对应的注解：" + validate_annotation.getClass().getSimpleName());
        }
        return (String) validate_annotation.getClass().getDeclaredMethod("message").invoke(validate_annotation);
    }

    @BeforeMethod
    void initialize() {
        tradePacketReqBodyInnerPayment = new TradePacketReqBodyInnerPayment();
    }

    @AfterMethod
    void destory() {
        tradePacketReqBodyInnerPayment = null;
    }

    @DataProvider(name = "merchant_extend_field_1")
    static Object[][] inintMerchant_extend_field_1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Format.class, error_message(Pattern.class, "merchant_extend_field_1"), "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"}
                , {Format.class, null, ""}
        };
    }
    @Test(dataProvider = "merchant_extend_field_1")
    void testMerchant_extend_field_1(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setMerchant_extend_field_1(actual);

        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "merchant_extend_field_1", group);
        Assert.assertEquals(err_msg, expected, actual);
    }

    @DataProvider(name = "out_trade_no")
    static Object[][] inintOut_trade_no() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Format.class, error_message(Pattern.class, "out_trade_no"), "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"}
                , {Format.class, null, "abcd_1234"}
                , {Format.class, null, "1234_abcd"}
                , {Format.class, null, "_1234abcd"}
                , {Format.class, null, "1234abcd_"}
                , {Format.class, null, "abcd1234_"}
                , {Format.class, null, "_abcd1234"}
                , {Format.class, error_message(Pattern.class, "out_trade_no"), "_"}
        };
    }
    @Test(dataProvider = "out_trade_no")
    void testOut_trade_no(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setOut_trade_no(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "out_trade_no", group);
        Assert.assertEquals(err_msg, expected, actual);
    }

    @DataProvider(name = "pay_profit_loss_extend_field_1")
    static Object[][] inintExternal_pay_merchant_extend_field_1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Format.class, error_message(Pattern.class, "pay_profit_loss_extend_field_1"), "012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890012345678900123456789001234567890"}
                , {Format.class, null, ""}
        };
    }
    @Test(dataProvider = "pay_profit_loss_extend_field_1")
    void testPay_profit_loss_extend_field_1(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setPay_profit_loss_extend_field_1(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "pay_profit_loss_extend_field_1", group);
        Assert.assertEquals(err_msg, expected, actual);
    }

    @DataProvider(name = "out_trade_no_ext")
    static Object[][] inintOut_trade_no_ext() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Required.class, error_message(NotBlank.class, "out_trade_no_ext"), ""}
                , {Format.class, error_message(Pattern.class, "out_trade_no_ext"), "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890"}
                , {Format.class, null, "abcd_1234"}
                , {Format.class, null, "1234_abcd"}
                , {Format.class, null, "_1234abcd"}
                , {Format.class, null, "1234abcd_"}
                , {Format.class, null, "abcd1234_"}
                , {Format.class, null, "_abcd1234"}
                , {Format.class, error_message(Pattern.class, "out_trade_no_ext"), "_"}
        };
    }
    @Test(dataProvider = "out_trade_no_ext")
    void testOut_trade_no_ext(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setOut_trade_no_ext(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "out_trade_no_ext", group);
        Assert.assertEquals(err_msg, expected, actual);
    }


    @DataProvider(name = "pay_type")
    static Object[][] inintPay_type() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Required.class, error_message(NotBlank.class, "pay_type"), ""}
                , {Format.class, error_message(Pattern.class, "pay_type"), "3"}
                , {Format.class, error_message(Pattern.class, "pay_type"), "31"}
                , {Format.class, error_message(Pattern.class, "pay_type"), "_"}
                , {Format.class, error_message(Pattern.class, "pay_type"), "a"}
                , {Format.class, null, "0"}
                , {Format.class, null, "1"}
                , {Format.class, null, "2"}
        };
    }
    @Test(dataProvider = "pay_type")
    void testPay_type(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setPay_type(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "pay_type", group);
        Assert.assertEquals(err_msg, expected, actual);
    }

    @DataProvider(name = "pay_profit_loss_attr_1")
    static Object[][] inintPay_profit_loss_attr_1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Format.class, error_message(Pattern.class, "pay_profit_loss_attr_1"), "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"}
                , {Format.class, null, ""}
        };
    }
    @Test(dataProvider = "pay_profit_loss_attr_1")
    void testPay_profit_loss_attr_1(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setPay_profit_loss_attr_1(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "pay_profit_loss_attr_1", group);
        Assert.assertEquals(err_msg, expected, actual);
    }


    @DataProvider(name = "pay_profit_loss_income_decr")
    static Object[][] inintPay_profit_loss_income_decr() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), ""}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "a"}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "_"}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "_ "}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "0. 1"}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "0._1"}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "0.0"}
                , {Format.class, error_message(DecimalMin.class, "pay_profit_loss_income_decr"), "0.1a"}
                , {Format.class, null, "1.0"}
                , {Format.class, null, "1.00"}
                , {Format.class, null, "0.01"}
                , {Format.class, null, "0.10"}
                , {Format.class, null, "123456789"}
                , {Format.class, null, "123456789.0"}
                , {Format.class, null, "123456789.00"}
                , {Format.class, error_message(Digits.class, "pay_profit_loss_income_decr"), "12345678901234.00"}
        };
    }
    @Test(dataProvider = "pay_profit_loss_income_decr")
    void testPay_profit_loss_income_decr(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setPay_profit_loss_income_decr(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "pay_profit_loss_income_decr", group);
        Assert.assertEquals(err_msg, expected, actual);
    }


    @DataProvider(name = "pay_account_no")
    static Object[][] inintPay_account_no() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
                {Format.class, error_message(Pattern.class, "pay_account_no"), "12345678901234567890123456789012345678901234567890123456789012345678901234567890"}
                , {Format.class, error_message(Pattern.class, "pay_account_no"), "12345"}
                , {Format.class, null, "abc_12"}
                , {Format.class, null, "12_abc"}
                , {Format.class, null, "_12abcd"}
                , {Format.class, null, "12abcd_"}
                , {Format.class, null, "abcd12_"}
                , {Format.class, null, "_abcd12"}
                , {Format.class, error_message(Pattern.class, "pay_account_no"), "_"}
        };
    }
    @Test(dataProvider = "pay_account_no")
    void testPay_account_no(Class group, String expected, String actual) throws NoSuchFieldException {
        tradePacketReqBodyInnerPayment.setPay_account_no(actual);
        String err_msg = ValidationUtil.validateObject(tradePacketReqBodyInnerPayment, "pay_account_no", group);
        Assert.assertEquals(err_msg, expected, actual);
    }

    @Test
    void testMashall(){
        TradeRequest<TradePacketReqBodyInnerPayment> request = new TradeRequest<TradePacketReqBodyInnerPayment>();
        tradePacketReqBodyInnerPayment.setMerchant_extend_field_1("merchant_extend_field_1");
        List<TradePacketReqBodyOtherPofitLossLedger> list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
        tradePacketReqBodyInnerPayment.setProfit_loss_list(list);
        TradePacketReqBodyOtherPofitLossLedger ledger1 = new TradePacketReqBodyOtherPofitLossLedger();
        ledger1.setMerchant_extend_field_1("merchant_extend_field_1");
        ledger1.setProfit_loss_attr_1("profit_loss_attr_1");
        list.add(ledger1);
        TradePacketReqBodyOtherPofitLossLedger ledger2 = new TradePacketReqBodyOtherPofitLossLedger();
        ledger2.setMerchant_extend_field_1("merchant_extend_field_1");
        ledger2.setProfit_loss_attr_1("profit_loss_attr_1");
        list.add(ledger2);
        request.setBody(tradePacketReqBodyInnerPayment);
        try {
            System.err.println(request.marshal());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUnMashall(){
        TradeRequest<?> innerPayment;
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tradeRequest><body xsi:type=\"tradePacketReqBodyInnerPayment\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><merchant_extend_field_1>merchant_extend_field_1</merchant_extend_field_1><profit_loss_list><profit_loss><merchant_extend_field_1>merchant_extend_field_1</merchant_extend_field_1><profit_loss_attr_1>profit_loss_attr_1</profit_loss_attr_1></profit_loss><profit_loss><merchant_extend_field_1>merchant_extend_field_1</merchant_extend_field_1><profit_loss_attr_1>profit_loss_attr_1</profit_loss_attr_1></profit_loss></profit_loss_list></body><head/></tradeRequest>";
        try {
            innerPayment = TradeRequest.unmarshal(xml, TradePacketReqBodyInnerPayment.class);
            System.err.println(innerPayment);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}