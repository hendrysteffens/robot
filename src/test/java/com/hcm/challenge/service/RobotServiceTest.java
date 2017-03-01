package com.hcm.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.hcm.challenge.domain.Coordinate;
import com.hcm.challenge.enums.Direction;
import com.hcm.challenge.exceptions.CommandNotExistsException;
import com.hcm.challenge.exceptions.OutOfWorldException;
import com.hcm.challenge.serviceimpl.RobotServiceImpl;
import com.hcm.challenge.testapi.ExpectedException;

//Todo : Usar Arquillian para os testes
public class RobotServiceTest {
	
	private RobotServiceImpl robot = new RobotServiceImpl();
	
	private ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void aroundWolrd() {	
		assertEquals(robot.moveOnTheMars("MMMMRMMMMRMMMMRMMMM"), Coordinate.create()); 
	}
	
	@Test
	public void testNorthException() {
		try {
			robot.moveOnTheMars("MMMMM");
		} catch (Exception e) {
			assertTrue(thrown.expect(OutOfWorldException.class, e));
		}
	}
	
	@Test
	public void testWestException() {
		 try{
			 robot.moveOnTheMars("LM");
		 }catch (Exception e){
			assertTrue(thrown.expect(OutOfWorldException.class, e));
		 }
	}
	
	@Test
	public void testEastException() {	
		try{
			robot.moveOnTheMars("RMMMMM");
		}catch (Throwable e){
			assertTrue(thrown.expect(OutOfWorldException.class, e));
		}
	}
	
	@Test
	public void testSouthException() throws OutOfWorldException, NamingException {	
		 try{
			 robot.moveOnTheMars("RRRM");
		 }catch (Throwable e){
			 assertTrue(thrown.expect(OutOfWorldException.class, e));
		 }
		 
	}
	@Test
	public void testCommandException() {
		try{
			robot.moveOnTheMars("T");
		}catch (Throwable e){
			assertTrue(thrown.expect(CommandNotExistsException.class, e));
		}
	}
	
	@Test
	public void testFinalValues1() {
		 assertEquals(robot.moveOnTheMars("MMRMMRMM"), new Coordinate(2, 0, Direction.SOUTH)); 
	}
	
	@Test
	public void testFinalValues2() {
		assertEquals(robot.moveOnTheMars("MML"), new Coordinate(0, 2, Direction.WEST)); 
	}
	
	@Test
	public void testFinalValues3() {
		assertEquals(robot.moveOnTheMars("RRRRM"), new Coordinate(0, 1, Direction.NORTH)); 
	}
	
	@Test
	public void testFinalValues4() {
		assertEquals(robot.moveOnTheMars("MRMRMLMLMLMLM"), new Coordinate(1, 0, Direction.SOUTH)); 
	}
	
	@Test
	public void testAllLocations() {
		assertEquals(robot.moveOnTheMars("MMMMRMRMMMMLMLMMMMRMRMMMMLMLMMMM"), new Coordinate(4, 4, Direction.NORTH)); 
	}

}
