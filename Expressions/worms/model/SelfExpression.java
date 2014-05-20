package worms.model;

import java.util.Map;

import worms.model.Worm;

public class SelfExpression extends EntityExpression {

	@Override
	public Entity getValue(Worm activeWorm) {
		return new Entity(activeWorm);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return null;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return EntityType.class;
	}


}
