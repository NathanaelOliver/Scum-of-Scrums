package test;

import src.DataWriter;
import src.Admin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        assertEquals(val, "[]");
    }

    @Test
    public void testToJSON1element() {
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        adminList.add(new Admin("username", "password", "firstName", "lastName"));
        String val = DataWriter.toJSON(adminList);
        assertEquals(val, "[ " + adminList.get(0).toJSON() + "]");
    }

    // public static String skillsToJSON(ArrayList<Skills> skills)
    // Should test 0 element case, 1 element case and 10 element case

    // public static String idsToJSON(ArrayList<UUID> ids)
    // Should test 0 element case, 1 element case and 10 element case

    // public static String stringsToJSON(ArrayList<String> strings)
    // Should test 0 element case, 1 element case and 10 element case
}