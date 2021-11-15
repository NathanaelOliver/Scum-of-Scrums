package test;

import src.ClubExperience;
import src.Date;

import java.util.UUID;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClubExperienceTest {
	private ClubExperience experience;
    private ClubExperience experience2;
	
	@BeforeClass
	public static void oneTimeSetup() {
        
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
        ArrayList<String> dets = new ArrayList<String>();
        dets.add("Kept the monies and bought a bunch of pizza");
        this.experience2 = new ClubExperience(UUID.randomUUID(), "ACM", dets, Date.fromString("05/09/2020"), Date.fromString("05/10/2020"), "Treasurer");
        this.experience = new ClubExperience("President of ACM");
    }
	
	@AfterEach
	public void tearDown() {

	}

    @Test
    public void testToString() {
		String str1 = "President of ACM";
        String str2 = this.experience.toString();
		assertEquals(str1, str2);
    }

    @Test
    public void testToStringLong() {
        String str2 = this.experience2.toString();
        String str1 = "ACM (05/09/20 - 05/10/20)\nTreasurer\n *  Kept the monies and bought a bunch of pizza";
        assertEquals(str1, str2);
    }

    @Test
    public void testToJSON() {   
        String str1 = this.experience.toJSON();
        String str2 = "{\"title\": \"President of ACM\"}";
        assertEquals(str1, str2);
    }

	@Test
	public void testFromJSON() {
		ClubExperience experience3 = ClubExperience.fromJSON("{\"id\":\"741690ea-c168-4211-9b75-bcba8c6fd1ea\",\"title\":\"Association for Computing Machinery UofSC Branch\",\"details\":[\"Served as club president\"],\"startDate\":\"08/05/20\",\"endDate\":\"12/20/20\",\"role\":\"Club President\"}");
        assertEquals(experience3.getTitle(), "Association for Computing Machinery UofSC Branch");
	}
    
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)
}