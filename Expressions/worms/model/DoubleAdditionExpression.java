package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleAdditionExpression extends BinaryExpression<MyDouble> {
	
	public DoubleAdditionExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1, e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDouble.add((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
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
