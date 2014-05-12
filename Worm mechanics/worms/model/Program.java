package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.programs.parser.Statement;
import worms.model.programs.parser.*;

public class Program {
	
	//TODO houdt momenteel geen rekening met 
	//het programma in het midden verder uit te voeren
	
	private Map<String, Type> globals;
	private Map<String, Expression> variables;
	private Statement mainStatement;
	private Worm activeWorm;
	private IActionHandler handler;

	public Program(IActionHandler handler, Map<String, Type> globals, Object statement) {
		this.globals = globals;
		this.mainStatement = (Statement) statement;
		this.handler = handler;
		for (String global: this.globals.keySet()) {
			this.variables.put(global, null);
		}
	}
	
	
	public void run(){
		mainStatement.execute(activeWorm, handler);
	}
	
}
