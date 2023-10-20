package Challenge_3;

/**
 * @author Bhavya Singh
 * */
public class Food {
    private String name;
    private double price;
    private FoodType type;

    public Food(String name, double price, FoodType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public FoodType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): £%.2f", this.name, this.type, this.price);
    }
}
