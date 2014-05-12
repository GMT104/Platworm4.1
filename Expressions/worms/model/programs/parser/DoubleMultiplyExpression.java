package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleMultiplyExpression extends BinaryExpression {

	public DoubleMultiplyExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return ((Double) getLeftExpression().getValue(activeWorm))*((Double) getRightExpression().getValue(activeWorm));
	}

}
