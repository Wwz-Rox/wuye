package org.edu.controller;

import org.edu.bo.adminRole.AddAdminRoleReqBO;
import org.edu.bo.adminRole.EditAdminRoleReqBO;
import org.edu.bo.adminRole.QryAdminRoleReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.AdminRole;
import org.edu.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;
import static org.edu.common.json.Constants.STATUS_FAILURE;


@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class AdminRoleController {
    //private static Logger logger = LoggerFactory.getLogger(AdminRecordController.class);
    @Autowired
    private AdminRoleService adminRoleService;
    //******************************查询角色********************************************************************
    @ResponseBody
    @RequestMapping(value = "/AdminRoleList",method = RequestMethod.POST)
    public JsonResult AdminRoleList(@RequestBody(required = false) QryAdminRoleReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<AdminRole> adminList= adminRoleService.QryAdminRole(qryAdminReqBO);
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
    @RequestMapping(value = "/AdminRoleDel",method = RequestMethod.GET)
    public JsonResult AdminRoleDel(@RequestParam(value= "adminRoleId",required = false) Integer adminRoleId){
        JsonResult result =null;
        try {
            int issuccess= adminRoleService.deleteAdminRole(adminRoleId);

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
    //***********************添加角色**********************************************************
    @ResponseBody
    @RequestMapping(value = "/AdminRoleAdd",method = RequestMethod.POST)
    public JsonResult AdminRoleAdd(@RequestBody AddAdminRoleReqBO addAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= adminRoleService.addAdminRole(addAdminReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加出错了");
        }
        return result;
    }
    //***********************编辑角色**********************************************************
    @ResponseBody
    @RequestMapping(value = "/AdminRoleEdit",method = RequestMethod.GET)
    public JsonResult AdminRoleEdit(@RequestParam(value= "adminRoleId",required = false) Integer adminRoleId){
        JsonResult result =null;
        try {
            AdminRole oneAdmin= adminRoleService.selectAdminRole(adminRoleId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑管理员角色功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑管理员角色功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑管理员角色功能-查询单个管理员角色出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/AdminRoleEdit2",method = RequestMethod.POST)
    public JsonResult AdminRoleEdits(@RequestBody EditAdminRoleReqBO editAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= adminRoleService.updateAdminRole(editAdminReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑管理员角色成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑管理员角色失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑管理员角色出错了");
        }
        return result;
    }
}
