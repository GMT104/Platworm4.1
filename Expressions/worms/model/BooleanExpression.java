package worms.model;

public abstract class BooleanExpression extends Expression{

	
	protected abstract MyBoolean getValue (Worm activeWorm);
}
