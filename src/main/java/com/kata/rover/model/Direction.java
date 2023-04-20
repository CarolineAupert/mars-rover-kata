package com.kata.rover.model;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The rover facing direction.
 * 
 * @author Caroline Aupert
 *
 */
public enum Direction {
	N("NORTH"), S("SOUTH"), W("WEST"), E("EAST");

	/**
	 * The label on one character.
	 */
	public final String label;

	/**
	 * The Direction constructor
	 * 
	 * @param label The label on one character.
	 */
	private Direction(String label) {
		this.label = label;
	}

	/**
	 * Check if a direction exists.
	 * 
	 * @param stringDirection The direction given.
	 * @return The answer.
	 */
	public static boolean exists(String stringDirection) {
		return Arrays.stream(Direction.values()).map(Direction::name).collect(Collectors.toList())
				.contains(stringDirection.toUpperCase());

	}
}
