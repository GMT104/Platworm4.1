package worms.model;

import worms.model.Worm;

public abstract class Expression {
	
	protected abstract MyObject getValue(Worm activeWorm);
}
