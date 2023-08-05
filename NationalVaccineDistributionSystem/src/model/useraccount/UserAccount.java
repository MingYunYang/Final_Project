package model.useraccount;

import model.Employee.Employee;
import model.role.EmployeeRole;

public class UserAccount {

    private String username;

    private String password;

    private Employee employee;

    private EmployeeRole role;
   

    public UserAccount(String username, String password, Employee employee, EmployeeRole role) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        employee.setEmployeeUserAccount(this);
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    @Override
    public String toString(){
        return employee.getEmployeeName();
    }
   

}
