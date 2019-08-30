package com.wang.pojo;

import java.util.Date;

public class Banner {
	@Override
	public String toString() {
		return "Banner [id=" + id + ", bannerName=" + bannerName + ", bannerUrl=" + bannerUrl + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", isDelete=" + isDelete + "]";
	}

	private Integer id;

	private String bannerName;

	private String bannerUrl;

	private Date createTime;

	private Date updateTime;

	private Integer isDelete;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName == null ? null : bannerName.trim();
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl == null ? null : bannerUrl.trim();
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