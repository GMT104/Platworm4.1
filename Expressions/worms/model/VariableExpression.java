package worms.model;

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
	public Class<? extends Type> getReturnType() {
		// TODO Deze functie moet op een of andere manier toegang hebben tot
		// 		de map globals uit Program om op die manier het juiste return type terug te geven.
		//		Hier zit ik momenteel vast.
		return Type.class;
	}


}
