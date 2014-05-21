package worms.model;

import worms.model.Worm;

public class DoubleVariableExpression extends DoubleExpression {

	private String variableName;
	
	public DoubleVariableExpression(String name) {
		this.variableName = name;
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return (MyDouble) activeWorm.getProgram().getVariable(variableName);
	}

}
