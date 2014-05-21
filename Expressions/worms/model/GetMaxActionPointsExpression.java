package worms.model;

import worms.model.Worm;

public class GetMaxActionPointsExpression extends DoubleUnaryExpression {

	public GetMaxActionPointsExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getMaximumActionPoints();
		return new MyDouble(value);
	}


}
