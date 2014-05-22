package worms.model;

import java.util.Map;

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

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDouble.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return Entity.class;
	}
}
