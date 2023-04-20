package com.kata.rover.service;

import java.util.Random;

/**
 * Implementation of {@link RoverService}
 * 
 * @author Caroline Aupert
 *
 */
public class MapServiceImpl implements MapService {

	@Override
	public boolean hasObstacle(int x, int y) {
		Random rd = new Random();
		return rd.nextBoolean();
	}

}
