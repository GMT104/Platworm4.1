package worms.model;

import java.util.Map;

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



	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyBoolean.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyBoolean.class;
	}

	
}
