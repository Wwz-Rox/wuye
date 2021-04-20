package org.edu.controller;

import org.edu.bo.repairRecord.QryRepairRecordReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.RepairRecord;
import org.edu.service.RepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:维修记录
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class RepairRecordController {
    /*private static Logger logger = LoggerFactory.getLogger(BankController.class);*/
    @Autowired
    private RepairRecordService repairRecordService;
    //*****************************查询维修记录**********************************************************
    @ResponseBody
    @RequestMapping(value = "/repairRecordList",method = RequestMethod.POST)
    public JsonResult repairRecordList(@RequestBody(required = false) QryRepairRecordReqBO qryRepairRecordReqBO){
        JsonResult result =null;
        try {
            RspPageBO<RepairRecord> repairRecordList= repairRecordService.qryRepairRecord(qryRepairRecordReqBO);
            if(null != repairRecordList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",repairRecordList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询出错了");
        }
        return result;
    }
    //*****************************删除维修记录**********************************************************
    @ResponseBody
    @RequestMapping(value = "/repairRecordDel",method = RequestMethod.GET)
    public JsonResult repairRecordDel(@RequestParam(value= "recordId",required = false) Long recordId){
        JsonResult result =null;
        try {
            int issuccess= repairRecordService.deleteRepairRecord(recordId);

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
}
