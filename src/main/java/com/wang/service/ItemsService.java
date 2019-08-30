package com.wang.service;

import java.util.List;

import com.wang.vo.ItemVo;

public interface ItemsService {
	List<ItemVo> queryItems();
	Boolean createItem(ItemVo itemVo);
	Boolean deleteItem(List<Integer> ids);
	Boolean updateItem(ItemVo itemVo);
}
