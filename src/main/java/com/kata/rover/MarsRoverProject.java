package com.kata.rover;

import java.util.Scanner;

import com.kata.rover.model.Rover;
import com.kata.rover.service.EarthRoverCommunicationService;

/**
 * This is the main class of the project.
 * 
 * @author Caroline Aupert
 *
 */
public class MarsRoverProject {

	/**
	 * Main method starting the project.
	 * 
	 * @param args The arguments needed.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome on Mars. Please initiate Rover coordinates.");
		EarthRoverCommunicationService comService = new EarthRoverCommunicationService(new Scanner(System.in));
		Rover rover = comService.askForRoverLocation();
		System.out.println(rover);
	}

}
