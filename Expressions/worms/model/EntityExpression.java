package worms.model;

public abstract class EntityExpression extends Expression {

	
	protected abstract Entity getValue(Worm activeWorm); 
}
