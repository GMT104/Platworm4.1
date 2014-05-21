package worms.model;

import worms.model.Worm;

public class NullExpression extends Expression<MyObject> {

	@Override
	public MyObject getValue(Worm activeWorm) {
		return null;
	}

}
