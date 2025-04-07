package labs.lab4;

import static org.junit.Assert.*;


import org.junit.Test;


public class StudentTest {
	
	/**
	 * Tests that the constructor behaves as specified
	 */

	// Junit uses an unpredictable order of tests which resulted in my test order to be all sporadic, so I based my tests off of the random test order I got after running my Junit file.
	// THE TEST ORDER IS AS FOLLOWS (WHEN I RAN MY TESTS):
	// 1. testGPA 2. testName 3. testID 4. testHonors 5. testConstructor

	@Test
    public void testConstructor() {
		// FILL IN
		Student aaron = new Student("Aaron Lin");
		assertEquals(7, aaron.getId());
		Student guy = new Student("some guy");
		assertEquals(8, guy.getId());
    }

	
	/**
	 * Tests the getting and setting of the name field
	 */
	@Test
    public void testName() {
		// FILL IN
		Student bob = new Student("Bob Target");
		assertEquals(2, bob.getId());
		assertTrue(bob.getName().equals("Bob Target"));
		Student rich = new Student("Richard Walmart");
		assertEquals(3, rich.getId());
		assertTrue(rich.getName().equals("Richard Walmart"));
    }
	
	
	/**
	 * Tests the id generation/setting and getting the id
	 */
	@Test
    public void testId() {
		// FILL IN
		Student dude = new Student("dude");
		assertEquals(4, dude.getId());
		Student person = new Student("person");
		assertEquals(5, person.getId());
    }
	
	
	/**
	 * Tests the getting and setting of the GPA field
	 */
	@Test
    public void testGPA() {
		// FILL IN
		Student robert = new Student("Robert Navarro");
		assertEquals(1, robert.getId());
		robert.setGPA(4.0);
		assertTrue(4.0 == robert.getGPA());
		robert.setGPA(3.2);
		assertTrue(3.2 == robert.getGPA());
    }
	
	
	/**
	 * Tests the getting and setting of the honors status
	 */
	@Test
    public void testHonors() {
		// FILL IN
		Student jojo = new Student("Joseph Joestar");
		assertEquals(6, jojo.getId());
		jojo.setGPA(3.5);
		assertEquals(true, jojo.isHonorsStudent());
		jojo.setGPA(2.1);
		assertEquals(false, jojo.isHonorsStudent());
    }
}
