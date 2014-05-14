package worms.model;

import java.util.HashSet;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.programs.parser.Expression;
import worms.model.programs.parser.Statement;

public class AssignStatement extends Statement {

	private String variable;
	private Expression rhs;
	
	public AssignStatement(String variable, Expression rhs) {
		this.variable = variable;
		this.rhs = rhs;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		activeWorm.getProgram().changeVariable(variable, rhs.getValue(activeWorm));
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}



}
