package com.wang.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Item {
	private Integer id;

	private String itemName;

	private Integer categoryId;

	private String price;

	private String unit;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//HH:mm:ss
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date productionDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date expiryDate;

	private String supplier;

	private String information;

	private Date createTime;

	private Date updateTime;

	private Integer isDelete;

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
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price == null ? null : price.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
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
		this.supplier = supplier == null ? null : supplier.trim();
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information == null ? null : information.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", categoryId=" + categoryId + ", price=" + price
				+ ", unit=" + unit + ", productionDate=" + productionDate + ", expiryDate=" + expiryDate + ", supplier="
				+ supplier + ", information=" + information + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", isDelete=" + isDelete + "]";
	}
	
}