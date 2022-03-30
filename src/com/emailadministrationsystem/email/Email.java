package com.emailadministrationsystem.email;

import java.util.Random;
import java.util.Scanner;

/**
 * @author: Adrian Adewunmi
 * @date:   2022-03-24
 * This class is used to store the email information.
 */

public class Email {

    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
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

    private String setDepartment() {
        Scanner scannerSetDepartment = new Scanner(System.in);
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
            departmentChoice = scannerSetDepartment.nextInt();
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

    private String createEmail() {
        Scanner scannerCreateEmail = new Scanner(System.in);
        System.out.println("\nEnter your first name: ");
        this.firstName = scannerCreateEmail.next();
        System.out.println("Enter your last name: ");
        this.lastName = scannerCreateEmail.next();
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toUpperCase() + ".company.com";
        System.out.println("Email: " + this.email);
        return this.email;
    }

    /**
     * This method is used to generate a random string password
     * @return: the password
     */

    private String generatePassword(){
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
        System.out.println("Password: " + this.password);
        return this.password;
    }

    /**
     * This method is used to change the randomly generated password
     * @return: the alternate password
     */

    private void changePassword(){
        Scanner scannerChangePassword = new Scanner(System.in);
        boolean isValid = false;
        do {
            System.out.println("\nDo you want to change your password? (Y / N)");
            char choice = scannerChangePassword.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                    isValid = true;
                    System.out.println("Enter current password: ");
                    scannerChangePassword.nextLine();
                    String currentPassword = scannerChangePassword.nextLine();
                    scannerChangePassword.nextLine();
                    if (currentPassword.equals(this.password)) {
                        System.out.println("Enter new password: ");
                        scannerChangePassword.nextLine();
                        this.password = scannerChangePassword.nextLine();
                        // Print the new password
                        System.out.println("Password successfully changed!");
                    }else {
                        System.out.println("Invalid password");
                        // Do you want to try again?
                    }
            }else if (choice == 'N' || choice == 'n') {
                    isValid = true;
                    System.out.println("Password not changed!");
            }else {
                System.out.println("Invalid input");
            }
        }while (!isValid);
    }

    /**
     * This method is used to set mailbox capacity
     */

    private void setMailboxCapacity() {
        System.out.println("Current mailbox capacity: " + this.mailCapacity + " MB");
        Scanner scannerSetMailboxCapacity = new Scanner(System.in);
        System.out.println("\nEnter new mailbox capacity: ");
        this.mailCapacity = scannerSetMailboxCapacity.nextInt();
        System.out.println("Mailbox capacity successfully changed!" + "\nNew mailbox capacity: " + this.mailCapacity + " MB");
    }

    /**
     * This method is used to set alternative email address
     */

    private void setAlternativeEmail() {
        Scanner scannerSetAlternativeEmail = new Scanner(System.in);
        System.out.println("\nEnter alternative email address: ");
        this.alter_email = scannerSetAlternativeEmail.next();
        System.out.println("Alternative email address successfully changed!" + "\nAlternative email address: " + this.alter_email);
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
                ", Email: " + email + "\n"
                + ", Password: " + password + "\n"
                + ", Mailbox Capacity: " + mailCapacity + " MB" + "\n"
                + ", Alternative Email: " + alter_email + "\n";
    }

    //Email Test Class
    /*public static void main(String[] args) {
        Email email = new Email();
        email.setDepartment();
        email.createEmail();
        email.generatePassword();
        email.changePassword();
    }*/
}
