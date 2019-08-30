package com.wang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.service.ItemsService;
import com.wang.vo.ItemVo;

@Controller
public class ItemsController {
	@Autowired
	private ItemsService ItemsService;

	@ResponseBody
	@RequestMapping("/queryItems.action")
	public List<ItemVo> queryItems() {
		List<ItemVo> itemVos = ItemsService.queryItems();
		return itemVos;
	}

	@RequestMapping("/createItem.action")
	public String createItem(ItemVo itemVo) {
		Boolean returnValue = ItemsService.createItem(itemVo);
		if (returnValue) {
			return "redirect:/view/html/adminhomespaces.html";
		} else {
			return "redirect:/view/html/creaetitem.html";
		}
	}

	@RequestMapping("/deleteitem.action")
	public String deleteitem(Integer[] itemId) {
		List<Integer> ids = new ArrayList<>();
		for (Integer id : itemId) {
			ids.add(id);
		}
		Boolean returnValue = ItemsService.deleteItem(ids);
		if (returnValue) {
			return "redirect:/view/html/adminhomespaces.html";
		} else {
			return "redirect:/view/html/adminhomespaces.html";
		}
	}

	@RequestMapping("/updateItem.action")
	public String updateItems(ItemVo itemVo) {
		Boolean returnValue = ItemsService.updateItem(itemVo);
		if (returnValue) {
			return "redirect:/view/html/adminhomespaces.html";
		} else {
			return "redirect:/view/html/adminhomespaces.html";
		}
	}
}
