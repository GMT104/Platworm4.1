package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class TurnStatement extends Statement {

	private Expression angle;
	
	public TurnStatement(Expression angle) {
		this.angle = angle;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		handler.turn(activeWorm, (double) angle.getValue().value());
	}


}
