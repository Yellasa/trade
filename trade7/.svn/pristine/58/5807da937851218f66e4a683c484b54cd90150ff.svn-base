package com.liantuo.trade.client.trade.packet.body.zf;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

public class Goods_Detail {

	// 商品编号(国标)
	@NotEmpty(message = "goods_id is required", groups = { Required.class })
	@Pattern(message = "goods_id format error", regexp = "({0})||(.{1,32})", groups = { Format.class })
	private String goods_id;
	
	@Pattern(message = "alipay_goods_id format error", regexp = "({0})||(.{1,32})", groups = { Format.class })
	private String alipay_goods_id;
	// 商品名称
	@NotEmpty(message = "goods_name is required", groups = { Required.class })
	@Pattern(message = "goods_name format error", regexp = "({0})||(.{1,256})", groups = { Format.class })
	private String goods_name;

	// 商品数量
	@NotEmpty(message = "quantity is required", groups = { Required.class })
	@Pattern(message = "quantity format error", regexp = "({0})||(.{1,10})", groups = { Format.class })
	private String quantity;

	// 商品价格，此处单位为元，精确到小数点后2位
	@NotEmpty(message = "price is required", groups = { Required.class })
	@Pattern(message = "price format error", regexp = "^(\\d{1,7}|\\d{1,7}\\.\\d{1,2})$", groups = { Format.class })
	private String price;

	// 商品类别
	@Pattern(message = "goods_category format error", regexp = "({0})||(.{1,24})", groups = { Format.class })
	private String goods_category;

	// 商品详情
	@Pattern(message = "body format error", regexp = "({0})||(.{1,1000})", groups = { Format.class })
	private String body;

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goodsId) {
		goods_id = goodsId;
	}

	public String getAlipay_goods_id() {
		return alipay_goods_id;
	}

	public void setAlipay_goods_id(String alipayGoodsId) {
		alipay_goods_id = alipayGoodsId;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGoods_category() {
		return goods_category;
	}

	public void setGoods_category(String goodsCategory) {
		goods_category = goodsCategory;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
