package worms.model;

import java.util.Map;

import worms.model.Worm;

public class EntityVariableExpression extends EntityExpression {

	private String variableName;
	
	public EntityVariableExpression(String name) {
		this.variableName = name;
	}

	@Override
	public Entity getValue(Worm activeWorm) {
		return activeWorm.getProgram().getVariable(variableName);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		System.out.println("      Variable of expression has type: "+globals.get(variableName).getClass());
		return globals.get(variableName).getClass();
	}


}
