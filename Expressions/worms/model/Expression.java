package worms.model;

import worms.model.Worm;

public abstract class Expression<O> {
	
	protected abstract O getValue(Worm activeWorm);
}
