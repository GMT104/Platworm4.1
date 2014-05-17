package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Worm;


public class JumpStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		handler.jump(activeWorm);
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
