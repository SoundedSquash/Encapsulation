package example1;

import javax.swing.JOptionPane;

/**
 * This class is an an abstraction of a real cake object. It demonstrates poor
 * encapsulation.
 * 
 * @author jlombardo
 */
public class Cake {
    private String cakeName;
    //// Both of these properties violate encapsulation rules. All should be
    // declared private scope and should have getter and/or setter methods.
    ///////
    public int quantity;
    public int size;

    //// Some of the methods below violate encapsulation rules. Many should
    //   be private, those that have arguments (setters) need validation rules.
    ////////

    public void setCakeName(String name) {
        this.cakeName = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    /* 
        These methods represent steps that should be performed
        in a certain order, but there is no guarantee this will happen.
        Furthermore, making all of these methods public exposes complexity
        that is not necessary. 
    */

    // VERY BAD! quantity should be validated for legal range
    public void gatherIngredients(int quantity) {
        this.quantity = quantity;
        System.out.println("Ingredients gathered");
    }

    public void mixIngredients() {
        System.out.println("Ingredients mixed");
    }

    public void bake() {
        System.out.println("Baking...");
    }

    public void takeFromOvenAndLetCool() {
        System.out.println("All done baking, removed from oven, cooling...");
    }
}
