/**
 * OrderSolutionTest.java
 */

package Challenge_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for the Order class.
 * 
 * @author Stella Kazamia
 */
public class OrderSolutionTest {

    /**
     * Creating a Order object with a valid order number of a mixed type. Add three
     * wines of different type to the same order. Test that the wines have been
     * added to the list, test that the total cost is �38.97 and test that the order
     * is for is a mixed order. Also print out the details of the order.
     */
    @Test
    public void testAddMixed() {
		Order order = new Order(789, OrderType.MIXED);
		Wine wine1 = new Wine("Beajoulais", WineType.RED, 12.99);
		Wine wine2 = new Wine("Chablis", WineType.WHITE, 14.99);
		Wine wine3 = new Wine("Cotes de Provence", WineType.ROSE, 10.99);

		order.addWine(wine1);
		order.addWine(wine2);
		order.addWine(wine3);
		assertEquals(3, order.howManyWinesInOrder());
		assertEquals(38.97, order.calculateTotalCostOfOrder(), 0);
		order.printOrder();
    }

    /**
     * Creating a Order object with a valid order number of a single type. Add three
     * red wines to the same order. Test that the wines have been added to the list,
     * test that the total cost is �51.48. Also print out the details of the order.
     */
    @Test
    public void testAddSingle() {
		Order order = new Order(456, OrderType.SINGLE);
		Wine wine1 = new Wine("Beajoulais", WineType.RED, 12.99);
		Wine wine2 = new Wine("Chianti", WineType.RED, 17.99);
		Wine wine3 = new Wine("Rioja", WineType.RED, 20.50);

		order.addWine(wine1);
		order.addWine(wine2);
		order.addWine(wine3);
		assertEquals(3, order.howManyWinesInOrder());
		assertEquals(51.48, order.calculateTotalCostOfOrder(), 0);
		order.printOrder();
    }

    /**
     * Creating a Order object with a valid order number of a single type. Test that
     * an invalid wine is detected as an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddArgument() {
		Order order = new Order(456, OrderType.SINGLE);
		order.addWine(null);
    }

    /**
     * Creating a Order object with a valid order number of a mixed type. Add two
     * wines of the SAME type to the same order. Test that the wines have been added
     * to the list and test that the order is for is a mixed order.
     */
    @Test
    public void testInvalidAddMixed() {
		Order order = new Order(789, OrderType.MIXED);
		Wine wine1 = new Wine("Beajoulais", WineType.RED, 12.99);
		Wine wine2 = new Wine("Chianti", WineType.RED, 17.99);

		order.addWine(wine1);
		assertEquals(1, order.howManyWinesInOrder());
		order.addWine(wine2);
		assertEquals(false, order.isMixedOrder());

    }

    /**
     * Creating a Order object with a valid order number of a single type. Create
     * two wines of a different type. Test that the first wine is added correctly to
     * the list. Test that when the second wine is detected an exception is
     * expected.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddSingle() {
		Order order = new Order(456, OrderType.SINGLE);
		Wine wine1 = new Wine("Beajoulais", WineType.RED, 12.99);
		Wine wine2 = new Wine("Sancerre", WineType.WHITE, 18.99);
		order.addWine(wine1);
		assertEquals(1, order.howManyWinesInOrder());
		order.addWine(wine2);
    }

    /**
     * Creating an Order object with valid order number and of mixed type. Testing
     * that the order number can be retrieved Test that the list has been created
     * successfully.
     */
    @Test
    public void testMixedConstruction() {
		Order order = new Order(123, OrderType.MIXED);
		assertEquals(123, order.getOrderNumber());
		assertEquals(0, order.howManyWinesInOrder());
    }

    /**
     * Creating an Order object with valid order number and of single type. Testing
     * that the order number can be retrieved. Test that the list has been created
     * successfully.
     */
    @Test
    public void testSingleConstruction() {
		Order order = new Order(123, OrderType.SINGLE);
		assertEquals(123, order.getOrderNumber());
		assertEquals(0, order.howManyWinesInOrder());
    }
}