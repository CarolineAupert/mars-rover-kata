package com.kata.rover;

import java.util.List;
import java.util.Scanner;

import com.kata.rover.exception.ObstacleException;
import com.kata.rover.model.Command;
import com.kata.rover.model.Rover;
import com.kata.rover.service.EarthRoverCommunicationService;
import com.kata.rover.service.EarthRoverCommunicationServiceImpl;
import com.kata.rover.service.MapService;
import com.kata.rover.service.MapServiceImpl;
import com.kata.rover.service.RoverService;
import com.kata.rover.service.RoverServiceImpl;

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
		EarthRoverCommunicationService comService = new EarthRoverCommunicationServiceImpl(new Scanner(System.in));
		MapService mapService = new MapServiceImpl();
		RoverService roverService = new RoverServiceImpl(mapService);
		launch(roverService, comService);
	}

	/**
	 * Launch the App.
	 * 
	 * @param roverService The service to move the rover.
	 * @param comService   The service to communicate with earth.
	 */
	static void launch(RoverService roverService, EarthRoverCommunicationService comService) {
		System.out.println("Welcome on Mars. Please initiate Rover coordinates.");
		int marsSize = comService.askForMarsSize();
		Rover rover = comService.askForRoverLocation(marsSize);
		System.out.println(rover);

		List<Command> commands = comService.askForCommands();
		while (commands != null) {
			try {
				rover = roverService.moveRover(rover, commands, marsSize);
			} catch (ObstacleException e) {
				System.out.println(e.getMessage());
				rover = e.getSafeRover();
			}
			System.out.println(rover);
			commands = comService.askForCommands();
		}

		System.out.println("You left Mars !");
	}

}
