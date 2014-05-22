package worms.model;

import worms.model.Worm;

public class VariableExpression<T> extends Expression<T> {

	private String variableName;
	
	public VariableExpression(String name, T type) {
		this.variableName = name;
	}

	@Override
	public T getValue(Worm activeWorm) {
		return  (T) activeWorm.getProgram().getVariable(variableName);
	}


}
