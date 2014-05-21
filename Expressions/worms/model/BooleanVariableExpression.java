package worms.model;

import worms.model.Worm;

public class BooleanVariableExpression extends BooleanExpression {

	private String variableName;
	
	public BooleanVariableExpression(String name) {
		this.variableName = name;
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return (MyBoolean) activeWorm.getProgram().getVariable(variableName);
	}


}
