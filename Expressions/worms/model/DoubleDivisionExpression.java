package worms.model;

import worms.model.Worm;

public class DoubleDivisionExpression extends DoubleBinaryExpression {

	public DoubleDivisionExpression(DoubleExpression e1, DoubleExpression e2) {
		super(e1,e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.divide((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
