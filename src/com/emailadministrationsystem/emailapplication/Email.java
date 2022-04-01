package com.emailadministrationsystem.emailapplication;

import java.io.*;
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

    public Email() {}

    /**
     * This method is used to select a department for the user
     * @return: the department
     */

    public String setDepartment() {
        Scanner scannerSetDepartment = new Scanner(System.in);
        int departmentChoice;
        do {
            System.out.println("Select a department: \n"
                    + "\n1. Sales & Marketing"
                    + "\n2. IT & Networking"
                    + "\n3. Accounting & Finance"
                    + "\n4. Human Resources"
                    + "\n5. Customer Service & Support"
                    + "\n6. Operations & Management\n"
                    + "\nEnter a number: ");
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

    public String createEmail() {
        Scanner scannerCreateEmail = new Scanner(System.in);
        System.out.println("\nEnter your first name: ");
        this.firstName = scannerCreateEmail.next();
        System.out.println("Enter your last name: ");
        this.lastName = scannerCreateEmail.next();
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toUpperCase() + ".company.com";
        System.out.println("\nEmail: " + this.email + "\n");
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
        System.out.println("\nPassword: " + this.password + "\n");
        return this.password;
    }

    /**
     * This method is used to change the randomly generated password
     * @return: the alternate password
     */

    public void changePassword(){
        Scanner scannerChangePassword = new Scanner(System.in);
        char a;
        do {
                System.out.println("\nChanging password ... " +
                        "\nEnter current password: ");
                String currentPassword = scannerChangePassword.nextLine();
                scannerChangePassword.nextLine();
                if (currentPassword.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = scannerChangePassword.nextLine();
                    System.out.println("New password: " + this.password);
                    System.out.println("Password successfully changed!" + "\n");
                    return;
                }else {
                    System.out.println("Invalid password\n" +
                            "Password not changed\n" +
                            "Would you like to try again? (y / n)");
                }
                a = scannerChangePassword.next().charAt(0);
                if (a != 'Y' || a != 'y') {
                    System.out.println("\nPassword not changed!");
                }
        }while (a == 'Y' || a == 'y');
    }

    /**
     * This method is used to set mailbox capacity
     */

    public void setMailboxCapacity() {
        System.out.println("\nSetting Mailbox capacity ... \n");
        System.out.println("Current mailbox capacity: " + this.mailCapacity + " MB");
        Scanner scannerSetMailboxCapacity = new Scanner(System.in);
        System.out.println("\nEnter new mailbox capacity: ");
        this.mailCapacity = scannerSetMailboxCapacity.nextInt();
        System.out.println("Mailbox capacity successfully changed!" + "\nNew mailbox capacity: " + this.mailCapacity + " MB" + "\n");
    }

    /**
     * This method is used to set alternative email address
     */

    public void setAlternativeEmail() {
        System.out.println("\nSetting alternative email address ... ");
        Scanner scannerSetAlternativeEmail = new Scanner(System.in);
        System.out.println("\nEnter alternative email address: ");
        this.alter_email = scannerSetAlternativeEmail.next();
        System.out.println("Alternative email address successfully changed!" + "\nAlternative email address: " + this.alter_email + "\n");
    }

    /**
     * This method is used to store the user's information
     * in a text file.
     */

    public void storeUserInfo() {
        try {
            FileWriter fileWriter = new FileWriter("user_info.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\nEmail User Info: " + "\n" +
                    "First Name: " + firstName + "\n" +
                    ", LastName: " + lastName + "\n" +
                    ", Department: " + department + "\n" +
                    ", Email: " + email + "\n"
                    + ", Password: " + password + "\n"
                    + ", Mailbox Capacity: " + mailCapacity + " MB" + "\n"
                    + ", Alternative Email: " + alter_email + "\n");
            System.out.println("\nUser information successfully stored!" + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to display the user's information
     * in a text file.
     */

    public void displayUserInfo() {
        try {
            System.out.println("\nDisplaying user information ... ");
            FileReader fileReader = new FileReader("user_info.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\nUser information successfully displayed!" + "\n");
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

}
