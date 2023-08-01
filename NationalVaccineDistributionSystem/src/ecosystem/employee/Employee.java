package ecosystem.employee;

import ecosystem.useraccount.UserAccount;

public class Employee {

    private String employeeName;

    private final int employeeID;

    private static int count = 1;
    
    private UserAccount userAccount;

    public Employee(String name) {
        employeeName = name;
        employeeID = count;
        count++;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return employeeName;
    }

}
