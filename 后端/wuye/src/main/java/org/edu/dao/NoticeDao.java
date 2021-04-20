package org.edu.dao;

import org.edu.bo.notice.AddNoticeReqBO;
import org.edu.bo.notice.EditNoticeReqBO;
import org.edu.bo.notice.QryNoticeReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Notice;

import java.util.List;

public interface NoticeDao {
    //删除公告
    int deleteByPrimaryKey(Integer noticeId);
    //添加公告
    int insertSelective(AddNoticeReqBO record);
    //编辑公告
    Notice selectByPrimaryKey(Integer noticeId);
    int updateByPrimaryKeySelective(EditNoticeReqBO record);
    //查询公告是否存在
    Notice selectNoticeIsExist(String name);
    //查询公告列表
    List<Notice> selectNoticeList(QryNoticeReqBO qryNoticeReqBO, Page<Notice> page);




    int updateByPrimaryKey(Notice record);
    int insert(Notice record);
}