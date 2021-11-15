package test;
import src.CourseExperience;
import src.Date;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseExperienceTester {
    private CourseExperience courseExperience;
    private UUID id;
	
	@BeforeClass
	public static void oneTimeSetup() {
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
        ArrayList<String> details = new ArrayList<>();
        details.add("Watched Wolf of Wall Street (2013) every class");
        details.add("Learned how to color within the lines");
        details.add("Developed the ability to emotionally manipulate my parents into giving me more money");
        id = UUID.randomUUID();
        courseExperience = new CourseExperience(id, "Business 301", details, new Date(10, 8, 2021), new Date(3, 12, 2021), 88);
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
	public void testCourseExperienceConstructor() {
        String str = "Business 301 (10/08/2021 - 03/12/2021)\n" + 
        "Grade: 88.0\n" +
        " * Watched Wolf of Wall Street (2013) every class\n" +
        " * Learned how to color within the lines\n" + 
        " * Developed the ability to emotionally manipulate my parents into giving me more money";
        assertEquals(courseExperience.toString(), str);
	}

    @Test
    public void testFromJSON() {
        String json = "{\"id\":\"ae5d1f8c-1350-4036-b5d7-7ac693cdf0b0\",\"title\":\"Software Engineering\",\"details\":[\"Developed a software project in Java with a group of peers\",\"Employed SCRUM/Agile development to create a functioning product\"],\"startDate\":\"05/01/20\",\"grade\":4.0,\"endDate\":\"08/20/20\"}";
        CourseExperience newCourseExperience = CourseExperience.fromJSON(json);
        String str = "Software Engineering (05/01/20 - 08/20/20)\n" + 
        "Grade: 4.0\n" +
        " * Developed a software project in Java with a group of peers\n" + 
        " * Employed SCRUM/Agile development to create a functioning product";
        assertEquals(newCourseExperience.toString(), str);
    }

    @Test
    public void testToJSON() {
        assertEquals(courseExperience.toJSON(), "{\"id\":\"" + id + "\",\"title\":\"Business 301\",\"details\":[\"Watched Wolf of Wall Street (2013) every class\",\"Learned how to color within the lines\",\"Developed the ability to emotionally manipulate my parents into giving me more money\"],\"startDate\":\"10/08/2021\",\"grade\":88.0,\"endDate\":\"03/12/2021\"}");
    }
}