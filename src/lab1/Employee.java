package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the other best practices as explained by 
 * your instructor.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 */
public class Employee {
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

    public Employee(String firstName, String lastName, String ssn, String birthDate){
        boolean firstNameCheck, lastNameCheck, ssnCheck, birthDateCheck;
        currentDate = new Date();
        firstNameCheck = setFirstName(firstName);
        lastNameCheck = setLastName(lastName);
        ssnCheck = setSsn(ssn);
        birthDateCheck = setBirthDate(birthDate);
    }

    public String getStatus() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        
        HRManager mm = new HRManager();
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

    public String getFirstName() {
        return firstName;
    }

    public final boolean setFirstName(String firstName) {
        if(firstName.length() > 0){
            this.firstName = firstName;
            return true;
        } else {
            System.out.println("Please check First Name for any errors and try again.");
            return false;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        if(lastName.length() > 0){
            this.lastName = lastName;
            return true;
        } else {
            System.out.println("Please check Last Name for any errors and try again.");
            return false;
        }
    }

    public String getSsn() {
        return ssn;
    }

    public boolean setSsn(String ssn) {
        if(ssn.matches("([0-9]{3})-([0-9]{2})-([0-9]{4})")){
            this.ssn = ssn;
            return true;
        } else {
            System.out.println("SSN is not in proper 000-00-0000 format.");
            return false;
        }
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean setBirthDate(String birthDate) throws ParseException {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
            date = sdf.parse(birthDate);
            if (birthDate.equals(sdf.format(date))) {
        this.birthDate = date;
        return true;
            }
        } catch (ParseException ex) {
            System.out.println("Invalid mm/dd/yyyy format.");
            return false;
        }
        return false;
    }
}
