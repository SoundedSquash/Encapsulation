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
    private boolean validEmployee = true;

    public Employee(String firstName, String lastName, String ssn, String birthDate) throws ParseException{
        boolean firstNameCheck, lastNameCheck, ssnCheck, birthDateCheck;
        currentDate = new Date();
        firstNameCheck = setFirstName(firstName);
        lastNameCheck = setLastName(lastName);
        ssnCheck = setSsn(ssn);
        birthDateCheck = setBirthDate(birthDate);
        
        if(firstNameCheck && lastNameCheck && ssnCheck && birthDateCheck){
            System.out.println("Employee added!");
            validEmployee = true;
        } else {
            System.out.println("Issue(s) occured when adding employee.");
            validEmployee = false;
        }
    }
    
    // Assume this must be performed first
    public void meetWithHrForBenefitAndSalryInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        System.out.println("Met with Hr on " + fmtDate);
        metWithHr = true;
    }

    // Assume this is must be performed second
    public void meetDepartmentStaff() {
        if(metWithHr) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(currentDate);
            System.out.println("Met with Dept. Staff on " + fmtDate);
            metDeptStaff = true;
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    public void reviewDeptPolicies() {
        if(metDeptStaff) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(currentDate);
            System.out.println("Reviewed Dept. Policies on " + fmtDate);
            reviewedDeptPolicies = true;
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    public void moveIntoCubicle() {
        if(reviewedDeptPolicies) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(currentDate);
            System.out.println("Moved into cube on " + fmtDate);
            this.cubeId = cubeId;
            movedIn =true;
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
            this.cubeId = "N/A";
        }
    }

    public String getStatus() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);

        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is completed on: " + fmtDate;
        } else {
            return fmtDate + ": Orientation in progress...";
        }
    }

    public boolean isValidEmployee() {
        return validEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    private final boolean setFirstName(String firstName) {
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

    private final boolean setLastName(String lastName) {
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

    private final boolean setSsn(String ssn) {
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

    private final boolean setBirthDate(String birthDate) throws ParseException {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
            date = sdf.parse(birthDate);
            if (birthDate.equals(sdf.format(date))) {
                this.birthDate = date;
                return true;
            } else return false;
        } catch (ParseException ex) {
            System.out.println("Invalid mm/dd/yyyy format.");
            return false;
        }
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public Date getCurrentDate() {
        return currentDate;
    }
}
