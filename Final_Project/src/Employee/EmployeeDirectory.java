/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

import java.util.ArrayList;

/**
 *
 * @author libby
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public Employee newEmployee(String name) {
        Employee e = new Employee(name);
        employeeList.add(e);
        return e;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

}
