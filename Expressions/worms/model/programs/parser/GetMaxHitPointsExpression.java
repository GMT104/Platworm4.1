package worms.model.programs.parser;

import worms.model.Worm;

public class GetMaxHitPointsExpression extends UnaryExpression {

	public GetMaxHitPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public Double getValue(Worm activeWorm) {
		return (double) ((Worm) this.getExpression().getValue(activeWorm)).getMaximumHitPoints();
	}

}
