package worms.model;

import worms.model.Worm;

public class DoubleSinusExpression extends UnaryExpression {

	public DoubleSinusExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return Math.sin((Double) getExpression().getValue(activeWorm));
	}

}
