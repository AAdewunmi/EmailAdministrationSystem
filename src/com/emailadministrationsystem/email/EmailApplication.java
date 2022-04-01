package com.emailadministrationsystem.email;

import java.util.Scanner;

/**
 * @author: Adrian Adewunmi
 * @date:   2022-04-01
 * This is the main class of the application.
 */

public class EmailApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Email email = new Email();
        int userChoice;
        do{
            System.out.println("*** Email Application ***" + "\n" +
                    "\n1. Create an email account" +
                    "\n2. Create password" +
                    "\n3. Change the password" +
                    "\n4. Set mailbox capacity" +
                    "\n5. Set alternative email address" +
                    "\n6. Print the email information" +
                    "\n7. Exit" +  "\n");
            userChoice = scanner.nextInt();
            switch(userChoice){
                case 1:
                    email.setDepartment();
                    email.createEmail();
                    break;
                case 2:
                    email.generatePassword();
                    break;
                case 3:
                    email.changePassword();
                    break;
                case 4:
                    email.setMailboxCapacity();
                    break;
                case 5:
                    email.setAlternativeEmail();
                    break;
                case 6:
                    System.out.println(email);
                case 7:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }while(userChoice != 7);
    }


}
