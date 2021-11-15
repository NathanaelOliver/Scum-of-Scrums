package test;
import src.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseTester {
	
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
	public void testDatabaseCreatedAndFromJSON() {
        // String val = DataLoader.getJSON("data/Users.json");
		// System.out.println(val);
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		//System.out.println(Database.employers.size());
		assertNotNull(Database.admins);
		assertFalse(Database.admins.size() == 0);
		assertNotNull(Database.employers);
        //System.out.println(Database.admins);
        assertTrue(Database.employers.size() > 0);
        assertNotNull(Database.students);
        assertTrue(Database.students.size() > 0);
        assertNotNull(Database.unverifiedUsers);
	}

	@Test
	public void testFilterResumesByGPA() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Resume> resumes = new ArrayList<>();
		resumes.add(Database.students.get(0).getResume());
		resumes.add(Database.students.get(1).getResume());
		resumes.add(Database.students.get(2).getResume());
		String filterString = "gpa:3.2";
		ArrayList<Resume> res = Database.filterApplicants(resumes, filterString);
		// System.out.println(res);
		resumes.remove(2);
		assertArrayEquals(resumes.toArray(), res.toArray());
	}

	@Test
	public void testFilterResumesBySkills() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Resume> resumes = new ArrayList<>();
		resumes.add(Database.students.get(0).getResume());
		resumes.add(Database.students.get(1).getResume());
		resumes.add(Database.students.get(2).getResume());
		String filterString = "skills:Python";
		ArrayList<Resume> res = Database.filterApplicants(resumes, filterString);
		resumes.remove(2);
		resumes.remove(0);
		assertArrayEquals(resumes.toArray(), res.toArray());
	}

	@Test
	public void testFilterResumesBySkillsAndGPA() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Resume> resumes = new ArrayList<>();
		resumes.add(Database.students.get(0).getResume());
		resumes.add(Database.students.get(1).getResume());
		resumes.add(Database.students.get(2).getResume());
		String filterString = "gpa:3.2;skills:Python";
		ArrayList<Resume> res = Database.filterApplicants(resumes, filterString);
		resumes.remove(2);
		resumes.remove(0);
		assertArrayEquals(resumes.toArray(), res.toArray());
	}

	@Test
	public void testFilterListingsByPay() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Listing> listings = new ArrayList<>();
		for (Employer employer: Database.employers)
			for (Listing listing: employer.getListings())
				listings.add(listing);
		String filter = "minpay:20.0";
		ArrayList<Listing> res = Database.filterListings(listings, filter);
		System.out.println(res);
		listings.removeIf(listing -> listing.getPayRate() < 20.0);
		assertEquals(res, listings);
	}

	@Test
	public void testFilterListingsByLocation() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Listing> listings = new ArrayList<>();
		for (Employer employer: Database.employers)
			for (Listing listing: employer.getListings())
				listings.add(listing);
		String filter = "location:Columbia, South Carolina";
		ArrayList<Listing> res = Database.filterListings(listings, filter);
		// System.out.println(res);
		listings.removeIf(listing -> !listing.getLocation().equalsIgnoreCase("Columbia, South Carolina"));
		assertEquals(res, listings);
	}

	@Test
	public void testFilterListingsByStartDate() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Listing> listings = new ArrayList<>();
		for (Employer employer: Database.employers)
			for (Listing listing: employer.getListings())
				listings.add(listing);
		String filter = "startdate:19/11/20";
		ArrayList<Listing> res = Database.filterListings(listings, filter);
		// System.out.println(res);
		listings.removeIf(listing -> listing.getStartDate().compareTo(new Date(19, 11, 2020)) > 0);
		assertEquals(res, listings);
	}

	@Test
	public void testFilterListingsByEndDate() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		ArrayList<Listing> listings = new ArrayList<>();
		for (Employer employer: Database.employers)
			for (Listing listing: employer.getListings())
				listings.add(listing);
		String filter = "enddate:19/07/20";
		ArrayList<Listing> res = Database.filterListings(listings, filter);
		System.out.println(listings);
		listings.removeIf(listing -> listing.getStartDate().compareTo(new Date(19, 7, 2020)) < 0);
		assertEquals(res, listings);
	}

	// @Test
	// public void testFilterListingsBySkills() {
	// 	Database.fromJSON(DataLoader.getJSON("data/Users.json"));
	// 	ArrayList<Listing> listings = new ArrayList<>();
	// 	for (Employer employer: Database.employers)
	// 		for (Listing listing: employer.getListings())
	// 			listings.add(listing);
	// 	String filter = "skills:JavaScript";
	// 	ArrayList<Listing> res = Database.filterListings(listings, filter);
	// 	System.out.println(listings);
	// 	listings.removeIf(listing -> !listing.getSkills().contains(src.Skills.valueOf("JavaScript")));
	// 	assertEquals(res, listings);
	// }

	@Test
	public void testRemoveAdmin() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		Admin adminRes = Database.admins.get(1);
		ArrayList<Admin> admins = new ArrayList<>();
		for (Admin admin: Database.admins)
			admins.add(admin);
		Database.removeAdmin(adminRes.ID);
		admins.remove(1);
		assertEquals(Database.admins, admins);
	}

	@Test
	public void testIsAvailableFalse() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		String username = "wihobbs";
		assertFalse(Database.isAvailable(username));
	}

	@Test
	public void testIsAvailableTrue() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		String username = "notTakenUsername";
		assertTrue(Database.isAvailable(username));
	}

	@Test
	public void testGetResumeByID() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		Resume resume = Database.students.get(1).getResume();
		Resume gotResume = Database.getResumeByID(resume.ID);
		assertSame(resume, gotResume);
	}

	@Test
	public void testGetResumeByIDFail() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		assertNull(Database.getResumeByID(UUID.randomUUID()));
	}

	@Test
	public void testGetListingByID() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		Listing listing = Database.employers.get(1).getListings().get(0);
		Listing gotListing = Database.getListingByID(listing.ID);
		assertSame(listing, gotListing);
	}

	@Test
	public void testGetListingByIDFail() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		assertNull(Database.getListingByID(UUID.randomUUID()));
	}

	@Test
	public void testPhoneNumberToString() {
		Database.fromJSON(DataLoader.getJSON("data/Users.json"));
		String number = "8034206969";
		String phoneNumber = Database.phoneNumberToString(number);
		assertEquals(phoneNumber, "(803)420-6969");
	}
}