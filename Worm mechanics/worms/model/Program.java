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
	private Map<String, MyObject> variables = new HashMap<String, MyObject>();
	private Statement mainStatement;
	private Worm activeWorm;
	private IActionHandler handler;
	private boolean runtimeError;

	public Program(IActionHandler handler, Map<String, Type> globals, Object statement) {
		this.globals = globals;
		this.mainStatement = (Statement) statement;
		this.handler = handler;
		initialiseVariables();
	}
	
	protected void setWorm(Worm worm) {
		this.activeWorm = worm;
	}
	
	protected boolean runtimeError() {
		return this.runtimeError;
	}
	
	private void setRuntimeError(boolean error) {
		this.runtimeError = error;
	}
	
	protected void addVariable(String key, MyObject variable) {
		this.variables.put(key, variable);
	}
	
	//TODO security
	public void removeVariable(String key) {
		this.variables.remove(key);
	}
	
	//TODO security
	public void changeVariable(String key, MyObject variable) {
		variables.put(key, variable);
	}
	
	public MyObject getVariable(String key) {
		return this.variables.get(key);
	}
	
	protected void run(){
		if (! runtimeError()) {
			try {	
				mainStatement.run(activeWorm, handler);
				initialiseVariables();
			} catch (Exception exc) {
				if (exc instanceof InsufficientActionPointsException)
					this.setRuntimeError(true);
				// ELSE
				// 	Worm can't perform the requested action because of a lack of action points.
				// 	Move on to the next worm.
			}
		}
		this.activeWorm.getWorld().nextTurn();
	}

	private void initialiseVariables() {
		for (String variableName: this.globals.keySet()) {
			if (globals.get(variableName) instanceof MyDoubleType)
				this.variables.put(variableName, new MyDouble(0.0));
			else if (globals.get(variableName) instanceof MyBooleanType)
				this.variables.put(variableName, new MyBoolean(false));
			else
				this.variables.put(variableName, new Entity(null));
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
