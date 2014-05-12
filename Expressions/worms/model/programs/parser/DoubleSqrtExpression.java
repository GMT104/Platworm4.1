package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleSqrtExpression extends UnaryExpression {

	public DoubleSqrtExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return Math.sqrt(((Double) getExpression().getValue(activeWorm)));
	}

}
