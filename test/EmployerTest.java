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
		this.employer1 = Database.getEmployerByID(UUID.fromString("01f78a8e-21a0-40cc-8b03-6155cb92986f"));
	}
	
	@AfterEach
	public void tearDown() {

	}

    @Test
    public void testFromJSON() {
		
	}

	@Test
	public void testToJSON() {
		assertEquals(employer1.toJSON(), "{\"id\":\"01f78a8e-21a0-40cc-8b03-6155cb92986f\",\"username\":\"publix\",\"password\":\"p9o08h80n\",\"userType\":\"employer\",\"isVerified\":true,\"title\":\"Publix Supermarkets Inc\",\"description\":[],\"listings\":[ {\"id\":\"f2c88aaa-dd37-46e4-abaf-919856ab5c4c\",\"employerId\":\"01f78a8e-21a0-40cc-8b03-6155cb92986f\",\"payRate\":18.75,\"location\":\"Greenville, South Carolina\",\"title\":\"Software Engineering Intern\",\"description\":[],\"startDate\":\"05/01/20\",\"endDate\":\"08/20/20\",\"siteLink\":\"https: //www.publix.com/\",\"skills\":[ \"Java\",\"Linux\",\"CSS\"],\"applicants\":[\"aae52f6d-08a1-4775-a2ac-ff7f631cd686\",\"6ab93632-f1c8-441f-bf57-e63384ae3c58\"]}]}");
	}

	@Test
	public void testToString() {
		String var = "Title: Publix Supermarkets Inc";
		assertEquals(var, employer1.toString());
	}

	@Test
	public void testGetListingByID() {
		assertNotNull(employer1.getListingById(UUID.fromString("f2c88aaa-dd37-46e4-abaf-919856ab5c4c")));
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