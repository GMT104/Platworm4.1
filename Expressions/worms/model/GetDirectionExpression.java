package worms.model;

import worms.model.Worm;

public class GetDirectionExpression extends UnaryExpression {

	public GetDirectionExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((MovableObject) this.getExpression().getValue(activeWorm).getValue()).getDirection();
		return new MyDouble(value);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return EntityType.class;
	}

	@Override
	public Class<? extends Type> getReturnType() {
		return MyDoubleType.class;
	}

}
