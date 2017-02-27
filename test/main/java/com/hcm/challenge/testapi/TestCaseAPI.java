package com.hcm.challenge.testapi;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Test;

import com.hcm.challenge.domain.Coordinate;
import com.hcm.challenge.enums.Direction;
import com.hcm.challenge.serviceimpl.RobotServiceImpl;

import junit.framework.TestCase;

public class TestCaseAPI extends TestCase {
private EJBContainer container;
private Context namingContext;
private RobotServiceImpl robot;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		container = EJBContainer.createEJBContainer();
		namingContext = container.getContext();
		robot = (RobotServiceImpl) namingContext.lookup("java:global/classes/RobotServiceImpl");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		namingContext.close();
		container.close();
	}

	@Test
	public void testFinalValues2() {
		assertEquals(robot.moveOnTheMars("MML"), new Coordinate(0, 2, Direction.WEST)); 
	}
	@Test
	public final void testMoveOnTheMars() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testExecuteActions() {
		fail("Not yet implemented"); // TODO
	}

}
