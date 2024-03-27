package org.example;
import ttoday.edu.*;
import ttoday.edu.Package;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
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
    private static final String ANSI_PURPLE = "\n\u001B[95m";

    private static final String NAME = "qa";
    private static final String PASS_1 = "3";

    private static final String ANSI_RESET = "\u001B[0m";

    private static String username(String str) {
        String user = "to";
        user += str;
        return user;
    }

    private static String password(String str) {
        String pass = "12";
        pass += str;
        return pass;
    }

    private static final String PROMPT_NAME_MESSAGE = "Please enter your Name";
    private static final String PROMPT_SERVICE_ID = "Enter service id:";
    private static final String INVALID_OPTION_MESSAGE = "Invalid option selected.";
    private static final String CREATE_EVENT_MESSAGE = "Create event successfully and its price is ";

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
        for (Package j : obj.getPackageList()) {
            if (j.getNumber() == packId) {
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

    private static Person user = new Person();
    private static ServiceProvider sp = new ServiceProvider();

    static MyAppT obj = new MyAppT();

    public static void main(String[] args) {

        logInSignUp();

    }

    public static void logInSignUp() {
        Scanner input = new Scanner(System.in);

        String menuOptions = ANSI_PURPLE + """
                ╔════════════════════════════╗
                ║          Welcome!          ║
                ╠════════════════════════════╣
                ║ 1. Sign up                 ║
                ║ 2. Login                   ║
                ║ 3. Forget password         ║
                ║ 4. Log out                 ║
                ╚════════════════════════════╝
                """ + ANSI_RESET + "\n" + CHOICE_PROMPT;
        logger.info(menuOptions);

        int choice = 0;
        boolean valid = false;
        while (!valid) {
            try {


                choice = input.nextInt();
                if (choice > 0 && choice < 5) {
                    valid = true;
                }
                if (!valid) {
                    logger.info(CHOICE_PROMPT);
                }
            } catch (InputMismatchException e) {

                logger.info(INCORRECT_VALUE_MESSAGE);
                input.next();

            }
        }

        switch (choice) {
            case 1 -> signUpProcedure(input);


            case 2 -> loginProcedure(input);


            case 3 -> forgotPass();


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
        String adimnUsername = username(NAME);
        String adminPassword = password(PASS_1);

        String name = getInput(PROMPT_NAME_MESSAGE);
        String password = getInput(PROMPT_PASSWORD_MESSAGE);
        user = obj.searchInUser(name);
        sp = obj.searchInServiceProvider(name);
        if (user != (null)) {
            if (password.equals(user.getPass())) {
                displayUserMenu(input);
            } else {
                logger.info("Wrong Password\n");
                logInSignUp();
            }
        } else if (sp != (null)) {
            if (password.equals(sp.getPerson().getPass())) {
                displaySpMenu(input);
            } else {
                logger.info("Wrong Password\n");
                logInSignUp();
            }


        } else if (name.equals(adimnUsername) && password.equals(adminPassword)) {
            displayAdminMenu(input);

        } else {
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
                """ + ANSI_RESET + "\n" + CHOICE_PROMPT;

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
            displaySpMenu(input);
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
        int id = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                id = input.nextInt();
                if (searchInServiceById(id, sp)) {
                    validInput = true;
                } else {
                    logger.severe("this id is existing before...  Enter another Service Id:  ");

                }
            } catch (InputMismatchException ime) {
                logger.severe("Invalid input ...  Enter Service Id: ");
                input.next();
            }
        }

        String description = getInput("Please enter description"); // Assuming this method handles its own exceptions

        logger.info("Enter service cost:");
        int cost = 0;
        validInput = false;
        while (!validInput) {
            try {
                cost = input.nextInt();
                validInput = true; // Exit loop if input is successful
            } catch (InputMismatchException ime) {
                logger.severe(INVALID_COST_INPUT);
                input.next(); // Consume the invalid token to avoid infinite loop
            }
        }

        obj.addServiceToSp(description, cost, id, sp.getPerson().getUserName());


    }

    private static final String INVALID_COST_INPUT = "Invalid input. Please enter a numeric value for cost.";


    private static void modifyExistingService(Scanner input) {

        Person person = sp.getPerson();

        String userName = person.getUserName();
        String p2 = obj.showservicesForSp(userName);
        logger.info(p2);

        logger.info(PROMPT_SERVICE_ID);
        int id = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                id = input.nextInt();
                if (!searchInServiceById(id, sp)) {
                    validInput = true;
                } else {
                    logger.severe("this id doesn't existing before...  Enter another Service Id:  ");

                }
            } catch (InputMismatchException ime) {
                logger.severe("Invalid input ...  Enter Service Id: ");
                input.next();
            }
        }


        String description = getInput("Please enter new description");

        logger.info("Enter new cost:");
        int cost = 0;
        validInput = false;
        while (!validInput) {
            try {
                cost = input.nextInt();
                validInput = true;
            } catch (InputMismatchException ime) {
                logger.info(INVALID_COST_INPUT);
                input.next(); // Consume the invalid token to avoid infinite loop
            }
        }


        obj.editServiceForSp(description, cost, id, userName);


    }


    private static void deleteExistingService(Scanner input) {
        if (sp != null && sp.getPerson() != null && sp.getPerson().getUserName() != null) {
            String p1 = obj.showservicesForSp(sp.getPerson().getUserName());
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
            String p = obj.showUsersAndEventsForSp(sp.getPerson().getUserName());
            logger.info(p);
        } else {
            logger.info("Cannot show users and events for service provider - missing details.");
        }
    }

    private static void viewListOfServices() {
        if (sp != null && sp.getPerson() != null && sp.getPerson().getUserName() != null) {
            String p1 = obj.showservicesForSp(sp.getPerson().getUserName());
            logger.info(p1);
        } else {
            logger.info("Cannot show services for the service provider - missing details.");
        }
    }

    private static void addServices(Scanner input, int int1, Event event1) {
        String menu = ANSI_PURPLE + """
                ╔════════════════════════════╗
                ║       Service Menu         ║
                ╠════════════════════════════╣
                ║ 1. Food Service            ║
                ║ 2. Decor Service           ║
                ║ 3. Enter Service           ║
                ║ 4. Photo Service           ║
                ║ 5. Finish                  ║
                ╚════════════════════════════╝
                """ + ANSI_RESET + "\n" + CHOICE_PROMPT;
        logger.info(menu);

        int serviceChoice = 0;
        boolean valid = false;
        while (!valid) {
            try {
                serviceChoice = input.nextInt();
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
                String createEventMessage = CREATE_EVENT_MESSAGE;
                createEventMessage += eventCost;
                logger.info(createEventMessage);


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
            String spName;
            do {
                spName = getInput("Please enter service Provider Name: ");
            } while (spName == null || spName.isEmpty() || obj.searchInServiceProvider(spName) == null);

            obj.searchInServiceProvider(spName).addEvent(obj.getLocalEvent());
            String s = obj.showservicesForSp(spName);
            s += "\nEnter your choice: ";
            logger.info(s);


            Integer serviceId = input.nextInt();
            obj.setLocalEvent(event1);

            obj.addFoodService(serviceId, type);

            logger.info("Added Successfully");

            addServices(input, int1, event1);
        }
    }


    static int cost;


    private static void location(int year, int month, int day, Time time) {

        logger.info("locations: ");
        int temp = 0;
        for (Location l : obj.getLocationList()) {

            for (Event e : obj.getEventList()) {


                if (e.getDate().getYear() == year && e.getDate().getMonth() == month && e.getDate().getDate() == day && e.getTime().equals(time) && e.getLocation().equals(l.getLocationName())) {
                    temp = 1;
                    break;
                }
            }
            if (temp == 0) {
                logger.info(l.getId() + "\t" + l.getLocationName() + "\t" + l.getCost() + "\n");


            } else {
                temp = 0;
            }

        }
        logger.info("Please enter location ID: ");

    }

    private static void creatBasicEvent(Scanner input) {
        cost = 0;

        Time time = new Time(1, 2, 3);
        String eventName = getInput("Please enter event name: ");
        String dates = getInput("Please enter event date(yyyy-MM-dd): ");
        String times = getInput("Please enter event time(HH:mm:ss): ");

        String[] dateComponents = dates.split("-");


        int year = Integer.parseInt(dateComponents[0]);
        int month = Integer.parseInt(dateComponents[1]);
        int day = Integer.parseInt(dateComponents[2]);


        dateComponents = times.split(":");
        int hour = Integer.parseInt(dateComponents[0]);
        int min = Integer.parseInt(dateComponents[1]);
        int sec = Integer.parseInt(dateComponents[2]);
        time = new Time(hour, min, sec);


        location(year, month, day, time);

        Integer id = input.nextInt();

        String theme = getInput("Please enter theme: ");
        logger.info("Please enter number of attend people: ");
        Integer number = input.nextInt();
        Location loc;
        String locationName = "";
        loc = searchInLocation(id);
        if (loc != null) {
            cost = loc.getCost();

            locationName = loc.getLocationName();
        }

        Date datePass = new Date(year, month, day);
        Time timePass = new Time(time.getHours(), time.getMinutes(), time.getSeconds());

        obj.createEventWithBasicInfo(user.getUserName(), eventName, datePass, timePass, locationName, theme, number);
        String menu = ANSI_PURPLE + """
                ╔═════════════════════════════════╗
                ║        Package & Services       ║
                ╠═════════════════════════════════╣
                ║ 1. Choose from existing package ║
                ║ 2. Choose your own services     ║
                ║ 3. Exit                         ║
                ╚═════════════════════════════════╝
                """ + ANSI_RESET + "\n" + CHOICE_PROMPT;

        logger.info(menu);

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
                        localEvent.setPack(pk);
                        int eventCost = localEvent.eventCost(cost);
                        String s = CREATE_EVENT_MESSAGE;
                        s += String.valueOf(eventCost);
                        logger.info(s);
                    } else {
                        logger.info("Local event not found, cannot calculate cost.");
                    }
                } else {
                    String packageMessage = "Package with id ";
                    packageMessage += String.valueOf(packid);
                    packageMessage += " not found.";
                    logger.info(packageMessage);
                }

                displayUserMenu(input);
            }
            case 2 -> addServices(input, obj.getLocalEvent().eventCost(cost), obj.getLocalEvent());
            case 3 -> {
                String s = CREATE_EVENT_MESSAGE;
                s += String.valueOf(cost);
                obj.getLocalEvent().eventCost(cost);
                logger.info(s);
            }
            default -> logger.info("Invalid input.");


        }

    }

    private static void displayUserMenu(Scanner input) {
        String s = ANSI_PURPLE +
                "\n╔══════════════════════╗" +
                "\n║      User Menu       ║" +
                " \n╠══════════════════════╣" +
                "\n║ 1. create an event   ║" +
                "\n║ 2. edit the event    ║" +
                "\n║ 3. delete an event   ║" +
                "\n║ 4. view events       ║" +
                "\n║ 5. exit              ║" +
                "\n╚══════════════════════╝" + ANSI_RESET + "\n" + CHOICE_PROMPT;


        logger.info(s);
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
        String show;
        switch (choice) {
            case 1 -> creatBasicEvent(input);
            case 2 -> {
                show = obj.viewEventsByUser(user.getUserName());
                logger.info(show);
                String eventName;
                do {
                    eventName = getInput("Please enter Event name: ");
                } while (searchInEventByName(eventName) == null);
                editEvent(input, eventName);
            }
            case 3 -> {
                show = obj.viewEventsByUser(user.getUserName());
                logger.info(show);
                String eventname;
                do {
                    eventname = getInput("Please enter Event name: ");
                } while (searchInEventByName(eventname) == null);
                obj.deleteEventByUser(user.getUserName(), eventname);
                String eventCreated = "The event ";
                eventCreated += eventname;
                eventCreated += " was successfully deleted\n\n";
                logger.info(eventCreated);

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

    private static void editEvent(Scanner input, String s) {

        String eventName = s;
        displayEditMenu();

        int choice = input.nextInt();

        switch (choice) {
            case 1 -> eventName = editEventName(eventName);
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
            default -> logger.info(INVALID_OPTION_MESSAGE);


        }
        editEvent(input, eventName);

    }

    private static void displayEditMenu() {
        String menu = ANSI_PURPLE +
                "\n╔════════════════════════════════════╗" +
                "\n║          Edit Event Menu           ║" +
                "\n╠════════════════════════════════════╣" +
                "\n║  1. Edit event name                ║" +
                "\n║  2. Change event location          ║" +
                "\n║  3. Update event date              ║" +
                "\n║  4. Update event time              ║" +
                "\n║  5. Number of attendees for event  ║" +
                "\n║  6. Change event theme             ║" +
                "\n║  7. Add additional services        ║" +
                "\n║  8. Remove a service               ║" +
                "\n║  9. Cancel selected package        ║" +
                "\n║ 10. Edit selected package          ║" +
                "\n║ 11. Exit                           ║" +
                "\n╚════════════════════════════════════╝" +
                ANSI_RESET + "\n" + CHOICE_PROMPT;
        logger.info(menu);
    }

    private static String editEventName(String eventName) {
        String newEventName = getInput("Please enter new Event name: ");
        obj.editEventNameByUser(user.getUserName(), eventName, newEventName);
        return newEventName;
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
                editEvent(input, eventName);
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
            obj.setLocalEvent(event);
            addServices(input, event.getOverallCost(), event);
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
            int cost11 = obj.getLocalEvent().eventCost(cost);
            String s = CREATE_EVENT_MESSAGE;
            s += String.valueOf(cost11);
            logger.info(s);
        } else {
            logger.info("Failed to add package to the event.");
        }
    }

    private static int enterCorrevtId(Scanner input, String s1, String s2) {
        boolean validInput = false;

        int id = 0;
        while (!validInput) {
            try {
                id = input.nextInt();
                if (searchInPackageById(id)) {
                    validInput = true;
                } else {
                    logger.severe(s1);

                }
            } catch (InputMismatchException ime) {
                logger.severe(s2);
                input.next();
            }
        }
        return id;
    }

    private static int enterCorrectCost(Scanner input) {
        int cost = 0;
        Boolean validCostInput = false;
        while (!validCostInput) {
            try {
                cost = input.nextInt();
                validCostInput = true; // Exit loop if input is successful
            } catch (InputMismatchException ime) {
                logger.severe(INVALID_COST_INPUT);
                input.next(); // Consume the invalid token to avoid infinite loop
            }
        }
        return cost;
    }

    private static int enterCorrevtIdLocation(Scanner input) {

        boolean validIn = false;
        int idLocation=0;

        while (!validIn) {
            try {
                idLocation = input.nextInt();
                if (searchInLocationById(idLocation)) {
                    validIn = true;
                } else {
                    logger.severe("this id is existing before...  Enter another Location Id:  ");

                }
            } catch (InputMismatchException ime) {
                logger.severe("Invalid input ...  Enter Location Id: ");
                input.next();
            }
        }
        return idLocation;

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
              ║ 7. Add location                          ║
              ║ 8. Show location                         ║
              ║ 9. Exit                                  ║
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



            int id = 0;
           id= enterCorrevtId( input,"this id is existing before...  Enter another Package Id:  ","Invalid input ...  Enter Package Id: ");


                String description = getInput("Please enter package description: ");
                logger.info("Please enter package cost: ");
                Double cost = input.nextDouble();
                obj.createPackage(description, cost, id);


        }
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
            logger.info("Enter Location Id:");
            int id = 0;
           id= enterCorrevtIdLocation(input);

            String name = getInput( "Enter the name ");
            String description = getInput("Please enter description");

            logger.info("Enter Location cost:");
            int cost = 0;
            cost=enterCorrectCost( input);

          Location l1=new Location(id,cost,name,description);
            obj.getLocationList().add(l1);

        }
        else if (choice==8) {
            String s=showLocationForAdmin();
            logger.info(s);
        }


        else if (choice==9) {
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
                logger.info("\nYou have successfully registered in our system as service provider. Welcome\n");
                logInSignUp();

            }
            case 2 -> {
                logger.info("\nIn order to make a new account you have to enter your information\n");
                name = getInput(PROMPT_NAME_MESSAGE);
                phone = getInput("Please enter your phone");
                email = getInput("Please enter your Gmail");
                password = getInput(PROMPT_PASSWORD_MESSAGE);
                birthDate = getInput("Please enter your BirthDate");
                obj.createAccountForUser(name, password, birthDate, phone, email);
                logger.info("\nYou have successfully registered in our system as User. Welcome\n");
                logInSignUp();
            }
            case 3 ->
                    logInSignUp();

            default -> {
                logger.info(INVALID_OPTION_MESSAGE);
                signUpProcedure(input);
            }
        }



    }

private static boolean searchInLocationById(int id){
    for(Location l :obj.getLocationList()) {
        if(l.getId()==id){
            return false;

        }
    }
    return true;}

    private static boolean searchInPackageById(int id){
        for(Package p :obj.getPackageList()) {
            if(p.getNumber()==id){
                return false;

            }
        }
        return true;}
    private static boolean searchInServiceById(int id,ServiceProvider sp){
        for(Service p : sp.getOfferList()) {
            if(p.getId()==id){
                return false;

            }
        }
        return true;}





private static String getInput(String prompt) {
        logger.info(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {

            return "";
        }
    }

    public static String showLocationForAdmin() {
        String headerFormat = "\u001B[33m%-10s\t%-30s\t%-40s\t%-10s\n\u001B[0m";
        String rowFormat = "\u001B[33m%-10s\t%-30s\t%-40s\t%-10.2f\n\u001B[0m";

        StringBuilder format = new StringBuilder();
        format.append("\n");
        format.append(String.format(headerFormat, "ID", "Name", "Description", "Cost"));

        for (Location L : obj.getLocationList()) {
            double cost = L.getCost();
            format.append(String.format(rowFormat,
                    L.getId(),
                    L.getLocationName(),
                    L.getDescription(),
                    cost));
        }


        return format.toString();
    }


}
