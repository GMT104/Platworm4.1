package worms.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class AssignStatement extends Statement {

	private String variable;
	private Expression<?> rhs;

	public AssignStatement(String variable, Expression<?> rhs){
		this.variable = variable;
		this.rhs = rhs;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		activeWorm.getProgram().changeVariable(variable, (Type) rhs.getValue(activeWorm));
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
		return true;
	}

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return globals.get(variable).getClass();
	}

	@Override
	public Expression<?> getInputExpression() {
		return rhs;
	}
	
}
