package worms.model;

import java.util.Map;

import worms.model.Worm;

public class VariableExpression<T> extends Expression<T> {

	private String variableName;
	
	public VariableExpression(String name, T type) {
		this.variableName = name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getValue(Worm activeWorm) {
		return  (T) activeWorm.getProgram().getVariable(variableName);
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		System.out.println("         Variable is of type: "+globals.get(variableName).getClass());
		return globals.get(variableName).getClass(); 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}
}
