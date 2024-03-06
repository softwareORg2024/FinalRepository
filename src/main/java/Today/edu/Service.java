package Today.edu;

public class Service {
    private ServiceProvider sp;
    private int id;

    public ServiceProvider getSp() {
        return sp;
    }

    public void setSp(ServiceProvider sp) {
        this.sp = sp;
    }

    private String Discription;
    private int cost;

    public Service(String discription,int id,int cost,ServiceProvider s) {
        Discription = discription;
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
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
