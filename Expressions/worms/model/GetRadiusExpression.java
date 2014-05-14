package worms.model;

import worms.model.Worm;

public class GetRadiusExpression extends UnaryExpression {

	public GetRadiusExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return ((Worm) getExpression().getValue(activeWorm)).getRadius();
	}

}
