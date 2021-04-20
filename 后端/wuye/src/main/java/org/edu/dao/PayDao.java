package org.edu.dao;

import org.edu.bo.money.PayMoneyReqBO;
import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.bo.money.QryPayReqBO;
import org.edu.bo.money.UpdatePayMoneyReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Pay;

import java.util.List;

public interface PayDao {
    int insert(Pay record);
    //缴费
    int insertSelective(PayMoneyReqBO record);
    //更新数据
    int updateByPrimaryKeySelective(UpdatePayMoneyReqBO updatePayMoneyReqBO);
    //根据姓名、身份证号和缴费类型查询缴费表
    Pay selectPayInfo(QryPayReqBO qryPayReqBO);

    Pay selectByPrimaryKey(Integer payId);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);


}