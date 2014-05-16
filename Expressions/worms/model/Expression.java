package worms.model;

import worms.model.Worm;

public abstract class Expression {
	
	public abstract MyObject getValue(Worm activeWorm);
	
	public abstract Class<? extends Type> getInputType();
	
	public abstract Class<? extends Type> getReturnType();
}
