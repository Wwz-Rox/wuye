package org.edu.controller;

import org.edu.bo.employee.AddEmployeeReqBO;
import org.edu.bo.employee.EditEmployeeReqBO;
import org.edu.bo.employee.QryEmployeeReqBO;
import org.edu.common.json.JsonResult;
import org.edu.common.page.BO.RspPageBO;
import org.edu.model.Employee;
import org.edu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.edu.common.json.Constants.*;


@Controller
@RequestMapping("/wuye")
@CrossOrigin
public class EmployeeController {
    //private static Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private EmployeeService employeeService;
    //******************************查询员工列表********************************************************************
    @ResponseBody
    @RequestMapping(value = "/EmployeeList",method = RequestMethod.POST)
    public JsonResult EmployeeList(@RequestBody(required = false) QryEmployeeReqBO qryAdminReqBO){
        JsonResult result =null;
        try {
            RspPageBO<Employee> adminList= employeeService.QryEmployee(qryAdminReqBO);
            if(null != adminList  ){
                result =new JsonResult( STATUS_SUCCESS,"查询成功",adminList);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"查询失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"查询员工列表出错了");
        }
        return result;
    }
    //***********************删除员工**********************************************************
    @ResponseBody
    @RequestMapping(value = "/EmployeeDel",method = RequestMethod.GET)
    public JsonResult EmployeeDel(@RequestParam(value= "employeeId",required = false) Integer employeeId){
        JsonResult result =null;
        try {
            int issuccess= employeeService.deleteEmployee(employeeId);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"删除成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"删除失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"删除员工出错了");
        }
        return result;
    }
    //***********************添加员工**********************************************************
    @ResponseBody
    @RequestMapping(value = "/EmployeeAdd",method = RequestMethod.POST)
    public JsonResult EmployeeAdd(@RequestBody AddEmployeeReqBO addAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= employeeService.addEmployee(addAdminReqBO);

            if( issuccess > 0 ){
                result =new JsonResult( STATUS_SUCCESS,"添加成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"添加失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"添加员工出错了");
        }
        return result;
    }
    //***********************编辑员工**********************************************************
    @ResponseBody
    @RequestMapping(value = "/EmployeeEdit",method = RequestMethod.GET)
    public JsonResult EmployeeEdit(@RequestParam(value= "employeeId",required = false) Integer employeeId){
        JsonResult result =null;
        try {
            Employee oneAdmin= employeeService.selectEmployee(employeeId);

            if( null != oneAdmin){
                result =new JsonResult( STATUS_SUCCESS,"编辑员工功能-查询单个成功",oneAdmin);
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑员工功能-查询单个失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑员工功能-查询单个员工出错了");
        }
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/EmployeeEdit2",method = RequestMethod.POST)
    public JsonResult EmployeeEdits(@RequestBody EditEmployeeReqBO editAdminReqBO){
        JsonResult result =null;
        try {
            int issuccess= employeeService.updateEmployee(editAdminReqBO);

            if( issuccess  > 0){
                result =new JsonResult( STATUS_SUCCESS,"编辑员工成功");
            }else{
                result =new JsonResult( STATUS_UNFOUND,"编辑员工失败");
            }
        }catch (Exception e){
            result=new JsonResult(STATUS_FAILURE,"编辑员工出错了");
        }
        return result;
    }





















}
