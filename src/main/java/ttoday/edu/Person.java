package ttoday.edu;

import java.util.ArrayList;
import java.util.List;


public class Person
{
    private  String userName;
    private  String pass;
    private  String birthDate;
    private String phoneNum;

    private ArrayList<Event> eventList =new ArrayList<>();
     private String email;

    public Person(String un, String pa, String bd, String pn,String em) {
        userName =un;
        pass=pa;
        birthDate =bd;
        phoneNum=pn;
        email=em;
    }

    public Person(String un, String pa, String bd, String pn) {
        userName =un;
        pass=pa;
        birthDate =bd;
        phoneNum=pn;
    }
    public String getUserName() {
        return userName;
    }
    public String getPass() {
        return pass;
    }
    public String getB(){return birthDate;}
    public String getPhoneNum(){return phoneNum;}


    public String getEmail() {
        return email;
    }

    public Person() {

    }



    public void setPass(String pass) {
        this.pass = pass;
    }


    public List<Event> getEventList() {
        return eventList;
    }


    public void addUserEvent(Event e){
        eventList.add(e);
    }
    public Event searchInUserEvents(String e1){
        for (Event e:eventList){
            if(e.getEventName().equals(e1)){

                return e;
            }
        }
        return null;
    }
}
