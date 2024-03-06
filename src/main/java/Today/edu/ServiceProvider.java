package Today.edu;

import java.util.ArrayList;

public class ServiceProvider {

private Person person;
    private String serviceType;

    private ArrayList<Event> eventList =new ArrayList<>();
    private ArrayList<Service> serviceList=new ArrayList<>();

    public ServiceProvider(Person P, String stype) {
        this.person = P;
        this.serviceType = stype;
    }
    public ServiceProvider(String un, String pa, String bd ,String pn, String stype) {
        person=new Person(un,pa,bd,pn);
        serviceType=stype;
    }
    public ServiceProvider(String un, String pa, String bd ,String pn, String stype,String em) {
        person=new Person(un,pa,bd,pn,em);
        serviceType=stype;
    }
    public ServiceProvider() {

    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getServiceType() {
        return serviceType;
    }


    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public ArrayList<Service> getOfferList() {
        return serviceList;
    }

    public void setOfferList(ArrayList<Service> offerList) {
        this.serviceList = offerList;
    }

    public void addEvent (Event e)
    {
        eventList.add(e);
    }
    public void addService (Service e)
    {
        serviceList.add(e);
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }


    public void editService(String string, Integer double1, Integer int1) {

    }

    public Service searchForServiceId(Integer int1){
        for(Service s : serviceList){
            if(s.getId()==int1){
                return s;
            }
        }
        return null;
    }
    public Event searchForEventName(String string){
        for(Event e : eventList){
            if(e.getEventName().equals(string)){
                return e;
            }
        }
        return null;
    }




}
