package ttoday.edu;


public class Location {
    private int cost;
     private int id;
    private String locationName;
    private String description;

    public String getDescription() {
        return description;
    }

    public Location(int id, int cost, String locationName, String description) {
        this.id=id;
        this.cost = cost;
        this.locationName = locationName;
        this.description=description;
    }

    public int getCost() {
        return cost;
    }



    public String getLocationName() {
        return locationName;
    }



    public int getId() {
        return id;
    }
}
