package com.kata.rover.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kata.rover.exception.ObstacleException;
import com.kata.rover.model.Command;
import com.kata.rover.model.Direction;
import com.kata.rover.model.Rover;

/**
 * Test of {@link RoverServiceImpl}
 * 
 * @author Caroline Aupert
 *
 */
@ExtendWith(MockitoExtension.class)
public class RoverServiceImplTest {

	/**
	 * The mock {@link MapService}
	 */
	@Mock
	private MapService mockMapService;

	/**
	 * Tests moveForward method facing East when the rover is at the edge.
	 */
	@Test
	void moveForward_facingEast_stepOverEdge() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(4, 2, Direction.E);
		Rover expectedRover = new Rover(0, 2, Direction.E);

		Rover roverMoved = serviceToTest.moveForward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing North when the rover is at the edge.
	 */
	@Test
	void moveBackward_obtascleFound() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(true);
		Rover roverToMove = new Rover(4, 0, Direction.S);

		assertThrows(ObstacleException.class, () -> serviceToTest.moveBackward(roverToMove, 5));

	}

	/**
	 * Tests moveForward method facing North when the rover is at the edge.
	 */
	@Test
	void moveForward_obtascleFound() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(true);
		Rover roverToMove = new Rover(4, 0, Direction.S);

		assertThrows(ObstacleException.class, () -> serviceToTest.moveForward(roverToMove, 5));

	}

	/**
	 * Tests moveForward method facing North when the rover is at the edge.
	 */
	@Test
	void moveBackward_facingSouth_stepOverEdge() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(4, 0, Direction.S);
		Rover expectedRover = new Rover(4, 4, Direction.S);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing North.
	 */
	@Test
	void moveForward_facingNorth() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(1, 2, Direction.N);
		Rover expectedRover = new Rover(1, 1, Direction.N);

		Rover roverMoved = serviceToTest.moveForward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing South.
	 */
	@Test
	void moveForward_facingSouth() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(1, 2, Direction.S);
		Rover expectedRover = new Rover(1, 3, Direction.S);

		Rover roverMoved = serviceToTest.moveForward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing East.
	 */
	@Test
	void moveForward_facingEast() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(1, 2, Direction.E);
		Rover expectedRover = new Rover(2, 2, Direction.E);

		Rover roverMoved = serviceToTest.moveForward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveForward method facing East.
	 */
	@Test
	void moveForward_facingWest() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(2, 2, Direction.W);

		Rover roverMoved = serviceToTest.moveForward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing North.
	 */
	@Test
	void moveBackward_facingNorth() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(3, 2, Direction.N);
		Rover expectedRover = new Rover(3, 3, Direction.N);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing North.
	 */
	@Test
	void moveBackward_facingSouth() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(3, 2, Direction.S);
		Rover expectedRover = new Rover(3, 1, Direction.S);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing West.
	 */
	@Test
	void moveBackward_facingWest() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(4, 2, Direction.W);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveBackward method facing East.
	 */
	@Test
	void moveBackward_facingEast() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(3, 2, Direction.E);
		Rover expectedRover = new Rover(2, 2, Direction.E);

		Rover roverMoved = serviceToTest.moveBackward(roverToMove, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests turnRight method facing North.
	 */
	@Test
	void turnRight_facingNorth() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
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
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(3, 2, Direction.S);

		Rover roverMoved = serviceToTest.turnLeft(roverToMove);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with one command.
	 */
	@Test
	void moveRover_oneCommand() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(2, 2, Direction.W);
		List<Command> commands = Arrays.asList(Command.F);

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with no command.
	 */
	@Test
	void moveRover_noCommand_doNotMove() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Rover roverToMove = new Rover(3, 2, Direction.W);
		Rover expectedRover = new Rover(3, 2, Direction.W);
		List<Command> commands = new ArrayList<>();

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with several commands.
	 */
	@Test
	void moveRover_severalCommands() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(2, 1, Direction.E);
		Rover expectedRover = new Rover(3, 2, Direction.S);
		List<Command> commands = Arrays.asList(Command.F, Command.F, Command.R, Command.F, Command.L, Command.B,
				Command.R);

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands, 5);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with several commands.
	 */
	@Test
	void moveRover_severalCommands_obstacleFound() {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(3, 1)).thenReturn(false);
		Mockito.when(mockMapService.hasObstacle(4, 1)).thenReturn(true);
		Rover roverToMove = new Rover(2, 1, Direction.E);
//		Rover expectedRover = new Rover(3, 1, Direction.E);
		List<Command> commands = Arrays.asList(Command.F, Command.F, Command.R, Command.F, Command.L, Command.B,
				Command.R);

//		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands, 5);

		assertThrows(ObstacleException.class, () -> serviceToTest.moveRover(roverToMove, commands, 5));

	}

	/**
	 * Tests moveRover method with several commands with edges jumps.
	 */
	@Test
	void moveRover_severalCommands_edgesJumps() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Mockito.when(mockMapService.hasObstacle(anyInt(), anyInt())).thenReturn(false);
		Rover roverToMove = new Rover(2, 1, Direction.E);
		Rover expectedRover = new Rover(1, 2, Direction.N);
		List<Command> commands = Arrays.asList(Command.F, Command.R, Command.B, Command.B, Command.L, Command.F,
				Command.L);

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands, 3);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

	/**
	 * Tests moveRover method with several commands with edges jumps when the size
	 * is 1.
	 */
	@Test
	void moveRover_severalCommands_edgesJumps_size1() throws ObstacleException {
		RoverServiceImpl serviceToTest = new RoverServiceImpl(mockMapService);
		Rover roverToMove = new Rover(0, 0, Direction.E);
		Rover expectedRover = new Rover(0, 0, Direction.W);
		List<Command> commands = Arrays.asList(Command.F, Command.F, Command.B, Command.B, Command.L, Command.F,
				Command.L);

		Rover roverMoved = serviceToTest.moveRover(roverToMove, commands, 1);

		assertEquals(expectedRover, roverMoved, "The 2 rovers should be at the same location");
	}

}
