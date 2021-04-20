package org.edu.service;

import org.edu.bo.money.PayMoneyReqBO;
import org.edu.bo.money.QryPayRecordReqBO;
import org.edu.bo.money.QryPayReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Pay;

/**
 * 标题:缴费模块Service层
 */
public interface PayMoneyService {

    //缴水费
    int addpayMoneyWater(PayMoneyReqBO payMoneyReqBO);
    //缴电费
    int addpayMoneyEle(PayMoneyReqBO payMoneyReqBO);
    //缴燃气费
    int addpayMoneyGas(PayMoneyReqBO payMoneyReqBO);
    //缴物业费
    int addpayMoneyWuye(PayMoneyReqBO payMoneyReqBO);
    //根据姓名、身份证号和缴费类型查询缴费表
    Pay selectPayInfo(QryPayReqBO qryPayReqBO);

}
