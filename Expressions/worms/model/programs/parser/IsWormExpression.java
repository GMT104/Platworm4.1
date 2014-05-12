package worms.model.programs.parser;

import worms.model.Worm;

public class IsWormExpression extends UnaryExpression {

	public IsWormExpression(Expression e) {
		super(e);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		return this.getExpression().getValue(activeWorm) instanceof Worm;
	}

}
