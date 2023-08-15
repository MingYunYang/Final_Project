package nvds.useraccount;

import nvds.employee.Employee;
import nvds.role.Role;
import java.util.ArrayList;

/**
 * @author libby
 * @author mutara
 */
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

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {
        UserAccount userAccount = new UserAccount(username, password, employee, role);
        listOfAccounts.add(userAccount);
        return userAccount;
    }

    public ArrayList<UserAccount> getListOfUserAccounts() {
        return listOfAccounts;
    }

}
