package com.kata.rover.service;

/**
 * The services for the Map
 * 
 * @author Caroline Aupert
 *
 */
public interface MapService {

	/**
	 * Indicates if a Map contains an obstacle at the specified coordinates.
	 * 
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @return True if an osbatcle is found.
	 */
	public boolean hasObstacle(int x, int y);

}