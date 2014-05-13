package worms.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import worms.gui.game.IActionHandler;
import worms.model.programs.parser.*;

public class Program {
	
	//TODO houdt momenteel geen rekening met 
	//het programma in het midden verder uit te voeren
	
	private Map<String, Type> globals;
	private Map<String, Object> variables = new HashMap<String, Object>();
	private Statement mainStatement;
	private Worm activeWorm;
	private IActionHandler handler;

	public Program(IActionHandler handler, Map<String, Type> globals, Object statement) {
		this.globals = globals;
		this.mainStatement = (Statement) statement;
		this.handler = handler;
		for (String variableName: this.globals.keySet()) {
			if (globals.get(variableName) instanceof MyDoubleType)
				this.variables.put(variableName, 0.0);
			else if (globals.get(variableName) instanceof MyBooleanType)
				this.variables.put(variableName, false);
			else
				this.variables.put(variableName, null);
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
		System.out.println("running now");
		mainStatement.execute(activeWorm, handler);
		this.activeWorm.getWorld().nextTurn();
	}

	public boolean isWellFormed() {
		Set<Statement> set = this.mainStatement.getAllSubstatements();
		for(Statement subStatement: set){
			Set<Statement> subSet = subStatement.getAllSubstatements();
			for(Statement subSubStatement: subSet){
				if ((subStatement instanceof ForEachStatement) && (subSubStatement instanceof ActionStatement))
					return false;
			}
		}
		return true;
	}
	
}
