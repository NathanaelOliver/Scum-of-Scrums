package test;

import src.Employer;
import src.Listing;

import static org.junit.jupiter.api.Assertions.*;

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
		this.employer1 = new Employer("berkeleylab", "12345678", 
			"Lawrence Berkeley National Laboratory");
		this.employer1.addListing(new Listing("BLUR Intern", this.employer1.ID));
	}
	
	@AfterEach
	public void tearDown() {

	}

    @Test
    public void testFromJSON() {

	}

	@Test
	public void testToJSON() {

	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testGetListingByID() {
		assertNotNull(employer1.getListings().get(0).ID);
	}

	@Test
	public void testDeleteListing() {
		assertNull(employer1.getListings());
	}
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
}