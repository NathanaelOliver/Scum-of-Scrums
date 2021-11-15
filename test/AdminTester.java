package test;
import src.Admin;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminTester {
	
	@BeforeClass
	public static void oneTimeSetup() {
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
	}
	
	@AfterEach
	public void tearDown() {
		//runs after each test
	}
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
	
	@Test
	public void testAdminConstructor() {
        Admin admin = new Admin("username", "password", "firstName", "lastName");
        assertNotNull(admin.ID);
        assertTrue(admin.getUsername().equals("username"));
        assertTrue(admin.checkPassword("password"));
        assertTrue(admin.getFirstName().equals("firstName"));
        assertTrue(admin.getLastName().equals("lastName"));
        assertFalse(admin.isVerified);
	}

    @Test
    public void testAdminLongConstructorAndToString() {
        Admin admin = new Admin(UUID.randomUUID(), true, "username", "password", "firstname", "lastName");
        assertTrue(admin.isVerified);
        String str = "First Name: firstname" +
        "\nLast Name: lastName" +
        "\nUsername: username";
        assertEquals(admin.toString(),str);
    }
}