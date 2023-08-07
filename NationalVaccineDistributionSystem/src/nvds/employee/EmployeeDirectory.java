package nvds.employee;

import java.util.ArrayList;

public class EmployeeDirectory {

    private final ArrayList<Employee> listOfEmployees;

    public EmployeeDirectory() {
        this.listOfEmployees = new ArrayList<>();
    }

    public Employee addEmployee(String name) {
        Employee e = new Employee(name);
        listOfEmployees.add(e);
        return e;
    }

    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

}
