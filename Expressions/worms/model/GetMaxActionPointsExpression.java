package worms.model;

import worms.model.Worm;

public class GetMaxActionPointsExpression extends UnaryExpression<MyDouble>{

	public GetMaxActionPointsExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) ((Entity) this.getExpression().getValue(activeWorm)).getValue()).getMaximumActionPoints();
		return new MyDouble(value);
	}


}
