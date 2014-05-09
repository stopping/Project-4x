package com.shared.model.commands;

import java.io.Serializable;

import com.server.FourXGameModel;

public abstract class GameCommand implements Serializable {
	
	/**
	 * Abstract class which concrete game commands are inherited from
	 */
	
	private static final long serialVersionUID = -3935706433387074689L;
	protected int turnSentOn; // Game turn the command was sent on
	protected int turnToExecute; // Game turn to execute on, defaults to turnSent + 1
	protected int playerID; // Player ID number
	
	public GameCommand(int turnSentOn, int turnToExecute, int playerID) {
		this.turnSentOn = turnSentOn;
		this.turnToExecute = turnToExecute;
		this.playerID = playerID;
	}
	
	public GameCommand(int turnSentOn, int playerID) {
		this(turnSentOn, turnSentOn + 1, playerID);
	}
	
	// Default no-argument constructor for GWT
	@SuppressWarnings("unused")
	private GameCommand() {
		this(-1, -1, -1);
	}
	
	/**
	 * @param model - the game model to execute this command on
	 * @return whether the command was successfully executed or not
	 */
	public abstract boolean executeOn( FourXGameModel model );
	
}