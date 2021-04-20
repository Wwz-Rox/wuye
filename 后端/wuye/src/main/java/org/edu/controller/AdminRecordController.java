package org.edu.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.edu.bo.adminRecord.QryAdminRecordReqBO;
import org.edu.common.constant.ExcelTemplateConstant;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.AdminRecord;
import org.edu.service.AdminRecordService;
//import org.edu.util.Excel.ExcelUtil;
import org.edu.util.Excel.loginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import static org.edu.common.json.Constants.*;

@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class AdminRecordController {
    private static Logger logger = LoggerFactory.getLogger(AdminRecordController.class);
    @Autowired
    private AdminRecordService adminRecordService;
    //******************************查询记录列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/AdminRecordList",method = RequestMethod.POST)
    public JsonResult AdminRecordList(@RequestBody(required = false) QryAdminRecordReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<AdminRecord> adminList= adminRecordService.QryAdminRecord(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询出错了");
        }
        return result;
    }
    //***********************删除记录**********************************************************
    @ResponseBody
    @RequestMapping(value = "/AdminRecordDel",method = RequestMethod.GET)
    public JsonResult AdminRecordDel(@RequestParam(value= "adminRecordId",required = false) Long adminRecordId){
        JsonResult result =null;
        try {
            int issuccess= adminRecordService.deleteAdminRecord(adminRecordId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除出错了");
        }
        return result;
    }


    @ResponseBody
    @RequestMapping(value = "/getLoginRecordExcel", method = RequestMethod.GET)
    public void getLoginRecordExcel(HttpServletResponse response, HttpServletRequest request) {

    }
}
