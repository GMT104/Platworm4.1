package worms.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import worms.gui.game.IActionHandler;
import worms.model.programs.ParseOutcome;
import worms.model.programs.ParseOutcome.Success;
import worms.util.Util;

public class ProgramTest {

	private static final double EPS = Util.DEFAULT_EPSILON;

	private IFacade facade;

	private Random random;

	// X X X X
	// . . . .
	// . . . .
	// X X X X
	private boolean[][] passableMap = new boolean[][] {
			{ false, false, false, false }, { true, true, true, true },
			{ true, true, true, true }, { false, false, false, false } };

	@Before
	public void setup() {
		facade = new Facade();
		random = new Random(7357);
		facade.createWorld(4.0, 4.0, passableMap, random);
	}

	
	@Test
	public void testProgram() {
		IActionHandler handler = new SimpleActionHandler(facade);
		World world = facade.createWorld(100.0, 100.0, new boolean[][] { {true}, {false} }, random);
		ParseOutcome<?> outcome = facade.parseProgram("double x; while (x < 1.5) {\nx := x + 0.1;\n}\n turn x;", handler);
		assertTrue(outcome.isSuccess());
		Program program = ((Success)outcome).getResult();
		Worm worm = facade.createWorm(world, 50.0, 50.51, 0, 0.5, "Test", program);
		assertTrue(worm.getProgram().isWellFormed());
		facade.addNewWorm(world, null); // add another worm
		double oldOrientation = facade.getOrientation(worm);
		facade.startGame(world); // this will run the program
		double newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
	}
	
	@Test
	public void testNotWellFormedProgram() {
		IActionHandler handler = new SimpleActionHandler(facade);
		World world = facade.createWorld(100.0, 100.0, new boolean[][] { {true}, {false} }, random);
		ParseOutcome<?> outcome = facade.parseProgram("double x; while (x < 1.5) {\nx := x + 0.1;\n}\n turn x; foreach (worm, w) do{ toggleweap;}", handler);
		assertTrue(outcome.isSuccess());
		Program program = ((Success)outcome).getResult();
		Worm worm = facade.createWorm(world, 50.0, 50.51, 0, 0.5, "Test", program);
		assertFalse(worm.getProgram().isWellFormed());
	}
	
	@Test(expected = ModelException.class)
	public void testTypeCastProblem() {
		IActionHandler handler = new SimpleActionHandler(facade);
		facade.parseProgram("double x;entity y; while (x < 1.5) {\nx := x + 0.1;\n}\n turn (y+x);", handler);
	}
	
	@Test(expected = ModelException.class)
	public void testTypeCastProblem2() {
		IActionHandler handler = new SimpleActionHandler(facade);
		facade.parseProgram("double x;entity y; while (x < 1.5) {\nx := x + 0.1;\n}\n turn x; while(x){;}", handler);
	}
	
	@Test
	public void testErrorInProgramReturnOfSubsequentRuns() {
		IActionHandler handler = new SimpleActionHandler(facade);
		World world = facade.createWorld(100.0, 100.0, new boolean[][] { {true}, {false} }, random);
		ParseOutcome<?> outcome = facade.parseProgram("double x;entity y; while (x < 1.5) {\nx := x + 0.1;\n}\n turn x; fire  (getx y); ", handler);
		assertTrue(outcome.isSuccess());
		Program program = ((Success)outcome).getResult();
		Worm worm = facade.createWorm(world, 50.0, 50.51, 0, 0.5, "Test", program);
		assertTrue(worm.getProgram().isWellFormed());
		facade.addNewWorm(world, null); // add another worm
		double oldOrientation = facade.getOrientation(worm);
		facade.startGame(world); // this will run the program
		double newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		world.nextTurn();
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
		world.nextTurn();
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
	}
	
	@Test
	public void testProgramAFewTurns() {
		IActionHandler handler = new SimpleActionHandler(facade);
		World world = facade.createWorld(100.0, 100.0, new boolean[][] { {true}, {false} }, random);
		ParseOutcome<?> outcome = facade.parseProgram("double x;entity y; while (x < 1.5) {\nx := x + 0.1;\n}\n turn x; ", handler);
		assertTrue(outcome.isSuccess());
		Program program = ((Success)outcome).getResult();
		Worm worm = facade.createWorm(world, 50.0, 50.51, 0, 0.5, "Test", program);
		assertTrue(worm.getProgram().isWellFormed());
		facade.addNewWorm(world, null); // add another worm
		double oldOrientation = facade.getOrientation(worm);
		facade.startGame(world); // this will run the program
		double newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 3.0, newOrientation, EPS);
	}
	
	@Test
	public void testContinueWhereStopped() {
		IActionHandler handler = new SimpleActionHandler(facade);
		World world = facade.createWorld(100.0, 100.0, new boolean[][] { {true}, {false} }, random);
		ParseOutcome<?> outcome = facade.parseProgram("jump;jump;turn 1.5;", handler);
		assertTrue(outcome.isSuccess());
		Program program = ((Success)outcome).getResult();
		Worm worm = facade.createWorm(world, 50.0, 50.51, 0, 0.5, "Test", program);
		assertTrue(worm.getProgram().isWellFormed());
		facade.addNewWorm(world, null); // add another worm
		double oldOrientation = facade.getOrientation(worm);
		facade.startGame(world); // this will run the program
		double newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation, newOrientation, EPS);
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation, newOrientation, EPS);
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation+1.5, newOrientation, EPS);
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 3.0, newOrientation, EPS);
	}
	
	@Test
	public void testStoppedAfter1000Statements() {
		IActionHandler handler = new SimpleActionHandler(facade);
		World world = facade.createWorld(100.0, 100.0, new boolean[][] { {true}, {false} }, random);
		ParseOutcome<?> outcome = facade.parseProgram("double x; while (x < 1.5) {\nx := x + (1.5/1000);\n}\n turn x;", handler);
		assertTrue(outcome.isSuccess());
		Program program = ((Success)outcome).getResult();
		Worm worm = facade.createWorm(world, 50.0, 50.51, 0, 0.5, "Test", program);
		assertTrue(worm.getProgram().isWellFormed());
		facade.addNewWorm(world, null); 
		double oldOrientation = facade.getOrientation(worm);
		facade.startGame(world); // this will run the program
		world.nextTurn();
		assertNotEquals(worm, facade.getCurrentWorm(world)); // turn must end after executing program
		double newOrientation = facade.getOrientation(worm);
		assertEquals(oldOrientation + 1.5, newOrientation, EPS);
	
	}
}
