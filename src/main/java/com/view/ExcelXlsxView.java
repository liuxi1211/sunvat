package com.view;

import com.alibaba.druid.util.StringUtils;
import com.service.ExportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelXlsxView extends AbstractXlsxView {
    private String fileName;
    private ExportService exportService;

    public ExcelXlsxView(ExportService exportService) {
        this.exportService = exportService;
    }

    public ExcelXlsxView(String fileName) {
        this.fileName = fileName;
    }

    public ExcelXlsxView(String fileName, ExportService exportService) {
        this.fileName = fileName;
        this.exportService = exportService;
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (exportService == null) {
            throw new RuntimeException("没有具体的导出程序");
        }
        if (StringUtils.isEmpty(fileName)) {
            throw new RuntimeException("文件名不能为null");
        }

        String reqCharSet = request.getCharacterEncoding();
        reqCharSet = reqCharSet == null ? "UTF-8" : reqCharSet;
        fileName = new String(fileName.getBytes(reqCharSet), "ISO8859-1");
        //设置文件名,触发浏览器下载器
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        //回调接口方法
        exportService.makeWorkBook(model, workbook);
    }
}
