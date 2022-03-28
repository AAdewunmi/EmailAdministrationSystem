package com.emailadministrationsystem.email;

import java.util.Random;
import java.util.Scanner;

/**
 * @author: Adrian Adewunmi
 * @date:   2022-03-24
 * This class is used to store the email information.
 */

public class Email {

    public Scanner scanner = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private final int mailCapacity = 500;
    private String alter_email;

    /**
     * Constructor for the Email class
     */

    public Email() {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * This method is used to select a department for the user
     * @return: the department
     */

    public String setDepartment() {
        System.out.println("Email Creation Process: \n");
        int departmentChoice;
        do {
            System.out.println("Select a department: \n"
                    + "\n1. Sales & Marketing"
                    + "\n2. IT & Networking"
                    + "\n3. Accounting & Finance"
                    + "\n4. Human Resources"
                    + "\n5. Customer Service & Support"
                    + "\n6. Operations & Management");
            departmentChoice = scanner.nextInt();
            switch (departmentChoice) {
                case 1:
                    this.department = "Sales & Marketing";
                    break;
                case 2:
                    this.department = "IT & Networking";
                    break;
                case 3:
                    this.department = "Accounting & Finance";
                    break;
                case 4:
                    this.department = "Human Resources";
                    break;
                case 5:
                    this.department = "Customer Service & Support";
                    break;
                case 6:
                    this.department = "Operations & Management";
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (departmentChoice < 1 || departmentChoice > 6);
        return this.department;
    }

    /**
     * This method is used to create an email address
     * @return: the email address
     */

    public String createEmail() {
        System.out.println("\nEnter your first name: ");
        this.firstName = scanner.next();
        System.out.println("Enter your last name: ");
        this.lastName = scanner.next();
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toUpperCase() + ".company.com";
        return this.email;
    }

    /**
     * This method is used to generate a random string password
     * @return: the password
     */

    public String generatePassword(){
        Random random = new Random();
        String Capital_Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_Chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";
        String values = Capital_Chars + Small_Chars + numbers + symbols;
        String password = "";
        for (int i = 0; i < 10; i++) {
            this.password += password + values.charAt(random.nextInt(values.length()));
        }
        return this.password;
    }


    /**
     * toString method for the Email class
     * @return: the email information
     */

    @Override
    public String toString() {
        return "\nEmail User Info: " + "\n" +
                "First Name: " + firstName + "\n" +
                ", LastName: " + lastName + "\n" +
                ", Department: " + department + "\n" +
                ", Email: " + email + "\n";
    }

    // Email Test Class
    public static void main(String[] args) {
        Email email = new Email();
        email.setDepartment();
        email.createEmail();
        System.out.println(email);
        System.out.println("Password: " + email.generatePassword());
    }
}
