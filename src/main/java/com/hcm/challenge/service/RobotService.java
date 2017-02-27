package com.hcm.challenge.service;

import javax.ejb.Local;

import com.hcm.challenge.domain.Coordinate;

@Local
public interface RobotService {
	
	public Coordinate moveOnTheMars(String command);

}
