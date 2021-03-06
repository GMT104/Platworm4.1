package worms.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class PrintStatement extends Statement {

	private Expression<?> expression;
	
	public PrintStatement(Expression<?> e) {
		this.expression = e;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
			System.out.println(expression.getValue(activeWorm));
			this.setHasBeenRunAlready(true);
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return false;
	}

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return null;
	}

	@Override
	public Expression<? extends Type> getInputExpression() {
		return null;
	}
	
	
}
