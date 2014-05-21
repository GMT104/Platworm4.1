package worms.model;

import worms.model.Worm;

public class GetDirectionExpression extends DoubleUnaryExpression {

	public GetDirectionExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((MovableObject) this.getExpression().getValue(activeWorm).getValue()).getDirection();
		return new MyDouble(value);
	}


}
