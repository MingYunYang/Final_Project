package nvds.employee;

import nvds.useraccount.UserAccount;

public class Employee {

    private String name;

    private final int id;

    private static int count = 1;

    private UserAccount userAccount;

    public Employee(String name) {
        this.name = name;
        id = count;
        count++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return name;
    }

}
