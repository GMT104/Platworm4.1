package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.programs.parser.Statement;

public class Program {
	
	//TODO houdt momenteel geen rekening met 
	//het programma in het midden verder uit te voeren
	
	private Map globals;
	private Statement mainStatement;

	public Program(IActionHandler handler, Map globals, Object statement) {
		this.globals = globals;
		this.mainStatement = (Statement) statement;
	}
	
	
	public void run(){
		mainStatement.execute(null,null);
	}
	
}
