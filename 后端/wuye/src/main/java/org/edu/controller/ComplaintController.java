package org.edu.controller;

import org.edu.bo.complaint.AddComplaintReqBO;
import org.edu.bo.complaint.EditComplaintReqBO;
import org.edu.bo.complaint.QryComplaintReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Complaint;
import org.edu.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.STATUS_FAILURE;
import static org.edu.common.json.Constants.STATUS_SUCCESS;
import static org.edu.common.json.Constants.STATUS_UNFOUND;


@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class ComplaintController {
    //private static Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private ComplaintService complaintService;
    //******************************查询投诉列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/ComplaintList",method = RequestMethod.POST)
    public JsonResult ComplaintList(@RequestBody(required = false) QryComplaintReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<Complaint> adminList= complaintService.QryComplaint(qryAdminReqBO);
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
    //***********************删除投诉**********************************************************
    @ResponseBody
    @RequestMapping(value = "/ComplaintDel",method = RequestMethod.GET)
    public JsonResult ComplaintDel(@RequestParam(value= "complaintId",required = false) Integer complaintId){
        JsonResult result =null;
        try {
            int issuccess= complaintService.deleteComplaint(complaintId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除投诉出错了");
        }
        return result;
    }
    //***********************添加投诉**********************************************************
    @ResponseBody
    @RequestMapping(value = "/ComplaintAdd",method = RequestMethod.POST)
    public JsonResult ComplaintAdd(@RequestBody AddComplaintReqBO addAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= complaintService.addComplaint(addAdminReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加投诉出错了");
        }
        return result;
    }
    //***********************编辑投诉**********************************************************
    @ResponseBody
    @RequestMapping(value = "/ComplaintEdit",method = RequestMethod.GET)
    public JsonResult ComplaintEdit(@RequestParam(value= "complaintId",required = false) Integer complaintId){
        JsonResult result =null;
        try {
            Complaint oneAdmin= complaintService.selectComplaint(complaintId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑投诉功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑投诉功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑投诉功能-查询单个投诉出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/ComplaintEdit2",method = RequestMethod.POST)
    public JsonResult ComplaintEdit2(@RequestBody EditComplaintReqBO editComplaintReqBO){
        JsonResult result =null;
        try {
            int issuccess= complaintService.updateComplaint(editComplaintReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑投诉成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑投诉失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑投诉出错了");
        }
        return result;
    }
}
