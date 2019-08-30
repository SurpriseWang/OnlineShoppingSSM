package com.wang.vo;

import org.springframework.web.multipart.MultipartFile;

public class ItemPictureVo {
	private Integer itemId;
	private MultipartFile inputfile;
	private String title;

	@Override
	public String toString() {
		return "ItemVo [itemId=" + itemId + ", inputfile=" + inputfile + ", title=" + title + "]";
	}

	public ItemPictureVo() {
		super();
	}

	public ItemPictureVo(Integer itemId, MultipartFile inputfile, String title) {
		super();
		this.itemId = itemId;
		this.inputfile = inputfile;
		this.title = title;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public MultipartFile getInputfile() {
		return inputfile;
	}

	public void setInputfile(MultipartFile inputfile) {
		this.inputfile = inputfile;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}