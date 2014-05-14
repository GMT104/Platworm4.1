package worms.model;

import worms.model.Worm;

public class EqualityExpression extends BinaryExpression {

	public EqualityExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return (getLeftExpression().getValue(activeWorm))==(getRightExpression().getValue(activeWorm));
	}

}
