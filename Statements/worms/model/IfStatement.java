package worms.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class IfStatement extends Statement {
	
	private Expression<MyBoolean> condition;
	private Statement then;
	private Statement otherwise;
	
	
	public IfStatement(Expression<MyBoolean> condition, Statement then, Statement otherwise) {
		this.condition = condition;
		this.then = then;
		this.otherwise = otherwise;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		if (((MyBoolean) condition.getValue(activeWorm)).getValue())
			this.then.run(activeWorm, handler);
		else
			this.otherwise.run(activeWorm, handler);
		this.setHasBeenRunAlready(true);
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		for(Statement subStatement: then.getAllSubstatements()){
			set.add(subStatement);
		}
		for(Statement subStatement: otherwise.getAllSubstatements()){
			set.add(subStatement);
		}
		return set;
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return true;
	}

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return MyBoolean.class;
	}

	@Override
	public Expression<? extends Type> getInputExpression() {
		return condition;
	}
	
}
