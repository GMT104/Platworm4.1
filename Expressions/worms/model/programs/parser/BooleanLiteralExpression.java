package worms.model.programs.parser;

import worms.model.Worm;

public class BooleanLiteralExpression extends Expression {

	private Boolean value;
	
	public BooleanLiteralExpression(boolean b) {
		value = b;
	}
	
	@Override
	public Boolean getValue(Worm activeWorm) {
		return value;
	}

}
