package worms.model;

import worms.model.Worm;

public class BooleanNotExpression extends UnaryExpression<MyBoolean> {

	public BooleanNotExpression(Expression<MyBoolean> e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.not((MyBoolean) this.getExpression().getValue(activeWorm));
	}

}
