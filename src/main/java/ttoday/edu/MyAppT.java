package ttoday.edu;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;


public class MyAppT {
private static int num=0;

     private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final String DEFAULT_EMAIL = "raghadsalhab13@gmail.com";
    public static final String SERVICE_TYPE_PHOTOGRAPHER = "Photographer";
    final String SERVICE_TYPE = "Entertainment";
    public static final String SERVICE_TYPE_DECORATION = "Decoration";

    public static final String SERVICE_TYPE_FOOD = "Food";
    public static final String HYPHEN_STRING = "------";
    public static final String PHONE_NUMBER_LABEL = "Phone Number";
    public static final String THEME_LABEL = "Theme";
    public static final String EVENT_NAME_LABEL = "Event Name";
    public static final String LOCATION_LABEL = "Location";
      private boolean isEventDeleteEventEdit;
    private boolean isEventViewEventsEdit;
    private boolean isEventCancelPackageEdit;
    private boolean isEventRemoveServiceEdit;
    private boolean isEventThemeEdit;
    private boolean isEventNumOfPeopleEdit;
    private boolean isEventTimeEdit;
    private boolean isEventDateEdit;
    private boolean adminMenuFlag;
    private boolean isDeletePackage;
    private boolean isCreatePackage;
    private boolean isSeeEventList;
    private boolean isSeeUserList;
    private boolean showUserListForAdminFlag;
    private boolean showEventForAdminFlag;
    private boolean isSeeSPList;
    private boolean showSPtForAdminFlag;
    private boolean createPackageFlag;
    private boolean deletePackageFlag;
    private boolean showPackageForAdminFlag;
    private boolean isEventNameEdit;
    private boolean isEventLocationEdit;


    private boolean isEventAdditionalServiceEdit;
    private boolean editEventNameByUserFlag;
    private boolean editEventDateByUserFlag;

    private boolean editEventTimeByUserFlag;
    private boolean editEventNumOfPeapleByUserFlag;
    private boolean editEventThemeByUserFlag;
    private boolean editToAddAdditionalServiceByUserFlag;
    private boolean editDeleteServiceFromEventByUserFlag;
    private boolean editDeletePackageFromEventByUserFlag;
    private boolean viewEventsByUserFlag;
    private boolean deleteeventbyuserflag;
    private boolean editLocationFlag;
    private boolean editPackageFlag;


    public Event getLocalEvent() {
        return localEvent;
    }

    public void setLocalEvent(Event localEvent) {
        this.localEvent = localEvent;
    }

    public MyAppT() {


        Person u1 = new Person("haya", "123", "7\3\2003", "0599221233",DEFAULT_EMAIL);
        addUser(u1);
        Person u2 = new Person("mohammad", "1234", "7\3\2004", "0594506933",DEFAULT_EMAIL);
        addUser(u2);
        Time t1 = new Time(5, 0, 0);
        java.sql.Date d1 = new java.sql.Date((long)2024 - 3 - 25);
        Event e1 = new Event("Laila's Birthday", d1, t1, "home", "Under the Sea", 20);
        Event e2 = new Event("omar's birthday", d1, t1, "home", "Upcycling ", 20);
        Location l1=new Location(1,0,"home","in my home free");
        Location l2=new Location(2,100,"ajaa resturent","150 peaple");

        addEvent(e1);
        addEvent(e2);
        Time t = new Time(8, 0, 0);
       d = new Date(2024, 2, 29);



        Event localEvent = new Event("asmaa", d, t, "home", "Superhero", 25);
        addEvent(localEvent);
        Person u4 = new Person("ahmad", "1234", "7\3\2005", "0594507973",DEFAULT_EMAIL);
        Person u3 = new Person("salma", "1234", "7\7\2006", "0594502933",DEFAULT_EMAIL);
        Person pforlogin = new Person("adam", "54321", "7\13\2014", "0594507933",DEFAULT_EMAIL);
        Person splogin = new Person("eman", "54321", "7\17\2016", "0594507933","eman@gmail.com");
        Person u7 = new Person("ali", "1234", "7\12\2020", "0594597933","s12112499@stu.najah.edu" +
                "");
        Person u8 = new Person("tala", "1234", "8\3\2009", "0594506933",DEFAULT_EMAIL);

        ServiceProvider eman = new ServiceProvider(splogin, SERVICE_TYPE_PHOTOGRAPHER);
        addServiceProvider(eman);
        addUser(pforlogin);
        addUser(u3);
        addUser(u4);
        u3.getEventList().add(e2);
        ServiceProvider raghad = new ServiceProvider(u8, SERVICE_TYPE_PHOTOGRAPHER);
        ServiceProvider mira = new ServiceProvider(u1, SERVICE_TYPE_FOOD);
        ServiceProvider asma = new ServiceProvider(u2, SERVICE_TYPE);
        ServiceProvider lama = new ServiceProvider(u7, SERVICE_TYPE_DECORATION);
        addServiceProvider(raghad);
        addServiceProvider(mira);
        addServiceProvider(asma);
        addServiceProvider(lama);


        Service f1 = new Service("cake", 1, 50, mira);
        Service f2 = new Service("flower", 3, 50, lama);
        Service f3 = new Service("photo", 4, 50, raghad);
        Service f4 = new Service("clone", 2, 50, asma);
        lama.addService(f2);
        mira.addService(f1);
        raghad.addService(f3);
        asma.addService(f4);
        e2.setEntertainmentService(f4);
       // e2.setDecorService(f2);

        Package p = new Package("food+photo", 1000.00,1);
        addPackage(p);
        Package p2 = new Package("food+photo+cake", 100.00,2);
        addPackage(p2);
        Person admin=new Person("Fatina","1234","17\3\2004","0599623123");
        Person abd=new Person("abd","1234","26\5\2004","0598188123");
        Event e3 = new Event("abd's Birthday", d1, t1, "home", "Circus ", 20);
        e3.setPack(p2);
        abd.addUserEvent(e3);
        up.add(abd);
        Person p5=new Person("mira","1234","26\2\2003","05981555123");
        addUser(p5);
        Event e5 = new Event("mira's Birthday", d1, t1, "home", "unicorn", 20);
        asma.addEvent(e5);
        e5.setUser(p5);
        e5.setPhotographerService(f4);
p5.addUserEvent(e5);
up.add(p5);
eventList.add(e5);
eventList.add(e3);
Location k1=new Location(1,100,"Resturant","50 people");
Location k2=new Location(2,100,"Park","70 people");
locationList.add(k1);
locationList.add(k2);
        Person pForDelete=new Person("rawand","1234","8\3\2011","0598986445");
        addUser(pForDelete);
        Event e6 = new Event("rawand's Birthday", d1, t1, "home", "Mexican", 20);
        e6.setUser(pForDelete);
        e6.setPhotographerService(f4);
        pForDelete.addUserEvent(e6);


    }

