package worms.model;

import java.util.Map;

import worms.model.Worm;

public class BooleanNotExpression extends BooleanUnaryExpression {

	public BooleanNotExpression(BooleanExpression e) {
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
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyBooleanType.class;
	}

}
