package test;

import src.Database;
import src.DataLoader;
import src.Listing;
import src.Resume;
import src.Student;
import src.StudentUI;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResumeTest {
	private Resume resume;

	@BeforeClass
	public void oneTimeSetup() {
	}

	@AfterClass
	public void oneTimeTearDown() {
	}

	@BeforeEach
	public void setup() {
        Database.fromJSON(DataLoader.getJSON("data/Users.json"));
        resume = Database.getResumeByID(UUID.fromString("05a6c472-75cf-4e0b-96d1-b3ea2bd33819"));
    }

	@AfterEach
	public void tearDown() {
	}

	@Test
	public void testToJSON() {
		String str = "{\"id\":\"" + "05a6c472-75cf-4e0b-96d1-b3ea2bd33819" + "\",\"firstName\":\"" + "Nathanael" + "\",\"lastName\":\"" + "Oliver" + "\",\"gpa\":"
		+ 3.9 + ",\"phoneNumber\":\"" + 1234567890 + "\",\"email\":\"" + "no2@email.sc.edu" + "\",\"skills\":"
		+ "[ \"Python\",\"Java\",\"JavaScript\",\"HTML\",\"CSS\"]" + ",\"workExperiences\":" + "[ {\"id\":\"33ca5522-95bc-4758-abf4-74e42dc0e432\",\"title\":\"JP Morgan\",\"details\":[\"Internship\",\"Created a Python program to predict clients needs.\",\"Managed incoming customers and future predictions\"],\"startDate\":\"05/01/20\",\"endDate\":\"08/01/20\",\"references\":[]},{\"id\":\"6bb43228-2c90-4c82-a4d2-aad68636c455\",\"title\":\"Bank of America\",\"details\":[\"Internship\",\"Created JUnit test cases to test new features of the back end of the banks website\",\"Executed test cases and reported issues to engineering\"],\"startDate\":\"05/01/20\",\"endDate\":\"08/01/20\",\"references\":[]}]"
		+ ",\"courseExperiences\":" + "[]" + ",\"clubExperiences\":"
		+ "[ {\"id\":\"741690ea-c168-4211-9b75-bcba8c6fd1ea\",\"title\":\"Association for Computing Machinery UofSC Branch\",\"details\":[\"Showed up regularly and ate pizza\"],\"startDate\":\"08/05/20\",\"endDate\":\"12/20/20\",\"role\":\"Member\"}]" + "}";

		assertEquals(resume.toJSON(), str);
	}

	@Test
	public void testFromJSON() {
		String json = "{\"id\":\"" + "05a6c472-75cf-4e0b-96d1-b3ea2bd33819" + "\",\"firstName\":\"" + "Nathanael" + "\",\"lastName\":\"" + "Oliver" + "\",\"gpa\":"
		+ 3.9 + ",\"phoneNumber\":\"" + 1234567890 + "\",\"email\":\"" + "no2@email.sc.edu" + "\",\"skills\":"
		+ "[ \"Python\",\"Java\",\"JavaScript\",\"HTML\",\"CSS\"]" + ",\"workExperiences\":" + "[ {\"id\":\"33ca5522-95bc-4758-abf4-74e42dc0e432\",\"title\":\"JP Morgan\",\"details\":[\"Internship\",\"Created a Python program to predict clients needs.\",\"Managed incoming customers and future predictions\"],\"startDate\":\"05/01/20\",\"endDate\":\"08/01/20\",\"references\":[]},{\"id\":\"6bb43228-2c90-4c82-a4d2-aad68636c455\",\"title\":\"Bank of America\",\"details\":[\"Internship\",\"Created JUnit test cases to test new features of the back end of the banks website\",\"Executed test cases and reported issues to engineering\"],\"startDate\":\"05/01/20\",\"endDate\":\"08/01/20\",\"references\":[]}]"
		+ ",\"courseExperiences\":" + "[]" + ",\"clubExperiences\":"
		+ "[ {\"id\":\"741690ea-c168-4211-9b75-bcba8c6fd1ea\",\"title\":\"Association for Computing Machinery UofSC Branch\",\"details\":[\"Showed up regularly and ate pizza\"],\"startDate\":\"08/05/20\",\"endDate\":\"12/20/20\",\"role\":\"Member\"}]" + "}";

        Resume resume2 = Resume.fromJSON(json);
        assertTrue(resume.ID.equals(resume2.ID) &&
                   resume.getFirstName().equals(resume.getFirstName()) &&
                   resume.getLastName().equals(resume2.getLastName()));
	}

	@Test
	public void testToString() {
        String res = "Nathanael Oliver\n" +
        "(123)456-7890\n" +
        "no2@email.sc.edu\n" +
        "GPA: 3.9\n" +
        "Skills: Python, Java, JavaScript, HTML, CSS\n" +
        "Education:\n" +
         "* University of South Carolina\n" +
         "* Bachelors in Computer Information Systems\n" +
         "* Expected Graduation: 0\n\n" +
        
        "Work Experiences\n" +
        "----------------------------------------\n" +
        "JP Morgan (05/01/2019 - 08/01/2019)\n" +
         "* Internship\n" +
         "* Created a Python program to predict clients needs.\n" +
         "* Managed incoming customers and future predictions\n" +
        "----------------------------------------\n" +
        "Bank of America (05/01/2020 - 08/01/2020)\n" +
         "* Internship\n" +
         "* Created JUnit tests cases to test new features of the back end of the banks website\n" +
         "* Executed test cases and reported issues to engineering\n\n" +
        
        "Club Experiences\n" +
        "----------------------------------------\n" +
        "Association for Computing Machinery UofSC Branch (08/05/20 - 12/20/20)\n" +
        "Member\n" +
         "*  Showed up regularly and ate pizza\n";

         assertEquals(res, resume.toString());
	}

	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)

}
