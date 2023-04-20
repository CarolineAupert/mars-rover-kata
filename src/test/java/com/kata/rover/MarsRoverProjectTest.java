package com.kata.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kata.rover.model.Command;
import com.kata.rover.model.Direction;
import com.kata.rover.model.Rover;
import com.kata.rover.service.EarthRoverCommunicationService;
import com.kata.rover.service.RoverService;

/**
 * Test of {@link MarsRoverProject}
 * 
 * @author Caroline Aupert
 *
 */
@ExtendWith(MockitoExtension.class)
public class MarsRoverProjectTest {
	
	/**
	 * The mock {@link RoverService}
	 */
	@Mock
	private RoverService mockRoverService;
	
	/**
	 * The mock {@link EarthRoverCommunicationService}
	 */
	@Mock
	private EarthRoverCommunicationService mockComService;
	
	/**
	 * System.out
	 */
	private final PrintStream standardOut = System.out;

	/**
	 * Captor to get what is System.out.
	 */
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	
	/**
	 * Initializes System.out.
	 */
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	/**
	 * Restores System.out.
	 */
	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}
	
	/**
	 * Tests launch method.
	 */
	@Test
	void launch() {
		int marsSize = 5;
		Mockito.when(mockComService.askForMarsSize()).thenReturn(marsSize);
		
		Rover initalRover = new Rover(2,5, Direction.E);
		Mockito.when(mockComService.askForRoverLocation(5)).thenReturn(initalRover);
		List<Command> commands = Arrays.asList(Command.F, Command.F, Command.L, Command.R);
		Mockito.when(mockComService.askForCommands()).thenReturn(commands).thenReturn(commands).thenReturn(null);
		
		Rover nextRover = new Rover(2,8, Direction.N);
		Mockito.when(mockRoverService.moveRover(initalRover, commands, marsSize)).thenReturn(nextRover);
		
		Rover finalRover = new Rover(5,8, Direction.S);
		Mockito.when(mockRoverService.moveRover(nextRover, commands, marsSize)).thenReturn(finalRover);
		
		MarsRoverProject.launch(mockRoverService, mockComService);
		
		assertTrue(outputStreamCaptor.toString().contains("Rover location is x: 2, y: 5 facing: EAST"), "The output should contain the message of the first rover.");
		assertTrue(outputStreamCaptor.toString().contains("Rover location is x: 2, y: 8 facing: NORTH"), "The output should contain the message of the second rover.");
		assertTrue(outputStreamCaptor.toString().contains("Rover location is x: 5, y: 8 facing: SOUTH"), "The output should contain the message of the last rover.");

	}
}
