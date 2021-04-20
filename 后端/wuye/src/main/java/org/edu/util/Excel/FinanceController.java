//package org.edu.util.Excel;
//
//import cn.com.bmsoft.core.domain.BaseResult;
//import cn.com.bmsoft.core.utils.GetIp;
//import cn.com.bmsoft.core.utils.ReadExcel;
//import cn.com.bmsoft.core.utils.SpringSecurityUtil;
//import cn.com.bmsoft.core.utils.StaticDic;
//import cn.com.bmsoft.dataexport.finance.domain.FinarptData;
//import cn.com.bmsoft.dataexport.finance.domain.FinarptInfo;
//import cn.com.bmsoft.dataexport.finance.domain.Finasubj;
//import cn.com.bmsoft.dataexport.finance.service.FinanceService;
//import cn.com.bmsoft.piccserver.customer.domain.SysCustomer;
//import cn.com.bmsoft.piccserver.customer.mapper.SysCustomerMapper;
//import cn.com.bmsoft.piccserver.logs.domain.SysLog;
//import cn.com.bmsoft.piccserver.logs.service.SysLogService;
//import org.apache.poi.hssf.usermodel.*;
//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//
//@Controller
//@RequestMapping(value = "/finance")
//public class FinanceController {
//    @Autowired
//    private HttpServletRequest request;
//
//    static   SimpleDateFormat  form = new SimpleDateFormat("yyyyMMdd");
//
//    //下载表
//    @RequestMapping(value="/createExcel",method =RequestMethod.GET)
//    @ResponseBody
//    public String createExcel1( String prtfreq, String userId,String time,String month, HttpServletResponse response,String rptprop) throws IOException {
//
//        //查询报表
//        FinarptInfo finarptInfo = financeService.select(rptNm, prtfreq, userId, time, rptprop + " ");
//        //查询标题
//        List<Finasubj> list = financeService.selectsubj(rptid);
//        //创建HSSFWorkbook对象(excel的文档对象)
//        HSSFWorkbook wb = new HSSFWorkbook();
//
//        HSSFCellStyle setBorder = wb.createCellStyle();
//        setBorder.setBorderBottom(BorderStyle.THIN); //下边框
//        setBorder.setBorderLeft(BorderStyle.THIN);//左边框
//        setBorder.setBorderTop(BorderStyle.THIN);//上边框
//        setBorder.setBorderRight(BorderStyle.THIN);//右边框
//        setBorder.setAlignment(HorizontalAlignment.CENTER);
//        setBorder.setWrapText(true);
//
//        HSSFCellStyle setBorder1 = wb.createCellStyle();
//        setBorder1.setWrapText(true);
//        setBorder1.setAlignment(HorizontalAlignment.CENTER);
//        //建立新的sheet对象（excel的表单）
//        HSSFSheet sheet = wb.createSheet(rptNm);
//        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
//        HSSFRow row1 = sheet.createRow(0);
//        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
//        HSSFCell cell = row1.createCell(1);
//        cell.setCellStyle(setBorder1);
//        //设置单元格内容
//        cell.setCellValue(rptNm);
//        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
//        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
//        //在sheet里创建第二行
//        HSSFRow row8 = sheet.createRow(1);
//        sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
//        row8.createCell(1).setCellValue(time);
//        row8.getCell(1).setCellStyle(setBorder1);
//        HSSFRow row2 = sheet.createRow(2);
//        //创建单元格并设置单元格内容
//        row2.createCell(0).setCellValue("制表单位:" + sysCustomer.getCustName());
//        row2.createCell(1).setCellStyle(setBorder);
//        row2.createCell(2).setCellStyle(setBorder);
//        row2.createCell(3).setCellValue("金额单位：人民币元");
//        //在sheet里创建第三行
//        row2.getCell(0).setCellStyle(setBorder);
//        row2.getCell(3).setCellStyle(setBorder);
//
//        HSSFRow row3 = sheet.createRow(3);
//        row3.createCell(0).setCellValue("项目编号");
//        row3.getCell(0).setCellStyle(setBorder);
//        row3.createCell(1).setCellValue("项目");
//        row3.getCell(1).setCellStyle(setBorder);
//        row3.createCell(2).setCellValue("期末金额");
//        row3.getCell(2).setCellStyle(setBorder);
//        row3.createCell(3).setCellValue("期初金额");
//        row3.getCell(3).setCellStyle(setBorder);
//
//
//        //放值
//        if (!finarptInfo.getFinarptData().isEmpty()) {
//            for (int i = 0; i < finarptInfo.getFinarptData().size(); i++) {
//                if (finarptInfo.getFinarptData().get(i).getSubjVal() != null) {
//                    sheet.getRow(Integer.parseInt(finarptInfo.getFinarptData().get(i).getSubjNo()) + 3).getCell(2).setCellValue(finarptInfo.getFinarptData().get(i).getSubjVal());
//                }
//
//            }
//        }
//
//
//        sheet.setColumnWidth(1, 100 * 100);
//
//
//        //输出Excel文件
//        OutputStream output = response.getOutputStream();
//        response.reset();
//        response.setHeader("Content-disposition", "attachment; filename=" + cn.com.bmsoft.core.utils.utf.toUtf8String(na) + ".xls");
//        response.setContentType("application/msexcel");
//        wb.write(output);
//        output.close();
//
//
//    }
//
//
//}
//
//
