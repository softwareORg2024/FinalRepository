package ttoday.edu;


public class Package {
    private String description;
    private double totalPrice;
    private int number;

    // Constructor
    public Package(String d, double c, int num) {
        description = d;
        totalPrice = c;
        number = num;


    }

    // Getters and Setters


    public String getDescription() {
        return description;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public int getNumber() {
        return number;
    }

}



