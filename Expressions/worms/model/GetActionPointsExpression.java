package worms.model;

import worms.model.Worm;

public class GetActionPointsExpression extends DoubleUnaryExpression {

	public GetActionPointsExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getActionPoints();
		return new MyDouble(value);
	}

}