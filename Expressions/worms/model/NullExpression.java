package worms.model;

import worms.model.Worm;

public class NullExpression extends Expression {

	@Override
	public MyObject getValue(Worm activeWorm) {
		return null;
	}

}
