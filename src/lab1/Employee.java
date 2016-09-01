package lab1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the other best practices as explained by 
 * your instructor.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 */
public final class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private Date birthDate;
    private boolean metWithHr = false;
    private boolean metDeptStaff = false;
    private boolean reviewedDeptPolicies = false;
    private boolean movedIn = false;
    private String cubeId;
    private final Date currentDate;

    public Employee(String firstName, String lastName, String ssn, String birthDate) {
        currentDate = new Date();
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }

    public String getStatus() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        
        MeetingManager mm = new MeetingManager();
        this.metWithHr = mm.meetWithHrForBenefitAndSalryInfo(currentDate);
        this.metDeptStaff = mm.meetDepartmentStaff(currentDate,metWithHr);
        this.reviewedDeptPolicies = mm.reviewDeptPolicies(currentDate, metDeptStaff);
        mm.moveIntoCubicle(cubeId, currentDate, reviewedDeptPolicies);

        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is completed on: " + fmtDate;
        } else {
            return fmtDate + ": Orientation in progress...";
        }
    }

    private boolean isStringValid(String string){
        return !string.equals("");
    }
    
    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if(isStringValid(firstName)){
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if(isStringValid(lastName)){
            this.lastName = lastName;
        }
    }

    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn) {
        if(isStringValid(ssn)){
            this.ssn = ssn;
        }
    }

    public Date getBirthDate() {
        return birthDate;
    }

    private void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
