package worms.model;

import worms.model.Worm;

public class IsWormExpression extends BooleanUnaryExpression {
	
	public IsWormExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		boolean value;
		if (this.getExpression() == null)
			value = false;
		else
			value = this.getExpression().getValue(activeWorm).getValue() instanceof Worm;
		return new MyBoolean(value);
	}


}
