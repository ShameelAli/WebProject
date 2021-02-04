package model;


import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;

import javax.validation.constraints.Size;
import java.util.ArrayList;



@Entity
@Table(name ="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int numberOfOrder;
    @NotEmpty(message = "Please Enter your name")
    private String firstname;
    @NotEmpty(message = "Kindly select atleast1 burger")
    @Size(min = 1)
    @Transient
    private ArrayList<String> burger;

    public String getBurgers() {
        return burgers;
    }

    public void setBurgers(String burgers) {
        this.burgers = burgers;
    }

    public String getCustomizations() {
        return customizations;
    }

    public void setCustomizations(String customizations) {
        this.customizations = customizations;
    }

    @NotEmpty(message = "No Customization Added")
    @Transient
    private ArrayList<String> customization;
    @NotEmpty(message = "Kindly Select Size of Burger")
    private String burgerSize;
    private String burgers;
    private String customizations;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public ArrayList<String> getBurger() {
        return burger;
    }

    public void setBurger(ArrayList<String> burger) {
        this.burger = burger;
    }

    public ArrayList<String> getCustomization() {
        return customization;
    }

    public void setCustomization(ArrayList<String> customization) {
        this.customization = customization;
    }


    public String getBurgerSize() {
        return burgerSize;
    }

    public void setBurgerSize(String burgerSize) {
        this.burgerSize = burgerSize;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", burger=" + burger +
                ", customization=" + customization +
                ", size='" + burgerSize + '\'' +
                '}';
    }

}
