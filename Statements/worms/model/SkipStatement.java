package worms.model;


import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class SkipStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
	}
	
	@Override
	public boolean hasExpressionAsInputToCheck() {
		return false;
	}

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return null;
	}

	@Override
	public Expression<? extends Type> getInputExpression() {
		return null;
	}
	
}
