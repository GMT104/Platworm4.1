package worms.model;

import java.util.Map;

import worms.model.Worm;

public class NullExpression extends Expression<Type> {

	@Override
	public Type getValue(Worm activeWorm) {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return Entity.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	
}
