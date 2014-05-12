package worms.model.programs.parser;

import worms.model.Worm;

public abstract class Expression {
	
	public abstract Object getValue(Worm activeWorm);
}
