package nvds.Useraccount;

import nvds.Employee.Employee;
import nvds.OrganizationEmployeeRole.OrganizationEmployeeUserAccountRole;

public class UserAccount {

    private String username;

    private String password;

    private Employee organizationEmployee;

    private OrganizationEmployeeUserAccountRole organizationEmployeeRole;


    public UserAccount(String username , String password , Employee organizationEmployee , OrganizationEmployeeUserAccountRole organizationEmployeeRole) {
        this.username = username;
        this.password = password;
        this.organizationEmployee = organizationEmployee;
        organizationEmployee.setEmployeeUserAccount(this);
        this.organizationEmployeeRole = organizationEmployeeRole;
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

    public OrganizationEmployeeUserAccountRole getOrganizationEmployeeRole() {
        return organizationEmployeeRole;
    }

    public void setOrganizationEmployee(Employee organizationEmployee) {
        this.organizationEmployee = organizationEmployee;
    }

    public void setOrganizationEmployeeRole(OrganizationEmployeeUserAccountRole organizationEmployeeRole) {
        this.organizationEmployeeRole = organizationEmployeeRole;
    }

    public Employee getOrganizationEmployee() {
        return organizationEmployee;
    }

    @Override
    public String toString() {
        return organizationEmployee.getOrganizationEmployeeName();
    }


}
