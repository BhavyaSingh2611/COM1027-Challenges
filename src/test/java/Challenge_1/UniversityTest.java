package Challenge_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Stella Kazamia
 */
public class UniversityTest {

	@Test
	public void testConstruction() {
		University surrey = new University("UNIVERSITY OF SURREY", 74.7, "www.surrey.ac.uk");

		assertEquals("UNIVERSITY OF SURREY", surrey.getName());
		assertEquals(74.7, surrey.getScore(), 0);
		assertEquals("www.surrey.ac.uk", surrey.getUrl());

		assertEquals("UNIVERSITY OF SURREY (www.surrey.ac.uk) - 74.7%", surrey.toString());
	}

	@Test
	public void testConstructionChange() {
		University port = new University("Portsmouth UNIVERSITY", 72.0, "port.ac.uk");

		assertEquals("PORTSMOUTH UNIVERSITY", port.getName());
		assertEquals(72.0, port.getScore(), 0);
		assertEquals("port.ac.uk", port.getUrl());

		assertEquals("PORTSMOUTH UNIVERSITY (port.ac.uk) - 72.0%", port.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructionInvalid() {
		University surrey = new University("UNIVERSITY OF SURREY", 74.7, "www.surrey.org.ac.uk");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructionInvalidScore() {
		University surrey = new University("UNIVERSITY OF SURREY", -74.7, "www.surrey.ac.uk");
	}
}
