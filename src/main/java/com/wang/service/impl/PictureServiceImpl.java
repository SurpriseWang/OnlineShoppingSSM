package com.wang.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mappers.PictureMapper;
import com.wang.pojo.Picture;
import com.wang.pojo.PictureExample;
import com.wang.service.PictureService;
import com.wang.vo.ItemPictureVo;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午4:38:41
 */
@Service
public class PictureServiceImpl implements PictureService {
	@Autowired
	private PictureMapper picturemapper;


	@Override
	public Boolean deletePicture(Integer id) {
		int returnValue = picturemapper.deleteByPrimaryKey(id);
		if (returnValue == 1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public Boolean insertPicture(ItemPictureVo itemPictureVo) {
		Picture picture = new Picture();
		String fileFolder = "D:\\SSMTestPicture\\UpLoadPictures";
		String fileName = itemPictureVo.getInputfile().getOriginalFilename();
		File descFile = new File(fileFolder + File.separator + fileName);
		// 把文件写入目标文件地址
		if (!itemPictureVo.getInputfile().isEmpty()) {
			try {
				itemPictureVo.getInputfile().transferTo(descFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		picture.setItemId(itemPictureVo.getItemId());
		picture.setSrc("http://127.0.0.1:8080/UpLoadPictures/"+fileName);
		picture.setTitle(itemPictureVo.getTitle());
		picture.setCreateTime(new Date(System.currentTimeMillis()));
		picture.setUpdateTime(new Date(System.currentTimeMillis()));
		picture.setIsDelete(0);
		int returnValue = picturemapper.insertSelective(picture);
		if (returnValue == 1) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public List<Picture> queryPictures(Integer itemId) {
		PictureExample pictureExample = new PictureExample();
		pictureExample.createCriteria().andItemIdEqualTo(itemId);
		List<Picture> picture = picturemapper.selectByExample(pictureExample);
		return picture;
	}
}
