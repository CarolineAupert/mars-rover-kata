package com.kata.rover.service;

import java.util.List;

import com.kata.rover.model.Command;
import com.kata.rover.model.Rover;

/**
 * The services of a {@link Rover}.
 * 
 * @author Caroline Aupert
 *
 */
public interface RoverService {
	
	/**
	 * Move the {@link Rover} accoridng to the given commands.
	 * @param roverToMove The rover to move.
	 * @param commands The commands to follow.
	 * @return The rover moved.
	 */
	public Rover moveRover(Rover roverToMove, List<Command> commands);

}