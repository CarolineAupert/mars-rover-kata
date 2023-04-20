package com.kata.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

/**
 * Test of {@link EarthRoverCommunicationServiceImpl}
 * 
 * @author Caroline Aupert
 *
 */
@ExtendWith(MockitoExtension.class)
public class EarthRoverCommunicationServiceImplTest {

	/**
	 * The mock {@link Scanner}
	 */
	@Mock
	private Scanner mockScanner;

	/**
	 * The service to test.
	 */
	private EarthRoverCommunicationService comServiceToTest;

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
		comServiceToTest = new EarthRoverCommunicationServiceImpl(mockScanner);
	}

	/**
	 * Restores System.out.
	 */
	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

	/**
	 * Tests initRover method when everything goes fine.
	 */
	@Test
	void initRover_ok() {

		Mockito.when(mockScanner.next()).thenReturn("2").thenReturn("4").thenReturn("E");
		Rover rover = comServiceToTest.askForRoverLocation();

		assertTrue(outputStreamCaptor.toString().contains("Enter x:"), "Console out should display 'Enter x:'");
		assertTrue(outputStreamCaptor.toString().contains("Enter y:"), "Console out should display 'Enter y:'");
		assertEquals(2, rover.getX(), "X coordinate should be equal");
		assertEquals(4, rover.getY(), "Y coordinate should be equal");
		assertEquals(Direction.E, rover.getDirection(), "Direction should be equal");
	}

	/**
	 * Tests initRover method when int parameter given by the user is not an int.
	 */
	@Test
	void initRover_wrongParams_notAnInt() {
		Mockito.when(mockScanner.next()).thenReturn("a").thenReturn("2").thenReturn("3").thenReturn("E");

		Rover rover = comServiceToTest.askForRoverLocation();

		assertTrue(outputStreamCaptor.toString().contains("Enter x:"), "Console out should display 'Enter x:'");
		assertEquals(2, rover.getX(), "X coordinate should be equal");
	}

	/**
	 * Tests initRover method when direction parameter given by the user is not an
	 * char.
	 */
	@Test
	void initRover_wrongDirection_notAChar() {
		Mockito.when(mockScanner.next()).thenReturn("2").thenReturn("3").thenReturn("5").thenReturn("N");
		;

		Rover rover = comServiceToTest.askForRoverLocation();

		assertTrue(outputStreamCaptor.toString().contains("Enter x:"), "Console out should display 'Enter x:'");
		assertEquals(2, rover.getX(), "X coordinate should be equal");
		assertEquals(3, rover.getY(), "Y coordinate should be equal");
		assertEquals(Direction.N, rover.getDirection(), "Direction should be equal");
	}

	/**
	 * Tests initRover method when direction parameter given by the user is not a
	 * direction (not N, S, W or E).
	 */
	@Test
	void initRover_wrongDirection_notADirection() {
		Mockito.when(mockScanner.next()).thenReturn("2").thenReturn("3").thenReturn("Z").thenReturn("E");

		Rover rover = comServiceToTest.askForRoverLocation();

		assertTrue(outputStreamCaptor.toString().contains("Enter x:"), "Console out should display 'Enter x:'");
		assertEquals(2, rover.getX(), "X coordinate should be equal");
		assertEquals(3, rover.getY(), "Y coordinate should be equal");
		assertEquals(Direction.E, rover.getDirection(), "Direction should be equal");
	}

	/**
	 * Tests getCommands method when everything goes fine.
	 */
	@Test
	void getCommands_ok() {
		Mockito.when(mockScanner.next()).thenReturn("ffb l r");

		List<Command> expectedCommands = Arrays.asList(Command.F, Command.F, Command.B, Command.L, Command.R);

		List<Command> commands = comServiceToTest.getCommands();

		assertEquals(expectedCommands, commands);
	}

	/**
	 * Tests initRover method when wrong commands are given.
	 */
	@Test
	void getCommands_ko() {
		Mockito.when(mockScanner.next()).thenReturn("ffe l r3");

		List<Command> expectedCommands = Arrays.asList(Command.F, Command.F, Command.L, Command.R);

		List<Command> commands = comServiceToTest.getCommands();

		assertEquals(expectedCommands, commands);
	}

}
