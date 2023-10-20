/**
 * CustomerProfileSolutionTest.java
 */
package Challenge_3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class CustomerProfileSolutionTest {

    /**
     * Creating a CustomerProfile object with a valid ID. Add four
     * favourite food class instances to the CustomerProfile class. Test that the class
     * is initialised correctly and all favourites are added correctly.
     * Also print out the details of the customer.
     */
    @Test
    public void testConstruction() {
        Food food = new Food("Tortellini",3.50, FoodType.PASTA);
        Food food2 = new Food("Ravioli",2.60, FoodType.PASTA);
        Food food3 = new Food("Penne",2.40, FoodType.PASTA);
        Food food4 = new Food("Greek Yoghurt", 1.50, FoodType.DAIRY);

        CustomerProfile customer = new CustomerProfile("123456", "John Doe", List.of(new Food[]{food, food2, food3, food4}));

        assertEquals("123456", customer.getId());
        assertEquals("John Doe", customer.getName());
        assertTrue(customer.isIn(food3));
        assertTrue(customer.isIn(food));

        assertEquals("CustomerProfile [name = John Doe, id = 123456]", customer.toString());
    }

    /**
     * Creating a CustomerProfile object with a valid ID. Add two
     * favourite food class instances to the CustomerProfile class. Test that the class
     * is initialised correctly and all favourites are added correctly.
     * Also print out the details of the customer.
     */
    @Test
    public void testConstructionChange() {
        Food food = new Food("Tuna",3.50, FoodType.FISH);
        Food food2 = new Food("Mac and Cheese",2.60, FoodType.PASTA);

        CustomerProfile customer = new CustomerProfile("654321", "Joe Bloggs", List.of(new Food[]{food, food2}));

        assertEquals("654321", customer.getId());
        assertEquals("Joe Bloggs", customer.getName());
        assertTrue(customer.isIn(food2));
        assertTrue(customer.isIn(food));

        assertEquals("CustomerProfile [name = Joe Bloggs, id = 654321]", customer.toString());
    }

    /**
     * Creating a CustomerProfile object with an invalid id format. Test that
     * an invalid id is detected as an exception.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testConstructionInvalidId() {
        CustomerProfile customer = new CustomerProfile("1234567", "Joe Bloggs", List.of(new Food[]{}));
    }

    /**
     * Creating a CustomerProfile object with too many favourites. Test that
     * too many favourites is detected as an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructionTooManyFavourites() {
        Food food = new Food("Tortellini",3.50, FoodType.PASTA);
        Food food2 = new Food("Ravioli",2.60, FoodType.PASTA);
        Food food3 = new Food("Penne",2.40, FoodType.PASTA);
        Food food4 = new Food("Greek Yoghurt", 1.50, FoodType.DAIRY);
        Food food5 = new Food("Tuna",3.50, FoodType.FISH);
        Food food6 = new Food("Mac and Cheese",2.60, FoodType.PASTA);

        CustomerProfile customer = new CustomerProfile("1234567", "Joe Bloggs", List.of(new Food[]{food, food2, food3, food4, food5, food6}));
    }

    /**
     * Creating a CustomerProfile object with three favourites. And later
     * add three more favourites to have too many favourites. Test that
     * too many favourites is detected as an exception while calling setFavourites.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructionAddTooManyFavourites() {
        Food food = new Food("Tortellini",3.50, FoodType.PASTA);
        Food food2 = new Food("Ravioli",2.60, FoodType.PASTA);
        Food food3 = new Food("Penne",2.40, FoodType.PASTA);
        Food food4 = new Food("Greek Yoghurt", 1.50, FoodType.DAIRY);
        Food food5 = new Food("Tuna",3.50, FoodType.FISH);
        Food food6 = new Food("Mac and Cheese",2.60, FoodType.PASTA);

        CustomerProfile customer = new CustomerProfile("1234567", "Joe Bloggs", List.of(new Food[]{food, food2, food3}));

        customer.setFavourites(List.of(new Food[]{food4, food5, food6}));
    }
}
