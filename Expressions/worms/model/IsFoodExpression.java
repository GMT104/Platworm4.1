package worms.model;

import worms.model.Food;
import worms.model.Worm;

public class IsFoodExpression extends UnaryExpression<MyBoolean>{

	public IsFoodExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		boolean value;
		if (this.getExpression() == null)
			value = false;
		else
			value = ((Entity) this.getExpression().getValue(activeWorm)).getValue() instanceof Food;
		return new MyBoolean(value);
	}


}
