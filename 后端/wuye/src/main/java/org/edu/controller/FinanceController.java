package org.edu.controller;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.edu.bo.adminRecord.QryAdminRecordReqBO;
import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.bo.repairRecord.QryRepairRecordReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.AdminRecord;
import org.edu.model.PayRecord;
import org.edu.model.RepairRecord;
import org.edu.service.AdminRecordService;
import org.edu.service.PayMoneyRecordService;
import org.edu.service.RepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;


@Controller
@RequestMapping(value = "/wuye")
public class FinanceController {
    @Autowired
    private PayMoneyRecordService payMoneyRecordService;
    @Autowired
    private AdminRecordService adminRecordService;
    @Autowired
    private RepairRecordService repairRecordService;

    SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //下载表
    @RequestMapping(value="/MoneyRecordExcel",method =RequestMethod.GET)
    @ResponseBody
    public String createExcel1(HttpServletResponse response) throws IOException {
       /* QryPayRecordReqBO qryPayRecordReqBO =new QryPayRecordReqBO();
        RspPageBO<PayRecord> payRecordList=payMoneyRecordService.QryPayRecord(qryPayRecordReqBO);

            //创建HSSFWorkbook对象(excel的文档对象)
            HSSFWorkbook wb = new HSSFWorkbook();

            HSSFCellStyle setBorder = wb.createCellStyle();
            setBorder.setBorderBottom(BorderStyle.THIN); //下边框
            setBorder.setBorderLeft(BorderStyle.THIN);//左边框
            setBorder.setBorderTop(BorderStyle.THIN);//上边框
            setBorder.setBorderRight(BorderStyle.THIN);//右边框
            setBorder.setAlignment(HorizontalAlignment.CENTER);//居中
            setBorder.setWrapText(false);//一个单元格内数据过长是否自动换行

            HSSFCellStyle setBorder1 = wb.createCellStyle();
            setBorder1.setWrapText(true);
            setBorder1.setAlignment(HorizontalAlignment.CENTER);
            //建立新的sheet对象（excel的表单）
            HSSFSheet sheet=wb.createSheet("Sheet1");
            //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
            HSSFRow row1=sheet.createRow(0);
            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
            HSSFCell cell=row1.createCell(0);
            cell.setCellStyle(setBorder);
            //设置单元格内容
            cell.setCellValue("缴费记录明细表");
            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
            //创建第二行
            HSSFRow row2=sheet.createRow(1);
            //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("编号");
        row2.createCell(1).setCellValue("缴费人");
        row2.createCell(2).setCellValue("身份证号");
        row2.createCell(3).setCellValue("缴费类型");
        row2.createCell(4).setCellValue("缴费金额");
        row2.createCell(5).setCellValue("房屋地址");
        row2.createCell(6).setCellValue("缴费时间");
        row2.getCell(0).setCellStyle(setBorder);
        row2.getCell(1).setCellStyle(setBorder);
        row2.getCell(2).setCellStyle(setBorder);
        row2.getCell(3).setCellStyle(setBorder);
        row2.getCell(4).setCellStyle(setBorder);
        row2.getCell(5).setCellStyle(setBorder);
        row2.getCell(6).setCellStyle(setBorder);

            //放值
                for (int i=0;i<payRecordList.getRows().size();i++ ){
                    HSSFRow rowj=sheet.createRow(i+2);
                    rowj.createCell(0).setCellValue(payRecordList.getRows().get(i).getPcordId());
                    rowj.createCell(1).setCellValue(payRecordList.getRows().get(i).getPcordName());
                    rowj.createCell(2).setCellValue(payRecordList.getRows().get(i).getPcordCard());
                    rowj.createCell(3).setCellValue(payRecordList.getRows().get(i).getPcordType());
                    rowj.createCell(4).setCellValue(payRecordList.getRows().get(i).getPcordNum());
                    rowj.createCell(5).setCellValue(payRecordList.getRows().get(i).getPcordAdrr());
                    rowj.createCell(6).setCellValue(form.format(payRecordList.getRows().get(i).getPcordTime()));
                    rowj.getCell(0).setCellStyle(setBorder);
                    rowj.getCell(1).setCellStyle(setBorder);
                    rowj.getCell(2).setCellStyle(setBorder);
                    rowj.getCell(3).setCellStyle(setBorder);
                    rowj.getCell(4).setCellStyle(setBorder);
                    rowj.getCell(5).setCellStyle(setBorder);
                    rowj.getCell(6).setCellStyle(setBorder);
                }

            sheet.setColumnWidth(2, 90*90);
        sheet.setColumnWidth(5, 90*90);
        sheet.setColumnWidth(6, 90*90);

            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=PayRecord.xls");
            response.setContentType("application/msexcel");
            wb.write(output);
            output.close();*/
        return null;
    }
    @RequestMapping(value="/AdminRecordExcel",method =RequestMethod.GET)
    @ResponseBody
    public String AdminRecordExcel(HttpServletResponse response) throws IOException {
       /* QryAdminRecordReqBO qryPayRecordReqBO =new QryAdminRecordReqBO();
        RspPageBO<AdminRecord> payRecordList=adminRecordService.QryAdminRecord(qryPayRecordReqBO);

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFCellStyle setBorder = wb.createCellStyle();
        setBorder.setBorderBottom(BorderStyle.THIN); //下边框
        setBorder.setBorderLeft(BorderStyle.THIN);//左边框
        setBorder.setBorderTop(BorderStyle.THIN);//上边框
        setBorder.setBorderRight(BorderStyle.THIN);//右边框
        setBorder.setAlignment(HorizontalAlignment.CENTER);//居中
        setBorder.setWrapText(false);//一个单元格内数据过长是否自动换行

        HSSFCellStyle setBorder1 = wb.createCellStyle();
        setBorder1.setWrapText(true);
        setBorder1.setAlignment(HorizontalAlignment.CENTER);
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("Sheet1");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);
        cell.setCellStyle(setBorder);
        //设置单元格内容
        cell.setCellValue("系统日志表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
        //创建第二行
        HSSFRow row2=sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("编号");
        row2.createCell(1).setCellValue("姓名");
        row2.createCell(2).setCellValue("角色");
        row2.createCell(3).setCellValue("电话");
        row2.createCell(4).setCellValue("登录时间");
        row2.getCell(0).setCellStyle(setBorder);
        row2.getCell(1).setCellStyle(setBorder);
        row2.getCell(2).setCellStyle(setBorder);
        row2.getCell(3).setCellStyle(setBorder);
        row2.getCell(4).setCellStyle(setBorder);


        //放值
        for (int i=0;i<payRecordList.getRows().size();i++ ){
            HSSFRow rowj=sheet.createRow(i+2);
            rowj.createCell(0).setCellValue(payRecordList.getRows().get(i).getAdminRecordId());
            rowj.createCell(1).setCellValue(payRecordList.getRows().get(i).getAdminRecordName());
            rowj.createCell(2).setCellValue(payRecordList.getRows().get(i).getAdminRecordRole());
            rowj.createCell(3).setCellValue(payRecordList.getRows().get(i).getAdminRecordTel());
            rowj.createCell(4).setCellValue(form.format(payRecordList.getRows().get(i).getAdminRecordTime()));
            rowj.getCell(0).setCellStyle(setBorder);
            rowj.getCell(1).setCellStyle(setBorder);
            rowj.getCell(2).setCellStyle(setBorder);
            rowj.getCell(3).setCellStyle(setBorder);
            rowj.getCell(4).setCellStyle(setBorder);
        }

        sheet.setColumnWidth(3, 90*90);
        sheet.setColumnWidth(4, 90*90);

        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=AdminRecord.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();*/
        return null;
    }
    @RequestMapping(value="/ ",method =RequestMethod.GET)
    @ResponseBody
    public String RepairRecordExcel(HttpServletResponse response) throws IOException {
        /*QryRepairRecordReqBO qryPayRecordReqBO =new QryRepairRecordReqBO();
        RspPageBO<RepairRecord> payRecordList= repairRecordService.qryRepairRecord(qryPayRecordReqBO);

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFCellStyle setBorder = wb.createCellStyle();
        setBorder.setBorderBottom(BorderStyle.THIN); //下边框
        setBorder.setBorderLeft(BorderStyle.THIN);//左边框
        setBorder.setBorderTop(BorderStyle.THIN);//上边框
        setBorder.setBorderRight(BorderStyle.THIN);//右边框
        setBorder.setAlignment(HorizontalAlignment.CENTER);//居中
        setBorder.setWrapText(false);//一个单元格内数据过长是否自动换行

        HSSFCellStyle setBorder1 = wb.createCellStyle();
        setBorder1.setWrapText(true);
        setBorder1.setAlignment(HorizontalAlignment.CENTER);
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("Sheet1");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);
        cell.setCellStyle(setBorder);
        //设置单元格内容
        cell.setCellValue("维修记录表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
        //创建第二行
        HSSFRow row2=sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("编号");
        row2.createCell(1).setCellValue("设备名称");
        row2.createCell(2).setCellValue("设备地点");
        row2.createCell(3).setCellValue("状态");
        row2.createCell(4).setCellValue("报修时间");
        row2.createCell(5).setCellValue("维修时间");
        row2.createCell(6).setCellValue("维修人员");
        row2.createCell(7).setCellValue("维修人员工号");
        row2.createCell(8).setCellValue("维修人员电话");
        row2.createCell(9).setCellValue("所属公司");
        row2.getCell(0).setCellStyle(setBorder);
        row2.getCell(1).setCellStyle(setBorder);
        row2.getCell(2).setCellStyle(setBorder);
        row2.getCell(3).setCellStyle(setBorder);
        row2.getCell(4).setCellStyle(setBorder);
        row2.getCell(5).setCellStyle(setBorder);
        row2.getCell(6).setCellStyle(setBorder);
        row2.getCell(7).setCellStyle(setBorder);
        row2.getCell(8).setCellStyle(setBorder);
        row2.getCell(9).setCellStyle(setBorder);


        //放值
        for (int i=0;i<payRecordList.getRows().size();i++ ){
            HSSFRow rowj=sheet.createRow(i+2);
            rowj.createCell(0).setCellValue(payRecordList.getRows().get(i).getRecordId());
            rowj.createCell(1).setCellValue(payRecordList.getRows().get(i).getRecordName());
            rowj.createCell(2).setCellValue(payRecordList.getRows().get(i).getRecordAddr());
            rowj.createCell(3).setCellValue(payRecordList.getRows().get(i).getStatus());
            rowj.createCell(4).setCellValue(form.format(payRecordList.getRows().get(i).getAskrepairTime()));
            rowj.createCell(5).setCellValue(form.format(payRecordList.getRows().get(i).getRepTime()));
            rowj.createCell(6).setCellValue(payRecordList.getRows().get(i).getRepPerson());
            rowj.createCell(7).setCellValue(payRecordList.getRows().get(i).getRepairNum());
            rowj.createCell(8).setCellValue(payRecordList.getRows().get(i).getRepairPhone());
            rowj.createCell(9).setCellValue(payRecordList.getRows().get(i).getRepCompany());
            rowj.getCell(0).setCellStyle(setBorder);
            rowj.getCell(1).setCellStyle(setBorder);
            rowj.getCell(2).setCellStyle(setBorder);
            rowj.getCell(3).setCellStyle(setBorder);
            rowj.getCell(4).setCellStyle(setBorder);
            rowj.getCell(5).setCellStyle(setBorder);
            rowj.getCell(6).setCellStyle(setBorder);
            rowj.getCell(7).setCellStyle(setBorder);
            rowj.getCell(8).setCellStyle(setBorder);
            rowj.getCell(9).setCellStyle(setBorder);
        }

        sheet.setColumnWidth(2, 90*90);
        sheet.setColumnWidth(4, 90*90);
        sheet.setColumnWidth(5, 90*90);
        sheet.setColumnWidth(7, 70*70);
        sheet.setColumnWidth(8, 90*90);
        sheet.setColumnWidth(9, 90*90);

        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=RepairRecord.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();*/
        return null;
    }
}


