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

	@Override
	public Class<? extends Type> getInputType() {
		return MyBooleanType.class;
	}

	@Override
	public Class<? extends Type> getReturnType() {
		return MyBooleanType.class;
	}

}
