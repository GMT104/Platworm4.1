package worms.model;

import worms.model.Worm;

public class DoubleSubtractionExpression extends BinaryExpression {

	public DoubleSubtractionExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return ((Double) getLeftExpression().getValue(activeWorm))-((Double) getRightExpression().getValue(activeWorm));
	}

}
