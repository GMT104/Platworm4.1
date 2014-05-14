package worms.model;

import worms.model.Worm;

public class GetMaxActionPointsExpression extends UnaryExpression {

	public GetMaxActionPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getMaximumActionPoints();
		return new MyDouble(value);
	}

}
