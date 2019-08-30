package com.wang.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.service.ExcelService;
import com.wang.service.ItemsService;
import com.wang.vo.ItemVo;

/**
 * @author SurpriseWang
 * @date 2019年8月27日上午10:33:12
 */
@Controller
public class ExcelController {
	@Autowired
	private ExcelService excelService;
	@Autowired
	private ItemsService ItemsService;

	@ResponseBody
	@RequestMapping("/outputExcel.action")
	public ResponseEntity<byte[]> queryItems2(HttpServletResponse response) throws Exception {
		List<ItemVo> itemVos = ItemsService.queryItems();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", "ItemTable.xlsx");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		byte[] outputExcel = excelService.outputExcel(itemVos, response.getOutputStream());
		return new ResponseEntity<byte[]>(outputExcel, headers, HttpStatus.CREATED);
	}
}
