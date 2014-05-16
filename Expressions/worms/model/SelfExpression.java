package worms.model;

import worms.model.Worm;

public class SelfExpression extends Expression {

	@Override
	public Entity getValue(Worm activeWorm) {
		return new Entity(activeWorm);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType() {
		return EntityType.class;
	}


}
