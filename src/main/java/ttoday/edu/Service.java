package ttoday.edu;

public class Service {
    private ServiceProvider sp;
    private int id;

    public ServiceProvider getSp() {
        return sp;
    }

    public void setSp(ServiceProvider sp) {
        this.sp = sp;
    }

    private String discription;
    private int cost;

    public Service(String d,int id,int cost,ServiceProvider s) {
        this.discription = d;
        this.cost=cost;
        this.id=id;
        sp=s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
