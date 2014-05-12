package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleLiteralExpression extends Expression {

	private double d;

	public DoubleLiteralExpression(double d) {
		this.d = d;
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return this.d;
	}

}
