package worms.model;

import java.util.Map;

import worms.model.Worm;

public abstract class Expression {
	
	public abstract MyObject getValue(Worm activeWorm);
	
	public abstract Class<? extends Type> getInputType();
	
	public abstract Class<? extends Type> getReturnType(Map<String, Type> globals);
}
