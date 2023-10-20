package Challenge_2;

import java.util.ArrayList;

/**
 * NOTE: Order makes the assumption that atleast one wine would be present
 * in the object state.
 *
 * @author Bhavya Singh
 */
public class Order {

    private OrderType orderType;
    private int orderNumber;
    private ArrayList<Wine> wines = new ArrayList<>();
    public Order(int orderNumber, OrderType orderType) {
        this.orderNumber = orderNumber;
        this.orderType = orderType;
    }
    /**
     * Adds wine to the order list, performs a null check on the argument passed
     * and is all the wines single type or mixed based on order
     * @param wine
     * */
    public void addWine(Wine wine) throws IllegalArgumentException {
        if (wine == null) {
            throw new IllegalArgumentException();
        }
        if (this.orderType == OrderType.SINGLE) {
            if (wines.isEmpty()) {
                wines.add(wine);
            } else {
                if (wines.get(0).getType() == wine.getType()) {
                    wines.add(wine);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            wines.add(wine);
        }
    }


    public int howManyWinesInOrder() {
        return wines.size();
    }

    public double calculateTotalCostOfOrder() {
        double cost = 0;
        for (Wine wine : wines) {
            cost += wine.getPrice();
        }
        return cost;
    }
    /**
     * Print info for all the wines present in the order.
     * */
    public void printOrder() {
        for (Wine wine : wines) {
            System.out.println(wine);
        }
    }

    public boolean isMixedOrder() {
        boolean isMixed = false;
        WineType defaultType = wines.get(0).getType();
        for (Wine wine : wines) {
            if (wine.getType() != defaultType) {
                isMixed = true;
                break;
            }
        }
        return isMixed;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }
}
