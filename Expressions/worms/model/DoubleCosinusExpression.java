package worms.model;

import worms.model.Worm;

public class DoubleCosinusExpression extends UnaryExpression {

	public DoubleCosinusExpression(Expression e) {
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
	public Class<? extends Type> getReturnType() {
		return MyDoubleType.class;
	}

}
