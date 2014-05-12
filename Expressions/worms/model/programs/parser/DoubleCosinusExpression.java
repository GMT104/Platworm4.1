package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleCosinusExpression extends UnaryExpression {

	public DoubleCosinusExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return Math.cos((Double) getExpression().getValue(activeWorm));
	}

}
