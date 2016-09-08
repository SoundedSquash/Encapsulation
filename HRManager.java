/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.text.ParseException;

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

            e.meetWithHrForBenefitAndSalryInfo();
            e.meetDepartmentStaff();
            e.reviewDeptPolicies();
            e.moveIntoCubicle();
        }
    }
    
    public String getEmployeeStatus(){
        return e.getStatus();
    }
}
