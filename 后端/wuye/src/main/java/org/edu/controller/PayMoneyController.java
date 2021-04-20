package org.edu.controller;

import org.edu.bo.money.PayMoneyReqBO;
import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.bo.money.QryPayReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Pay;
import org.edu.service.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;

/**
 * 标题:缴费模块
 */
@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class PayMoneyController {
    //private static Logger logger = LoggerFactory.getLogger(PayMoneyController.class);
    @Autowired
    PayMoneyService payMoneyService;
    //*****************************根据姓名、身份证号和缴费类型查询缴费表**********************************************************
    @ResponseBody
    @RequestMapping(value = "/selectPayInfo",method = RequestMethod.POST )
    public JsonResult selectPayInfo(@RequestBody QryPayReqBO qryPayReqBO){
        JsonResult result =null;
        try {
            Pay pay= payMoneyService.selectPayInfo(qryPayReqBO);
            if( null != pay   ){
                result =new JsonResult( STATUS_SUCCESS,"查询缴费成功",pay);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询缴费失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询缴费出错了");
        }
        return result;
    }
    //*****************************缴水费**********************************************************
    @ResponseBody
    @RequestMapping(value = "/payMoney",method = RequestMethod.POST )
    public JsonResult payMoney(@RequestBody PayMoneyReqBO payMoneyReqBO){
        JsonResult result =null;
        try {
            int issuccess= payMoneyService.addpayMoneyWater(payMoneyReqBO);
                System.out.println("进入缴费Controller");
            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"缴费成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"缴费失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"缴费出错了");
        }
        return result;
    }
    //*****************************缴物业费**********************************************************
    @ResponseBody
    @RequestMapping(value = "/payMoneyWuye",method = RequestMethod.POST )
    public JsonResult payMoneyWuye(@RequestBody PayMoneyReqBO payMoneyReqBO){
        JsonResult result =null;
        try {
            int issuccess= payMoneyService.addpayMoneyWuye(payMoneyReqBO);
            System.out.println("进入缴费Controller");
            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"缴费成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"缴费失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"缴费出错了");
        }
        return result;
    }
    //*****************************缴燃气费**********************************************************
    @ResponseBody
    @RequestMapping(value = "/payMoneyGas",method = RequestMethod.POST )
    public JsonResult payMoneyGas(@RequestBody PayMoneyReqBO payMoneyReqBO){
        JsonResult result =null;
        try {
            int issuccess= payMoneyService.addpayMoneyGas(payMoneyReqBO);
            System.out.println("进入缴费Controller");
            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"缴费成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"缴费失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"缴费出错了");
        }
        return result;
    }
    //*****************************缴电费**********************************************************
    @ResponseBody
    @RequestMapping(value = "/payMoneyEle",method = RequestMethod.POST )
    public JsonResult payMoneyEle(@RequestBody PayMoneyReqBO payMoneyReqBO){
        JsonResult result =null;
        try {
            int issuccess= payMoneyService.addpayMoneyEle(payMoneyReqBO);
            System.out.println("进入缴费Controller");
            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"缴费成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"缴费失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"缴费出错了");
        }
        return result;
    }





















}
