package worms.model;

import java.util.Map;

import worms.model.Worm;

public class GetMaxHitPointsExpression extends DoubleUnaryExpression {

	public GetMaxHitPointsExpression(EntityExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getMaximumHitPoints();
		return new MyDouble(value);
	}

	@Override
	public Class<? extends Type> getInputType() {
		return EntityType.class;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDoubleType.class;
	}


}
