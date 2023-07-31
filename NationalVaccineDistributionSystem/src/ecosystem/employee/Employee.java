package ecosystem.employee;

public class Employee {

    private String employeeName;

    private final int employeeID;

    private static int count = 1;

    public Employee(String name) {
        employeeName = name;
        employeeID = count;
        count++;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
