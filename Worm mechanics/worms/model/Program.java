package worms.model;

import java.util.Map;
import java.util.Set;

import worms.gui.game.IActionHandler;

public class Program {
	
	private Map<String, Type> globals;
	//private Map<String, MyObject> variables = new HashMap<String, MyObject>();
	private Statement mainStatement;
	private Worm activeWorm;
	private IActionHandler handler;
	private boolean runtimeError;
	private boolean typeCheckError;
	private int counter;

	public Program(IActionHandler handler, Map<String, Type> globals, Object statement) {
		if (! typeCheck(statement, globals))
			setTypeCheckError(true);
		this.globals = globals;
		this.mainStatement = (Statement) statement;
		this.handler = handler;
			
	}
	
	protected Worm getWorm() {
		return this.activeWorm;
	}
	
	protected void setWorm(Worm worm) {
		this.activeWorm = worm;
	}
	
	protected boolean getRuntimeError() {
		return this.runtimeError;
	}
	
	private void setRuntimeError(boolean error) {
		this.runtimeError = error;
	}
	
	protected boolean getTypeCheckError() {
		return this.typeCheckError;
	}
	
	private void setTypeCheckError(boolean error) {
		this.typeCheckError = error;
	}
	
	protected void addVariable(String key, Type variable) {
		this.globals.put(key, variable);
	}
	
	public void removeVariable(String key) {
		this.globals.remove(key);
	}
	
	public void changeVariable(String key, Type variable) {
		this.globals.put(key, variable);
	}
	
	public Type getVariable(String key) {
		return this.globals.get(key);
	}
	
	protected void run(){
		if (! getRuntimeError()) {
			try {	
				resetCounter();
				getMainStatement().run(activeWorm, handler);
				reInitialiseVariables();
				restartStatements();
			} catch (Exception exc) {
				if (!(exc instanceof InsufficientActionPointsException || exc instanceof MaximumAmountOfStatementsException))
					this.setRuntimeError(true);
				// ELSE
				// 	Worm can't perform the requested action because of a lack of action points.
				//  Or the worm wanted to execute more than 1000 statements. 
				// 	Move on to the next worm.
			}
		}
		if(this.getWorm().isAlive()){
		if (this.getWorm() == this.getWorm().getWorld().getActiveWorm())
			this.getWorm().getWorld().nextTurn();
		}
	}

	private void restartStatements() {
		Set<Statement> set = this.getMainStatement().getAllSubstatements();
		for(Statement subStatement: set){
			subStatement.setHasBeenRunAlready(false);
		}
	}

	private Statement getMainStatement() {
		return this.mainStatement;
	}


	private void reInitialiseVariables() {
		for (String variableName: this.getGlobals().keySet()) {
			addVariable(variableName, getGlobals().get(variableName).createObjectWithDefaultValue());
		}
	}

	private Map<String, Type> getGlobals() {
		return this.globals;
	}

	public boolean isWellFormed() {
		Set<Statement> set = this.getMainStatement().getAllSubstatements();
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
		System.out.println("################################################");
		System.out.println("##################Type Checking#################");
		System.out.println("################################################");
		if (!(statement instanceof Statement))
			return false;
		Set<Statement> set = ((Statement) statement).getAllSubstatements();
		for(Statement subStatement: set) {
			if (subStatement.hasExpressionAsInputToCheck()) {
				if (! typeCheckExpression(subStatement.getInputExpression(), globals)) {
					System.out.println("################################################");
					System.out.println("##############Type Checking Error###############");
					System.out.println("################################################");
					return false;
				}
				if (! typeCheckStatement(subStatement, globals)) {
					System.out.println("################################################");
					System.out.println("##############Type Checking Error###############");
					System.out.println("################################################");
					return false;
				}
			}
		}
		System.out.println("################################################");
		System.out.println("########Type Checking Succesfully Ended#########");
		System.out.println("################################################");
		
		return true;
	}
	
	private boolean typeCheckStatement(Statement statement, Map<String, Type> globals) {
		System.out.println("################################################");
		System.out.println("Statement: "+statement);
		System.out.println("Input expression: "+statement.getInputExpression());
		System.out.println("Input type required: "+statement.getInputType(globals));
		return (statement.getInputExpression().getReturnType(globals) == statement.getInputType(globals));
	}

	@SuppressWarnings("unchecked")
	private boolean typeCheckExpression(Expression<?> expression, Map<String, Type> globals) {
		boolean correct = true;
		if (expression instanceof UnaryExpression) {
			System.out.println("################################################");
			System.out.println("Unary expression: "+expression);
			System.out.println("Input expression: "+((UnaryExpression<? extends Type>) expression).getExpression());
			System.out.println("Input type required: "+expression.getInputType());
			correct = (((UnaryExpression<? extends Type>) expression).getExpression().getReturnType(globals) == (expression.getInputType()));
			if (correct)
				correct = typeCheckExpression(((UnaryExpression<? extends Type>) expression).getExpression(), globals);
		} else if (expression instanceof BinaryExpression) {
			System.out.println("################################################");
			System.out.println("Binary expression: "+expression);
			System.out.println("Input left expression: "+((BinaryExpression<? extends Type>) expression).getLeftExpression());
			System.out.println("Input right expression: "+((BinaryExpression<? extends Type>) expression).getRightExpression());
			System.out.println("Input type required: "+expression.getInputType());
			correct = ((BinaryExpression<? extends Type>) expression).getLeftExpression().getReturnType(globals) == expression.getInputType()
						&& ((BinaryExpression<? extends Type>) expression).getRightExpression().getReturnType(globals) == expression.getInputType();
			if (correct)
				correct = typeCheckExpression(((BinaryExpression<? extends Type>) expression).getLeftExpression(), globals)
							&& typeCheckExpression(((BinaryExpression<? extends Type>) expression).getRightExpression(), globals);
		}	
		return correct;
	}

	public void count() {
		this.counter = this.counter +1;
	}
	
	public void resetCounter(){
		this.counter = 0;
	}
	
	public int getCounter() {
		return this.counter;
	}
}
