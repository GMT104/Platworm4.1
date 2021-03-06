package worms.model;


import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class FireStatement extends ActionStatement {

	private Expression<MyDouble> yieldExpression;

	public FireStatement(Expression<MyDouble> yield) {
		this.yieldExpression = yield;
	}

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		if (activeWorm.getProjectile().getCostActionPoints() > activeWorm.getActionPoints())
			throw new InsufficientActionPointsException("cannot fire");
		int yield = ((MyDouble) this.yieldExpression.getValue(activeWorm)).getValueAsInteger();
		handler.fire(activeWorm, yield);
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
		return yieldExpression;
	}
	
	
}
