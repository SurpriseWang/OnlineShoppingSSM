package com.wang.service;

import java.util.List;

import com.wang.pojo.Banner;
import com.wang.vo.BannerVo;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午7:15:36
 */
public interface BannerService {
	List<Banner> queryAllBanner();
	Boolean insertBanner(BannerVo bannerVo);
	Boolean deleteBanner(Integer[] id);
}
