package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.pojo.Picture;
import com.wang.service.PictureService;
import com.wang.vo.ItemPictureVo;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午4:46:54
 */
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;

	@ResponseBody
	@RequestMapping("/queryPhoto.action")
	public List<Picture> queryPicture(Integer itemId) {
		List<Picture> returnValue = pictureService.queryPictures(itemId);
		return returnValue;
	}
	@RequestMapping("/insertPhotos.action")
	public String insertPicture(ItemPictureVo itemPictureVo) {
		pictureService.insertPicture(itemPictureVo);
		return "redirect:/view/html/adminhomespaces.html";
	}
	
	@ResponseBody
	@RequestMapping("/deletePhoto.action")
	public Boolean deletePicture(Integer pictureId) {
		Boolean returnValue = pictureService.deletePicture(pictureId);
		return returnValue;
	}
	
}
