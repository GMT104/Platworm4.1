package worms.model.programs.parser;

import worms.model.Food;
import worms.model.Worm;

public class IsFoodExpression extends UnaryExpression {

	public IsFoodExpression(Expression e) {
		super(e);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return this.getExpression().getValue(activeWorm) instanceof Food;
	}

}
