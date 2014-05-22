package worms.model;

import worms.model.Worm;

public class VariableExpression<Type> extends Expression<Type> {

	private String variableName;
	
	public VariableExpression(String name, Type type) {
		this.variableName = name;
	}

	@Override
	public Type getValue(Worm activeWorm) {
		return  (Type) activeWorm.getProgram().getVariable(variableName);
	}


}
