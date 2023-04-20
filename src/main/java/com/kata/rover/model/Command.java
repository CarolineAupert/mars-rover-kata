package com.kata.rover.model;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The rover facing direction.
 * 
 * @author Caroline Aupert
 *
 */
public enum Command {
	F("Front"), B("Back"), L("Left"), R("Right");

	/**
	 * The label on one character.
	 */
	public final String label;

	/**
	 * The Direction constructor
	 * 
	 * @param label The label on one character.
	 */
	private Command(String label) {
		this.label = label;
	}

	/**
	 * Check if a command exists.
	 * 
	 * @param stringCommand The command given.
	 * @return The answer.
	 */
	public static boolean exists(String stringCommand) {
		return Arrays.stream(Command.values()).map(Command::name).collect(Collectors.toList())
				.contains(stringCommand.toUpperCase());

	}
}
