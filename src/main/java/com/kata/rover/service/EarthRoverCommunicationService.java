package com.kata.rover.service;

import java.util.List;

import com.kata.rover.model.Command;
import com.kata.rover.model.Rover;

/**
 * This class manages the communication between Earth and Rover.
 * 
 * @author Caroline Aupert
 *
 */
public interface EarthRoverCommunicationService {

	/**
	 * Retrieve the commands given by the user. If a command is not in the
	 * 
	 * @return The commands.
	 */
	public List<Command> askForCommands();

	/**
	 * Initializes the Rover position.
	 * 
	 * @param x The x coordinate.
	 * @return A recp of the Rover position.
	 */
	public Rover askForRoverLocation();

}