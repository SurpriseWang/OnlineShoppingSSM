package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.pojo.Banner;
import com.wang.service.BannerService;
import com.wang.vo.BannerVo;

/**
 * @author SurpriseWang
 * @date 2019年8月30日下午7:13:28
 */
@Controller
public class BannerController {
	@Autowired
	private BannerService bannerService;
		@ResponseBody
		@RequestMapping("/queryBanner.action")
		public List<Banner> queryAllBanner() {
			List<Banner> banners = bannerService.queryAllBanner();
			return banners;
		}
		@RequestMapping("/insertBanner.action")
		public String insertBanner(BannerVo bannerVo) {
			bannerService.insertBanner(bannerVo);
			return "redirect:/view/html/banner.html";
		}
		@RequestMapping("/deleteBanner.action")
		public String deleteBanner(Integer[] ids) {
			bannerService.deleteBanner(ids);
			return "redirect:/view/html/banner.html";
		}
		
		
}
