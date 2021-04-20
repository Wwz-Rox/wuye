package org.edu.controller;

import org.edu.bo.repairPerson.AddRepairPersonReqBO;
import org.edu.bo.repairPerson.EditRepairPersonReqBO;
import org.edu.bo.repairPerson.QryRepairPersonReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.RepairPerson;
import org.edu.service.RepairPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:维修人员模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class RepairPersonController {
    /*private static Logger logger = LoggerFactory.getLogger(BankController.class);*/
    @Autowired
    private RepairPersonService repairPersonService;

    //*****************************添加维修人员**********************************************************
    @ResponseBody
    @RequestMapping(value = "/addRepairPerson",method = RequestMethod.POST )
    public JsonResult addRepairPerson(@RequestBody AddRepairPersonReqBO addRepairPersonReqBO){
        JsonResult result =null;
        try {
            int issuccess= repairPersonService.addRepairPerson(addRepairPersonReqBO);
//            System.out.println("进入添加维修人员Controller");
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
    //*****************************维修人员查询**********************************************************
    @ResponseBody
    @RequestMapping(value = "/repairPersonList",method = RequestMethod.POST)
    public JsonResult repairPersonList(@RequestBody(required = false) QryRepairPersonReqBO qryRepairPersonReqBO){
        JsonResult result =null;
        try {
            RspPageBO<RepairPerson> RepairPersonList= repairPersonService.qryRepairPerson(qryRepairPersonReqBO);
            System.out.println("进入维修人员查询Controller");
            if(null != RepairPersonList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",RepairPersonList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询出错了");
        }
        return result;
    }
    //***********************删除维修人员**********************************************************
    @ResponseBody
    @RequestMapping(value = "/repairPersonDel",method = RequestMethod.GET)
    public JsonResult repairPersonDel(@RequestParam(value= "repairId",required = false) Integer repairId){
        JsonResult result =null;
        try {
            int issuccess= repairPersonService.deleteRepairPerson(repairId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除维修人员出错了");
        }
        return result;
    }
    //***********************编辑维修人员**********************************************************
    @ResponseBody
    @RequestMapping(value = "/repairPersonEdit",method = RequestMethod.GET)
    public JsonResult repairPersonEdit(@RequestParam(value= "repairId",required = false) Integer repairId){
        JsonResult result =null;
        try {
            RepairPerson onerepairPerson= repairPersonService.selectRepairPerson(repairId);

            if( null != onerepairPerson){
                result =new JsonResult( STATUS_SUCCESS,"编辑维修人员功能-查询单个成功",onerepairPerson);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑维修人员功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑维修人员功能-查询单个维修人员出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/repairPersonEdit2",method = RequestMethod.POST)
    public JsonResult repairPersonEdits(@RequestBody EditRepairPersonReqBO editRepairPersonReqBO){
        JsonResult result =null;
        try {
            int issuccess= repairPersonService.updateRepairPerson(editRepairPersonReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑维修人员成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑维修人员失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑维修人员出错了");
        }
        return result;
    }















}
