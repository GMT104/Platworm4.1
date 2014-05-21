package worms.model;

import worms.model.Worm;

public class BooleanOrExpression extends BooleanBinaryExpression {



	public BooleanOrExpression(BooleanExpression e1, BooleanExpression e2) {
		super(e1, e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBooleanType.or((MyBoolean) getLeftExpression().getValue(activeWorm), 
				(MyBoolean) getRightExpression().getValue(activeWorm));
	}


}
