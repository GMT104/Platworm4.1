package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.programs.parser.Statement;
import worms.model.programs.parser.*;

public class Program {
	
	//TODO houdt momenteel geen rekening met 
	//het programma in het midden verder uit te voeren
	
	private Map<String, Type> globals;
	private Map<String, Object> variables;
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
	
	public void setWorm(Worm worm) {
		this.activeWorm = worm;
	}
	
	public void addVariable(String key, Object variable) {
		this.variables.put(key, variable);
	}
	
	public void removeVariable(String key) {
		this.variables.remove(key);
	}
	
	public void changeVariable(String key, Object variable) {
		variables.put(key, variable);
	}
	
	public Object getVariable(String key) {
		return this.variables.get(key);
	}
	
	public void run(){
		mainStatement.execute(activeWorm, handler);
	}
	
}
