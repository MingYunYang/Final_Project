package nvds.Employee;

import java.util.ArrayList;

public class EmployeeDirectory {

    private final ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public Employee addNewEmployee(String employeeName) {
        Employee e = new Employee(employeeName);
        employeeList.add(e);
        return e;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

}
