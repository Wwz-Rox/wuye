package org.edu.controller;

import org.edu.bo.house.AddHouseReqBO;
import org.edu.bo.house.EditHouseReqBO;
import org.edu.bo.house.QryHouseReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.House;
import org.edu.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:房屋模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class HouseController {
    //private static Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private HouseService houseService;
    //******************************查询房屋列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseList",method = RequestMethod.POST)
    public JsonResult HouseList(@RequestBody(required = false) QryHouseReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<House> adminList= houseService.QryHouse(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询房屋列表出错了");
        }
        return result;
    }
    //***********************删除房屋**********************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseDel",method = RequestMethod.GET)
    public JsonResult HouseDel(@RequestParam(value= "houseId",required = false) Long houseId){
        JsonResult result =null;
        try {
            int issuccess= houseService.deleteHouse(houseId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除房屋出错了");
        }
        return result;
    }
    //***********************添加房屋**********************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseAdd",method = RequestMethod.POST)
    public JsonResult HouseAdd(@RequestBody AddHouseReqBO addAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= houseService.addHouse(addAdminReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加房屋出错了");
        }
        return result;
    }
    //***********************编辑房屋**********************************************************
    @ResponseBody
    @RequestMapping(value = "/HouseEdit",method = RequestMethod.GET)
    public JsonResult HouseEdit(@RequestParam(value= "houseId",required = false) Long houseId){
        JsonResult result =null;
        try {
            House oneAdmin= houseService.selectHouse(houseId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑房屋功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑房屋功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑房屋功能-查询单个房屋出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/HouseEdit2",method = RequestMethod.POST)
    public JsonResult HouseEdits(@RequestBody EditHouseReqBO editAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= houseService.updateHouse(editAdminReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑房屋成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑房屋失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑房屋出错了");
        }
        return result;
    }


}
