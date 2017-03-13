package com.hcm.challenge.serviceimpl;

import javax.ejb.Stateless;

import com.hcm.challenge.domain.Coordinate;
import com.hcm.challenge.enums.Command;
import com.hcm.challenge.enums.Direction;
import com.hcm.challenge.exceptions.CommandNotExistsException;
import com.hcm.challenge.service.RobotService;

@Stateless
public class RobotServiceImpl implements RobotService{

	private static Coordinate coordinate = Coordinate.create();

	@Override
	public Coordinate moveOnTheMars(String command){
		coordinate = Coordinate.create();
		return executeActions(command);
	}
	
	public Coordinate executeActions (String comand){
		for(int i = 0;i < comand.length(); i++){
			execute(comand.toUpperCase().charAt(i));
		}
		return coordinate;
	}

	private void execute(char command) {
		if(command == Command.LEFT.getValue()){
			turnLeft();
		}else if(command == Command.RIGHT.getValue()){
			turnRight();
		}else if (command == Command.MOVE.getValue()) {
			move();
		}else{
			throw new CommandNotExistsException("O comando que você digitou não existe.");
		}
	}

	private void move() {
		switch (coordinate.getDirection()) {
		case NORTH:
			coordinate.goUp();
			break;
		case WEST:
			coordinate.goLeft();
			break;
		case SOUTH:
			coordinate.goDown();
			break;
		case EAST:
			coordinate.goRight();
			break;
		default:
			break;
		}
	}

	private void turnLeft() {
		switch (coordinate.getDirection()) {
		case NORTH:
			coordinate.setDirection(Direction.WEST);
			break;
		case WEST:
			coordinate.setDirection(Direction.SOUTH);
			break;
		case SOUTH:
			coordinate.setDirection(Direction.EAST);
			break;
		case EAST:
			coordinate.setDirection(Direction.NORTH);
			break;
		default:
			break;
		}
	}
	
	private void turnRight() {
		switch (coordinate.getDirection()) {
		case NORTH:
			coordinate.setDirection(Direction.EAST);
			break;
		case WEST:
			coordinate.setDirection(Direction.NORTH);
			break;
		case SOUTH:
			coordinate.setDirection(Direction.WEST);
			break;
		case EAST:
			coordinate.setDirection(Direction.SOUTH);
			break;
		default:
			break;
		}
	}

}
