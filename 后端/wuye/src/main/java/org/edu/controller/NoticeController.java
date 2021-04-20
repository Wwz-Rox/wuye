package org.edu.controller;

import org.edu.bo.complaint.AddComplaintReqBO;
import org.edu.bo.complaint.EditComplaintReqBO;
import org.edu.bo.complaint.QryComplaintReqBO;
import org.edu.bo.notice.AddNoticeReqBO;
import org.edu.bo.notice.EditNoticeReqBO;
import org.edu.bo.notice.QryNoticeReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Complaint;
import org.edu.model.Notice;
import org.edu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.STATUS_FAILURE;
import static org.edu.common.json.Constants.STATUS_SUCCESS;
import static org.edu.common.json.Constants.STATUS_UNFOUND;

@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class NoticeController {
    //private static Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private NoticeService noticeService;
    //******************************查询公告列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/NoticeList",method = RequestMethod.POST)
    public JsonResult ComplaintList(@RequestBody(required = false) QryNoticeReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<Notice> adminList= noticeService.QryNotice(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询公告列表出错了");
        }
        return result;
    }
    //***********************删除公告**********************************************************
    @ResponseBody
    @RequestMapping(value = "/NoticeDel",method = RequestMethod.GET)
    public JsonResult ComplaintDel(@RequestParam(value= "noticeId",required = false) Integer noticeId){
        JsonResult result =null;
        try {
            int issuccess= noticeService.deleteNotice(noticeId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除公告出错了");
        }
        return result;
    }
    //***********************添加公告**********************************************************
    @ResponseBody
    @RequestMapping(value = "/NoticeAdd",method = RequestMethod.POST)
    public JsonResult ComplaintAdd(@RequestBody AddNoticeReqBO addAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= noticeService.addNotice(addAdminReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加公告出错了");
        }
        return result;
    }
    //***********************编辑公告**********************************************************
    @ResponseBody
    @RequestMapping(value = "/NoticeEdit",method = RequestMethod.GET)
    public JsonResult ComplaintEdit(@RequestParam(value= "noticeId",required = false) Integer noticeId){
        JsonResult result =null;
        try {
            Notice oneAdmin= noticeService.selectNotice(noticeId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑公告功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑公告功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑公告功能-查询单个公告出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/NoticeEdit2",method = RequestMethod.POST)
    public JsonResult ComplaintEdit2(@RequestBody EditNoticeReqBO editComplaintReqBO){
        JsonResult result =null;
        try {
            int issuccess= noticeService.updateNotice(editComplaintReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑公告成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑公告失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑公告出错了");
        }
        return result;
    }
}
