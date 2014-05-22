package worms.model;

import worms.model.Worm;

public class BooleanOrExpression extends BinaryExpression<MyBoolean> {



	public BooleanOrExpression(Expression<MyBoolean> e1, Expression<MyBoolean> e2) {
		super(e1, e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBoolean.or((MyBoolean) getLeftExpression().getValue(activeWorm), 
				(MyBoolean) getRightExpression().getValue(activeWorm));
	}


}
