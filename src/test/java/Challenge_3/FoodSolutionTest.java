/**
 * FoodSolutionTest.java
 */
package Challenge_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodSolutionTest {

    /**
     * Creating a Food object with a valid name, type and price. Testing that the
     * name, type and price can be retrieved correctly and that the toString method
     * returns the correct string representation of the Wine.
     */
    @Test
    public void testConstruction() {
        Food food = new Food("Tortellini",3.50, FoodType.PASTA);

        assertEquals("Tortellini", food.getName());
        assertEquals(FoodType.PASTA, food.getType());
        assertEquals(3.50, food.getPrice(), 0);

        assertEquals("Tortellini (PASTA): £3.50", food.toString());
    }
}
