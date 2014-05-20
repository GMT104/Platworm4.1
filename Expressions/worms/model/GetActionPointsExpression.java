package worms.model;

import java.util.Map;

import worms.model.Worm;

public class GetActionPointsExpression extends DoubleUnaryExpression {

	public GetActionPointsExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		double value = ((Worm) this.getExpression().getValue(activeWorm).getValue()).getActionPoints();
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