package com.wang.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.mappers.CategoryMapper;
import com.wang.mappers.ItemMapper;
import com.wang.pojo.Category;
import com.wang.pojo.CategoryExample;
import com.wang.pojo.Item;
import com.wang.pojo.ItemExample;
import com.wang.service.ItemsService;
import com.wang.vo.ItemVo;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<ItemVo> queryItems() {
		ItemExample itemExample = new ItemExample();
		itemExample.createCriteria().andIdIsNotNull();
		List<Item> items = itemMapper.selectByExample(itemExample);
		List<ItemVo> itemVos = new ArrayList<ItemVo>();
		for (Item item : items) {
			Category category = categoryMapper.selectByPrimaryKey(item.getCategoryId());
			Integer id = item.getId();
			String itemName = item.getItemName();
			String categoryType = category.getCategoryType();
			String price = item.getPrice();
			String unit = item.getUnit();
			Date productionDate = item.getProductionDate();
			Date expiryDate = item.getExpiryDate();
			String supplier = item.getSupplier();
			String information = item.getInformation();
			ItemVo itemVo = new ItemVo(id, itemName, categoryType, price, unit, productionDate, expiryDate, supplier, information);
			itemVos.add(itemVo);
		}
		return itemVos;
	}

	@Override
	public Boolean createItem(ItemVo itemVo) {
		Item item = new Item();
		item.setCreateTime(new Date(System.currentTimeMillis()));
		item.setUpdateTime(new Date(System.currentTimeMillis()));
		item.setIsDelete(0);
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.createCriteria().andCategoryTypeEqualTo(itemVo.getCategory());
		List<Category> categorys = categoryMapper.selectByExample(categoryExample);
		for (Category category : categorys) {
			item.setCategoryId(category.getId());
		}
		item.setExpiryDate(itemVo.getExpiryDate());
		item.setInformation(itemVo.getInformation());
		item.setIsDelete(0);
		item.setItemName(itemVo.getItemName());
		item.setPrice(itemVo.getPrice());
		item.setProductionDate(itemVo.getProductionDate());
		item.setSupplier(itemVo.getSupplier());
		item.setUnit(itemVo.getUnit());
		int returnValue = itemMapper.insertSelective(item);
		if (returnValue >= 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean deleteItem(List<Integer> ids) {
		ItemExample itemExample = new ItemExample();
		itemExample.createCriteria().andIdIn(ids);
		int returnValue = itemMapper.deleteByExample(itemExample);
		if (returnValue >= 1) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Boolean updateItem(ItemVo itemVo) {
		Item item = new Item();
		item.setUpdateTime(new Date(System.currentTimeMillis()));
		CategoryExample categoryExample = new CategoryExample();
		categoryExample.createCriteria().andCategoryTypeEqualTo(itemVo.getCategory());
		List<Category> categorys = categoryMapper.selectByExample(categoryExample);
		for (Category category : categorys) {
			item.setCategoryId(category.getId());
		}
		item.setId(itemVo.getId());
		item.setExpiryDate(itemVo.getExpiryDate());
		item.setInformation(itemVo.getInformation());
		item.setIsDelete(0);
		item.setItemName(itemVo.getItemName());
		item.setPrice(itemVo.getPrice());
		item.setProductionDate(itemVo.getProductionDate());
		item.setSupplier(itemVo.getSupplier());
		item.setUnit(itemVo.getUnit());
		System.out.println(item);
		int returnValue = itemMapper.updateByPrimaryKeySelective(item);
		if (returnValue >= 1) {
			return true;
		} else {
			return false;
		}
	}

}
