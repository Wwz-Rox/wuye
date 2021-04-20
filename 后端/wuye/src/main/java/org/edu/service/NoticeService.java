package org.edu.service;

import org.edu.bo.notice.AddNoticeReqBO;
import org.edu.bo.notice.EditNoticeReqBO;
import org.edu.bo.notice.QryNoticeReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Notice;

/**
 * 标题:公告
 */
public interface NoticeService {
    //查询公告
    RspPageBO<Notice> QryNotice(QryNoticeReqBO qryNoticeReqBO);
    //删除公告
    int deleteNotice(Integer noticeId);
    //添加公告
    int addNotice(AddNoticeReqBO addNoticeReqBO);
    //编辑公告
    Notice selectNotice(Integer noticeId);
    int updateNotice(EditNoticeReqBO editNoticeReqBO);
}
