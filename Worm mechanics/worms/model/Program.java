package worms.model;

import java.lang.Character.Subset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import worms.gui.game.IActionHandler;

public class Program {
	
	//TODO houdt momenteel geen rekening met 
	//het programma in het midden verder uit te voeren
	
	private Map<String, Type> globals;
	private Map<String, MyObject> variables = new HashMap<String, MyObject>();
	private Statement mainStatement;
	private Worm activeWorm;
	private IActionHandler handler;
	private boolean runtimeError;

	public Program(IActionHandler handler, Map<String, Type> globals, Object statement) throws ModelException {
		if (! typeCheck(statement, globals))
			throw new ModelException("This program has a type checking error!");
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
	
	public void removeVariable(String key) {
		this.variables.remove(key);
	}
	
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
				restartStatements();
				
			} catch (Exception exc) {
				if (!(exc instanceof InsufficientActionPointsException))
					this.setRuntimeError(true);
				// ELSE
				// 	Worm can't perform the requested action because of a lack of action points.
				// 	Move on to the next worm.
			}
		}
		this.activeWorm.getWorld().nextTurn();
	}

	private void restartStatements() {
		Set<Statement> set = this.mainStatement.getAllSubstatements();
		for(Statement subStatement: set){
			subStatement.setHasBeenRunAlready(false);
		}
	}

	private void initialiseVariables() {
		for (String variableName: this.globals.keySet()) {
			addVariable(variableName, globals.get(variableName).createObjectWithDefaultValue());
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
	
	public boolean typeCheck(Object statement, Map<String, Type> globals) {
		if (!(statement instanceof Statement))
			return false;
		Set<Statement> set = ((Statement) statement).getAllSubstatements();
		for(Statement subStatement: set){
			Set<Statement> subSet = ((Statement) subStatement).getAllSubstatements();
			for(Statement subSubStatement: subSet) {
				if (subSubStatement.hasExpressionAsInputToCheck()) {
					if (! typeCheckExpression(subSubStatement.getInputExpression(), globals))
						return false;
					if (! typeCheckStatement(subSubStatement, globals))
						return false;
				}
			}
		}
		return true;
	}
	
	private boolean typeCheckStatement(Statement statement, Map<String, Type> globals) {
		System.out.println("################################################");
		System.out.println("Statement: "+statement);
		System.out.println("Input expression: "+statement.getInputExpression());
		System.out.println("Input type required: "+statement.getInputType());
		return (statement.getInputExpression().getReturnType(globals) == statement.getInputType());
	}

	private boolean typeCheckExpression(Expression expr, Map<String, Type> globals) {
		boolean correct = true;
		if (expr instanceof UnaryExpression) {
			System.out.println("################################################");
			System.out.println("Unary expression: "+expr);
			System.out.println("Input expression: "+((UnaryExpression) expr).getExpression());
			System.out.println("Input type required: "+expr.getInputType());
			correct = (((UnaryExpression) expr).getExpression().getReturnType(globals) == (expr.getInputType()));
			if (correct)
				correct = typeCheckExpression(((UnaryExpression) expr).getExpression(), globals);
		} else if (expr instanceof BinaryExpression) {
			System.out.println("################################################");
			System.out.println("Binary expression: "+expr);
			System.out.println("Input left expression: "+((BinaryExpression) expr).getLeftExpression());
			System.out.println("Input right expression: "+((BinaryExpression) expr).getRightExpression());
			System.out.println("Input type required: "+expr.getInputType());
			correct = ((BinaryExpression) expr).getLeftExpression().getReturnType(globals) == expr.getInputType()
						&& ((BinaryExpression) expr).getRightExpression().getReturnType(globals) == expr.getInputType();
			if (correct)
				correct = typeCheckExpression(((BinaryExpression) expr).getLeftExpression(), globals)
							&& typeCheckExpression(((BinaryExpression) expr).getRightExpression(), globals);
		}	
		return correct;
	}
	
}
