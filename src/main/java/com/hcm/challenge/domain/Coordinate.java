package com.hcm.challenge.domain;

import com.hcm.challenge.enums.Direction;
import com.hcm.challenge.exceptions.OutOfWorldException;

public class Coordinate {
	
	Direction direction;
	private int x;
	private int y;
	private final int WORLD_MAX_HEIGHT = 4;
	private final int WORLD_MIN_HEIGHT = 0;
	
	private final int WORLD_MAX_WIDTH = 4;
	private final int WORLD_MIN_WIDTH = 0;
	
	public static Coordinate create() {
	    return new Coordinate(0,0,Direction.NORTH);
	}
	
	public Coordinate(int x, int y, Direction direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void goUp() {
		if (y < WORLD_MAX_HEIGHT) {
			y++;
		} else {
			throw new OutOfWorldException("Você ultrapassou o limite do mundo, seguiu o NORTE demais...");
		}
	}

	public void goDown() {
		if (y > WORLD_MIN_HEIGHT) {
			y--;
		} else {
			throw new OutOfWorldException("Você ultrapassou o limite do mundo, seguiu o SUL demais...");
		}
	}

	public void goRight() {
		if (x < WORLD_MAX_WIDTH) {
			x++;
		} else {
			throw new OutOfWorldException("Você ultrapassou o limite do mundo, seguiu o LESTE demais...");
		}
	}

	public void goLeft() {
		if (x > WORLD_MIN_WIDTH) {
			x--;
		} else {
			throw new OutOfWorldException("Você ultrapassou o limite do mundo, seguiu o OESTE demais...");
		}
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + ", Direction=" + direction.name() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}