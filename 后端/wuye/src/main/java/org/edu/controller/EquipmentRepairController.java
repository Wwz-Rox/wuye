package org.edu.controller;

import org.edu.bo.equipmentRepair.AddEquipmentRepairReqBO;
import org.edu.bo.equipmentRepair.QryEquipmentRepairReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.EquipmentRepair;
import org.edu.service.EquipmentRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;


@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class EquipmentRepairController {
    /*private static Logger logger = LoggerFactory.getLogger(BankController.class);*/
    @Autowired
    private EquipmentRepairService equipmentRepairService;

    //*****************************添加设备报修**********************************************************
    @ResponseBody
    @RequestMapping(value = "/addEquipmentRepair",method = RequestMethod.POST )
    public JsonResult addEquipmentRepair(@RequestBody AddEquipmentRepairReqBO addEquipmentRepairReqBO){
        JsonResult result =null;
        try {
            int issuccess= equipmentRepairService.addEquipmentRepair(addEquipmentRepairReqBO);
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
    //*****************************设备报修查询**********************************************************
    @ResponseBody
    @RequestMapping(value = "/equipmentRepairList",method = RequestMethod.POST)
    public JsonResult equipmentRepairList(@RequestBody(required = false) QryEquipmentRepairReqBO qryEquipmentRepairReqBO){
        JsonResult result =null;
        try {
            RspPageBO<EquipmentRepair> EquipmentRepairList= equipmentRepairService.qryEquipmentRepair(qryEquipmentRepairReqBO);
            if(null != EquipmentRepairList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",EquipmentRepairList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询出错了");
        }
        return result;
    }
    //***********************删除报修查询**********************************************************
    @ResponseBody
    @RequestMapping(value = "/equipmentRepairListDel",method = RequestMethod.GET)
    public JsonResult equipmentRepairListDel(@RequestParam(value= "equRepairId",required = false) Long equRepairId){
        JsonResult result =null;
        try {
            int issuccess= equipmentRepairService.deleteEquipmentRepair(equRepairId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除报修查询出错了");
        }
        return result;
    }
    //***********************更新状态**********************************************************
    @ResponseBody
    @RequestMapping(value = "/updateStatus",method = RequestMethod.GET)
    public JsonResult updateStatus(@RequestParam(value= "equRepairId",required = false) Long equRepairId){
        JsonResult result =null;
        try {
            int issuccess= equipmentRepairService.updateEquipmentRepair(equRepairId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"更新成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"更新失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"更新报修状态出错了");
        }
        return result;
    }
}
