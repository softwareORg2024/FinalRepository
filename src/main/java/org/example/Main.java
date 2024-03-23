package org.example;

import Today.edu.*;
import Today.edu.Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import java.sql.Time;

import java.util.Date;
import java.util.Scanner;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + ": " + record.getMessage() + "\n";
            }
        });
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }
    }

    private static Person user=new Person();
    private static ServiceProvider sp=new ServiceProvider();

    static MyAppT obj = new MyAppT();

    public static void main(String[] args) {

        LogInSignUp();

    }
    public static void LogInSignUp() {
        Scanner input = new Scanner(System.in);
        String s = "\n1. Sign up\n2. Login\n3. Forget password\n4.Log out\nEnter the number of your choice:";
        logger.info(s);

            int choice = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    choice = input.nextInt();
                    valid = true;
                } catch (InputMismatchException e) {

                    logger.info("\nYou have entered an incorrect value.\n Please enter a correct number:");
                    input.next();

                }
            }

            switch (choice) {
                case 1:
                    signUpProcedure(input);
                    return;
                case 2:
                    loginProcedure(input);
                    return;
                case 3:
                    forgotPass(input);
                    return;
                case 4:
                    logger.info("Have a nice day!! ");
                    System.exit(1);
                default:
                    logger.info("Invalid option selected. Please try again.");
                    logger.info(s);

            }
        }


    private static void loginProcedure(Scanner input) {
        String name= getInput( "Please enter your Name");
        String password = getInput( "Please enter your password");
       user= obj.searchInUser(name);
        sp=obj.searchInServiceProvider(name);
        if(!(user==(null))){
            if(password.equals(user.getPass())){
            displayUserMenu(input);}else{
                logger.info("Wrong Password\n");
                LogInSignUp();
            }
        }
       else if(!(sp==(null))){
            if(password.equals(sp.getPerson().getPass())){
                displaySpMenu(input);}else{
                logger.info("Wrong Password\n");
                LogInSignUp();
            }


        }
       else if(name.equals("toqa")&&password.equals("123")){
            displayAdminMenu(input);

        }else{
            logger.info("Wrong information\n");
            LogInSignUp();
        }

    }

    private static void displaySpMenu(Scanner input) {
        String s="\n1.add a new service\n2.modify an existing service\n3.delete an existing service\n4.view the list of users\n";
        s+="5.view the list of services\n6. exit\nEnter the number of your choice:";
        int choice;
        logger.info(s);


            choice = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    choice = input.nextInt();
                    valid = true;

                } catch (InputMismatchException e) {

                    logger.info("\nYou have entered an incorrect value.\n Please enter a correct number:");
                    input.next();

                }

        }displaySpMenu( input);

            switch (choice) {
            case 1:
                logger.info("Enter service id:");
                int id = input.nextInt();
                String description= getInput( "Please enter description");
                logger.info("Enter service cost:");
                int cost = input.nextInt();
                obj.addServiceToSp(description,cost,id,sp.getPerson().getUserName());
                break;


            case 2:
                logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));

                logger.info("Enter service id:");
                 id = input.nextInt();
                 description= getInput( "Please enter new description");
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
            LogInSignUp();
                break;
            default:
                logger.info("Invalid option selected.");

        }
        displaySpMenu( input);
    }

   private static void addServices(Scanner input,int int1,Event event1){
            String s = "\n1.FoodService\n2.DecorService\n3.PhotoService\n4.EnterService\n5.finish\nEnter the number of your choice:";
            logger.info(s);

          int serviceChoice= 0;
           boolean valid = false;
           while (!valid) {
               try {
                   serviceChoice= input.nextInt();
                   valid = true;
               } catch (InputMismatchException e) {

                   logger.info("\nYou have entered an incorrect value.\n Please enter a correct number:");
                   input.next();

               }
           }

            String type = "";
            String spList = "";
            switch (serviceChoice) {
                case 1:
                    type = "Food";

                    break;
                case 2:
                    type = "Decoration";

                    break;
                case 3:
                    type = "Entertainment";
                    break;
                case 4:
                    type = "Photographer";
                    break;
                case 5:
                    int t = obj.getLocalEvent().eventCost(cost);
                    logger.info("create event successfully and its price is " + t);
                    displayUserMenu(input);

                    break;
                default:
                    //logger.info("locally cost "+ cost);
                    logger.info("Choose from the menu plz..\n");
                    addServices(input, int1, event1);


            }
            if (serviceChoice != 5) {
                spList = obj.searchInSpAccordingToType(type);
                logger.info(spList);
                String spName = getInput("Please enter service Provider Name: ");
                logger.info(obj.showservicesForSp(spName));
                Integer serviceId = input.nextInt();
                obj.setLocalEvent(event1);


                int t = obj.addFoodService(serviceId, type);

                logger.info("Successful addtion");


                addServices(input, int1, event1);

        }}


