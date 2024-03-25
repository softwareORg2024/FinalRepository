package org.example;
import ttoday.edu.*;
import ttoday.edu.Package;

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
import java.util.Scanner;

public class Main {
    private static final String INCORRECT_VALUE_MESSAGE = "\nYou have entered an incorrect value. Please enter a correct number:";
    private static final String PROMPT_PASSWORD_MESSAGE = "Please enter your password";
    private static final String ANSI_PURPLE = "\u001B[95m";
    private static final String name = "qa";
    private static final String pass1 = "3";
    private static final String ANSI_RESET = "\u001B[0m";

    private static String username(String str){
        String user="to";
        user+=str;
        return user;
    }
    private static String password(String str){
        String pass="12";
        pass+=str;
        return pass;
    }
    private static final String PROMPT_NAME_MESSAGE = "Please enter your Name";
    private static final String PROMPT_SERVICE_ID = "Enter service id:";
    private static final String INVALID_OPTION_MESSAGE = "Invalid option selected.";
    private static final String CREATE_EVENT_MESSAGE = "Create event successfully and its price is ";

    private static final String INCORRECT_VALUE_MESSAGEE = "\nYou have entered an incorrect value. Please enter a correct number:";
    public static final String CHOICE_PROMPT = "\u001B[37mEnter the number of your choice: \u001B[0m";

    public static String searchInSpAccordingToType(String string) {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Service providers:\n");
        for (ServiceProvider p : obj.getProviderList()) {
            if (p.getServiceType().equals(string)) {
                resultBuilder.append(p.getPerson().getUserName()).append("\t").append(p.getPerson().getPhoneNum()).append("\n");
            }
        }
        return resultBuilder.toString();
    }
    public static Event searchInEventByName(String str) {
        for (Event e : obj.getEventList()) {
            if (e.getEventName().equals(str)) {
                return e;
            }
        }
        return null;
    }
    public static Package searchInPackage(int packId) {
        for(Package j :obj.getPackageList())
        {
            if (j.getNumber()==packId) {
                return j;
            }

        }
        return null;
    }
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static {
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord rec) {
                return rec.getLevel() + ": " + rec.getMessage() + "\n";
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
    public static Location searchInLocation(Integer int1) {
        for (Location e : obj.getLocationList()) {
            if (e.getId() == int1) {
                return e;
            }
        }
        return null;
    }

    private static Person user=new Person();
    private static ServiceProvider sp=new ServiceProvider();

    static MyAppT obj = new MyAppT();

    public static void main(String[] args) {

        logInSignUp();

    }
    public static void logInSignUp() {
        Scanner input = new Scanner(System.in);

        String menuOptions = ANSI_PURPLE + """
                     ╔════════════════════════════╗
                     ║         System Menu        ║
                     ╠════════════════════════════╣
                     ║ 1. Sign up                 ║
                     ║ 2. Login                   ║
                     ║ 3. Forget password         ║
                     ║ 4. Log out                 ║
                     ╚════════════════════════════╝
                     """ +ANSI_RESET+"\n"+CHOICE_PROMPT;
        logger.info(menuOptions);

            int choice = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    choice = input.nextInt();
                    valid = true;
                } catch (InputMismatchException e) {

                    logger.info(INCORRECT_VALUE_MESSAGE);
                    input.next();

                }
            }

