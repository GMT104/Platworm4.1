package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class FireStatement extends Statement {

	private Expression yieldExpression;

	public FireStatement(Expression yield) {
		this.yieldExpression = yield;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		handler.fire(activeWorm, (int) ((double) this.yieldExpression.getValue(activeWorm)));
	}

	

}
