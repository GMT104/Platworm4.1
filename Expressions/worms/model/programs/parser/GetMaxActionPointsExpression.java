package worms.model.programs.parser;

import worms.model.Worm;

public class GetMaxActionPointsExpression extends UnaryExpression {

	public GetMaxActionPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return (double) ((Worm) this.getExpression().getValue(activeWorm)).getMaximumActionPoints();
	}

}
