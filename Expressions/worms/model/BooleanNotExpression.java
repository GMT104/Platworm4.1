package worms.model;

import java.util.Map;

import worms.model.Worm;

public class BooleanNotExpression extends UnaryExpression<MyBoolean> {

	public BooleanNotExpression(Expression<MyBoolean> e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyBoolean.not((MyBoolean) this.getExpression().getValue(activeWorm));
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
