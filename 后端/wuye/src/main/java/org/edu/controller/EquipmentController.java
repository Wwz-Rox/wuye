package org.edu.controller;

import org.edu.bo.equipment.AddEquipmentReqBO;
import org.edu.bo.equipment.EditEquipmentReqBO;
import org.edu.bo.equipment.QryEquipmentReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Equipment;
import org.edu.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:设备模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class EquipmentController {
    //private static Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private EquipmentService equipmentService;

    //******************************查询设备列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/equipmentList",method = RequestMethod.POST)
    public JsonResult equipmentList(@RequestBody(required = false) QryEquipmentReqBO qryEquipmentReqBO){
        JsonResult result =null;
        try {
            System.out.println("进入查询设备列表Controller");

            RspPageBO<Equipment> adminList= equipmentService.qryEquipment(qryEquipmentReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询设备列表出错了");
        }
        return result;
    }

    //***********************添加设备**********************************************************
    @ResponseBody
    @RequestMapping(value = "/equipmentAdd",method = RequestMethod.POST)
    public JsonResult equipmentAdd(@RequestBody AddEquipmentReqBO addEquipmentReqBO){
        JsonResult result =null;
        try {
            int issuccess= equipmentService.addEquipment(addEquipmentReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加设备出错了");
        }
        return result;
    }
    //***********************删除设备**********************************************************
    @ResponseBody
    @RequestMapping(value = "/equipmentDel",method = RequestMethod.GET)
    public JsonResult equipmentDel(@RequestParam(value= "equipmentId",required = false) Long equipmentId){
        JsonResult result =null;
        try {
            int issuccess= equipmentService.deleteEquipment(equipmentId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除设备出错了");
        }
        return result;
    }
    //***********************编辑设备**********************************************************
    @ResponseBody
    @RequestMapping(value = "/equipmentIdEdit",method = RequestMethod.GET)
    public JsonResult equipmentIdEdit(@RequestParam(value= "equipmentId",required = false) Long equipmentId){
        JsonResult result =null;
        try {
            Equipment oneAdmin= equipmentService.selectEquipment(equipmentId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑设备功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑设备功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑设备功能-查询单个设备出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/equipmentIdEdit2",method = RequestMethod.POST)
    public JsonResult EmployeeEdits(@RequestBody EditEquipmentReqBO editAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= equipmentService.updateEquipment(editAdminReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑设备成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑设备失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑设备出错了");
        }
        return result;
    }


}
