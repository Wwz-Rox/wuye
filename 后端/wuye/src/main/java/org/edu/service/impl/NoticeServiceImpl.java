package org.edu.service.impl;

import org.edu.bo.notice.AddNoticeReqBO;
import org.edu.bo.notice.EditNoticeReqBO;
import org.edu.bo.notice.QryNoticeReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.NoticeDao;
import org.edu.model.Notice;
import org.edu.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final static Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private NoticeDao noticeDao;
    //******************************查询公告********************************************************************
    @Override
    public RspPageBO<Notice> QryNotice(QryNoticeReqBO qryNoticeReqBO) {
        if (isDebugEnabled) {
            logger.debug("查询公告列表服务入参{}" + qryNoticeReqBO.toString());
        }
        RspPageBO<Notice> rspPageBO = new RspPageBO<Notice>();
        try{
            Page<Notice> page = new Page<Notice>(qryNoticeReqBO.getPageNo(),qryNoticeReqBO.getPageSize());
            List<Notice> adminList=noticeDao.selectNoticeList(qryNoticeReqBO,page);
            rspPageBO.setRows(adminList);
            rspPageBO.setPageNo(qryNoticeReqBO.getPageNo());
            rspPageBO.setRecordsTotal(page.getTotalCount());
            rspPageBO.setTotal(page.getTotalPages());
            return rspPageBO;
        }catch(Exception e){
            logger.error("查询公告列表服务失败啦", e);
            throw new RuntimeException();
        }
    }
    //******************************删除公告********************************************************************
    @Override
    public int deleteNotice(Integer noticeId) {
        if (isDebugEnabled) {
            logger.debug("删除公告服务入参{}" + noticeId);
        }
        return noticeDao.deleteByPrimaryKey(noticeId);
    }
    //******************************添加公告********************************************************************
    @Override
    public int addNotice(AddNoticeReqBO addNoticeReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加投诉服务入参{}" + addNoticeReqBO.toString());
        }

        Notice house=noticeDao.selectNoticeIsExist(addNoticeReqBO.getNoticeTitle());
        if (null == house) {
            return noticeDao.insertSelective(addNoticeReqBO);
        }else{
            return -1;
        }
    }
    //******************************编辑公告********************************************************************
    @Override
    public Notice selectNotice(Integer noticeId) {
        if (isDebugEnabled) {
            logger.debug("编辑-查询公告服务入参{}" + noticeId);
        }
        return noticeDao.selectByPrimaryKey(noticeId);
    }

    @Override
    public int updateNotice(EditNoticeReqBO editNoticeReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑公告服务入参{}" + editNoticeReqBO.toString());
        }
        return noticeDao.updateByPrimaryKeySelective(editNoticeReqBO);
    }
}
