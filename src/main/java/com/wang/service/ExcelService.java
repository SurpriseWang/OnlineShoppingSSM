package com.wang.service;

import java.io.OutputStream;
import java.util.List;

import com.wang.vo.ItemVo;

/**
 * @author SurpriseWang
 * @date 2019年8月27日上午9:31:48
 */
public interface ExcelService {
	public byte[] outputExcel(List<ItemVo> itemVos, OutputStream outPutStream);
}
