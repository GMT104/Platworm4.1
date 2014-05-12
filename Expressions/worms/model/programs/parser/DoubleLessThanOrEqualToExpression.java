package worms.model.programs.parser;

import worms.model.Worm;

public class DoubleLessThanOrEqualToExpression extends BinaryExpression {

	public DoubleLessThanOrEqualToExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ((Double) getLeftExpression().getValue(activeWorm))<=((Double) getRightExpression().getValue(activeWorm));
	}

}
