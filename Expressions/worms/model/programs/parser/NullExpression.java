package worms.model.programs.parser;

import worms.model.Worm;

public class NullExpression extends Expression {

	@Override
	public Object getValue(Worm activeWorm) {
		return null;
	}

}
