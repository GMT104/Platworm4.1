package worms.model;

import java.util.Map;

import worms.model.Worm;

public class VariableExpression extends Expression {

	private String variableName;
	
	public VariableExpression(String name) {
		this.variableName = name;
	}

	@Override
	public MyObject getValue(Worm activeWorm) {
		return activeWorm.getProgram().getVariable(variableName);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		System.out.println("      Variable of type: "+globals.get(variableName).getClass());
		return globals.get(variableName).getClass();
	}


}
