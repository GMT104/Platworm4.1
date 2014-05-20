package worms.model;

public class EntityType extends Type {

	@Override
	public Entity createObjectWithDefaultValue() {
		return null;
	}
	
	
	@Override
	public EntityExpression createVariableExpression(String name) {
		return new EntityVariableExpression(name);
	}

	
	
}
