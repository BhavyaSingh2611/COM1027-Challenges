/**
 * ShoppingSolutionTest.java
 */
package Challenge_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.List;

public class ShoppingSolutionTest {
    /**
     * Creating a Shopping object with a valid CustomerProfile. Testing that the
     * shopping list adds all items and discount is calculated on favourite items
     * and print the all the items at the end.
     */
    @Test
    public void testAdd() {
        Food food = new Food("Tortellini",3.50, FoodType.PASTA);
        Food food2 = new Food("Ravioli",2.60, FoodType.PASTA);
        Food food3 = new Food("Penne",2.40, FoodType.PASTA);
        Food food4 = new Food("Greek Yoghurt", 1.50, FoodType.DAIRY);
        Food food5 = new Food("Tuna",3.50, FoodType.FISH);
        Food food6 = new Food("Mac and Cheese",2.60, FoodType.PASTA);

        CustomerProfile customer = new CustomerProfile("123456", "John Doe", List.of(new Food[]{food, food2, food3, food4}));

        Shopping shopping = new Shopping(customer);

        shopping.addItem(food2);
        shopping.addItem(food4);
        shopping.addItem(food5);
        shopping.addItem(food6);


        assertEquals(10.2, shopping.calculateTotalCost(), 0);
        assertEquals(9.38, shopping.calculateTotalCostWithDiscount(), 0);
        assertEquals(4, shopping.howManyItems(),0);
        shopping.printShoppingWithFavouritesInformation();
    }

    /**
     * Creating a Shopping object with a valid CustomerProfile. Testing that the
     * shopping list functions as expected without any items added.
     */
    @Test
    public void testAddNone() {
        Food food = new Food("Tortellini",3.50, FoodType.PASTA);
        Food food2 = new Food("Ravioli",2.60, FoodType.PASTA);
        Food food3 = new Food("Penne",2.40, FoodType.PASTA);
        Food food4 = new Food("Greek Yoghurt", 1.50, FoodType.DAIRY);

        CustomerProfile customer = new CustomerProfile("123456", "John Doe", List.of(new Food[]{food, food2, food3, food4}));

        Shopping shopping = new Shopping(customer);


        assertEquals(0, shopping.calculateTotalCost(), 0);
        assertEquals(0, shopping.calculateTotalCostWithDiscount(), 0);
        assertEquals(0, shopping.howManyItems(),0);
        shopping.printShoppingWithFavouritesInformation();
    }

    /**
     * Creating a Shopping object with a valid CustomerProfile. Testing that the
     * addItem function rejects and null values passed to add to the shopping list.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddArgument() {
        CustomerProfile customer = new CustomerProfile("123456", "John Doe", List.of(new Food[]{}));
        Shopping shopping = new Shopping(customer);
        shopping.addItem(null);
    }
}
