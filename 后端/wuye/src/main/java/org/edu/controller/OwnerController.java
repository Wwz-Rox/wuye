package org.edu.controller;

import org.edu.bo.owner.AddOwnerReqBO;
import org.edu.bo.owner.EditOwnerReqBO;
import org.edu.bo.owner.QryOwnerReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Owner;
import org.edu.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:业主模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class OwnerController {
    //private static Logger logger = LoggerFactory.getLogger(OwnerController.class);
    @Autowired
    private OwnerService ownerService;
    //******************************查询业主列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/OwnerList",method = RequestMethod.POST)
    public JsonResult HouseList(@RequestBody(required = false) QryOwnerReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<Owner> adminList= ownerService.QryOwner(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询业主列表出错了");
        }
        return result;
    }
    //***********************删除业主**********************************************************
    @ResponseBody
    @RequestMapping(value = "/OwnerDel",method = RequestMethod.GET)
    public JsonResult OwnerDel(@RequestParam(value= "ownerId",required = false) Long ownerId){
        JsonResult result =null;
        try {
            int issuccess= ownerService.deleteOwner(ownerId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除业主出错了");
        }
        return result;
    }
    //***********************添加业主**********************************************************
    @ResponseBody
    @RequestMapping(value = "/OwnerAdd",method = RequestMethod.POST)
    public JsonResult OwnerAdd(@RequestBody AddOwnerReqBO addOwnerReqBO){
        JsonResult result =null;
        try {
            int issuccess= ownerService.addOwner(addOwnerReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加业主出错了");
        }
        return result;
    }
    //***********************编辑业主**********************************************************
    @ResponseBody
    @RequestMapping(value = "/OwnerEdit",method = RequestMethod.GET)
    public JsonResult OwnerEdit(@RequestParam(value= "ownerId",required = false) Long ownerId){
        JsonResult result =null;
        try {
            Owner oneAdmin= ownerService.selectOwner(ownerId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑业主功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑业主功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑业主功能-查询单个业主出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/OwnerEdit2",method = RequestMethod.POST)
    public JsonResult OwnerEdits(@RequestBody EditOwnerReqBO editOwnerReqBO){
        JsonResult result =null;
        try {
            int issuccess= ownerService.updateOwner(editOwnerReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑业主成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑业主失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑业主出错了");
        }
        return result;
    }

}
