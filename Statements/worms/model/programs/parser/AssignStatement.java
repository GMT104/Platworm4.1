package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class AssignStatement extends Statement {

	private String variable;
	private Expression rhs;
	
	public AssignStatement(String variable, Expression rhs) {
		this.variable = variable;
		this.rhs = rhs;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		activeWorm.getProgram().
	}



}
