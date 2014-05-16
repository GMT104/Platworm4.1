package worms.model;

import java.util.Map;

import worms.model.Worm;

public class NullExpression extends Expression {

	@Override
	public MyObject getValue(Worm activeWorm) {
		return null;
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return EntityType.class;
	}


}
