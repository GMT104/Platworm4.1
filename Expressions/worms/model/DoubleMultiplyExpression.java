package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleMultiplyExpression extends DoubleBinaryExpression {

	public DoubleMultiplyExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.multiply((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
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
