package org.edu.service.impl;

import org.edu.bo.complaint.AddComplaintReqBO;
import org.edu.bo.complaint.EditComplaintReqBO;
import org.edu.bo.complaint.QryComplaintReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.ComplaintDao;
import org.edu.model.Complaint;
import org.edu.service.ComplaintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ComplaintServiceImpl implements ComplaintService {
    private final static Logger logger = LoggerFactory.getLogger(ComplaintServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private ComplaintDao complaintDao;
    //******************************查询投诉********************************************************************
    @Override
    public RspPageBO<Complaint> QryComplaint(QryComplaintReqBO qryComplaintReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询房屋列表服务入参{}" + qryComplaintReqBO.toString());
        }
        RspPageBO<Complaint> rspPageBO = new RspPageBO<Complaint>();
        try{
            Page<Complaint> page = new Page<Complaint>(qryComplaintReqBO.getPageNo(),qryComplaintReqBO.getPageSize());
            List<Complaint> adminList=complaintDao.selectComplaintList(qryComplaintReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryComplaintReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询投诉列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除投诉********************************************************************
    @Override
    public int deleteComplaint(Integer complaintId) {
        if (isDebugEnabled) {
            logger.debug("删除投诉服务入参{}" + complaintId);
        }
        return complaintDao.deleteByPrimaryKey(complaintId);
    }
    //******************************添加投诉********************************************************************
    @Override
    public int addComplaint(AddComplaintReqBO addComplaintReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加投诉服务入参{}" + addComplaintReqBO.toString());
        }

        Complaint house=complaintDao.selectComplaintIsExist(addComplaintReqBO.getComplaintTitle());
        if (null == house) {
            return complaintDao.insertSelective(addComplaintReqBO);
        }else{
            return -1;
        }
    }
    //******************************编辑投诉********************************************************************
    @Override
    public Complaint selectComplaint(Integer complaintId) {
        if (isDebugEnabled) {
            logger.debug("编辑-查询投诉服务入参{}" + complaintId);
        }
        return complaintDao.selectByPrimaryKey(complaintId);
    }

    @Override
    public int updateComplaint(EditComplaintReqBO editComplaintReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑投诉服务入参{}" + editComplaintReqBO.toString());
        }
        return complaintDao.updateByPrimaryKeySelective(editComplaintReqBO);
    }
}
