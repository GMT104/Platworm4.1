package worms.model;


import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class TurnStatement extends ActionStatement {

	private Expression angle;
	
	public TurnStatement(DoubleExpression angle) {
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
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return MyDoubleType.class;
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return true;
	}

	@Override
	public Expression getInputExpression() {
		return angle;
	}

}
