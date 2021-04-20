package org.edu.service;

import org.edu.bo.complaint.AddComplaintReqBO;
import org.edu.bo.complaint.EditComplaintReqBO;
import org.edu.bo.complaint.QryComplaintReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Complaint;

/**
 * 标题:投诉
 */
public interface ComplaintService {
    //查询投诉
    RspPageBO<Complaint> QryComplaint(QryComplaintReqBO qryComplaintReqBO);
    //删除投诉
    int deleteComplaint(Integer complaintId);
    //添加投诉
    int addComplaint(AddComplaintReqBO addComplaintReqBO);
    //编辑投诉
    Complaint selectComplaint(Integer complaintId);
    int updateComplaint(EditComplaintReqBO editComplaintReqBO);
}
