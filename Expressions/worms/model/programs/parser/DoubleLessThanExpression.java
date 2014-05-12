package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleLessThanExpression extends BinaryExpression {

	public DoubleLessThanExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ((double) getLeftExpression().getValue(activeWorm))<((double) getRightExpression().getValue(activeWorm));
	}

}
