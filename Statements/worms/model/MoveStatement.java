package worms.model;


import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class MoveStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		//TODO checkt niet alleen AP
		if (! activeWorm.canMove())
			throw new InsufficientActionPointsException("cannot move");
		handler.move(activeWorm);
	}


	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return null;
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return false;
	}

	@Override
	public Expression getInputExpression() {
		return null;
	}


}
