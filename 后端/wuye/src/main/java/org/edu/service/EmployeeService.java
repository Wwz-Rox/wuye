package org.edu.service;

import org.edu.bo.employee.AddEmployeeReqBO;
import org.edu.bo.employee.EditEmployeeReqBO;
import org.edu.bo.employee.QryEmployeeReqBO;
import org.edu.bo.equipment.AddEquipmentReqBO;
import org.edu.bo.equipment.QryEquipmentReqBO;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Employee;

/**
 * 标题:员工模块
 */
public interface EmployeeService {
    //查询员工
    RspPageBO<Employee> QryEmployee(QryEmployeeReqBO qryAdminReqBO);
    //删除员工
    int deleteEmployee(Integer employeeId);
    //添加员工
    int addEmployee(AddEmployeeReqBO addAdminReqBO);
    //编辑员工
    Employee selectEmployee(Integer employeeId);
    int updateEmployee(EditEmployeeReqBO editAdminReqBO);
}
