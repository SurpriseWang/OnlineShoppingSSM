package com.wang.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author SurpriseWang
 * @date 2019年8月29日下午9:18:28
 */
public class ItemVo {
	private Integer id;

	private String itemName;

	private String category;

	private String price;

	private String unit;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// HH:mm:ss
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date productionDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date expiryDate;

	private String supplier;

	private String information;

	public ItemVo() {
		super();
	}

	public ItemVo(Integer id, String itemName, String category, String price, String unit, Date productionDate,
			Date expiryDate, String supplier, String information) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.category = category;
		this.price = price;
		this.unit = unit;
		this.productionDate = productionDate;
		this.expiryDate = expiryDate;
		this.supplier = supplier;
		this.information = information;
	}

	@Override
	public String toString() {
		return "ItemVo [id=" + id + ", itemName=" + itemName + ", category=" + category + ", price=" + price + ", unit="
				+ unit + ", productionDate=" + productionDate + ", expiryDate=" + expiryDate + ", supplier=" + supplier
				+ ", information=" + information + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}
