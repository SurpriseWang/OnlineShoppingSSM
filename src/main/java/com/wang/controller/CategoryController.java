package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.pojo.Category;
import com.wang.service.CategoryService;

/**
 * @author SurpriseWang
 * @date 2019年8月30日上午9:18:33
 */
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@ResponseBody
	@RequestMapping("/queryCategorys.action")
	public List<Category> queryItems() {
		List<Category> categorys = categoryService.queryAllCategorys();
		return categorys;
	}
	
	@RequestMapping("/createcategory.action")
	public String createItems(String categoryType) {
		Boolean returnValue = categoryService.createCategory(categoryType);
		if (returnValue) {
			return "redirect:/view/html/adminhomespaces.html";
		} else {
			return "redirect:/view/html/creaetitem.html";
		}
	}
	
	@RequestMapping("/deleteCategorys.action")
	public String deleteItems(Integer[] categoryId) {
		Boolean returnValue = categoryService.deleteCategory(categoryId);
		if (returnValue) {
			return "category";
		} else {
			return "adminhomespaces";
		}
	}
}
