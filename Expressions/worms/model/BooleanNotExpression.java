package worms.model;

import worms.model.Worm;

public class BooleanNotExpression extends UnaryExpression {

	public BooleanNotExpression(Expression e) {
		super(e);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return (! (Boolean)getExpression().getValue(activeWorm));
	}

}
