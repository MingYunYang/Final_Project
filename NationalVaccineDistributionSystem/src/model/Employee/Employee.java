package model.Employee;

import model.UserAccount.UserAccount;

public class Employee {

    private String employeeName;

    private final int EMPLOYEE_ID;

    private static int nextId = 0;

    private UserAccount employeeUserAccount;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
        EMPLOYEE_ID = nextId;
        nextId ++;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public UserAccount getEmployeeUserAccount() {
        return employeeUserAccount;
    }

    public void setEmployeeUserAccount(UserAccount employeeUserAccount) {
        this.employeeUserAccount = employeeUserAccount;
    }

    @Override
    public String toString() {
        return employeeName;
    }

}
