package worms.model;

import worms.model.Worm;

public class GetHitPointsExpression extends UnaryExpression<MyDouble> {

	public GetHitPointsExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) ((Entity) this.getExpression().getValue(activeWorm)).getValue()).getHitPoints();
		return new MyDouble(value);
	}


}
