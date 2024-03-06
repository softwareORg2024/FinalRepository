package Today.edu;

public class Location {
    private int cost,id;
    private String locationName;
    private String description;

    public Location(int id,int cost, String locationName,String description) {
        this.id=id;
        this.cost = cost;
        this.locationName = locationName;
        this.description=description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }
}
