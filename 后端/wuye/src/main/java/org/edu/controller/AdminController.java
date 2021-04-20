package org.edu.controller;

import org.apache.poi.util.SystemOutLogger;
import org.edu.bo.admin.*;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Admin;
import org.edu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 标题:管理员模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class AdminController {
    public void AdminController(){
        System.out.print("aa");
    }

    //private static Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    AdminService adminService;
    //*****************************管理员登陆****************************************************
    @ResponseBody
    @RequestMapping(value = "/adminlogin",method = RequestMethod.POST)
    public JsonResult adminLogin(@RequestBody AdminLoginReqBO adminLoginReqBO){
        JsonResult result =null;
        try {

            Admin admin= adminService.adminLogin(adminLoginReqBO);
            if(admin != null){
                if(admin.getStatus().equals("已启用")){
                    result =new JsonResult( STATUS_SUCCESS,"登录成功",admin);
                }else{
                    result =new JsonResult( "201","此管理员没有权限");
                }
            }else{
                result =new JsonResult( STATUS_UNFOUND,"用户名或者密码错误");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"出错了");
        }
        return result;
    }
        @ResponseBody
        @RequestMapping(value = "/adminlogin1",method = RequestMethod.POST,consumes = "application/json")
        public Object adminlogin1(HttpServletRequest request) {
            String reqParam = null;
            JsonResult result =null;
            try {
                BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
                StringBuilder responseStrBuilder = new StringBuilder();
                String inputStr;
                while ((inputStr = streamReader.readLine()) != null)
                    responseStrBuilder.append(inputStr);
                System.out.println("==============="+responseStrBuilder);
                JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
                reqParam = jsonObject.toString();
               // wuyeService.updateDemo(jsonObject.getString("name"), jsonObject.getString("password"), JSON.parseObject(jsonObject.getJSONObject("admin").toString(), Admin.class));
                Admin admin = adminService.adminLogin(JSON.parseObject(jsonObject.getJSONObject("adminLoginReqBO").toString(), AdminLoginReqBO.class));
                if(admin != null){
                result =new JsonResult( STATUS_SUCCESS,"登录成功",admin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"用户名或者密码错误");
            }
            } catch (Exception e) {
                result=new JsonResult(STATUS_FAILURE,"出错了");
                e.printStackTrace();
            }
            return result;
        }

//    @ResponseBody
//    @RequestMapping(value = "/adminlogin",method = RequestMethod.POST)
//    public JsonResult adminLogin( @RequestBody String name,@RequestBody String password){
//        JsonResult result =null;
//        try {
//
//            Admin admin= wuyeService.adminLogin(name,password);
//            if(admin != null){
//                result =new JsonResult( STATUS_SUCCESS,"登录成功",admin);
//            }else{
//                result =new JsonResult( STATUS_UNFOUND,"用户名或者密码错误");
//            }
//        }catch (Exception e){
//            result=new JsonResult(STATUS_FAILURE,"出错了");
//        }
//        return result;
//    }

    //******************************查询管理员列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/adminList",method = RequestMethod.POST)
    public JsonResult adminList(@RequestBody(required = false) QryAdminReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<Admin> adminList= adminService.QryAdmin(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询管理员列表出错了");
        }
        return result;
    }
    //***********************删除管理员**********************************************************
    @ResponseBody
    @RequestMapping(value = "/adminDel",method = RequestMethod.GET)
    public JsonResult adminDel(@RequestParam(value= "adminId",required = false) Integer adminId){
        JsonResult result =null;
        try {
            int issuccess= adminService.deleteAdmin(adminId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除管理员出错了");
        }
        return result;
    }
    //***********************添加管理员**********************************************************
    @ResponseBody
    @RequestMapping(value = "/adminAdd",method = RequestMethod.POST)
    public JsonResult adminAdd(@RequestBody AddAdminReqBO addAdminReqBO){
        JsonResult result =null;
//        try {
            int issuccess= adminService.addAdmin(addAdminReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                System.out.println("结果小于零");
                result =new JsonResult( STATUS_UNFOUND,"此管理员已存在");
            }
//        }catch (Exception e){
//            result=new JsonResult(STATUS_FAILURE,"添加管理员出错了");
//        }
        return result;
    }
    //***********************编辑管理员**********************************************************
    @ResponseBody
    @RequestMapping(value = "/adminEdit",method = RequestMethod.GET)
    public JsonResult adminEdit(@RequestParam(value= "adminId",required = false) Integer adminId){
        JsonResult result =null;
        try {
            Admin oneAdmin= adminService.selectAdmin(adminId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑管理员功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑管理员功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑管理员功能-查询单个管理员出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/adminEdit2",method = RequestMethod.POST)
    public JsonResult adminEdits(@RequestBody EditAdminReqBO editAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= adminService.updateAdmin(editAdminReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑管理员成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑管理员失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑管理员出错了");
        }
        return result;
    }
    //***********************修改密码**********************************************************
    @ResponseBody
    @RequestMapping(value = "/adminUpdatePass",method = RequestMethod.POST)
    public JsonResult adminUpdatePass(@RequestBody UpdateAdminPassReqBO editAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= adminService.updatePass(editAdminReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"修改密码成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"修改密码失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"修改密码出错了");
        }
        return result;
    }
    //***********************个人信息**********************************************************
    @ResponseBody
    @RequestMapping(value = "/adminInfo",method = RequestMethod.GET)
    public JsonResult adminInfo(@RequestParam(value= "adminName",required = false) String adminName){
        JsonResult result =null;
        try {
            Admin oneAdmin= adminService.PersonInfo(adminName);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"个人信息成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"个人信息失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"个人信息出错了");
        }
        return result;
    }
    //***********************更新状态**********************************************************
    @ResponseBody
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.GET)
    public JsonResult updateAdmin(@RequestParam(value= "adminId",required = false) Integer adminId){
        JsonResult result =null;
        try {
             int issuccess=adminService.updateStatus(adminId);

            if(issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"更新状态成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"更新状态失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"更新状态出错了");
        }
        return result;
    }
}
