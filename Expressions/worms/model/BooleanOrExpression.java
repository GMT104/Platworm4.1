package worms.model;

import worms.model.Worm;

public class BooleanOrExpression extends BinaryExpression {



	public BooleanOrExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.or((MyBoolean) getLeftExpression().getValue(activeWorm), 
				(MyBoolean) getRightExpression().getValue(activeWorm));
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
