package com.wang.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.wang.service.ExcelService;
import com.wang.vo.ItemVo;

/**
 * @author SurpriseWang
 * @date 2019年8月27日上午9:37:16
 */
@Service
public class ExcelServiceImpl implements ExcelService {

	@Override
	public byte[] outputExcel(List<ItemVo> itemVos, OutputStream outPutStream) {
		// 第一步，创建一个workbook，对应一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet hssfSheet = workbook.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = hssfSheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
		// 居中样式
		hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		byte[] byteArray = null;
		try {
			HSSFCell createCell = row.createCell(0);
			createCell.setCellValue("商品ID");
			createCell = row.createCell(1);
			createCell.setCellValue("商品名称");
			createCell = row.createCell(2);
			createCell.setCellValue("商品类别");
			createCell = row.createCell(3);
			createCell.setCellValue("商品价格");
			createCell = row.createCell(4);
			createCell.setCellValue("商品单位");
			createCell = row.createCell(5);
			createCell.setCellValue("生产日期");
			createCell = row.createCell(6);
			createCell.setCellValue("保质期");
			createCell = row.createCell(7);
			createCell.setCellValue("供货商");
			createCell = row.createCell(8);
			createCell.setCellValue("描述信息");
			int i = 1;
			for (ItemVo item : itemVos) {
				HSSFRow rows = hssfSheet.createRow(i);
				createCell = rows.createCell(0);
				createCell.setCellValue(item.getId());
				createCell = rows.createCell(1);
				createCell.setCellValue(item.getItemName());
				createCell = rows.createCell(2);
				createCell.setCellValue(item.getCategory());
				createCell = rows.createCell(3);
				createCell.setCellValue(item.getPrice());
				createCell = rows.createCell(4);
				createCell.setCellValue(item.getUnit());
				createCell = rows.createCell(5);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
				createCell.setCellValue(formatter.format(item.getProductionDate()));
				createCell = rows.createCell(6);
				createCell.setCellValue(formatter.format(item.getExpiryDate()));
				createCell = rows.createCell(7);
				createCell.setCellValue(item.getSupplier());
				createCell = rows.createCell(8);
				createCell.setCellValue(item.getInformation());
				i++;
			}
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			workbook.write(os);
			byteArray = os.toByteArray();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArray;
	}

}
