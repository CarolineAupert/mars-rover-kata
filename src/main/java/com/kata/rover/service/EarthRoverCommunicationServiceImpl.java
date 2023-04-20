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

	@Override
	public List<Command> askForCommands() {
		System.out.println("Enter commands (f b l r) or exit :");
		String stringCommands = getScanner().next();
		
		String cleanStringCommands = StringUtils.deleteWhitespace(stringCommands).toUpperCase();
	
		if(StringUtils.isEmpty(cleanStringCommands) || cleanStringCommands.equals("EXIT")) {
			return null;
		} else {
			return convertCommands(stringCommands);
		}
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

	@Override
	public Rover askForRoverLocation(int marsSize) {
		// Get x coordinate
		int x = getCoordinateFromConsole("Enter x:", marsSize);

		// Get y coordinate
		int y = getCoordinateFromConsole("Enter y:", marsSize);

		// Get Direction
		Direction direction = getDirectionFromConsole("Enter direction (N,E,W,S):");

		return new Rover(x, y, direction);
	}
	
	@Override
	public int askForMarsSize() {
		int marsSize = 0;
		while(marsSize == 0) {
			marsSize = getIntFromConsole("Enter Mars Size (integer > 0): ");
		}
		return marsSize;
	}
	
	/**
	 * Get the coordinate according to Mars Size.
	 * @param message The message directive for the user.
	 * @param marsSize Mars Size
	 * @return The coordinate.
	 */
	private int getCoordinateFromConsole(String message, int marsSize) {
		int coo = getIntFromConsole(message);
		while(coo >= marsSize) {
			coo = getCoordinateFromConsole(message, marsSize);
		}
		return coo;
	}

	/**
	 * Retrieve int value from the console.
	 * 
	 * @param message The message directive for the user.
	 * @return The corresponding int.
	 */
	private int getIntFromConsole(String message) {
		String StringCoordinate = getArgFromConsole(message);
		try {
			return Integer.valueOf(StringUtils.deleteWhitespace(StringCoordinate));
		} catch (NumberFormatException e) {
			return getIntFromConsole(message);
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