    private boolean editServiceForSpFlag;
    private boolean providerhasservice;
    private boolean showservicesForSpFlag;
    private boolean isEditService;
    private boolean isDeleteService;
    private boolean showUsersAndEventsForSpFlag;
    private boolean serviceaddedsucc;
    private boolean isShoweventsAnduser;
    private boolean deleteServiceForSpFlag;
    private boolean isShowService;
    private boolean serviceproviderMenuFlag;
    private boolean isAddService;
    private boolean isAdminFlag;
    private boolean isUserFlag;
    private boolean eventfoundflag;
    private boolean isServiceProviderFlag;
    private boolean userhasevent;
    private boolean serviceOrPackage;
    private boolean serviceMenuFlag;
    private boolean isPackageFlag;
    private boolean isServiceFlag;
    private boolean isDecorService;
    private boolean isFoodService;
    private boolean isPhotoService;
    private boolean isEnterService;
    private boolean addLocalEventFoodFlag;
    private boolean addLocalEventDecorFlag;
    private boolean addLocalEventEnterFlag;
    private boolean addLocalEventPhotoFlag;

    private boolean addPackageFlag;


    private boolean isLogged;
    private boolean localEventFlag = false;
    private boolean inUserPage = false;
    private boolean isInCreationPage;
    private boolean validation;
    Time t = new Time(8, 0, 0);
    Date d = new Date(2024, 2, 29);
    private Event localEvent = new Event("asmaa", d, t, "home", "frozen", 25);


    private List<Person> up = new ArrayList<>();
    private List<ServiceProvider> providerList = new ArrayList<>();

    private List<Event> eventList = new ArrayList<>();

    public List<Event> getEventList() {
        return eventList;
    }

    private List<Package> packageList = new ArrayList<>();
    private List<Location>locationList=new ArrayList<>();

    public List<Location> getLocationList() {
        return locationList;
    }

    public void addUser(Person user) {
        up.add(user);
    }

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void addServiceProvider(ServiceProvider user) {
        providerList.add(user);
    }

    public void addPackage(Package pack) {
        packageList.add(pack);
    }

