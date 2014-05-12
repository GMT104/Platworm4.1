package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class WhileStatement extends Statement {

	private Expression condition;
	private Statement bodyStatement;
	
	public WhileStatement(Expression condition, Statement body) {
		this.condition = condition;
		this.bodyStatement = body;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		while ((boolean) condition.getValue(activeWorm)){
			this.bodyStatement.execute(activeWorm,handler);
		}
	}


}
