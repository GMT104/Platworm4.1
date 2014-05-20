package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleCosinusExpression extends DoubleUnaryExpression {

	public DoubleCosinusExpression(DoubleExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.cosine((MyDouble) this.getExpression().getValue(activeWorm));
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
