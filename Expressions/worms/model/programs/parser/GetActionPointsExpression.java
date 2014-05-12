package worms.model.programs.parser;

import worms.model.Worm;

public class GetActionPointsExpression extends UnaryExpression {

	public GetActionPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return (double) ((Worm) getExpression().getValue(activeWorm)).getActionPoints();
	}

}