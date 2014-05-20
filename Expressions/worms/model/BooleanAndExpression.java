package worms.model;

import java.util.Map;

import worms.model.Worm;

public class BooleanAndExpression extends BooleanBinaryExpression {



	public BooleanAndExpression(BooleanExpression e1, BooleanExpression e2) {
		super(e1, e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.and((MyBoolean) getLeftExpression().getValue(activeWorm), 
				(MyBoolean) getRightExpression().getValue(activeWorm));
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
