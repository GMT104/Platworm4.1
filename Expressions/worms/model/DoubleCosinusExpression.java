package worms.model;

import worms.model.Worm;

public class DoubleCosinusExpression extends DoubleUnaryExpression {

	public DoubleCosinusExpression(DoubleExpression e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.cosine((MyDouble) this.getExpression().getValue(activeWorm));
	}

}
