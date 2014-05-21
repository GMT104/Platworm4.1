package worms.model;

import worms.model.Worm;
import worms.model.GameObject;

public class GetXExpression extends DoubleUnaryExpression {

	public GetXExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((GameObject) this.getExpression().getValue(activeWorm).getValue()).getCoordinateX();
		return new MyDouble(value);
	}


}
