package lab1.poor.solution;

/**
 * This solution solves some, but not all encapsulation and best practice problems.
 * Can you identify the good and bad parts?
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 */
public class HRManager {
    private Employee employee;
    
    public void orientNewEmployee(String firstName, String lastName, String ssn) {
        Employee e = new Employee();
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setSsn(ssn);
        e.doOrientation("A101");
        employee = e;
    }
    
    public String getEmployeeStatus() {
        return employee.getStatus();
    }
}
