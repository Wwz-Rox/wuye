package org.edu.controller;

import org.edu.bo.household.AddHouseholdReqBO;
import org.edu.bo.household.EditHouseholdReqBO;
import org.edu.bo.household.QryHouseholdReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Household;
import org.edu.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:租户模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class HouseholdController {
    //private static Logger logger = LoggerFactory.getLogger(HouseholdController.class);
    @Autowired
    private HouseholdService householdService;
    //******************************查询租户列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseholdList",method = RequestMethod.POST)
    public JsonResult HouseholdList(@RequestBody(required = false) QryHouseholdReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<Household> adminList= householdService.QryHousehold(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询租户列表出错了");
        }
        return result;
    }
    //***********************删除租户**********************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseholdDel",method = RequestMethod.GET)
    public JsonResult HouseholdDel(@RequestParam(value= "householdId",required = false) Long householdId){
        JsonResult result =null;
        try {
            int issuccess= householdService.deleteHousehold(householdId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除租户出错了");
        }
        return result;
    }
    //***********************添加租户**********************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseholdAdd",method = RequestMethod.POST)
    public JsonResult HouseholdAdd(@RequestBody AddHouseholdReqBO addHouseholdReqBO){
        JsonResult result =null;
        try {
            int issuccess= householdService.addHousehold(addHouseholdReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加租户出错了");
        }
        return result;
    }
    //***********************编辑租户**********************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseholdEdit",method = RequestMethod.GET)
    public JsonResult HouseholdEdit(@RequestParam(value= "householdId",required = false) Long householdId){
        JsonResult result =null;
        try {
            Household oneAdmin= householdService.selectHousehold(householdId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑租户功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑租户功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑租户功能-查询单个租户出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/HouseholdEdit2",method = RequestMethod.POST)
    public JsonResult HouseholdEdits(@RequestBody EditHouseholdReqBO editHouseholdReqBO){
        JsonResult result =null;
        try {
            int issuccess= householdService.updateHousehold(editHouseholdReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑租户成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑租户失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑租户出错了");
        }
        return result;
    }

}
