package worms.model;

import worms.model.Worm;

public class VariableExpression extends Expression {

	private String variableName;
	
	public VariableExpression(String name) {
		this.variableName = name;
	}

	@Override
	public Object getValue(Worm activeWorm) {
		return activeWorm.getProgram().getVariable(variableName);
	}
}
