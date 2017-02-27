package com.hcm.challenge.enums;

public enum Command {
	
	LEFT('L'), RIGHT('R'), MOVE('M');
	
	private final char command;

	private Command(char comand) {
		this.command = comand;
	}

	public char getValue() {
		return command;
	}

}
