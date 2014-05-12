package worms.model.programs.parser;

import worms.model.Worm;

public class GetHitPointsExpression extends UnaryExpression {

	public GetHitPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return (double) ((Worm) getExpression().getValue(activeWorm)).getHitPoints();
	}

}
