package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleSinusExpression extends UnaryExpression<MyDouble> {

	public DoubleSinusExpression(Expression<MyDouble> e) {
		super(e);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDouble.sine((MyDouble) this.getExpression().getValue(activeWorm));
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
