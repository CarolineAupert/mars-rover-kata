package com.kata.rover.service;

import java.util.List;

import com.kata.rover.exception.ObstacleException;
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
	 * 
	 * @param roverToMove The rover to move.
	 * @param commands    The commands to follow.
	 * @param marsSize    The size of Mars.
	 * @return The rover moved.
	 * @throws ObstacleException if an obstacle is found.
	 */
	public Rover moveRover(Rover roverToMove, List<Command> commands, int marsSize) throws ObstacleException;

}