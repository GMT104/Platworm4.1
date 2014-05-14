package worms.model;

import worms.model.Worm;

public class InequalityExpression extends BinaryExpression {

	public InequalityExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return ! this.getLeftExpression().getValue(activeWorm).equals(this.getRightExpression().getValue(activeWorm));
	}

}
