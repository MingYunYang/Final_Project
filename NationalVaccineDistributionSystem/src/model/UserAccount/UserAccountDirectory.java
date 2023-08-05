package model.UserAccount;

import model.Employee.Employee;
import model.EmployeeRole.EmployeeRole;
import java.util.ArrayList;

public class UserAccountDirectory {

    private final ArrayList<UserAccount> listOfAccounts;

    public UserAccountDirectory() {
        listOfAccounts = new ArrayList<>();
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : listOfAccounts) {
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, EmployeeRole role) {
        UserAccount userAccount = new UserAccount(username, password, employee, role);
        listOfAccounts.add(userAccount);
        return userAccount;
    }

    public ArrayList<UserAccount> getListOfUserAccounts() {
        return listOfAccounts;
    }

}
