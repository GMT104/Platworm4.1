package worms.model;

import worms.model.Worm;

public class SelfExpression extends Expression {

	@Override
	public Entity getValue(Worm activeWorm) {
		return new Entity(activeWorm);
	}

}
