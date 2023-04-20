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
	 * Asks for the Rover location.
	 * 
	 * @param marsSize Mars Size
	 * @return The Rover.
	 */
	public Rover askForRoverLocation(int marsSize);

	/**
	 * Ask for Mars size..
	 * 
	 * @return Mars size.
	 */
	public int askForMarsSize();

}