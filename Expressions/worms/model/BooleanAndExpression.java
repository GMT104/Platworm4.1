package worms.model;

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


}
