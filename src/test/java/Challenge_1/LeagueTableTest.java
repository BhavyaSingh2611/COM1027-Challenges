
package Challenge_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for the LeagueTable class.
 * 
 * @author Stella Kazamia
 */
public class LeagueTableTest {

	@Test
	public void testAddUniversity() {
		LeagueTable LeagueTable = new LeagueTable();
		University surrey = new University("UNIVERSITY OF SURREY", 74.7, "www.surrey.ac.uk");
		University port = new University("Portsmouth UNIVERSITY", 72.0, "port.ac.uk");

		LeagueTable.addUniversity(surrey);
		LeagueTable.addUniversity(port);
		LeagueTable.printUniversityList();
	}

	@Test(expected = NullPointerException.class)
	public void testAddInvalid() {
		LeagueTable LeagueTable = new LeagueTable();
		University surrey = null;
		LeagueTable.addUniversity(surrey);

	}

}