package worms.model;

import worms.model.Worm;

public class DoubleCosinusExpression extends UnaryExpression<MyDouble> {

	public DoubleCosinusExpression(Expression<MyDouble> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.cosine((MyDouble) this.getExpression().getValue(activeWorm));
	}

}
