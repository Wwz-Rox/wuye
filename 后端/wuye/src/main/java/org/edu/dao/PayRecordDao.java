package org.edu.dao;

import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.PayRecord;

import java.util.List;

public interface PayRecordDao {
    //缴费记录删除
    int deleteByPrimaryKey(Integer pcordId);
    //查询缴费记录
    List<PayRecord> selectPayRecord(QryPayRecordReqBO qryPayRecordReqBO, Page<PayRecord> page);

    int insert(PayRecord record);
    //插入缴费记录表
    int insertSelective(PayRecord record);

    PayRecord selectByPrimaryKey(Integer pcordId);

    int updateByPrimaryKeySelective(PayRecord record);

    int updateByPrimaryKey(PayRecord record);
}