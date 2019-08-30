package com.wang.service;

import java.util.List;

import com.wang.pojo.Category;

/**
 * @author SurpriseWang
 * @date 2019年8月30日上午9:08:56
 */
public interface CategoryService {
	List<Category> queryAllCategorys();
	Boolean createCategory(String categoryType);
	Boolean deleteCategory(Integer[] ids);
}
