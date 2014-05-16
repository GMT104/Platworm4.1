package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleSqrtExpression extends UnaryExpression {

	public DoubleSqrtExpression(Expression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.squareRoot((MyDouble) this.getExpression().getValue(activeWorm));
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyDoubleType.class;
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDoubleType.class;
	}
}
