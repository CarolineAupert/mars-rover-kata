package com.kata.rover.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.kata.rover.model.Command;
import com.kata.rover.model.Direction;
import com.kata.rover.model.Rover;

/**
 * Implementation of {@link EarthRoverCommunicationService}
 * 
 * @author Caroline Aupert
 *
 */
public class EarthRoverCommunicationServiceImpl implements EarthRoverCommunicationService {

	/**
	 * The {@link Scanner} to read user entries.
	 */
	private Scanner scanner;

	/**
	 * Constructor.
	 * @param scanner The scanner to read user answers.
	 */
	public EarthRoverCommunicationServiceImpl(Scanner scanner) {
		this.scanner = scanner;
	}

	/**
	 * Retrieve the commands given by the user.
	 * 
	 * @return The commands
	 */
	public List<Command> getCommands() {
		System.out.println("Enter commands (f b l r) :");
		String stringCommands = getScanner().next();

		return convertCommands(stringCommands);
	}

	/**
	 * Converts a String of command into a list of commands.
	 * @param stringCommands The commands to convert.
	 * @return The commands.
	 */
	private List<Command> convertCommands(String stringCommands) {
		var commands = new ArrayList<Command>();

		if (StringUtils.isNotEmpty(stringCommands)) {

			String stringToExtract = StringUtils.deleteWhitespace(stringCommands);
			for (int i = 0; i < stringToExtract.length(); i++) {
				String character = String.valueOf(stringToExtract.charAt(i)).toUpperCase();
				if (Command.exists(character)) {
					commands.add(Command.valueOf(character));
				}
			}
		}

		return commands;
	}

	/**
	 * Initializes the Rover position.
	 * 
	 * @param x The x coordinate.
	 * @return A recp of the Rover position.
	 */
	public Rover askForRoverLocation() {
		// Get x coordinate
		int x = getCoordinateFromConsole("Enter x:");

		// Get y coordinate
		int y = getCoordinateFromConsole("Enter y:");

		// Get Direction
		Direction direction = getDirectionFromConsole("Enter direction (N,E,W,S):");

		return new Rover(x, y, direction);
	}

	/**
	 * Retrieve the int coordinate from the console.
	 * 
	 * @param message The message directive for the user.
	 * @return The corresponding coordinate.
	 */
	private int getCoordinateFromConsole(String message) {
		String StringCoordinate = getArgFromConsole(message);
		try {
			return Integer.valueOf(StringUtils.deleteWhitespace(StringCoordinate));
		} catch (NumberFormatException e) {
			return getCoordinateFromConsole(message);
		}
	}

	/**
	 * Retrieve the {@link Direction} from the console.
	 * 
	 * @param message The message directive for the user.
	 * @return The corresponding Direction.
	 */
	private Direction getDirectionFromConsole(String message) {
		String stringDirection = getArgFromConsole(message);

		if (StringUtils.isNotBlank(stringDirection) && Direction.exists(stringDirection)) {
			return Direction.valueOf(stringDirection);
		} else {
			return getDirectionFromConsole(message);
		}
	}

	/**
	 * Ask for a String in the console. Note : if it is not a String that is given,
	 * then the same directive would be given until a good answer is given.
	 * 
	 * @param message The message directive.
	 * @return The value given by the user.
	 */
	private String getArgFromConsole(String message) {
		System.out.println(message);
		try {
			return getScanner().next();
		} catch (InputMismatchException e) {
			return getArgFromConsole(message);
		}
	}

	/**
	 * scanner getter.
	 *
	 * @return the scanner.
	 */
	public Scanner getScanner() {
		return scanner;
	}

	/**
	 * scanner setter.
	 *
	 * @param scanner : the scanner to set.
	 */
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

}