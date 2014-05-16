package worms.model;

import worms.gui.game.IActionHandler;
import worms.model.Worm;


public class JumpStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		handler.jump(activeWorm);
	}

	@Override
	public Class<? extends Type> getInputType() {
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