static int cost;


    private static void location(Scanner input,int year,int month,int day,Time time){

        logger.info("locations: ");
        int temp=0;
        for (Location l : obj.getLocationList()) {

            for (Event e : obj.getEventList()) {


                if (e.getDate().getYear()==year && e.getDate().getMonth()==month && e.getDate().getDate()==day && e.getTime().equals(time)&& e.getLocation().equals(l.getLocationName())) {
                    temp=1;
                    break;
                }
            }
            if(temp==0){
                logger.info(l.getId()+"\t"+l.getLocationName()+"\t"+l.getCost()+"\n");


            }
            else {
                temp=0;
            }

        }
        logger.info("Please enter location ID: ");

    }

    private static void creatBasicEvent(Scanner input){
        cost=0;

        Date date= new Date(2003, 2, 13);
        Time time= new Time(1, 2, 3);
        String eventName= getInput( "Please enter event name: ");
        String dates= getInput( "Please enter event date(yyyy-MM-dd): ");
        String times= getInput( "Please enter event time(HH:mm:ss): ");

        String[] dateComponents = dates.split("-");



        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]);
        int day = Integer.parseInt(dateComponents[2]);


        dateComponents = times.split(":");
        int hour = Integer.parseInt(dateComponents[0]);
        int min= Integer.parseInt(dateComponents[1]);
        int sec = Integer.parseInt(dateComponents[2]);
        time = new Time(hour,min,sec);



        location( input, year, month, day, time);

        Integer id = input.nextInt();

        String theme= getInput( "Please enter theme: ");
        logger.info("Please enter number of attend people: ");
        Integer number = input.nextInt();
        Location L=obj.searchInLocation(id);
        cost+=L.getCost();
        String locationName=L.getLocationName();

        obj.createEventWithBasicInfo(user.getUserName(),eventName,year,month, day, time.getHours(), time.getMinutes(), time.getSeconds(), locationName, theme, number);
        String s="\n1.choose from existing package\n2. choose your own services\n3. exit\n";
        logger.info(s);
        int choice = input.nextInt();
        int PackId;
        switch (choice) {
            case 1:
                String pack= obj.showPackageForAdmin();
                logger.info(pack);
                PackId = input.nextInt();
                boolean b=obj.addPackageToEvent(PackId);
                obj.addLocalEventToEventList();

                Package P;
                P=obj.searchInPackage(PackId);
                logger.info("create event successfully and its price is "+ obj.getLocalEvent().eventCost(cost));

                displayUserMenu(input);
                break;

            case 2:
                addServices(input,obj.getLocalEvent().eventCost(cost),obj.getLocalEvent());
                break;
            case 3:
                logger.info("create event successfully and its price is "+cost);









        }

    }

    private static void displayUserMenu(Scanner input) {
        String s="\n1.create an event\n" +
                "2.edit the event\n" +
                "3.delete an existing event\n" +
                "4.view events\n" +
                "5.exit\nEnter the number of your choice:";
        logger.info(s);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                creatBasicEvent(input);
                break;


            case 2:

               editEvent(input);
                break;
         case 3:
                String show=obj.ViewEventsByUser(user.getUserName());
                String EventName= getInput(show+"\n Please enter eventName:\n");
                System.out.println("The event "+EventName+" was successfully deleted\n\n");
                obj.DeleteEventByUser(user.getUserName(), EventName);

                break;

            case 4:
                 show=obj.ViewEventsByUser(user.getUserName());
                logger.info(show);
                displayUserMenu(input);
                break;

            case 5:
                LogInSignUp();
                break;


            default:
                logger.info("Invalid option selected.\n");
                displayUserMenu(input);
        }
        displayUserMenu(input);





    }

    private static void editEvent(Scanner input) {
        String show=obj.ViewEventsByUser(user.getUserName());
        logger.info(show);
        String eventName= getInput( "Please enter Event name: ");


        String s="\n1.edits the event name\n" +
                "2.changes the event location\n" +
                "3.updates the event date\n" +
                "4.User updates the event time\n" +
                "5.number of attendees for the event\n" +
                "6.changes the theme of the event\n" +
                "7.adds additional services to the event\n" +
                "8.removes a service from the event\n" +
                "9.cancels the selected package\n" +
                "10.User edit the selected package\n11.exit\nEnter the number of your choice:";
        logger.info(s);
        int choice = input.nextInt();


        show=obj.ViewEventsByUser(user.getUserName());
        logger.info(show);
        switch (choice) {
            case 1:
                String NewEventName= getInput( "Please enter Event name: ");

                obj.editEventNameByUser(user.getUserName(),eventName,NewEventName);

                eventName=NewEventName;

                break;

            case 2:
                location( input,  obj.searchInEventByName(eventName).getDate().getYear(), obj.searchInEventByName(eventName).getDate().getMonth(),obj.searchInEventByName(eventName).getDate().getDate(), obj.searchInEventByName(eventName).getTime());
                int locationId = input.nextInt();
                obj.editLocation(user.getUserName(),eventName, locationId);
                break;
            case 3:
                String dates= getInput("Please enter event date (yyyy-MM-dd): ");

                String[] dateComponents = dates.split("-");

                int year = Integer.parseInt(dateComponents[0]);
                int month = Integer.parseInt(dateComponents[1]);
                int day = Integer.parseInt(dateComponents[2]);

               int temp=0;

                    for (Event e : obj.getEventList()) {

                        if (e.getDate().getYear()==year && e.getDate().getMonth()==month && e.getDate().getDate()==day && e.getTime().equals(obj.searchInEventByName(eventName).getTime()) && e.getLocation().equals(obj.searchInEventByName(eventName).getLocation())) {
                            logger.info("You cannot book on this date.\n There is another event booked\n" );
                            temp=1;
                            editEvent(input);
                            break;
                        }
                    }
                    if(temp==0){
                       obj.editEventDateByUser(user.getUserName(), eventName,year, month, day);

                    }



                break;

            case 4:
                String times= getInput( "Please enter event time (HH:mm:ss): ");

                dateComponents = times.split(":");
                int hour = Integer.parseInt(dateComponents[0]);
                int min= Integer.parseInt(dateComponents[1]);
                int sec = Integer.parseInt(dateComponents[2]);
                Time time = new Time(hour,min,sec);

                 temp=0;

                for (Event e : obj.getEventList()) {


                    if (e.getDate().getYear()==obj.searchInEventByName(eventName).getDate().getYear() && e.getDate().getMonth()==obj.searchInEventByName(eventName).getDate().getMonth() && e.getDate().getDate()== obj.searchInEventByName(eventName).getDate().getDate() && e.getTime().equals(time)&& e.getLocation().equals(obj.searchInEventByName(eventName).getLocation())) {
                        logger.info("you can't choose this time because location is booked to another event\n" );
                        temp=1;
                        editEvent(input);
                        break;
                    }
                }
                if(temp==0){
                    obj.editEventTimeByUser(user.getUserName(), eventName, hour, min, sec) ;
                }

                break;

            case 5:
                logger.info("number of attendees for the event ");
                int num = input.nextInt();
                obj.editEventNumOfPeapleByUser(user.getUserName(), eventName, num);
                break;

            case 6:
                String theme= getInput( "Please enter Event new theme: ");
                obj.editEventThemeByUser(user.getUserName(), eventName, theme);

                break;
            case 7:
                addServices( input,obj.searchInEventByName(eventName).getOverallCost(),obj.searchInEventByName(eventName));
                break;
            case 8:
                s="";
                if(obj.searchInEventByName(eventName).getFoodService()!=null){
                    s+=obj.searchInEventByName(eventName).getFoodService().getId()+"\t"+obj.searchInEventByName(eventName).getFoodService().getDiscription()+"\n";
              }




                if(obj.searchInEventByName(eventName).getDecorService()!=null){
                    s+=obj.searchInEventByName(eventName).getDecorService().getId()+"\t"+obj.searchInEventByName(eventName).getDecorService().getDiscription()+"\n";
                }



                if(obj.searchInEventByName(eventName).getEntertainmentService()!=null){
                    s+=obj.searchInEventByName(eventName).getEntertainmentService().getId()+"\t"+obj.searchInEventByName(eventName).getEntertainmentService().getDiscription()+"\n";
                }

                if(obj.searchInEventByName(eventName).getPhotographerService()!=null){
                    s+=obj.searchInEventByName(eventName).getPhotographerService().getId()+"\t"+obj.searchInEventByName(eventName).getPhotographerService().getDiscription()+"\n";
                }

                logger.info(s);
                Integer serviceToDelete = input.nextInt();
                obj.editDeleteServiceFromEventByUser(user.getUserName(), eventName, serviceToDelete);
                break;
            case 9:
                obj.editDeletePackageFromEventByUser(user.getUserName(), eventName);
                break;
            case 10:
                String pack= obj.showPackageForAdmin();
                logger.info(pack);
               int  PackId = input.nextInt();
               obj.setLocalEvent(obj.searchInEventByName(eventName));
                boolean b=obj.addPackageToEvent(PackId);

                logger.info("create event successfully and its price is "+ obj.getLocalEvent().eventCost(cost));
                break;
            case 11:
                displayUserMenu(input);
                break;
            default:
                logger.info("Invalid option selected.");
                editEvent( input);
        }
        editEvent( input);
    }

    private static void displayAdminMenu(Scanner input) {
        String s="\n1.view list of all registered users\n2.view list of all service providers\n3.view list of all event\n4.create a new ready-made package\n";
        s+="5.deletes an existing ready-made package\n6.view list of all packages\n7.exit\nEnter the number of your choice: ";
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
                String description= getInput( "Please enter package description: ");
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

                LogInSignUp();

            default:
                logger.info("Invalid option selected.");
                displayAdminMenu(input);
        }
        displayAdminMenu( input);
    }

    private static void forgotPass(Scanner input) {
        String name = getInput( "Enter the name for your account");
        String pass = getInput( "Enter the new password for your account");
        obj.setEnteredUsername(name);
        obj.takePass(pass);
        logger.info("successfully Update");
    }

    private static void signUpProcedure(Scanner input) {
        logger.info("\n1.Service provider \n2.User\n3.Exit\n Enter the Number:");
        int choice = input.nextInt();


        switch (choice) {
            case 1 :
                logger.info("\nIn order to make a new account you have to enter your information\n");
                String name= getInput( "Please enter your Name");
                String phone= getInput( "Please enter your phone");
                String email = getInput( "Please enter your Gmail");
                String password = getInput( "Please enter your password");
                String birthDate = getInput("Please enter your BirthDate");
                String type= getInput( "\nPlease enter your type(Food,Decoration,Entertainment,Photographer)-->");
                obj.createAccountForSp(name,password,birthDate,phone,type,email);
                break;


            case 2 :
                logger.info("\nIn order to make a new account you have to enter your information\n");
                 name= getInput( "Please enter your Name");
                 phone= getInput( "Please enter your phone");
                 email = getInput( "Please enter your Gmail");
                 password = getInput("Please enter your password");
                 birthDate = getInput("Please enter your BirthDate");
                obj.createAccountForUser(name,password,birthDate,phone,email);
                break;
            case 3 :
                LogInSignUp();
            default :
                logger.info("Invalid option selected.");
                signUpProcedure(input);

        }



    }




    private static String getInput(String prompt) {
        System.out.println(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}