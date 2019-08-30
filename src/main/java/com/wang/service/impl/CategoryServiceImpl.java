package com.wang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mappers.CategoryMapper;
import com.wang.pojo.Category;
import com.wang.pojo.CategoryExample;
import com.wang.service.CategoryService;

/**
 * @author SurpriseWang
 * @date 2019年8月30日上午9:10:17
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> queryAllCategorys() {
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.createCriteria().andIdIsNotNull();
		List<Category> categorys = categoryMapper.selectByExample(categoryExample);
		return categorys;
	}

	@Override
	public Boolean createCategory(String categoryType) {
		Category category = new Category();
		category.setCategoryType(categoryType);
		category.setCreateTime(new Date(System.currentTimeMillis()));
		category.setUpdateTime(new Date(System.currentTimeMillis()));
		category.setIsDelete(0);
		int returnValue = categoryMapper.insert(category);
		if (returnValue == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean deleteCategory(Integer[] ids) {
		CategoryExample categoryExample = new CategoryExample();
		List<Integer> deleteId = new ArrayList<Integer>();
		for (Integer id : ids) {
			deleteId.add(id);
		}
		categoryExample.createCriteria().andIdIn(deleteId);
		int returnValue = categoryMapper.deleteByExample(categoryExample);
		if (returnValue == 1) {
			return true;
		} else {
			return false;
		}
	}
}
