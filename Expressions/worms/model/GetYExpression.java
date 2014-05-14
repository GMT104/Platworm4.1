package worms.model;

import worms.model.Worm;
import worms.model.GameObject;

public class GetYExpression extends UnaryExpression {

	public GetYExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return ((GameObject) this.getExpression().getValue(activeWorm)).getCoordinateY();
	}

}
