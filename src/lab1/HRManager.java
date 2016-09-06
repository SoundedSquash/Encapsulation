/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wboyer
 */
public class HRManager {
    private Employee e;
    
    public void addEmployee(String firstName, String lastName, String ssn, String birthDate) throws ParseException{
        e = new Employee(firstName, lastName, ssn, birthDate);
    }
    
    public void orientEmployee(){
        if(e.isValidEmployee()){
            Date currentDate = e.getCurrentDate();

            meetWithHrForBenefitAndSalryInfo(currentDate);
            meetDepartmentStaff(currentDate, e.isMetWithHr());
            reviewDeptPolicies(currentDate, e.isMetDeptStaff());
            moveIntoCubicle(e.getCubeId(), currentDate, e.isReviewedDeptPolicies());
        }
    }
    
    public String getEmployeeStatus(){
        return e.getStatus();
    }
    
    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo(Date currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
        String fmtDate = sdf.format(currentDate);
        System.out.println("Met with Hr on " + fmtDate);
        e.setMetWithHr(true);
    }

    // Assume this is must be performed second
    private void meetDepartmentStaff(Date currentDate, boolean metWithHr) {
        if(metWithHr) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(currentDate);
            System.out.println("Met with Dept. Staff on " + fmtDate);
            e.setMetDeptStaff(true);
        } else {
            System.out.println("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies(Date currentDate, boolean metDeptStaff) {
        if(metDeptStaff) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(currentDate);
            System.out.println("Reviewed Dept. Policies on " + fmtDate);
            e.setReviewedDeptPolicies(true);
        } else {
            System.out.println("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId, Date currentDate, boolean reviewedDeptPolicies) {
        if(reviewedDeptPolicies) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            String fmtDate = sdf.format(currentDate);
            System.out.println("Moved into cube on " + fmtDate);
            e.setCubeId(cubeId);
            e.setMovedIn(true);
        } else {
            System.out.println("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
            e.setCubeId("N/A");
        }
    }
}
