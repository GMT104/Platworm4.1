package worms.model;

import worms.model.Worm;

public class BooleanAndExpression extends BinaryExpression {



	public BooleanAndExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.and((MyBoolean) getLeftExpression().getValue(activeWorm), 
				(MyBoolean) getRightExpression().getValue(activeWorm));
	}

}
