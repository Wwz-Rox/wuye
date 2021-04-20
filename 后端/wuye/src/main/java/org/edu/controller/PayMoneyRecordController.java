package org.edu.controller;

import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.PayRecord;
import org.edu.service.PayMoneyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.STATUS_FAILURE;
import static org.edu.common.json.Constants.STATUS_SUCCESS;
import static org.edu.common.json.Constants.STATUS_UNFOUND;


@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class PayMoneyRecordController {
    //private static Logger logger = LoggerFactory.getLogger(PayMoneyRecordController.class);
    @Autowired
    PayMoneyRecordService PayMoneyRecordService;
    //*****************************缴费记录查询**********************************************************
    @ResponseBody
    @RequestMapping(value = "/payRecordList",method = RequestMethod.POST)
    public JsonResult payRecordList(@RequestBody(required = false) QryPayRecordReqBO qryPayRecordReqBO){
        JsonResult result =null;
        try {
            RspPageBO<PayRecord> PayRecordList= PayMoneyRecordService.QryPayRecord(qryPayRecordReqBO);
//            System.out.println("进入缴费记录查询Controller");
            if(null != PayRecordList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",PayRecordList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询出错了");
        }
        return result;
    }
    //***********************删除缴费记录**********************************************************
    @ResponseBody
    @RequestMapping(value = "/payRecordListDel",method = RequestMethod.GET)
    public JsonResult payRecordListDel(@RequestParam(value= "pcordId",required = false) Integer pcordId){
        JsonResult result =null;
        try {
            int issuccess= PayMoneyRecordService.deletePayRecord(pcordId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除缴费记录出错了");
        }
        return result;
    }
}
