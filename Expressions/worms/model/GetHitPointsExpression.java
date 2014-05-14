package worms.model;

import worms.model.Worm;

public class GetHitPointsExpression extends UnaryExpression {

	public GetHitPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getHitPoints();
		return new MyDouble(value);
	}

}
