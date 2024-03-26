package ttoday.edu;

import java.util.ArrayList;
import java.util.List;

public class ServiceProvider {

private Person person;
    private String serviceType;

    private ArrayList<Event> eventList =new ArrayList<>();
    private ArrayList<Service> serviceList=new ArrayList<>();

    public ServiceProvider(Person p, String stype) {
        this.person = p;
        this.serviceType = stype;
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


    public String getServiceType() {
        return serviceType;
    }





    public void addEvent (Event e)
    {
        eventList.add(e);
    }
    public void addService (Service e)
    {
        serviceList.add(e);
    }

    public List<Event>getEventList() {
        return eventList;
    }
    public List<Service> getOfferList() {
        return serviceList;
    }





    public Service searchForServiceId(Integer int1){
        for(Service s : serviceList){
            if(s.getId()==int1){
                return s;
            }
        }
        return null;
    }





}
