package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import src.Reference;

public class ReferenceTester {
    @Test
    public void testReferenceEqualsPointer() {
        Reference r1 = new Reference("first", "last", "phone", "email");
        Reference r2 = r1;
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void testReferenceEqualsSame() {
        Reference r1 = new Reference("first", "last", "phone", "email");
        Reference r2 = new Reference("first", "last", "phone", "email");
        assertEquals(true, r1.equals(r2));
    }

    @Test
    public void testReferenceEqualsDiffFirstName() {
        Reference r1 = new Reference("first", "last", "phone", "email");
        Reference r2 = new Reference("first1", "last", "phone", "email");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testReferenceEqualsDiffLastName() {
        Reference r1 = new Reference("first", "last", "phone", "email");
        Reference r2 = new Reference("first", "last1", "phone", "email");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testReferenceEqualsDiffPhone() {
        Reference r1 = new Reference("first", "last", "phone", "email");
        Reference r2 = new Reference("first", "last", "phone1", "email");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testReferenceEqualsDiffEmail() {
        Reference r1 = new Reference("first", "last", "phone", "email");
        Reference r2 = new Reference("first", "last", "phone", "email1");
        assertEquals(false, r1.equals(r2));
    }

    @Test
    public void testReferenceToString() {
        Reference r = new Reference("firstName", "lastName", "8038072017", "email");
        assertEquals("firstName lastName\nemail\n(803)807-2017", r.toString());
    }

    @Test
    public void testReferenceFromJson() {
        Reference r = new Reference("John", "Doe", "8038072017", "email@domain.site");
        Reference r2 = Reference.fromJSON(
                "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"phoneNumber\": \"8038072017\", \"email\": \"email@domain.site\"}");
        assertEquals(r, r2);
    }
}
