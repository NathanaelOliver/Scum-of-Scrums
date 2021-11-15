package test;

import src.Employer;
import src.Listing;
import src.Database;
import src.DataLoader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployerTest {
	private Employer employer1;
	
	@BeforeClass
	public static void oneTimeSetup() {
		
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		employer1 = Database.getEmployerByID(UUID.fromString("01f78a8e-21a0-40cc-8b03-6155cb92986f"));
	}
	
	@AfterEach
	public void tearDown() {

	}

    @Test
    public void testFromJSON() {
		
	}

	@Test
	public void testToJSON() {
		assertEquals(employer1.toJSON(), "");
	}

	@Test
	public void testToString() {
		String var = "";
		assertEquals(var, employer1.toString());
	}

	@Test
	public void testGetListingByID() {
		assertNotNull(new Listing(employer1.getListingById(UUID.fromString("f2c88aaa-dd37-46e4-abaf-919856ab5c4c"))));
	}

	@Test
	public void testDeleteListing() {
		employer1.deleteListing(employer1.getListingById(UUID.fromString("f2c88aaa-dd37-46e4-abaf-919856ab5c4c")));
		assertNull(employer1.getListingById(UUID.fromString("f2c88aaa-dd37-46e4-abaf-919856ab5c4c")));
	}
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
}