        switch (choice) {
            case 1 ->
                signUpProcedure(input);


            case 2 ->
                loginProcedure(input);


            case 3 ->
                forgotPass();


            case 4 -> {
                logger.info("Have a nice day!! ");
                System.exit(1);
            }
            default -> {
                logger.info("Invalid option selected. Please try again.");
                logger.info(menuOptions);
            }
        }
        }



    private static void loginProcedure(Scanner input) {
        String adimnUsername = username(name);
        String adminPassword = password(pass1);

        String name= getInput( PROMPT_NAME_MESSAGE);
        String password = getInput( PROMPT_PASSWORD_MESSAGE);
       user= obj.searchInUser(name);
        sp=obj.searchInServiceProvider(name);
        if(user!=(null)){
            if(password.equals(user.getPass())){
            displayUserMenu(input);}else{
                logger.info("Wrong Password\n");
                logInSignUp();
            }
        }
       else if(sp!=(null)){
            if(password.equals(sp.getPerson().getPass())){
                displaySpMenu(input);}else{
                logger.info("Wrong Password\n");
                logInSignUp();
            }


        }
       else if(name.equals(adimnUsername)&&password.equals(adminPassword)){
            displayAdminMenu(input);

        }else{
            logger.info("Wrong information\n");
            logInSignUp();
        }

    }

    private static void displaySpMenu(Scanner input) {
        String menuOptions = ANSI_PURPLE + """
                     ╔════════════════════════════════════╗
                     ║       Service Provider Menu        ║
                     ╠════════════════════════════════════╣
                     ║ 1. Add a new service               ║
                     ║ 2. Modify an existing service      ║
                     ║ 3. Delete an existing service      ║
                     ║ 4. View the list of users          ║
                     ║ 5. View the list of services       ║
                     ║ 6. Exit                            ║
                     ╚════════════════════════════════════╝
                     """ + ANSI_RESET+"\n"+CHOICE_PROMPT;

        int choice;
        logger.info(menuOptions);

        while (true) {
            choice = getChoice(input);
            switch (choice) {
                case 1 -> addNewService(input);
                case 2 -> modifyExistingService(input);
                case 3 -> deleteExistingService(input);
                case 4 -> viewListOfUsers();
                case 5 -> viewListOfServices();
                case 6 -> {
                    logger.info("Logging out as Service provider.");
                    logInSignUp();
                    return;
                }
                default -> logger.info(INVALID_OPTION_MESSAGE);
            }
            displaySpMenu( input);
        }
    }

    private static int getChoice(Scanner input) {
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            try {
                choice = input.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                logger.info(INCORRECT_VALUE_MESSAGE);
                input.next();
            }
        }
        return choice;
    }

    private static void addNewService(Scanner input) {
        logger.info(PROMPT_SERVICE_ID);
        int id = input.nextInt();
        String description = getInput("Please enter description");
        logger.info("Enter service cost:");
        int cost = input.nextInt();
        obj.addServiceToSp(description, cost, id, sp.getPerson().getUserName());
    }

    private static void modifyExistingService(Scanner input) {
        if (sp != null) {
            Person person = sp.getPerson();
            if (person != null) {
                String userName = person.getUserName();
                if (userName != null) {
                    String p2=obj.showservicesForSp(userName);
                    logger.info(p2);
                    logger.info(PROMPT_SERVICE_ID);
                    int id = input.nextInt();
                    String description = getInput("Please enter new description");
                    logger.info("Enter new cost:");
                    int cost = input.nextInt();

                    if (description != null) {
                        obj.editServiceForSp(description, cost, id, userName);
                    } else {
                        logger.info("Cannot edit service for SP, description is null.");
                    }
                } else {
                    logger.info("User name is null.");
                }
            } else {
                logger.info("Person object is null.");
            }
        } else {
            logger.info("Service provider details are incomplete.");
        }
    }


    private static void deleteExistingService(Scanner input) {
        if (sp != null && sp.getPerson() != null && sp.getPerson().getUserName() != null) {
            String p1=obj.showservicesForSp(sp.getPerson().getUserName());
            logger.info(p1);
            logger.info(PROMPT_SERVICE_ID);
            int id = input.nextInt();
            obj.deleteServiceForSp(id, sp.getPerson().getUserName());
        } else {
            logger.info("Service provider or username is null, cannot proceed with the delete operation.");
        }
    }

    private static void viewListOfUsers() {
        if (sp != null && sp.getPerson() != null && sp.getPerson().getUserName() != null) {
            String p=obj.showUsersAndEventsForSp(sp.getPerson().getUserName());
            logger.info(p);
        } else {
            logger.info("Cannot show users and events for service provider - missing details.");
        }
    }

    private static void viewListOfServices() {
        if (sp != null && sp.getPerson() != null && sp.getPerson().getUserName() != null) {
            logger.info(obj.showservicesForSp(sp.getPerson().getUserName()));
        } else {
            logger.info("Cannot show services for the service provider - missing details.");
        }
    }

   private static void addServices(Scanner input,int int1,Event event1){
       String menu = ANSI_PURPLE + """
              ╔════════════════════════════╗
              ║       Service Menu         ║
              ╠════════════════════════════╣
              ║ 1. Food Service            ║
              ║ 2. Decor Service           ║
              ║ 3. Photo Service           ║
              ║ 4. Enter Service           ║
              ║ 5. Finish                  ║
              ╚════════════════════════════╝
              """ +ANSI_RESET+"\n"+CHOICE_PROMPT;
            logger.info(menu);

          int serviceChoice= 0;
           boolean valid = false;
           while (!valid) {
               try {
                   serviceChoice= input.nextInt();
                   valid = true;
               } catch (InputMismatchException e) {

                   logger.info(INCORRECT_VALUE_MESSAGE);
                   input.next();

               }
           }

            String type = "";
            String spList = "";
       switch (serviceChoice) {
           case 1 -> type = "Food";
           case 2 -> type = "Decoration";
           case 3 -> type = "Entertainment";
           case 4 -> type = "Photographer";
           case 5 -> {
               int eventCost = obj.getLocalEvent().eventCost(cost);

               logger.info(CREATE_EVENT_MESSAGE + String.valueOf(eventCost));


               displayUserMenu(input);
           }
           default -> {
               logger.info("Choose from the menu plz..\n");
               addServices(input, int1, event1);
           }
       }
       if (serviceChoice != 5) {
            spList = searchInSpAccordingToType(type);
           logger.info(spList);

           String spName = getInput("Please enter service Provider Name: ");
           if (spName != null && !spName.isEmpty()) {
               logger.info(obj.showservicesForSp(spName));
           } else {
               logger.info("Service provider name is not provided.");
           }

           Integer serviceId = input.nextInt();
           obj.setLocalEvent(event1);

           obj.addFoodService(serviceId, type);

           logger.info("Added Successfully");


           addServices(input, int1, event1);
       }}


       static int cost;


    private static void location(int year,int month,int day,Time time){

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



        location(year, month, day, time);

        Integer id = input.nextInt();

        String theme= getInput( "Please enter theme: ");
        logger.info("Please enter number of attend people: ");
        Integer number = input.nextInt();
        Location loc;
        String locationName="";
        loc = searchInLocation(id);
        if (loc != null) {
            cost += loc.getCost();
            locationName = loc.getLocationName();
        }




        obj.createEventWithBasicInfo(user.getUserName(),eventName,year,month, day, time.getHours(), time.getMinutes(), time.getSeconds(), locationName, theme, number);
        String menu = ANSI_PURPLE + """
              ╔═════════════════════════════════╗
              ║        Package & Services       ║
              ╠═════════════════════════════════╣
              ║ 1. Choose from existing package ║
              ║ 2. Choose your own services     ║
              ║ 3. Exit                         ║
              ╚═════════════════════════════════╝
              """ + ANSI_RESET+"\n"+CHOICE_PROMPT;

        logger.info(menu );
        int choice = input.nextInt();
        int packid;
        switch (choice) {
            case 1 -> {
                String pack = obj.showPackageForAdmin();
                logger.info(pack);

                packid = input.nextInt();
                obj.addLocalEventToEventList();


                Package pk = searchInPackage(packid);
                if (pk != null) {
                    Event localEvent = obj.getLocalEvent();
                    if (localEvent != null) {
                        int eventCost = localEvent.eventCost(cost);
                        logger.info(CREATE_EVENT_MESSAGE + eventCost);
                    } else {
                        logger.info("Local event not found, cannot calculate cost.");
                    }
                } else {
                    logger.info("Package with id " + packid + " not found.");
                }

                displayUserMenu(input);
            }
            case 2 -> addServices(input, obj.getLocalEvent().eventCost(cost), obj.getLocalEvent());
            case 3 -> logger.info(CREATE_EVENT_MESSAGE + cost);
            default ->
                logger.info("Invalid input.");


        }

    }

    private static void displayUserMenu(Scanner input) {
        String s = "\u001B[95m" + """
        \n
        ╔══════════════════════╗
        ║      User Menu       ║
        ╠══════════════════════╣
        ║ 1. create an event   ║
        ║ 2. edit the event    ║
        ║ 3. delete an event   ║
        ║ 4. view events       ║
        ║ 5. exit              ║
        ╚══════════════════════╝
        """ + ANSI_RESET+"\n"+CHOICE_PROMPT;

        logger.info(s);
        int choice = input.nextInt();
        String show;
        switch (choice) {
            case 1 -> creatBasicEvent(input);
            case 2 -> editEvent(input);
            case 3 -> {
                show = obj.viewEventsByUser(user.getUserName());
                String eventname = getInput(show + "\n Please enter eventName:\n");
                logger.info("The event " + eventname + " was successfully deleted\n\n");
                obj.deleteEventByUser(user.getUserName(), eventname);

            }
            case 4 -> {
                show = obj.viewEventsByUser(user.getUserName());
                logger.info(show);
                displayUserMenu(input);
            }
            case 5 -> logInSignUp();
            default -> {
                logger.info("Invalid option selected.\n");
                displayUserMenu(input);
            }
        }
        displayUserMenu(input);





    }

    private static void editEvent(Scanner input) {
        String show = obj.viewEventsByUser(user.getUserName());
        logger.info(show);
        String eventName = getInput("Please enter Event name: ");

        displayEditMenu();

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> editEventName(eventName);
            case 2 -> editEventLocation(eventName, input);
            case 3 -> editEventDate(eventName, input);
            case 4 -> editEventTime(eventName, input);
            case 5 -> editEventAttendees(eventName, input);
            case 6 -> editEventTheme(eventName);
            case 7 -> addServicesToEvent(eventName, input);
            case 8 -> removeServiceFromEvent(eventName, input);
            case 9 -> cancelSelectedPackage(eventName);
            case 10 -> editSelectedPackage(eventName, input);
            case 11 -> displayUserMenu(input);
            default -> {
                logger.info(INVALID_OPTION_MESSAGE);
                displayEditMenu();
            }
        }

    }

    private static void displayEditMenu() {
        String menu = "\u001B[95m" + """
        \n
        ╔════════════════════════════════════╗
        ║          Edit Event Menu           ║
        ╠════════════════════════════════════╣
        ║  1. Edit event name                ║
        ║  2. Change event location          ║
        ║  3. Update event date              ║
        ║  4. Update event time              ║
        ║  5. Number of attendees for event  ║
        ║  6. Change event theme             ║
        ║  7. Add additional services        ║
        ║  8. Remove a service               ║
        ║  9. Cancel selected package        ║
        ║ 10. Edit selected package          ║
        ║ 11. Exit                           ║
        ╚════════════════════════════════════╝
       """ + ANSI_RESET+"\n"+CHOICE_PROMPT;
        logger.info(menu);
    }

    private static void editEventName(String eventName) {
        String newEventName = getInput("Please enter new Event name: ");
        obj.editEventNameByUser(user.getUserName(), eventName, newEventName);
    }

    private static void editEventLocation(String eventName, Scanner input) {

        Event event = searchInEventByName(eventName);
        if (event != null) {
            location(event.getDate().getYear(), event.getDate().getMonth(), event.getDate().getDate(), event.getTime());
        }





            int locationId = input.nextInt();
        obj.editLocation(user.getUserName(), eventName, locationId);
    }

    private static void editEventDate(String eventName, Scanner input) {
        String dates = getInput("Please enter event date (yyyy-MM-dd): ");
        String[] dateComponents = dates.split("-");
        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]);
        int day = Integer.parseInt(dateComponents[2]);
        int temp = 0;

        for (Event e : obj.getEventList()) {

            Event event = searchInEventByName(eventName);
                if (event != null && e.getDate().getYear() == year && e.getDate().getMonth() == month && e.getDate().getDate() == day && e.getTime().equals(event.getTime()) && e.getLocation().equals(event.getLocation())) {
                    logger.info("You cannot book on this date.\n There is another event booked\n");
                    temp = 1;
                    editEventDate(eventName, input);
                    break;
                }



        }
        if (temp == 0) {
            obj.editEventDateByUser(user.getUserName(), eventName, year, month, day);
        }
    }

    private static void editEventTime(String eventName, Scanner input) {
        String times = getInput("Please enter event time (HH:mm:ss): ");
        String[] dateComponents = times.split(":");
        int hour = Integer.parseInt(dateComponents[0]);
        int min = Integer.parseInt(dateComponents[1]);
        int sec = Integer.parseInt(dateComponents[2]);
        Time time = new Time(hour, min, sec);

        int temp = 0;

        for (Event e : obj.getEventList()) {
            Event event = searchInEventByName(eventName); // Call the method once and store the result in loc
            if (event != null && e.getDate().getYear() == event.getDate().getYear() && e.getDate().getMonth() == event.getDate().getMonth() && e.getDate().getDate() == event.getDate().getDate() && e.getTime().equals(time) && e.getLocation().equals(event.getLocation())) {
                logger.info("you can't choose this time because location is booked to another event\n");
                temp = 1;
                editEvent(input);
                break;
            }


        }
        if (temp == 0) {
            obj.editEventTimeByUser(user.getUserName(), eventName, hour, min, sec);
        }
    }

    private static void editEventAttendees(String eventName, Scanner input) {
        logger.info("Number of attendees for the event: ");
        int num = input.nextInt();
        obj.editEventNumOfPeapleByUser(user.getUserName(), eventName, num);
    }

    private static void editEventTheme(String eventName) {
        String theme = getInput("Please enter new Event theme: ");
        obj.editEventThemeByUser(user.getUserName(), eventName, theme);
    }

    private static void addServicesToEvent(String eventName, Scanner input) {
        Event event = searchInEventByName(eventName);
        if (event != null) {
            addServices(input, event.getOverallCost(),event);
        }
    }

    private static void removeServiceFromEvent(String eventName, Scanner input) {

        String s = "";
        Event event = searchInEventByName(eventName);
        if (event != null) {
        if (event.getFoodService() != null) {
            s += event.getFoodService().getId() + "\t" + event.getFoodService().getDiscription() + "\n";
        }
        if (event.getDecorService() != null) {
            s += event.getDecorService().getId() + "\t" + event.getDecorService().getDiscription() + "\n";
        }
        if (event.getEntertainmentService() != null) {
            s += event.getEntertainmentService().getId() + "\t" + event.getEntertainmentService().getDiscription() + "\n";
        }
        if (event.getPhotographerService() != null) {
            s += event.getPhotographerService().getId() + "\t" + event.getPhotographerService().getDiscription() + "\n";
        }
        }
        logger.info(s);
        Integer serviceToDelete = input.nextInt();
        obj.editDeleteServiceFromEventByUser(user.getUserName(), eventName, serviceToDelete);
    }

    private static void cancelSelectedPackage(String eventName) {
        obj.editDeletePackageFromEventByUser(user.getUserName(), eventName);
    }

    private static void editSelectedPackage(String eventName, Scanner input) {
        String pack = obj.showPackageForAdmin();
        logger.info(pack);
        int pakid = input.nextInt();
        obj.setLocalEvent(searchInEventByName(eventName));

        if (obj.addPackageToEvent(pakid)) {
            int cost11= obj.getLocalEvent().eventCost(cost);
            logger.info(String.format("%s %d", CREATE_EVENT_MESSAGE,cost11));
        } else {
            logger.info("Failed to add package to the event.");
        }
    }


    private static void displayAdminMenu(Scanner input) {
        String menu = "\n\u001B[33m" + """
              ╔══════════════════════════════════════════╗
              ║                 Admin Menu               ║
              ╠══════════════════════════════════════════╣
              ║ 1. View list of all registered users     ║
              ║ 2. View list of all service providers    ║
              ║ 3. View list of all events               ║
              ║ 4. Create a new ready-made package       ║
              ║ 5. Delete an existing ready-made package ║
              ║ 6. View list of all packages             ║
              ║ 7. Exit                                  ║
              ╚══════════════════════════════════════════╝
              """ +ANSI_RESET+"\n"+CHOICE_PROMPT;
        logger.info(menu);
        int choice = input.nextInt();

            String s1="";

                      if (choice==1) {
                s1=obj.showUserListForAdmin();

                logger.info(s1);
            }

                      else if (choice==2) {
                    s1=obj.showSPtForAdmin();
                    logger.info(s1);
                }


                else if (choice==3) {
                s1=  obj.showEventForAdmin();
                logger.info(s1);
            }

            else if (choice==4) {

                    logger.info("Please enter package ID: ");
                Integer id = input.nextInt();
                String description = getInput("Please enter package description: ");
                logger.info("Please enter package cost: ");
                Double cost = input.nextDouble();
                obj.createPackage(description, cost, id);}


                else if (choice==5) {
                    s1=obj.showPackageForAdmin();

                logger.info(s1);
                logger.info("Please enter package ID: ");
                Integer id = input.nextInt();
                obj.deletePackage(id);
                }


                else if (choice==6) {
                    String packageInfo = obj.showPackageForAdmin();
                    logger.info(packageInfo);
                }


         else if (choice==7) {
                logger.info("Logging out as Admin.");

                logInSignUp();
            }
           else{
                logger.info(INVALID_OPTION_MESSAGE);
                displayAdminMenu(input);
            }

        displayAdminMenu( input);
    }

    private static void forgotPass() {
        String name = getInput( "Enter the name for your account");
        String pass = getInput( "Enter the new password for your account");
        obj.setEnteredUsername(name);
        obj.takePass(pass);
        logger.info("successfully Update");
    }

    private static void signUpProcedure(Scanner input) {
        String menu = ANSI_PURPLE + """
              ╔══════════════════════╗
              ║      Role Menu       ║
              ╠══════════════════════╣
              ║ 1. Service provider  ║
              ║ 2. User              ║
              ║ 3. Exit              ║
              ╚══════════════════════╝
              """ +ANSI_RESET+"\n"+CHOICE_PROMPT;

        logger.info(menu);
        int choice = input.nextInt();
        String name ;
        String phone ;
        String email ;
        String password;
        String birthDate;
        String type;

        switch (choice) {
            case 1 -> {
                logger.info("\nIn order to make a new account you have to enter your information\n");
                name = getInput(PROMPT_NAME_MESSAGE);
                phone = getInput("Please enter your phone");
                email = getInput("Please enter your Gmail");
                password = getInput(PROMPT_PASSWORD_MESSAGE);
                birthDate = getInput("Please enter your BirthDate");
                type = getInput("\nPlease enter your type(Food,Decoration,Entertainment,Photographer)-->");
                obj.createAccountForSp(name, password, birthDate, phone, type, email);

            }
            case 2 -> {
                logger.info("\nIn order to make a new account you have to enter your information\n");
                name = getInput(PROMPT_NAME_MESSAGE);
                phone = getInput("Please enter your phone");
                email = getInput("Please enter your Gmail");
                password = getInput(PROMPT_PASSWORD_MESSAGE);
                birthDate = getInput("Please enter your BirthDate");
                obj.createAccountForUser(name, password, birthDate, phone, email);
            }
            case 3 ->
                logInSignUp();

            default -> {
                logger.info(INVALID_OPTION_MESSAGE);
                signUpProcedure(input);
            }
        }



    }

    private static String getInput(String prompt) {
       logger.info(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
       
            return "";
        }
    }

}
