package com.service;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.ui.Model;

import java.util.Map;

/**
 * Excel导出接口
 * 只要实现此接口，重写此方法，就会自动调用makeWorkBook方法
 */
public interface ExportService {
    public void makeWorkBook(Map<String,Object> model, Workbook workbook);
}
