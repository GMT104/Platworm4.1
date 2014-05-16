package worms.model;

import worms.model.Worm;
import worms.model.GameObject;

public class GetXExpression extends UnaryExpression {

	public GetXExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((GameObject) this.getExpression().getValue(activeWorm).getValue()).getCoordinateX();
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
