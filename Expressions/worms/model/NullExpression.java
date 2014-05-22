package worms.model;

import worms.model.Worm;

public class NullExpression extends Expression<Type> {

	@Override
	public Type getValue(Worm activeWorm) {
		return null;
	}

}
