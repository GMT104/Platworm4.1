package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleMultiplyExpression extends BinaryExpression<MyDouble> {

	public DoubleMultiplyExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDouble.multiply((MyDouble) this.getLeftExpression().getValue(activeWorm), 
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
