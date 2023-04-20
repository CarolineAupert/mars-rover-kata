/**
 * 
 */
package com.kata.rover.exception;

import com.kata.rover.model.Rover;

/**
 * 
 * The exception thrown when an obstacle is found.
 * 
 * @author carol
 *
 */
public class ObstacleException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The last time the River was safe
	 */
	private Rover safeRover;

	/**
	 * Constructor.
	 * 
	 * @param rover The last position where the Rover was safe.
	 * @param x     X coordinate
	 * @param y     Y coordinate
	 */
	public ObstacleException(Rover safeRover, int x, int y) {
		super("An obtascle was fount at x: " + x + ", y:" + y);
		this.safeRover = safeRover;
	}

	/**
	 * safeRover getter.
	 *
	 * @return the safeRover.
	 */
	public Rover getSafeRover() {
		return safeRover;
	}

	/**
	 * safeRover setter.
	 *
	 * @param safeRover : the safeRover to set.
	 */
	public void setSafeRover(Rover safeRover) {
		this.safeRover = safeRover;
	}

}
