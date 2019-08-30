package com.wang.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午7:17:23
 */
public class BannerVo {
	private Integer id;
	private MultipartFile inputfile;
	private String bannerName;
	@Override
	public String toString() {
		return "BannerVo [id=" + id + ", inputfile=" + inputfile + ", bannerName=" + bannerName + "]";
	}
	public BannerVo() {
		super();
	}
	public BannerVo(Integer id, MultipartFile inputfile, String bannerName) {
		super();
		this.id = id;
		this.inputfile = inputfile;
		this.bannerName = bannerName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MultipartFile getInputfile() {
		return inputfile;
	}
	public void setInputfile(MultipartFile inputfile) {
		this.inputfile = inputfile;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	
}
