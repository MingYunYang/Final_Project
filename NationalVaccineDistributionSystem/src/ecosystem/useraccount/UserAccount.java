package ecosystem.useraccount;

import ecosystem.employee.Employee;
import ecosystem.role.Role;
import ecosystem.workqueue.WorkQueue;

public class UserAccount {

    private String username;

    private String password;

    private Employee employee;

    private Role role;

    private WorkQueue workQueue;

    public UserAccount(String username, String password, Employee employee, Role role) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        employee.setUserAccount(this);
        this.role = role;
        workQueue = new WorkQueue();
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

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

}
