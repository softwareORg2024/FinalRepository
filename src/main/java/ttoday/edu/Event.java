package ttoday.edu;

import java.sql.Time;
import java.util.Date;

public class Event {
    private String eventName;
    private Date date;



    private Time time;

    private String theme;
    private Person user;
    private int numGuests;
    private int index=0;



    private Service foodService ;
    private String location ;

    private Service decorService;
    private Service photographerService;
    private Service entertainmentService;
    private Package pack;
    private int overallCost=0;
    private int eventLocationCost=0;

    public int getOverallCost() {
        return overallCost;
    }

    public void setOverallCost(int overallCost) {
        this.overallCost = overallCost;
    }

    public Event(String eventName, Date date, Time time, String location, String theme, int numGuests) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.theme = theme;
        this.numGuests = numGuests;
        index++;

    }



    public String getEventName() {
        return eventName;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getTheme() {
        return theme;
    }


    public int getNumGuests() {
        return numGuests;
    }


    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public Service getFoodService() {
        return foodService;
    }

    public void setFoodService(Service foodService) {
        this.foodService = foodService;
    }

    public Service getDecorService() {
        return decorService;
    }

    public void setDecorService(Service decorService) {
        this.decorService = decorService;
    }

    public Service getPhotographerService() {
        return photographerService;
    }

    public void setPhotographerService(Service photographerService) {
        this.photographerService = photographerService;
    }

    public Service getEntertainmentService() {
        return entertainmentService;
    }

    public void setEntertainmentService(Service entertainmentService) {
        this.entertainmentService = entertainmentService;
    }



    public void setEventLocationCost(int eventLocationCost) {
        this.eventLocationCost = eventLocationCost;
    }

    public int eventCost(int locationCost) {

        int cost;
        if(location.equals("home")){
            eventLocationCost=0;
            cost=eventLocationCost;

        }
        else if(eventLocationCost==0 ){

            eventLocationCost=locationCost;
            cost=locationCost;
        }
        else {
            cost=eventLocationCost;
        }

        if(getFoodService() != null) {
            cost += getFoodService().getCost();
        }
        if(getPhotographerService() != null) {
            cost += getPhotographerService().getCost();
        }
        if(getEntertainmentService() != null) {
            cost += getEntertainmentService().getCost();
        }
        if(getDecorService() != null) {
            cost += getDecorService().getCost();
        }
        if(getPack() != null) {
            cost=eventLocationCost;
            cost += (int) getPack().getTotalPrice();
        }

        this.overallCost = cost;
        return overallCost;
    }

    public int getIndex() {
        return index;
    }


    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }
}