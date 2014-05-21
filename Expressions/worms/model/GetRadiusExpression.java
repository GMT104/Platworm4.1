package worms.model;

import worms.model.Worm;

public class GetRadiusExpression extends DoubleUnaryExpression {

	public GetRadiusExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((GameObject) this.getExpression().getValue(activeWorm).getValue()).getRadius();
		return new MyDouble(value);
	}


}
