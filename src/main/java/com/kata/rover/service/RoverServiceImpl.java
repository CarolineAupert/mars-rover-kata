package com.kata.rover.service;

import java.util.List;

import com.kata.rover.model.Command;
import com.kata.rover.model.Direction;
import com.kata.rover.model.Rover;

/**
 * Implementation of {@link RoverService}
 * 
 * @author Caroline Aupert
 *
 */
public class RoverServiceImpl implements RoverService {

	/**
	 * Move the {@link Rover} forward. That is to say, move the rover in the direction it is facing.
	 * @param roverToMove The rover to move.
	 * @return The rover moved.
	 */
	Rover moveForward(Rover roverToMove) {
		Rover roverMoved = new Rover(roverToMove);
		
		// Move rover on y or x axis according to facing direction
		switch (roverToMove.getDirection()) {
			case N -> roverMoved.setY(roverMoved.getY()-1);
			case W -> roverMoved.setX(roverMoved.getX()-1);
			case S -> roverMoved.setY(roverMoved.getY()+1);
			case E -> roverMoved.setX(roverMoved.getX()+1);
		}
		
		return roverMoved;
	}
	
	/**
	 * Move the {@link Rover} backward. That is to say, move the rover in the direction it is facing.
	 * @param roverToMove The rover to move.
	 * @return The rover moved.
	 */
	Rover moveBackward(Rover roverToMove) {
		Rover roverMoved = new Rover(roverToMove);
		
		// Move rover on y or x axis according to facing direction
		switch (roverToMove.getDirection()) {
			case N -> roverMoved.setY(roverMoved.getY()+1);
			case W -> roverMoved.setX(roverMoved.getX()+1);
			case S -> roverMoved.setY(roverMoved.getY()-1);
			case E -> roverMoved.setX(roverMoved.getX()- 1);
		}
		
		return roverMoved;
	}
	
	/**
	 * Turn the {@link Rover} to the Right. That is to say, don't move the rover but update its direction.
	 * @param roverToMove The rover to move.
	 * @return The rover moved.
	 */
	Rover turnRight(Rover roverToMove) {
		Rover roverMoved = new Rover(roverToMove);
		
		// Turns Rover according to the initial direction
		switch (roverToMove.getDirection()) {
			case N -> roverMoved.setDirection(Direction.E);
			case W -> roverMoved.setDirection(Direction.N);
			case S -> roverMoved.setDirection(Direction.W);
			case E -> roverMoved.setDirection(Direction.S);
		}
		
		return roverMoved;
	}
	
	
	/**
	 * Turn the {@link Rover} to the Left. That is to say, don't move the rover but update its direction.
	 * @param roverToMove The rover to move.
	 * @return The rover moved.
	 */
	Rover turnLeft(Rover roverToMove) {
		Rover roverMoved = new Rover(roverToMove);
		
		// Turns Rover according to the initial direction
		switch (roverToMove.getDirection()) {
			case N -> roverMoved.setDirection(Direction.W);
			case W -> roverMoved.setDirection(Direction.S);
			case S -> roverMoved.setDirection(Direction.E);
			case E -> roverMoved.setDirection(Direction.N);
		}
		
		return roverMoved;
	}
	
	
	/**
	 * Move the {@link Rover} accoridng to the given commands.
	 * @param roverToMove The rover to move.
	 * @param commands The commands to follow.
	 * @return The rover moved.
	 */
	public Rover moveRover(Rover roverToMove, List<Command> commands) {
		Rover roverMoved = new Rover(roverToMove);
		
		for(Command command : commands) {
			switch (command) {
				case F -> roverMoved = moveForward(roverMoved);
				case B -> roverMoved = moveBackward(roverMoved);
				case L -> roverMoved = turnLeft(roverMoved);
				case R -> roverMoved = turnRight(roverMoved);
			}
		}
		
		return roverMoved;
	}


}
