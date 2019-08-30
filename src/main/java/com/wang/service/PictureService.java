package com.wang.service;

import java.util.List;

import com.wang.pojo.Picture;
import com.wang.vo.ItemPictureVo;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午2:13:26
 */
public interface PictureService {
	List<Picture> queryPictures(Integer itemId);
	Boolean deletePicture(Integer id);
	Boolean insertPicture(ItemPictureVo itemPictureVo);
}
