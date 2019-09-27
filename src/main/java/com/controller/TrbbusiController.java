package com.controller;

import com.pojo.TrbBusi;
import com.service.ExportService;
import com.service.TrbBusiService;
import com.view.ExcelXlsxView;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller()
public class TrbbusiController  {

    @Autowired
    private TrbBusiService trbBusiService;

    @RequestMapping("trbbusi")
    public ModelAndView doExport(ModelAndView modelAndView,TrbBusi trbBusi){
        List<TrbBusi> trbBusis = trbBusiService.selectTrbBusiList(trbBusi);
        modelAndView.addObject("trbBusi",trbBusis);
        ExcelXlsxView excelXlsxView =new ExcelXlsxView("传票流水详情.xlsx",getExportService());

//        modelAndView.setView(  new AbstractXlsView(){
//            @Override
//            protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
//                //重写方法，具体执行
//            }
//        });

        return modelAndView;
    }

    /**
     * 具体执行器,将ExportService当作参数传入，会自动调用重写方法
     * @return
     */
    private ExportService getExportService(){
        return (Map<String,Object> model, Workbook workbook) ->{
            List<TrbBusi> trbBusis = (List<TrbBusi>) model.get("trbBusi");
            Sheet sheet = workbook.createSheet("传票流水");
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
            Row row = sheet.createRow(0);
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);
            CellStyle titleStyle = workbook.createCellStyle();
            titleStyle.setFont(font);
            titleStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
            Cell cell = row.createCell(0);
            cell.setCellStyle(titleStyle);
            cell.setCellValue("传票流水详情");
            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("日期");
            row1.createCell(1).setCellValue("流水号");
            row1.createCell(2).setCellValue("税率");
            row1.createCell(3).setCellValue("税额");
            row1.createCell(4).setCellValue("净价格");
            int rownum=0;
            TrbBusi trbBusi;
            for(int i=0;i<trbBusis.size();i++){
                rownum=i+2;
                trbBusi=trbBusis.get(i);
                Row row2 = sheet.createRow(rownum);
                row2.createCell(0).setCellValue(trbBusi.getTrandt());
                row2.createCell(1).setCellValue(trbBusi.getTransq());
                row2.createCell(2).setCellValue(String.valueOf(trbBusi.getVatxrt()));
                row2.createCell(3).setCellValue(String.valueOf(trbBusi.getVatxam()));
                row2.createCell(4).setCellValue(String.valueOf(trbBusi.getPricam()));
            }
        };
    }
}
