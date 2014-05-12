package worms.model.programs.parser;

import worms.model.Worm;

public class GetDirectionExpression extends UnaryExpression {

	public GetDirectionExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return ((Worm) getExpression().getValue(activeWorm)).getDirection();
	}

}
