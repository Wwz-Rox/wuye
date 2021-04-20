package org.edu.bo.employee;

import java.util.Date;

public class AddEmployeeReqBO {
    private String employeeCode;

    private String employeeName;

    private String employeePhone;

    private String employeeIdcard;

    private String employeeAddr;

    private String employeeType;

    private Integer age;

    private String sex;

    private String ismarriage;

//    private Date workTime;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode == null ? null : employeeCode.trim();
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone == null ? null : employeePhone.trim();
    }

    public String getEmployeeIdcard() {
        return employeeIdcard;
    }

    public void setEmployeeIdcard(String employeeIdcard) {
        this.employeeIdcard = employeeIdcard == null ? null : employeeIdcard.trim();
    }

    public String getEmployeeAddr() {
        return employeeAddr;
    }

    public void setEmployeeAddr(String employeeAddr) {
        this.employeeAddr = employeeAddr == null ? null : employeeAddr.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIsmarriage() {
        return ismarriage;
    }

    public void setIsmarriage(String ismarriage) {
        this.ismarriage = ismarriage == null ? null : ismarriage.trim();
    }

//    public Date getWorkTime() {
//        return workTime;
//    }
//
//    public void setWorkTime(Date workTime) {
//        this.workTime = workTime;
//    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "AddEmployeeReqBO{" +
                "employeeCode='" + employeeCode + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeIdcard='" + employeeIdcard + '\'' +
                ", employeeAddr='" + employeeAddr + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", ismarriage='" + ismarriage + '\'' +
                '}';
    }
}
