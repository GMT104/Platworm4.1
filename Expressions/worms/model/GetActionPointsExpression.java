package worms.model;

import worms.model.Worm;

public class GetActionPointsExpression extends UnaryExpression {

	public GetActionPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getActionPoints();
		return new MyDouble(value);
	}

}