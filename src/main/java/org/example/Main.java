package org.example;

import Today.edu.MyAppT;
import Today.edu.Person;
import Today.edu.ServiceProvider;

import java.util.Scanner;

import static Today.edu.MyAppT.logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    private static Person user=new Person();
    private static ServiceProvider sp=new ServiceProvider();

    static MyAppT obj = new MyAppT();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        menuForMain o=new menuForMain();
        logger.info(o.LogInSignUp());
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> signUpProcedure(input);
            case 2 -> loginProcedure(input);
            case 3-> forgotPass(input);
            default -> logger.info("Invalid option selected.");
        }


    }

    private static void loginProcedure(Scanner input) {
        String name= getInput(input, "Please enter your Name");
        String password = getInput(input, "Please enter your password");
       user= obj.searchInUser(name);
        sp=obj.searchInServiceProvider(name);
        if(!(user==(null))){
            displayUserMenu();
            System.out.println("dgf");
        }
       else if(!(sp==(null))){
            displaySpMenu(input);
            System.out.println("ttt");

        }
       else if(name.equals("toqa")&&password.equals("123")){
            displayAdminMenu(input);
            System.out.println("cxc");

        }

    }

    private static void displaySpMenu(Scanner input) {
        String s="\n1. add a new service\n2. modify an existing service\n3. delete an existing service\n4. view the list of users\n";
        s+="5. view the list of services\n6. exit";
        logger.info(s);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                logger.info("Enter service id:");
                int id = input.nextInt();
                String description= getInput(input, "Please enter description");
                logger.info("Enter service cost:");
                int cost = input.nextInt();
                obj.addServiceToSp(description,cost,id,sp.getPerson().getUserName());
                break;


            case 2:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));

                logger.info("Enter service id:");
                 id = input.nextInt();
                 description= getInput(input, "Please enter new description");
                logger.info("Enter new cost:");
                 cost = input.nextInt();
                obj.editServiceForSp(description,cost,id,sp.getPerson().getUserName());

                break;
            case 3:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));
                logger.info("Enter service id:");
                id = input.nextInt();
                obj.deleteServiceForSp(id,sp.getPerson().getUserName());
                break;
            case 4:
                logger.info(obj.showUsersAndEventsForSp(sp.getPerson().getUserName()));
                break;
            case 5:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));

                break;
            case 6:
                logger.info("Logging out as Service provider.");
                System.exit(1);
                break;
            default:
                logger.info("Invalid option selected.");

        }
        displaySpMenu( input);
    }

    private static void displayUserMenu() {
    }

    private static void displayAdminMenu(Scanner input) {
        String s="\n1. view list of all registered users\n2. view list of all service providers\n3. view list of all event\n4. create a new ready-made package\n";
        s+="5. deletes an existing ready-made package\n6. view list of all packages\n7. exit";
        logger.info(s);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                logger.info(obj.showUserListForAdmin());

                break;


            case 2:
                logger.info(obj.showSPtForAdmin());

                break;
            case 3:
                logger.info(obj.showEventForAdmin());break;
            case 4:
                logger.info("Please enter package ID: ");
                Integer id = input.nextInt();
                String description= getInput(input, "Please enter package description: ");
                logger.info("Please enter package cost: ");
                Double cost = input.nextDouble();
                obj.createPackage(description,cost,id);break;
            case 5:
                logger.info(obj.showPackageForAdmin());
                logger.info("Please enter package ID: ");
                 id = input.nextInt();
                obj.deletePackage(id);
                break;
            case 6:
                logger.info(obj.showPackageForAdmin());break;
            case 7:
                logger.info("Logging out as Admin.");
                System.exit(1);

            default:
                logger.info("Invalid option selected.");
                signUpProcedure(input);
        }
        displayAdminMenu( input);
    }


    private static void forgotPass(Scanner input) {
        String name = getInput(input, "Enter the name for your account");
        String pass = getInput(input, "Enter the new password for your account");
        obj.setEnteredUsername(name);
        obj.takePass(pass);
        logger.info("successfully Update");
    }

    private static void signUpProcedure(Scanner input) {
        logger.info("\n1.Service provider \n2.User\n Enter the Number:");
        int choice = input.nextInt();


        switch (choice) {
            case 1 :
                logger.info("\nIn order to make a new account you have to enter your information\n");
                String name= getInput(input, "Please enter your Name");
                String phone= getInput(input, "Please enter your phone");
                String email = getInput(input, "Please enter your Gmail");
                String password = getInput(input, "Please enter your password");
                String birthDate = getInput(input, "Please enter your BirthDate");
                String type= getInput(input, "\nPlease enter your type(Food,Decoration,Entertainment,Photographer)-->");
                obj.createAccountForSp(name,password,birthDate,phone,type,email);
                break;


            case 2 :
                logger.info("\nIn order to make a new account you have to enter your information\n");
                 name= getInput(input, "Please enter your Name");
                 phone= getInput(input, "Please enter your phone");
                 email = getInput(input, "Please enter your Gmail");
                 password = getInput(input, "Please enter your password");
                 birthDate = getInput(input, "Please enter your BirthDate");
                obj.createAccountForUser(name,password,birthDate,phone,email);
                break;
            default :
                logger.info("Invalid option selected.");
                signUpProcedure(input);

        }



    }




    private static String getInput(Scanner input, String prompt) {
        logger.info(prompt);
        return input.next();
    }

}