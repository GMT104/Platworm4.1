package worms.model;

import worms.model.Worm;

public class DoubleCosinusExpression extends UnaryExpression<MyDouble> {

	public DoubleCosinusExpression(Expression<MyDouble> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDouble.cosine((MyDouble) this.getExpression().getValue(activeWorm));
	}

}
