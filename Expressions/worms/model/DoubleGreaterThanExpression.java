package worms.model;

import worms.model.Worm;

public class DoubleGreaterThanExpression extends BinaryExpression {

	public DoubleGreaterThanExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public MyBoolean getValue(Worm activeWorm) {
		return MyDoubleType.greaterThan((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyDoubleType.class;
	}

	@Override
	public Class<? extends Type> getReturnType() {
		return MyBooleanType.class;
	}

}
