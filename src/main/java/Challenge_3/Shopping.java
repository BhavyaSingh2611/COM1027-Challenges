package Challenge_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bhavya Singh
 * */
public class Shopping {
    private CustomerProfile customer;
    private List<Food> shopping = new ArrayList<Food>();

    public Shopping(CustomerProfile customer) {
        this.customer = customer;
    }

    public void addItem(Food food) throws IllegalArgumentException {
        if (food == null) {
            throw new IllegalArgumentException("Null object passed");
        }
        this.shopping.add(food);
    }

    public double calculateTotalCost() {
        double cost = 0;
        for (Food food: this.shopping) {
            cost += food.getPrice();
        }
        return cost;
    }

    /**
     * Prints the entire shopping list with mentioning the favourite items in the list
     * */
    public void printShoppingWithFavouritesInformation() {
        int fav = 0;
        System.out.println(this.customer.toString());
        for (Food item: this.shopping) {
            if (this.customer.isIn(item)) {
                fav++;
                System.out.println(item.toString() + " in favourites");
            }
            System.out.println(item.toString());
        }
        System.out.printf("%d items and %d favourite(s)%n", this.shopping.size(), fav);
    }

    /**
     * Calculates the cost for the shopping list with 20% discount applied on favourite items
     * */
    public double calculateTotalCostWithDiscount() {
        double cost = 0;
        for (Food item: this.shopping) {
            if (this.customer.isIn(item)) {
                cost += item.getPrice() * 0.8;
            } else {
                cost += item.getPrice();
            }
        }
        return cost;
    }
    public int howManyItems() {
        return this.shopping.size();
    }
}
