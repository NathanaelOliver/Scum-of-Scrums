package test;

import src.Database;
import src.Listing;
import src.DataLoader;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListingTest {
	private Listing listing1;
	
	@BeforeClass
	public static void oneTimeSetup() {
        
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
        Database.fromJSON(DataLoader.getJSON("data/Users.json"));
        this.listing1 = new Listing(Database.getListingByID(UUID.fromString("f2c88aaa-dd37-46e4-abaf-919856ab5c4c")));
    }
	
	@AfterEach
	public void tearDown() {

	}

    @Test
    public void testToString() {
        assertNotNull(listing1.toString());
    }

    @Test
    public void testToJSON() {   
        assertEquals("{\"id\":\"f2c88aaa-dd37-46e4-abaf-919856ab5c4c\",\"employerId\":\"01f78a8e-21a0-40cc-8b03-6155cb92986f\",\"payRate\":18.75,\"location\":\"Greenville, South Carolina\",\"title\":\"Software Engineering Intern\",\"description\":[],\"startDate\":\"05/01/20\",\"endDate\":\"08/20/20\",\"siteLink\":\"https: //www.publix.com/\",\"skills\":[\"Java\",\"Linux\",\"CSS\"],\"applicants\":[\"aae52f6d-08a1-4775-a2ac-ff7f631cd686\",\"6ab93632-f1c8-441f-bf57-e63384ae3c58\"]}", listing1.toJSON());
    }
    
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
}