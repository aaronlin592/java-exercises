package labs.lab4;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class RobotTest {

	@Test
    public void testConstructor() {
		// FILL IN
		Robot robot = new Robot();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());
    }

	@Test
    public void testTurnLeft() {
		// FILL IN
		Robot robot = new Robot();
		robot.turnLeft();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("W", robot.getDirection());
    }
	
	@Test
    public void testTurnRight() {
		// FILL IN
		Robot robot = new Robot();
		robot.turnRight();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("E", robot.getDirection());
    }
	
	@Test
    public void testMove() {
		// FILL IN
		Robot robot = new Robot();
		assertTrue(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(0, 1))); 
		assertEquals("N", robot.getDirection());
		
    }
}
