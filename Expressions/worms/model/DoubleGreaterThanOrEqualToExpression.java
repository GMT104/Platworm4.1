package worms.model;

import worms.model.Worm;

public class DoubleGreaterThanOrEqualToExpression extends BinaryExpression {

	public DoubleGreaterThanOrEqualToExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ((Double) getLeftExpression().getValue(activeWorm))>=((Double) getRightExpression().getValue(activeWorm));
	}

}