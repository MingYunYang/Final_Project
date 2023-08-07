package nvds.useraccount;

import nvds.employee.Employee;
import nvds.role.Role;

public class UserAccount {

    private String username;

    private String password;

    private Employee employee;

    private Role role;
   

    public UserAccount(String username, String password, Employee employee, Role role) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        employee.setUserAccount(this);
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

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    @Override
    public String toString(){
        return employee.getName();
    }
   

}
