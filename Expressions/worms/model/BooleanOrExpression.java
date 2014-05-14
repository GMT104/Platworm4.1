package worms.model;

import worms.model.Worm;

public class BooleanOrExpression extends BinaryExpression {



	public BooleanOrExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ((Boolean) getLeftExpression().getValue(activeWorm) || (Boolean) getRightExpression().getValue(activeWorm));
	}

}
