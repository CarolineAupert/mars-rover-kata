package com.kata.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kata.rover.model.Command;
import com.kata.rover.model.Direction;
import com.kata.rover.model.Rover;

/**
 * Test of {@link RoverServiceImpl}
 * 
 * @author Caroline Aupert
 *
 */
public class RoverServiceImplTest {

	/**
	 * Tests moveForward method facing North.
	 */
	@Test
	void moveForward_facingNorth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(1, 2, Direction.N);
		Rover expectedRover = new Rover(1, 1, Direction.N);

		Rover roverMoved = serviceToTest.moveForward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing South.
	 */
	@Test
	void moveForward_facingSouth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(1, 2, Direction.S);
		Rover expectedRover = new Rover(1, 3, Direction.S);

		Rover roverMoved = serviceToTest.moveForward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing East.
	 */
	@Test
	void moveForward_facingEast() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(1, 2, Direction.E);
		Rover expectedRover = new Rover(2, 2, Direction.E);

		Rover roverMoved = serviceToTest.moveForward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing East.
	 */
	@Test
	void moveForward_facingWest() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(2, 2, Direction.W);

		Rover roverMoved = serviceToTest.moveForward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing North.
	 */
	@Test
	void moveBackward_facingNorth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.N);
		Rover expectedRover = new Rover(3, 3, Direction.N);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing North.
	 */
	@Test
	void moveBackward_facingSouth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.S);
		Rover expectedRover = new Rover(3, 1, Direction.S);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing West.
	 */
	@Test
	void moveBackward_facingWest() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(4, 2, Direction.W);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing East.
	 */
	@Test
	void moveBackward_facingEast() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.E);
		Rover expectedRover = new Rover(2, 2, Direction.E);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing North.
	 */
	@Test
	void turnRight_facingNorth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.N);
		Rover expectedRover = new Rover(3, 2, Direction.E);

		Rover roverMoved = serviceToTest.turnRight(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing South.
	 */
	@Test
	void turnRight_facingSouth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.S);
		Rover expectedRover = new Rover(3, 2, Direction.W);

		Rover roverMoved = serviceToTest.turnRight(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing East.
	 */
	@Test
	void turnRight_facingEast() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.E);
		Rover expectedRover = new Rover(3, 2, Direction.S);

		Rover roverMoved = serviceToTest.turnRight(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing West.
	 */
	@Test
	void turnRight_facingWest() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(3, 2, Direction.N);

		Rover roverMoved = serviceToTest.turnRight(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing North.
	 */
	@Test
	void turnLeft_facingNorth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.N);
		Rover expectedRover = new Rover(3, 2, Direction.W);

		Rover roverMoved = serviceToTest.turnLeft(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing South.
	 */
	@Test
	void turnLeft_facingSouth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.S);
		Rover expectedRover = new Rover(3, 2, Direction.E);

		Rover roverMoved = serviceToTest.turnLeft(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing East.
	 */
	@Test
	void turnLeft_facingEast() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.E);
		Rover expectedRover = new Rover(3, 2, Direction.N);

		Rover roverMoved = serviceToTest.turnLeft(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing West.
	 */
	@Test
	void turnLeft_facingWest() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(3, 2, Direction.S);

		Rover roverMoved = serviceToTest.turnLeft(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with one command.
	 */
	@Test
	void moveRover_oneCommand() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(2, 2, Direction.W);
		List<Command> commands = Arrays.asList(Command.F);

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with no command.
	 */
	@Test
	void moveRover_noCommand_doNotMove() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(3, 2, Direction.W);
		List<Command> commands = new ArrayList<>();

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with several commands.
	 */
	@Test
	void moveRover_severalCommands() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl();
		Rover roverToMove = new Rover(2, 1, Direction.E);
		Rover expectedRover = new Rover(3, 2, Direction.S);
		List<Command> commands = Arrays.asList(Command.F, Command.F, Command.R, Command.F, Command.L, Command.B,
				Command.R);

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

}
