package worms.model;


import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class TurnStatement extends ActionStatement {

	private Expression<MyDouble> angle;
	
	public TurnStatement(Expression<MyDouble> angle) {
		this.angle = angle;
	}

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		double angle = ((MyDouble) this.angle.getValue(activeWorm)).getValue();
		if (! activeWorm.canTurn(angle))
			throw new InsufficientActionPointsException("cannot fire");
		handler.turn(activeWorm, angle);
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return true;
	}

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return MyDouble.class;
	}

	@Override
	public Expression<? extends Type> getInputExpression() {
		return angle;
	}

}