    public static final Logger logger = Logger.getLogger(MyAppT.class.getName());

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }

    public boolean getValidation() {
        return validation;
    }


    public void setUsernameAndPassAndPassFromSystem(String name, String pass) {

        for (Person u : up) {

            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;

                logger.info("hi");
                break;

            }
        }
    }

    public void setInvalidUsernameAndPass(String name, String pass) {

        validation = false;
        for (Person u : up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {

                validation = true;
                break;
            }
        }
    }

    public void setValidUsernameAndInvalidPass(String name, String pass) {
        validation = false;
        for (Person u : up) {
            if (name.equals(u.getUserName()) && u.getPass().equals(pass)) {
                validation = true;
                break;
            }
        }
    }

    public void searchUser(){

    }


    public void setEmptyUsernameAndPass(String name, String pass) {
        if (name.isEmpty() && !pass.isEmpty())
            validation = false;
    }

    public void setValidUsernameAndEmptyPass(String name, String pass) {
        if (pass.isEmpty() && !name.isEmpty())
            validation = false;
    }

    public boolean isEditPackageFlag() {
        return editPackageFlag;
    }

    public void iAmNotInSystem(MyAppT obj) {
        obj.isLogged = false;
    }


    private boolean forget = false;

    public void setForget(boolean forget) {
        this.forget = forget;
    }

    public boolean getForget() {
        return forget;
    }

    private String enteredUsername;

    public String getEnteredUsername() {
        return enteredUsername;
    }

    private boolean passwordUpdated = false;

    public boolean getPasswordUpdated() {
        return passwordUpdated;
    }

    private boolean userCreated = false;

    public boolean getUserCreated() {
        return userCreated;
    }

    public void validUserPass(String userName, String pass) {
        setForget(false);
        for (Person u : up) {
            if (userName.equals(u.getUserName()) && pass.equals("Forget")) {
                setForget(true);
                enteredUsername = userName;
                break;

            }
        }
    }

    public void createAcc(String enteredUsernam, String enteredPasswor) {
        for (Person user : up) {
            if (user.getUserName().equals(enteredUsernam) && user.getPass().equals(enteredPasswor)) {
                userCreated = true;
                break;
            }

        }

        for (ServiceProvider user : providerList) {
            if (user.getPerson().getUserName().equals(enteredUsernam) && user.getPerson().getPass().equals(enteredPasswor)) {
                userCreated = true;
                break;
            }
        }
    }

    public void takePass(String newPass) {
        for (Person user : up) {

            if (user.getUserName().equals(enteredUsername)) {
                user.setPass(newPass);
                passwordUpdated = true;
            }
        }
        for (ServiceProvider sp : providerList) {

            if (sp.getPerson().getUserName().equals(enteredUsername)) {
                sp.getPerson().setPass(newPass);
                passwordUpdated = true;
            }

        }



    }
    public void setEnteredUsername(String s){

        enteredUsername=s;
    }

    public void iAmNotINCreationPage(MyAppT obj) {
        isInCreationPage = false;
    }

    public void chooseFromUserPage(Integer int1) {
        switch (int1) {
            case 1:
                isInCreationPage = true;
                break;
            default:
        }

    }

    public boolean checkPastDate(Integer int1, Integer int2, Integer int3) {
        LocalDate d = LocalDate.of(int1, int2, int3);


        LocalDate currentDate = LocalDate.now();
        if (d.isBefore(currentDate))
            return true;
        else
            return false;


    }

    public boolean isInCreationPage() {
        return isInCreationPage;
    }

    public void setInCreationPage(boolean inCreationPage) {
        isInCreationPage = inCreationPage;
    }

    public void iAmInUserPage(MyAppT obj) {
        inUserPage = true;
    }

    public void iAmINCreationPage(MyAppT obj) {
        isInCreationPage = true;
    }

    public void createEventWithBasicInfo(String s, String string, Integer int4, Integer int5, Integer int6, Integer int1, Integer int2, Integer int3, String string2, String string3, Integer int7) {
        Person n = searchInUser(s);
   Date date=new Date(int4,int5,int6);
        Time t = new Time(int1, int2, int3);


int temp=0;


        for (Event e : eventList) {
            if (e.getDate().equals(d) && e.getTime().equals(t) && e.getLocation().equals(string2)) {
                localEventFlag = false;
                temp = 1;

            }

        }
        if (temp == 0) {
            localEvent = new Event(string, date, t, string2, string3, int7);
            localEvent.setUser(n);
            n.getEventList().add(localEvent);
            eventList.add(localEvent);

            localEventFlag = true;

        }


    }

    public boolean isLocalEventFlag() {
        return localEventFlag;
    }

    public void setLocalEventFlag(boolean localEventFlag) {
        this.localEventFlag = localEventFlag;
    }


    public void chooseServiceOrPackageFlag(MyAppT obj) {
        serviceOrPackage = false;
    }

    public void chooseServiceOrPackage(Integer int1) {
        serviceOrPackage = true;
        switch (int1) {
            case 1:
                isServiceFlag = true;
                break;
            case 2:
                isPackageFlag = true;
                break;
            default:
                serviceOrPackage = false;

        }
    }

    public boolean isServiceOrPackage() {
        return serviceOrPackage;
    }

    public void setServiceOrPackage(boolean serviceOrPackage) {
        this.serviceOrPackage = serviceOrPackage;
    }

    public boolean isPackageFlag() {
        return isPackageFlag;
    }

    public void setPackageFlag(boolean packageFlag) {
        isPackageFlag = packageFlag;
    }

    public boolean isServiceFlag() {
        return isServiceFlag;
    }

    public void setServiceFlag(boolean serviceFlag) {
        isServiceFlag = serviceFlag;
    }

    public void chooseService(Integer int1) {
        serviceMenuFlag = true;
        switch (int1) {
            case 1:
                isFoodService = true;
                break;
            case 2:
                isDecorService = true;
                break;
            case 3:
                isPhotoService = true;
                break;
            case 4:
                isEnterService = true;
                break;
            case 5:
                eventList.add(localEvent);
                break;
            default:
                serviceMenuFlag = false;
        }
    }
    public void addLocalEventToEventList() {
        eventList.add(localEvent);
    }

    public void isMenuServiceFlag() {
        serviceMenuFlag = false;
    }

    public boolean isServiceMenuFlag() {
        return serviceMenuFlag;
    }

    public void setServiceMenuFlag(boolean serviceMenuFlag) {
        this.serviceMenuFlag = serviceMenuFlag;
    }

    public boolean isFoodService() {
        return isFoodService;
    }

    public boolean isDecorService() {
        return isDecorService;
    }

    public boolean isPhotoService() {
        return isPhotoService;
    }

    public boolean isEnterService() {
        return isEnterService;
    }

   public int addFoodService(Integer int1, String str) {
        for (ServiceProvider sp : providerList) {
            if (sp.getServiceType().equals(str)) {
                for (Service s : sp.getOfferList()) {
                    if (s.getId() == int1) {
                        handleEventService(s, str);
                        return s.getCost();
                    }
                }
            }
        }
        return 0;
    }

    private void handleEventService(Service service, String serviceType) {
        switch (serviceType) {
            case SERVICE_TYPE_FOOD:
                localEvent.setFoodService(service);
                addLocalEventFoodFlag = true;
                break;
            case SERVICE_TYPE_DECORATION:
                localEvent.setDecorService(service);
                addLocalEventDecorFlag = true;
                break;
            case SERVICE_TYPE:
                localEvent.setEntertainmentService(service);
                addLocalEventEnterFlag = true;
                break;
            case SERVICE_TYPE_PHOTOGRAPHER:
                localEvent.setPhotographerService(service);
                addLocalEventPhotoFlag = true;
                break;
            default:
                break;
        }
        sendBookingNotification(service);
    }

    private void sendBookingNotification(Service service) {
        String email = "";
        if (localEvent.getUser() != null) {
            email = "The user " + localEvent.getUser().getUserName() + ", whose phone number is " +
                    localEvent.getUser().getPhoneNum() + " , has booked a service from you...";
        }
        sendEmailTo(service.getSp().getPerson().getEmail(), email);
    }

    public boolean isAddLocalEventFoodFlag() {
        return addLocalEventFoodFlag;
    }

    public boolean isAddLocalEventDecorFlag() {
        return addLocalEventDecorFlag;
    }

    public boolean isAddLocalEventEnterFlag() {
        return addLocalEventEnterFlag;
    }

    public boolean isAddLocalEventPhotoFlag() {
        return addLocalEventPhotoFlag;
    }

    public boolean addPackageToEvent(Integer int1) {
        for (Package p : packageList) {
            if (p.getNumber() == int1) {
                localEvent.setPack(p);
                addPackageFlag = true;
                return true;
            }
        }
        return false;
    }

    public boolean isAddPackageFlag() {
        return addPackageFlag;
    }

    public void openRoleMenu(Integer int1) {
        switch (int1) {
            case 1:
                isAdminFlag = true;
                break;
            case 2:
                isUserFlag = true;
                break;
            case 3:
                isServiceProviderFlag = true;
                break;

            default:
                serviceMenuFlag = false;
        }
    }

    public boolean isAdminFlag() {
        return isAdminFlag;
    }

    public boolean isUserFlag() {
        return isUserFlag;
    }

    public boolean isServiceProviderFlag() {
        return isServiceProviderFlag;
    }


    public Person searchInUser(String string1) {
        for (Person p : up) {
            if (p.getUserName().equals(string1)) {
                return p;
            }
        }
        return null;
    }


    public String searchInSpAccordingToType(String string) {
        String s="Service providers:\n";
        for (ServiceProvider p : providerList) {
            if (p.getServiceType().equals(string)) {
              s+=p.getPerson().getUserName()+"\t"+p.getPerson().getPhoneNum()+"\n";
            }
        }
        return s;
    }



    public ServiceProvider searchInServiceProvider(String string) {
        for (ServiceProvider p : providerList) {
            if (p.getPerson().getUserName().equals(string)) {
                return p;
            }
        }
        return null;
    }

    public void searchInEventUser(String string) {
        Person pp = searchInUser(string);
        userhasevent = !(pp.getEventList().isEmpty());
    }







    public boolean isUserhasevent() {
        return userhasevent;
    }

    public Event searchInEvent(Integer int1) {
        for (Event e : eventList) {
            if (e.getIndex() == int1) {
                return e;
            }
        }
        return null;
    }

    public Event searchInEventByName(String str) {
        for (Event e : eventList) {
            if (e.getEventName().equals(str)) {
                return e;
            }
        }
        return null;
    }



    public Location searchInLocation(Integer int1) {
        for (Location e : locationList) {
            if (e.getId() == int1) {
                 return e;
            }
        }
        return null;
    }



    public void serchforevent(Integer int1) {

        Event ev = searchInEvent(int1);

        if (ev == null) {
            eventfoundflag = false;
        } else {
            eventfoundflag = true;
        }


    }

    public boolean isEventfoundflag() {
        return eventfoundflag;
    }

    public void selectServiceProviderMenu(Integer int1) {
        serviceproviderMenuFlag = true;
        switch (int1) {
            case 1:
                isAddService = true;
                break;
            case 2:
                isEditService = true;
                break;
            case 3:
                isDeleteService = true;
                break;
            case 4:
                isShoweventsAnduser = true;
                break;
            case 5:
                isShowService = true;

                break;
            default:
                serviceproviderMenuFlag = false;
        }

    }


    public boolean isEditService() {
        return isEditService;
    }

    public boolean isDeleteService() {
        return isDeleteService;
    }

    public boolean isShoweventsAnduser() {
        return isShoweventsAnduser;
    }

    public boolean isShowService() {
        return isShowService;
    }

    public boolean isServiceproviderMenuFlag() {
        return serviceproviderMenuFlag;
    }

    public boolean isAddService() {
        return isAddService;
    }

    public void addServiceToSp(String string, Integer double1, Integer int1, String string1) {

        Service s = new Service(string, int1, double1, searchInServiceProvider(string1));
        searchInServiceProvider(string1).addService(s);
        serviceaddedsucc = true;

        logger.info("Added successfully");

    }

    public boolean isServiceaddedsucc() {
        return serviceaddedsucc;
    }

    public void searchInServicesForSp(String string) {
        ServiceProvider pp = searchInServiceProvider(string);

        providerhasservice = !(pp.getOfferList().isEmpty());
    }

    public void editServiceForSp(String string, Integer double1, Integer int1, String string2) {
        Service s = searchInServiceProvider(string2).searchForServiceId(int1);
        if(s==null){
            logger.info("the service doesn't existing");
        }
        else {
            s.setCost(double1);
            s.setDiscription(string);
        }editServiceForSpFlag = true;




    }




    public boolean isEditServiceForSpFlag() {
        return editServiceForSpFlag;
    }

    public void deleteServiceForSp(Integer int1, String string) {
        ServiceProvider p = searchInServiceProvider(string);
        Service s = p.searchForServiceId(int1);
        p.getOfferList().remove(s);

        deleteServiceForSpFlag = true;
        if(s==null){
            logger.info("The service doesn't exist");
        }
        else{
        logger.info("deleted successfully");}

    }

    public boolean isDeleteServiceForSpFlag() {
        return deleteServiceForSpFlag;
    }

    public String showservicesForSp(String string) {
        ServiceProvider p = searchInServiceProvider(string);
        String headerFormat = "%-10s\t%-50s\t%-10s\n";
        String rowFormat = "%-10s\t%-50s\t%-10.2f\n";

        StringBuilder format = new StringBuilder();
        format.append("\n");
        format.append(String.format(headerFormat, "ID", "Description", "Cost"));

        for (Service s : p.getOfferList()) {
            double cost = s.getCost();
            format.append(String.format(rowFormat,
                    s.getId(),
                    s.getDiscription(),
                    cost));
        }

        showservicesForSpFlag = true;

        return format.toString();
    }


    public String showUsersAndEventsForSp(String string) {

       ServiceProvider p = searchInServiceProvider(string);

       String headerFormat = "%-20s\t%-15s\t%-20s\t%-15s\t%-20s\t%-10s\t%-10s\n";
       String rowFormat = "%-20s\t%-15s\t%-20s\t%-15s\t%-20s\t%-10s\t%-10s\n";

       StringBuilder format = new StringBuilder();
       format.append("\n");

       format.append(String.format(headerFormat, "User Name", PHONE_NUMBER_LABEL, EVENT_NAME_LABEL, THEME_LABEL, LOCATION_LABEL, "Date", "Time"));


       for (Event e : p.getEventList()) {
           String date = e.getDate().getYear() + "\\" + e.getDate().getMonth() + "\\" + e.getDate().getDate();
           format.append(String.format(rowFormat, e.getUser().getUserName(), e.getUser().getPhoneNum(), e.getEventName(), e.getTheme(), e.getLocation(), date, e.getTime()));
       }

       showUsersAndEventsForSpFlag = true;
       return format.toString();
   }

    public boolean isShowservicesForSpFlag() {
        return showservicesForSpFlag;
    }

    public boolean isShowUsersAndEventsForSpFlag() {
        return showUsersAndEventsForSpFlag;
    }

    public void selectFromAdminMenu(Integer int1) {
        adminMenuFlag = true;
        switch (int1) {
            case 1:
                isSeeUserList = true;
                break;
            case 2:

                isSeeSPList = true;
                break;
            case 3:

                isSeeEventList = true;
                break;

            case 4:
                isCreatePackage = true;
                break;
            case 5:
                isDeletePackage = true;
                break;

            default:
                adminMenuFlag = false;
        }
    }

    public String showUserListForAdmin() {
        StringBuilder s = new StringBuilder();

        String headerFormat = "%-20s\t%-15s\t%-10s\n";
        String rowFormat = "%-20s\t%-15s\t%-10s\n";

        s.append("\n");

        s.append(String.format(headerFormat, "UserName", PHONE_NUMBER_LABEL, "Birth Date"));

        for (Person p : up) {

            String birthDate = p.getB();
            s.append(String.format(rowFormat,
                    p.getUserName(),
                    p.getPhoneNum(),
                    birthDate ));
        }

        showUserListForAdminFlag = true;

        return s.toString();
    }


    public String showEventForAdmin() {
        StringBuilder format = new StringBuilder();


        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");


        format.append("\n");
        String headerFormat = "%-20s\t%-15s\t%-20s\t%-12s\t%-10s\n";
        format.append(String.format(headerFormat,EVENT_NAME_LABEL,THEME_LABEL, LOCATION_LABEL, "Date", "Time"));


        for (Event e : eventList) {
            // Format date and time based on the stored date object within the event
            String formattedDate = dateFormatter.format(e.getDate());
            String formattedTime = timeFormatter.format(e.getDate());

            String rowFormat = "%-20s\t%-15s\t%-20s\t%-12s\t%-10s\n";
            format.append(String.format(rowFormat,
                    e.getEventName(),
                    e.getTheme(),
                    e.getLocation(),
                    formattedDate,
                    formattedTime));
        }

        showEventForAdminFlag = true;
        return format.toString();
    }
    public String showSPtForAdmin() {

        StringBuilder formattedOutput = new StringBuilder();

        String headerFormat = "%-20s\t%-15s\t%-12s\t%-15s\n";
        String rowFormat = "%-20s\t%-15s\t%-12s\t%-15s\n";
        formattedOutput.append("\n");

        formattedOutput.append(String.format(headerFormat, "UserName", PHONE_NUMBER_LABEL, "Birth Date", "Service Type"));


        for (ServiceProvider e : providerList) {
            formattedOutput.append(String.format(rowFormat,
                    e.getPerson().getUserName(),
                    e.getPerson().getPhoneNum(),
                    e.getPerson().getB(),
                    e.getServiceType()));
        }
        showSPtForAdminFlag = true;
        return formattedOutput.toString();
    }


    public boolean isAdminMenuFlag() {
        return adminMenuFlag;
    }

    public boolean isShowUserListForAdminFlag() {
        return showUserListForAdminFlag;
    }

    public boolean isShowEventForAdminFlag() {
        return showEventForAdminFlag;
    }

    public boolean isShowSPtForAdminFlag() {
        return showSPtForAdminFlag;
    }

    public void createPackage(String string, Double double1,Integer int1) {
        Package p = new Package(string, double1,int1);
        packageList.add(p);

        createPackageFlag = true;
        logger.info("Package added successfully");


    }

    public boolean isCreatePackageFlag() {
        return createPackageFlag;
    }

    public void deletePackage(Integer int1) {

        for(Package p:packageList)
        {
            if(p.getNumber()==int1) {

                packageList.remove(p);
                deletePackageFlag=true;
                break;



            }

        }
    }

    public boolean isDeletePackageFlag() {
        return deletePackageFlag;
    }

    public boolean checkPackageList() {
     return !(packageList.isEmpty());

    }

    public String showPackageForAdmin() {
        StringBuilder format = new StringBuilder();
        format.append("\n");

        String headerFormat = "%-10s\t%-50s\t%-10s\n";
        String rowFormat = "%-10s\t%-50s\t%-10.2f\n";


        format.append(String.format(headerFormat, "ID", "Description", "Cost"));


        for (Package p : packageList) {
            format.append(String.format(rowFormat,
                    p.getNumber(),
                    p.getDescription(),
                    p.getTotalPrice()
            ));
        }

        showPackageForAdminFlag = true;
        return format.toString();
    }


    public boolean isShowPackageForAdminFlag() {
        return showPackageForAdminFlag;
    }


    public void editEventForUserMenu(Integer int1) {
        adminMenuFlag = true;
        switch (int1) {
            case 1:
                isEventNameEdit = true;
                break;
            case 2:

                isEventLocationEdit = true;
                break;
            case 3:
                isEventDateEdit = true;
                break;

            case 4:
                isEventTimeEdit = true;
                break;
            case 5:
                isEventNumOfPeopleEdit = true;
                break;
            case 6:
                isEventThemeEdit = true;
                break;
            case 7:
                isEventAdditionalServiceEdit = true;
                break;
            case 8:
                isEventRemoveServiceEdit = true;
                break;
            case 9:
                isEventCancelPackageEdit = true;
                break;
            case 10:
                isEventViewEventsEdit = true;
                break;
            case 11:
                isEventDeleteEventEdit = true;
                break;
           
            default:
                adminMenuFlag = false;
        }
    }

    public boolean isEventDeleteEventEdit() {
        return isEventDeleteEventEdit;
    }

    public boolean isEventViewEventsEdit() {
        return isEventViewEventsEdit;
    }

    public boolean isEventCancelPackageEdit() {
        return isEventCancelPackageEdit;
    }

    public boolean isEventRemoveServiceEdit() {
        return isEventRemoveServiceEdit;
    }

    public boolean isEventThemeEdit() {
        return isEventThemeEdit;
    }

    public boolean isEventNumOfPeopleEdit() {
        return isEventNumOfPeopleEdit;
    }

    public boolean isEventTimeEdit() {
        return isEventTimeEdit;
    }

    public boolean isEventDateEdit() {
        return isEventDateEdit;
    }

    public boolean isEventNameEdit() {
        return isEventNameEdit;
    }

    public boolean isEventLocationEdit() {
        return isEventLocationEdit;
    }

    public void editEventNameByUser(String string, String string2, String string3) {
        Person p=searchInUser(string);

       Event e= p.searchInUserEvents(string2);

       if(e==null){

       }
       else{
       e.setEventName(string3);}
        editEventNameByUserFlag=true;

    }

    public boolean isEditEventNameByUserFlag() {
        return editEventNameByUserFlag;
    }

    public void editEventDateByUser(String string, String string2, Integer int1, Integer int2, Integer int3) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        Date d=new Date(int1,int2,int3);
        e.setDate(d);
        editEventDateByUserFlag=true;

    }

    public boolean isEditEventDateByUserFlag() {
        return editEventDateByUserFlag;
    }

    public void editEventTimeByUser(String string, String string2, Integer int1, Integer int2, Integer int3) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        Time d=new Time(int1,int2,int3);
        e.setTime(d);
        editEventTimeByUserFlag=true;
    }

    public boolean isEditLocationFlag() {
        return editLocationFlag;
    }

    public boolean isEditEventTimeByUserFlag() {
        return editEventTimeByUserFlag;
    }

    public void editEventNumOfPeapleByUser(String string, String string2, Integer int1) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        e.setNumGuests(int1);
        editEventNumOfPeapleByUserFlag=true;
    }

    public boolean isEditEventNumOfPeapleByUserFlag() {
        return editEventNumOfPeapleByUserFlag;
    }

    public void editEventThemeByUser(String string, String string2, String string3) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        e.setTheme(string3);
        editEventThemeByUserFlag=true;
    }

    public boolean isEditEventThemeByUserFlag() {
        return editEventThemeByUserFlag;
    }

    public List<String> editToAddAdditionalServiceByUser(String string, String string2) {
        List<String> s;
        s = new ArrayList<>();

        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        if(e.getDecorService()==null){
            s.add(SERVICE_TYPE_DECORATION);
        }
        if(e.getEntertainmentService()==null){
            s.add(SERVICE_TYPE);
        }
        if(e.getFoodService()==null){
            s.add(SERVICE_TYPE_FOOD);
        }
        if(e.getPhotographerService()==null){
            s.add(SERVICE_TYPE_PHOTOGRAPHER);
        }
        editToAddAdditionalServiceByUserFlag=true;
        return s;
    }

    public boolean isEditToAddAdditionalServiceByUserFlag() {
        return editToAddAdditionalServiceByUserFlag;
    }

    public void editDeleteServiceFromEventByUser(String username, String eventName, Integer serviceId) {
         editDeleteServiceFromEventByUserFlag = true;
        Person p = searchInUser(username);
        Event e = p.searchInUserEvents(eventName);

             if (e.getEntertainmentService() != null) {
            if( e.getEntertainmentService().getId()==serviceId){  e.setEntertainmentService(null);}

        }
           else if (e.getDecorService() != null) {
                 if( e.getDecorService().getId()==serviceId)
                 { e.setDecorService(null);}

            }

            else if (e.getFoodService() == null ) {
              if(e.getFoodService().getId()==(serviceId))
              { e.setFoodService(null);}
            }

            else if (e.getPhotographerService() != null ) {
                if(e.getPhotographerService().getId()==(serviceId))
                {  e.setPhotographerService(null);  }
            }
            else {

                editDeleteServiceFromEventByUserFlag = false;
            }

    }


    public boolean isEditDeleteServiceFromEventByUserFlag() {
        return editDeleteServiceFromEventByUserFlag;
    }

    public void editDeletePackageFromEventByUser(String string, String string2) {

        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        e.setPack(null);
        editDeletePackageFromEventByUserFlag=true;
        logger.info("deleted successfully");

    }
    public int getcostlocation(String l){
        for(Location i :locationList){
            if(i.getLocationName().equals(l)){
               return i.getCost();
            }
        }
        return 0;
    }

    public boolean isEditDeletePackageFromEventByUserFlag() {
        return editDeletePackageFromEventByUserFlag;
    }


    public String viewEventsByUser(String string) {
        Person p = searchInUser(string);
        StringBuilder eventsWithPackage = new StringBuilder();
        StringBuilder eventsWithoutPackage = new StringBuilder();
        initializeEventStringBuilders(eventsWithPackage, eventsWithoutPackage);

        String eventWithPackageFormat = "%-20s %-15s %-20s %-12s %-10s %-18s %-10s %-25s %-10s\n";
        String eventWithoutPackageFormat = "%-20s %-15s %-20s %-12s %-10s %-18s %-25s %-25s %-25s %-25s %-10s\n";

        int c = getcostlocation(localEvent.getLocation());
        eventsWithPackage.append(String.format(eventWithPackageFormat, "Event Name", "Theme", "Location", "Date", "Time", "Number of People", "Package ID", "Package Description", "Cost"));
        eventsWithoutPackage.append(String.format(eventWithoutPackageFormat, "Event Name", "Theme", "Location", "Date", "Time", "Number of People", "Decoration Service", "Entertainment Service", "Food Service", "Photographer Service", "Cost"));

        addEventDetailsToBuilders(p.getEventList(), eventsWithPackage, eventsWithoutPackage, eventWithPackageFormat, eventWithoutPackageFormat, c);

        String combined = eventsWithoutPackage.toString() + "\n\n\n\n" + eventsWithPackage.toString();
        viewEventsByUserFlag = true;
        return combined;
    }

    private void initializeEventStringBuilders(StringBuilder eventsWithPackage, StringBuilder eventsWithoutPackage) {
        eventsWithPackage.append("\n");
        eventsWithoutPackage.append("\n");
    }

    private void addEventDetailsToBuilders(List<Event> eventList, StringBuilder eventsWithPackage, StringBuilder eventsWithoutPackage, String eventWithPackageFormat, String eventWithoutPackageFormat, int cost) {
        for (Event e : eventList) {
            String date = formatDate(e.getDate());

            if (e.getPack() == null) {
                addEventWithoutPackageDetails(e, eventsWithoutPackage, eventWithoutPackageFormat, date, cost);
            } else {
                addEventWithPackageDetails(e, eventsWithPackage, eventWithPackageFormat, date, cost);
            }
        }
    }

    private void addEventWithoutPackageDetails(Event event, StringBuilder eventsWithoutPackage, String eventWithoutPackageFormat, String date, int cost) {
        eventsWithoutPackage.append(String.format(eventWithoutPackageFormat,
                event.getEventName(),
                event.getTheme(),
                event.getLocation(),
                date,
                event.getTime(),
                event.getNumGuests(),
                event.getDecorService() != null ? event.getDecorService().getDiscription() : HYPHEN_STRING,
                event.getEntertainmentService() != null ? event.getEntertainmentService().getDiscription() : HYPHEN_STRING,
                event.getFoodService() != null ? event.getFoodService().getDiscription() : HYPHEN_STRING,
                event.getPhotographerService() != null ? event.getPhotographerService().getDiscription() : HYPHEN_STRING,
                event.eventCost(cost)));
    }

    private void addEventWithPackageDetails(Event event, StringBuilder eventsWithPackage, String eventWithPackageFormat, String date, int cost) {
        eventsWithPackage.append(String.format(eventWithPackageFormat,
                event.getEventName(),
                event.getTheme(),
                event.getLocation(),
                date,
                event.getTime(),
                event.getNumGuests(),
                event.getPack().getNumber(),
                event.getPack().getDescription(),
                event.eventCost(cost)));
    }

    private String formatDate(Date date) {
        return date.getYear() + "\\" + date.getMonth() + "\\" + date.getDate();
    }



    public boolean isViewEventsByUserFlag() {
        return viewEventsByUserFlag;
    }

    public void deleteEventByUser(String string, String string2) {
        Person p = searchInUser(string);
        Event e = p.searchInUserEvents(string2);
        p.getEventList().remove(e);
        eventList.remove(e);
        deleteeventbyuserflag = true;
        for (ServiceProvider S : providerList) {
            Iterator<Event> iterator = S.getEventList().iterator(); // Use an iterator
            while (iterator.hasNext()) { // Iterate over the list
                Event yy = iterator.next(); // Get the next event
                if (yy.getEventName().equals(string2)) {
                    iterator.remove(); // Remove the current event using the iterator
                }
            }
        }
    }

    public boolean isDeleteEventByUserFlag() {
        return deleteeventbyuserflag;
    }


    public void editLocation(String string, String string2, Integer int1) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        for(Location l:locationList)
        {
            if (l.getId()==int1) {
                e.setLocation(l.getLocationName());
                editLocationFlag=true;
            }
        }


    }

    public void editPackage(String string, String string2, Integer int1) {
        Person p=searchInUser(string);
        Event e= p.searchInUserEvents(string2);
        for(Package j :packageList)
        {
            if (j.getNumber()==int1) {
                e.setPack(j);

                editPackageFlag=true;            }

        }

    }
    public void sendEmailTo(String recipient,String s) {

        String ss=s;
        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("eventplannerapp1@gmail.com\n", "nmyv urhn rsxv zooj");
                }
            });
            //session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("eventplannerapp1@gmail.com\n"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient, false));

                message.setSubject("event planner project");
                message.setText(s);
            Transport.send(message);
        } catch (MessagingException m) {
           // m.printStackTrace();
        }
    }

    public void createAccountForSp(String string, String string2, String string3, String string5, String string4, String string6) {
       int temp=0;
        for (ServiceProvider user : providerList) {
            if (user.getPerson().getUserName().equals(string) && user.getPerson().getPass().equals(string2)) {
                temp=1;
                userCreated = true;
                break;
            }
        }
        if(temp==0){
            addServiceProvider(new ServiceProvider(string, string2,string3,string5,string4,string6));
        }
    }
    public void createAccountForUser(String string, String string2, String string3, String string5, String string4) {
    int temp=0;
        for (Person user : up) {
            if (user.getUserName().equals(string) && user.getPass().equals(string2)) {
                temp=1;
                userCreated = true;
                break;
            }


        }
        if(temp==0)

        {
            addUser(new Person(string, string2,string3,string4,string5));

        }
    }

    public Package searchInPackage(int packId) {
        for(Package j :packageList)
        {
            if (j.getNumber()==packId) {
              return j;
                       }

        }
        return null;
    }
}


