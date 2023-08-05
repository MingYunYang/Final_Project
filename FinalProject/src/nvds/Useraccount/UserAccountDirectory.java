package nvds.Useraccount;

import nvds.Employee.Employee;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeRole;
import java.util.ArrayList;

public class UserAccountDirectory {

    private final ArrayList<UserAccount> listOfUserAccounts;

    public UserAccountDirectory() {
        listOfUserAccounts = new ArrayList<>();
    }

    public UserAccount authenticateUser(String username , String password) {
        for ( UserAccount ua : listOfUserAccounts ) {
            if ( ua.getUsername().equals(username) && ua.getPassword().equals(password) ) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username , String password , Employee employeeName , OrganizationEmployeeRole organizationEmployeeRole) {
        UserAccount userAccount = new UserAccount(username , password , employeeName , organizationEmployeeRole);
        listOfUserAccounts.add(userAccount);
        return userAccount;
    }

    public ArrayList<UserAccount> getListOfUserAccounts() {
        return listOfUserAccounts;
    }

}