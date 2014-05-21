package worms.model;

import worms.model.Worm;

public class GetMaxHitPointsExpression extends UnaryExpression<MyDouble> {

	public GetMaxHitPointsExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) ((Entity) this.getExpression().getValue(activeWorm)).getValue()).getMaximumHitPoints();
		return new MyDouble(value);
	}

}
