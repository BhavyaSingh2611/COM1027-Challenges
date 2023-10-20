/**
 * WineSolutionTest.java
 */

package Challenge_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Stella Kazamia
 */
public class WineSolutionTest {

    /**
     * Creating a Wine object with a valid name, type and price. Testing that the
     * name, type and price can be retrieved correctly and that the toString method
     * returns the correct string representation of the Wine.
     */
    @Test
    public void testConstruction() {
		Wine wine = new Wine("Rioja", WineType.RED, 10.50);

		assertEquals("Rioja", wine.getName());
		assertEquals(WineType.RED, wine.getType());
		assertEquals(10.50, wine.getPrice(), 0);

		assertEquals("Rioja, RED, £10.50", wine.toString());
    }

}
