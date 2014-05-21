package worms.model;

import worms.model.Worm;

public class BooleanAndExpression extends BinaryExpression<MyBoolean> {



	public BooleanAndExpression(Expression<MyBoolean> e1, Expression<MyBoolean> e2) {
		super(e1, e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.and((MyBoolean) getLeftExpression().getValue(activeWorm), 
				(MyBoolean) getRightExpression().getValue(activeWorm));
	}


}
