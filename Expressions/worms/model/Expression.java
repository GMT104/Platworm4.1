package worms.model;

import worms.model.Worm;

public abstract class Expression {
	
	public abstract MyObject getValue(Worm activeWorm);
}
