package org.edu.dao;

import org.edu.bo.employee.AddEmployeeReqBO;
import org.edu.bo.employee.EditEmployeeReqBO;
import org.edu.bo.employee.QryEmployeeReqBO;
import org.edu.common.page.mybatis.Page;
import org.edu.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    //删除员工
    int deleteByPrimaryKey(Integer employeeId);
    //添加员工
    int insertSelective(AddEmployeeReqBO record);
    //编辑员工
    Employee selectByPrimaryKey(Integer employeeId);
    int updateByPrimaryKeySelective(EditEmployeeReqBO record);
    //查询员工列表
    List<Employee> selectToEmployee(QryEmployeeReqBO qryEmployeeReqBO, Page<Employee> page);
    //查询员工是否存在
    Employee selectIsExist(Map<String, Object> params);

    int updateByPrimaryKey(Employee record);
    int insert(Employee record);
}