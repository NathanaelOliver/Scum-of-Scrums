package test;

import src.Database;
import src.DataLoader;
import src.Student;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	private Student student;

	@BeforeClass
	public void oneTimeSetup() {
	}

	@AfterClass
	public void oneTimeTearDown() {
	}

	@BeforeEach
	public void setup() {
    }

	@AfterEach
	public void tearDown() {
	}

	@Test
	public void testToJSON() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
        student = Database.getStudentByID(UUID.fromString("cd37b6a7-894a-4355-857c-ae582249fe6d"));
		String str = "{\"id\":\"" + "cd37b6a7-894a-4355-857c-ae582249fe6d" + "\",\"username\":\"" + "natoliver" + "\",\"password\":\"" + "g%merBoi2"
		+ "\",\"userType\":\"" + "student" + "\",\"isVerified\":" + true + ",\"resume\":"
		+ this.student.getResume().toJSON() + "}";

		assertEquals(this.student.toJSON(), str);
	}

	@Test
	public void testFromJSON() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
        student = Database.getStudentByID(UUID.fromString("cd37b6a7-894a-4355-857c-ae582249fe6d"));
		String json = "{\"id\":\"" + "cd37b6a7-894a-4355-857c-ae582249fe6d" + "\",\"username\":\"" + "natoliver" + "\",\"password\":\"" + "g%merBoi2"
		+ "\",\"userType\":\"" + "student" + "\",\"isVerified\":" + true + ",\"resume\":"
		+ this.student.getResume().toJSON() + "}";

		Student student2 = Student.fromJSON(json);
		assertTrue(student.getFirstName().equals(student2.getFirstName()) &&
				   student.getLastName().equals(student2.getLastName()) &&
				   student.getUsername().equals(student2.getUsername()));
	}

	@Test
	public void testToString() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
        student = Database.getStudentByID(UUID.fromString("cd37b6a7-894a-4355-857c-ae582249fe6d"));
		String str = "First Name: " + student.getFirstName() +
		"\nLast Name: " + student.getLastName() +
		"\nUsername: " + student.getUsername();

		assertEquals(str, student.toString());
	}

	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)

}
