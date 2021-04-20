package org.edu.dao;

import org.edu.bo.complaint.AddComplaintReqBO;
import org.edu.bo.complaint.EditComplaintReqBO;
import org.edu.bo.complaint.QryComplaintReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Complaint;

import java.util.List;

public interface ComplaintDao {
    //查询投诉是否存在
    Complaint selectComplaintIsExist(String name);
    //查询投诉列表
    List<Complaint> selectComplaintList(QryComplaintReqBO qryComplaintReqBO, Page<Complaint> page);
    //删除投诉
    int deleteByPrimaryKey(Integer complaintId);
    //添加投诉
    int insertSelective(AddComplaintReqBO record);
    //编辑投诉
    Complaint selectByPrimaryKey(Integer complaintId);
    int updateByPrimaryKeySelective(EditComplaintReqBO record);




    int updateByPrimaryKey(Complaint record);
    int insert(Complaint record);
}