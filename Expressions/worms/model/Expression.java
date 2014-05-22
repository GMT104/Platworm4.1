package worms.model;

import java.util.Map;

import worms.model.Worm;

public abstract class Expression<O> {
	
	protected abstract O getValue(Worm activeWorm);

	public abstract Class<? extends Type> getReturnType(Map<String, Type> globals);

	public abstract Class<? extends Type> getInputType();
}
