package worms.model;

import java.util.Map;

import worms.model.Food;
import worms.model.Worm;

public class IsFoodExpression extends BooleanUnaryExpression {

	public IsFoodExpression(Expression e) {
		super(e);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		boolean value;
		if (this.getExpression() == null)
			value = false;
		else
			value = this.getExpression().getValue(activeWorm).getValue() instanceof Food;
		return new MyBoolean(value);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return EntityType.class;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyBooleanType.class;
	}


}
