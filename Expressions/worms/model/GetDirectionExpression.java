package worms.model;

import worms.model.Worm;

public class GetDirectionExpression extends UnaryExpression<MyDouble> {

	public GetDirectionExpression(Expression<Entity> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((MovableObject) ( (Entity) this.getExpression().getValue(activeWorm)).getValue()).getDirection();
		return new MyDouble(value);
	}


}
