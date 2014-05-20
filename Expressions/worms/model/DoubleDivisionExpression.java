package worms.model;

import java.util.Map;

import worms.model.Worm;

public class DoubleDivisionExpression extends DoubleBinaryExpression {

	public DoubleDivisionExpression(Expression e1, Expression e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.divide((MyDouble) this.getLeftExpression().getValue(activeWorm), 
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
