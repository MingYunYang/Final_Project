/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Employee;

/**
 *
 * @author libby
 */
public class Employee {

    private String employeeName;
    private final int employeeID;
    private static int count = 1;

    public Employee(String name) {
        employeeName = name;
        employeeID = count;
        count++;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public String toString() {
        return employeeName;
    }

}
