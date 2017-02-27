package com.hcm.challenge.domain;

import com.hcm.challenge.enums.Direction;

public class Robot {
	
	Direction direction;
	
	public Robot() {
	}
	
	public Robot(Direction direction) {
		super();
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
}