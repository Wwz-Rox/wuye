package org.edu.service.impl;

import org.edu.bo.employee.AddEmployeeReqBO;
import org.edu.bo.employee.EditEmployeeReqBO;
import org.edu.bo.employee.QryEmployeeReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.common.page.mybatis.Page;
import org.edu.dao.EmployeeDao;
import org.edu.model.Employee;
import org.edu.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 标题:员工模块实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final static Boolean isDebugEnabled = logger.isDebugEnabled();
    @Autowired
    private EmployeeDao employeeDao;
    //******************************查询员工********************************************************************
    @Override
    public RspPageBO<Employee> QryEmployee(QryEmployeeReqBO qryEmployeeReqBO) {

            if (isDebugEnabled) {
                logger.debug("查询员工列表服务入参{}" + qryEmployeeReqBO.toString());
            }
            RspPageBO<Employee> rspPageBO = new RspPageBO<Employee>();
            try{
                Page<Employee> page = new Page<Employee>(qryEmployeeReqBO.getPageNo(),qryEmployeeReqBO.getPageSize());
                List<Employee> adminList=employeeDao.selectToEmployee(qryEmployeeReqBO,page);
                rspPageBO.setRows(adminList);
                rspPageBO.setPageNo(qryEmployeeReqBO.getPageNo());
                rspPageBO.setRecordsTotal(page.getTotalCount());
                rspPageBO.setTotal(page.getTotalPages());
                return rspPageBO;
            }catch(Exception e){
                logger.error("查询员工列表服务失败啦", e);
                throw new RuntimeException();
            }

        }
    //******************************删除员工********************************************************************
    @Override
    public int deleteEmployee(Integer employeeId) {
        if (isDebugEnabled) {
            logger.debug("删除员工服务入参{}" + employeeId);
        }
        return employeeDao.deleteByPrimaryKey(employeeId);
    }
    //******************************添加员工********************************************************************
    @Override
    public int addEmployee(AddEmployeeReqBO addEmployeeReqBO) {
        if (isDebugEnabled) {
            logger.debug("添加员工服务入参{}" + addEmployeeReqBO.toString());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("employeeCode", addEmployeeReqBO.getEmployeeCode());
        params.put("employeeName", addEmployeeReqBO.getEmployeeName());
        Employee employee=employeeDao.selectIsExist(params);
        if(null == employee){
            int  a=(int)(Math.random()*90000+10000);
            char str= (char)(Math.random ()*26+'A');
            String  code =String.valueOf(str)+a;
            addEmployeeReqBO.setEmployeeCode(code);
            return employeeDao.insertSelective(addEmployeeReqBO);
        }else{
            return -1;
        }

    }
    //******************************编辑员工********************************************************************
    @Override
    public Employee selectEmployee(Integer employeeId) {
        if (isDebugEnabled) {
            logger.debug("编辑-查询员工服务入参{}" + employeeId);
        }
        return employeeDao.selectByPrimaryKey(employeeId);
    }
    @Override
    public int updateEmployee(EditEmployeeReqBO editEmployeeReqBO) {
        if (isDebugEnabled) {
            logger.debug("编辑员工服务入参{}" + editEmployeeReqBO.toString());
        }
        return employeeDao.updateByPrimaryKeySelective(editEmployeeReqBO);
    }
}
