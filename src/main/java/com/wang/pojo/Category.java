package com.wang.pojo;

import java.util.Date;

public class Category {
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryType=" + categoryType + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", isDelete=" + isDelete + "]";
	}

	private Integer id;

	private String categoryType;

	private Date createTime;

	private Date updateTime;

	private Integer isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType == null ? null : categoryType.trim();
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
}