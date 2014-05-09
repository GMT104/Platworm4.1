package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.programs.parser.Statement;

public class Program {
	
	//TODO houdt momenteel geen rekening met 
	//het programma in het midden verder uit te voeren
	
	private Map globals;
	private Statement mainStatement;
	private Worm activeWorm;
	private IActionHandler handler;

	public Program(IActionHandler handler, Map globals, Object statement) {
		this.globals = globals;
		this.mainStatement = (Statement) statement;
		this.handler = handler;
		
	}
	
	
	public void run(){
		mainStatement.execute(activeWorm, handler);
	}
	
}
