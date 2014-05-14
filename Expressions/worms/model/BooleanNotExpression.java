package worms.model;

import worms.model.Worm;

public class BooleanNotExpression extends UnaryExpression {

	public BooleanNotExpression(Expression e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.not((MyBoolean) this.getExpression().getValue(activeWorm));
	}

}
