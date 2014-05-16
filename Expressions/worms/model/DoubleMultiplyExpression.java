package worms.model;

import worms.model.Worm;

public class DoubleMultiplyExpression extends BinaryExpression {

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
	public Class<? extends Type> getReturnType() {
		return MyDoubleType.class;
	}
}
