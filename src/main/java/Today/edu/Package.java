package Today.edu;

public class Package {
    private String description;
    private double totalPrice;
    private  int number;
    // Constructor
    public Package(String d,double c,int num) {
      description=d;
      totalPrice=c;
      number=num;


    }

    // Getters and Setters

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}



