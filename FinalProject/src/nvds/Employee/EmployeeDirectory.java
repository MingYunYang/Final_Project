package nvds.Employee;

import java.util.ArrayList;

public class EmployeeDirectory {

    private final ArrayList<Employee> listOfEmployees;

    public EmployeeDirectory() {
        this.listOfEmployees = new ArrayList<>();
    }

    public Employee addNewEmployee(String employeeName) {
        Employee e = new Employee(employeeName);
        listOfEmployees.add(e);
        return e;
    }

    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

}
