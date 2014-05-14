package worms.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import worms.gui.game.IActionHandler;
import worms.model.*;

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
		initialiseVariables();
	}
	
	protected void setWorm(Worm worm) {
		this.activeWorm = worm;
	}
	
	protected void addVariable(String key, Object variable) {
		this.variables.put(key, variable);
	}
	
	//TODO security
	public void removeVariable(String key) {
		this.variables.remove(key);
	}
	
	//TODO security
	public void changeVariable(String key, Object variable) {
		variables.put(key, variable);
	}
	
	public Object getVariable(String key) {
		return this.variables.get(key);
	}
	
	protected void run(){
		try {	
			mainStatement.run(activeWorm, handler);
			initialiseVariables();
		} catch (InsufficientActionPointsException exc) {
			// Worm can't perform the requested action because of a lack of action points.
			// Move on to the next worm.
		}
		this.activeWorm.getWorld().nextTurn();
	}

	private void initialiseVariables() {
		for (String variableName: this.globals.keySet()) {
			if (globals.get(variableName) instanceof MyDoubleType)
				this.variables.put(variableName, 0.0);
			else if (globals.get(variableName) instanceof MyBooleanType)
				this.variables.put(variableName, false);
			else
				this.variables.put(variableName, null);
		}
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
