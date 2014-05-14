package worms.model;

import java.util.HashSet;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class IfStatement extends Statement {
	
	private Expression condition;
	private Statement then;
	private Statement otherwise;
	
	
	public IfStatement(Expression condition, Statement then, Statement otherwise) {
		this.condition = condition;
		this.then = then;
		this.otherwise = otherwise;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		if ((boolean) this.condition.getValue(activeWorm))
			this.then.execute(activeWorm, handler);
		else
			this.otherwise.execute(activeWorm, handler);
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



}