package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;

import src.Date;
import src.Reference;
import src.WorkExperience;

public class WorkExperienceTester {

    @Test
    public void testWorkExperienceEqualsPointer() {
        WorkExperience r1 = new WorkExperience("Work", "Boss");
        WorkExperience r2 = r1;
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsSame() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffTitle() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "not work",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffPosition() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position2");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffReferenceNum() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        r1.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffReferenceTrue() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        r1.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        r2.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffReferenceFalse() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        r1.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        r2.addReference(new Reference("diffName", "lastName", "phoneNumber", "email"));
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffDetailNum() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        r1.addDetail("Did stuff... maybe");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffDetailTrue() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        r1.addDetail("Did stuff... maybe");
        r2.addDetail("Did stuff... maybe");
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceEqualsDiffDetailFalse() {
        WorkExperience r1 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        WorkExperience r2 = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "title",
                new ArrayList<String>(), new Date(1, 2, 2000), new Date(2, 4, 2005), new ArrayList<Reference>(),
                "position");
        r1.addDetail("Did stuff... maybe");
        r2.addDetail("Definitely did not do stuff");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testWorkExperienceToString() {
        WorkExperience r = new WorkExperience("Work", "Boss");
        r.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        r.addDetail("Definitely did not do anything");
        r.setStartDate(new Date(12, 12, 2001));
        r.setEndDate(new Date(11, 10, 2002));
        assertEquals(
                "Work (12/12/2001 - 11/10/2002)\n * Boss\n * Definitely did not do anything\n\nReferences:\n--------------------\nfirstName lastName\nemail\n(pho)neN-umber",
                r.toString());
    }

    @Test
    public void testWorkExperienceToJSON() {
        WorkExperience r = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "Work",
                new ArrayList<String>(), new Date(12, 12, 2001), new Date(11, 10, 2002), new ArrayList<Reference>(),
                "Boss");
        r.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        r.addDetail("Definitely did not do anything");
        assertEquals(
                "{\"id\":\"6557166f-27d3-410a-889e-5b700e8d35ff\",\"title\":\"Work\",\"details\":[\"Boss\",\"Definitely did not do anything\"],\"startDate\":\"12/12/2001\",\"endDate\":\"11/10/2002\",\"references\":[ {\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"phoneNumber\":\"phoneNumber\",\"email\":\"email\"}]}",
                r.toJSON());
    }

    @Test
    public void testWorkExperienceFromJson() {
        WorkExperience r = new WorkExperience(UUID.fromString("6557166f-27d3-410a-889e-5b700e8d35ff"), "Work",
                new ArrayList<String>(), new Date(12, 12, 2001), new Date(11, 10, 2002), new ArrayList<Reference>(),
                "Boss");
        r.addReference(new Reference("firstName", "lastName", "phoneNumber", "email"));
        r.addDetail("Definitely did not do anything");
        WorkExperience r2 = WorkExperience.fromJSON(
                "{\"id\":\"6557166f-27d3-410a-889e-5b700e8d35ff\",\"title\":\"Work\",\"details\":[\"Boss\",\"Definitely did not do anything\"],\"startDate\":\"12/12/2001\",\"endDate\":\"11/10/2002\",\"references\":[ {\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"phoneNumber\":\"phoneNumber\",\"email\":\"email\"}]}");
        assertEquals(r, r2);
    }
}