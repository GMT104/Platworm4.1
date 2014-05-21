package worms.model;

import worms.model.Worm;

public class EntityVariableExpression extends EntityExpression {

	private String variableName;
	
	public EntityVariableExpression(String name) {
		this.variableName = name;
	}

	@Override
	public Entity getValue(Worm activeWorm) {
		return (Entity) activeWorm.getProgram().getVariable(variableName);
	}



}
