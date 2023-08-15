package nvds.employee;

import java.util.ArrayList;

/**
 * @author libby
 * @author mutara
 */
public class EmployeeDirectory {

    private final ArrayList<Employee> employeeList;

    public EmployeeDirectory () {
        this.employeeList = new ArrayList<>();
    }

    public Employee addEmployee ( String name ) {
        Employee e = new Employee( name );
        employeeList.add( e );
        return e;
    }

    public ArrayList<Employee> getEmployeeList () {
        return employeeList;
    }

}
