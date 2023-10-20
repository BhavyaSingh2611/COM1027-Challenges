package Challenge_2;

/**
 * @author Bhavya Singh
 * */
public class Wine {
    private String name;
    private double price;
    private WineType wineType;


    public Wine(String name, WineType wineType, double price) {
        this.name = name;
        this.wineType = wineType;
        this.price = price;

    }

    public String getName() {
        return this.name;
    }

    public WineType getType() {
        return this.wineType;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return this.name + ", " + this.wineType + ", £" + String.format("%.2f", this.price);
    }

}
