package worms.model;

import worms.model.Worm;

public class GetMaxHitPointsExpression extends UnaryExpression {

	public GetMaxHitPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getMaximumHitPoints();
		return new MyDouble(value);
	}

}
