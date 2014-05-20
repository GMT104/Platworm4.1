package worms.model;

public abstract class Type {

	public abstract MyObject createObjectWithDefaultValue();

	public abstract Expression createVariableExpression(String name);

	
}
