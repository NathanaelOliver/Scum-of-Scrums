package test;

import src.DataWriter;
import src.Admin;
import src.Skills;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

class DataWriterTester {

    @BeforeClass
    public void oneTimeSetup() {
    }

    @AfterClass
    public void oneTimeTearDown() {

    }

    @BeforeEach
    public void setup() {
        // runs before each test
    }

    @AfterEach
    public void tearDown() {
        // runs after each test
    }

    @Test
    public void testToJSON0elements() {
        String val = DataWriter.toJSON(new ArrayList<Admin>());
        assertEquals("[]", val);
    }

    @Test
    public void testToJSON1element() {
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        adminList.add(new Admin("username", "password", "firstName", "lastName"));
        String val = DataWriter.toJSON(adminList);
        assertEquals("[ " + adminList.get(0).toJSON() + "]", val);
    }

    @Test
    public void testToJSONManyElements() {
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        adminList.add(new Admin("username0", "password0", "firstName0", "lastName0"));
        adminList.add(new Admin("username1", "password1", "firstName1", "lastName1"));
        adminList.add(new Admin("username2", "password2", "firstName2", "lastName2"));
        adminList.add(new Admin("username3", "password3", "firstName3", "lastName3"));
        String val = DataWriter.toJSON(adminList);
        assertEquals("[ " + adminList.get(0).toJSON() + "," + adminList.get(1).toJSON() + ","
                + adminList.get(2).toJSON() + "," + adminList.get(3).toJSON() + "]", val);
    }

    @Test
    public void testSkillsToJSON() {
        String val = DataWriter.skillsToJSON(new ArrayList<src.Skills>());
        assertEquals("[]", val);
    }

    @Test
    public void testSkillsToJSON1element() {
        ArrayList<Skills> skillList = new ArrayList<Skills>();
        skillList.add(src.Skills.Java);
        String val = DataWriter.skillsToJSON(skillList);
        assertEquals("[ \"Java\"]", val);
    }

    @Test
    public void testSkillsToJSONManyElements() {
        ArrayList<src.Skills> skillList = new ArrayList<src.Skills>();
        skillList.add(src.Skills.Angular);
        skillList.add(src.Skills.C);
        skillList.add(src.Skills.CPlusPlus);
        skillList.add(src.Skills.CSS);
        String val = DataWriter.skillsToJSON(skillList);
        assertEquals("[ \"Angular\",\"C\",\"CPlusPlus\",\"CSS\"]", val);
    }

    @Test
    public void testIdsToJSON() {
        String val = DataWriter.idsToJSON(new ArrayList<UUID>());
        assertEquals("[]", val);
    }

    @Test
    public void testIdsToJSON1element() {
        ArrayList<UUID> idList = new ArrayList<UUID>();
        idList.add(UUID.fromString("c67dd783-0f91-4a9e-b337-794768fd9ba3"));
        String val = DataWriter.idsToJSON(idList);
        assertEquals("[\"c67dd783-0f91-4a9e-b337-794768fd9ba3\"]", val);
    }

    @Test
    public void testIdsToJSONManyElements() {
        ArrayList<UUID> idList = new ArrayList<UUID>();
        idList.add(UUID.fromString("c67dd783-0f91-4a9e-b337-794768fd9ba3"));
        idList.add(UUID.fromString("c67dd783-0f91-4a9e-b337-794768fd9ba4"));
        idList.add(UUID.fromString("c67dd783-0f91-4a9e-b337-794768fd9ba5"));
        idList.add(UUID.fromString("c67dd783-0f91-4a9e-b337-794768fd9ba6"));
        String val = DataWriter.idsToJSON(idList);
        assertEquals(
                "[\"c67dd783-0f91-4a9e-b337-794768fd9ba3\",\"c67dd783-0f91-4a9e-b337-794768fd9ba4\",\"c67dd783-0f91-4a9e-b337-794768fd9ba5\",\"c67dd783-0f91-4a9e-b337-794768fd9ba6\"]",
                val);
    }

    @Test
    public void testStringsToJSON() {
        String val = DataWriter.stringsToJSON(new ArrayList<String>());
        assertEquals("[]", val);
    }

    @Test
    public void testStringsToJSON1element() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("c67dd783-0f91-4a9e-b337-794768fd9ba3");
        String val = DataWriter.stringsToJSON(stringList);
        assertEquals("[\"c67dd783-0f91-4a9e-b337-794768fd9ba3\"]", val);
    }

    @Test
    public void testStringsToJSONManyElements() {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("c67dd783-0f91-4a9e-b337-794768fd9ba3");
        stringList.add("c67dd783-0f91-4a9e-b337-794768fd9ba4");
        stringList.add("c67dd783-0f91-4a9e-b337-794768fd9ba5");
        stringList.add("c67dd783-0f91-4a9e-b337-794768fd9ba6");
        String val = DataWriter.stringsToJSON(stringList);
        assertEquals(
                "[\"c67dd783-0f91-4a9e-b337-794768fd9ba3\",\"c67dd783-0f91-4a9e-b337-794768fd9ba4\",\"c67dd783-0f91-4a9e-b337-794768fd9ba5\",\"c67dd783-0f91-4a9e-b337-794768fd9ba6\"]",
                val);
    }
}