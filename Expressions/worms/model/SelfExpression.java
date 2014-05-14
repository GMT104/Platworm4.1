package worms.model;

import worms.model.Worm;

public class SelfExpression extends Expression {

	@Override
	public Worm getValue(Worm activeWorm) {
		return activeWorm;
	}

}
