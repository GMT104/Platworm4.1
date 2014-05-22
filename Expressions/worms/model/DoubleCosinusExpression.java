package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleCosinusExpression extends UnaryExpression<MyDouble> {

	public DoubleCosinusExpression(Expression<MyDouble> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDouble.cosine((MyDouble) this.getExpression().getValue(activeWorm));
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return MyDouble.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyDouble.class;
	}

}
