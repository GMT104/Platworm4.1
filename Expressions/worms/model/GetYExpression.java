package worms.model;

import worms.model.Worm;
import worms.model.GameObject;

public class GetYExpression extends UnaryExpression {

	public GetYExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((GameObject) this.getExpression().getValue(activeWorm).getValue()).getCoordinateY();
		return new MyDouble(value);
	}

}
