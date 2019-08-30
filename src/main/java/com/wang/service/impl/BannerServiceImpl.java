package com.wang.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mappers.BannerMapper;
import com.wang.pojo.Banner;
import com.wang.pojo.BannerExample;
import com.wang.service.BannerService;
import com.wang.vo.BannerVo;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午7:21:16
 */
@Service
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public List<Banner> queryAllBanner() {
		BannerExample bannerExample = new BannerExample();
		bannerExample.createCriteria().andIdIsNotNull();
		List<Banner> banners = bannerMapper.selectByExample(bannerExample);
		return banners;
	}

	@Override
	public Boolean insertBanner(BannerVo bannerVo) {
		Banner banner = new Banner();
		String fileFolder = "D:\\SSMTestPicture\\RotaryPictures";
		String fileName = bannerVo.getInputfile().getOriginalFilename();
		File descFile = new File(fileFolder + File.separator + fileName);
		// 把文件写入目标文件地址
		if (!bannerVo.getInputfile().isEmpty()) {
			try {
				bannerVo.getInputfile().transferTo(descFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		banner.setId(bannerVo.getId());
		banner.setBannerUrl("http://127.0.0.1:8080/UpLoadPictures/" + fileName);
		banner.setBannerName(bannerVo.getBannerName());
		banner.setCreateTime(new Date(System.currentTimeMillis()));
		banner.setUpdateTime(new Date(System.currentTimeMillis()));
		banner.setIsDelete(0);
		int returnValue = bannerMapper.insertSelective(banner);
		if (returnValue == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean deleteBanner(Integer[] ids) {
		List<Integer> deleteIds = new ArrayList<Integer>();
		for (Integer id : ids) {
			deleteIds.add(id);
		}
		BannerExample bannerExample = new BannerExample();
		bannerExample.createCriteria().andIdIn(deleteIds);
		int returnValue = bannerMapper.deleteByExample(bannerExample);
		if (returnValue == 1) {
			return true;
		} else {
			return false;
		}
	}
}
