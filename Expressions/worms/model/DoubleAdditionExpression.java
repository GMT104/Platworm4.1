package worms.model;

import worms.model.Worm;

public class DoubleAdditionExpression extends DoubleBinaryExpression {
	
	public DoubleAdditionExpression(DoubleExpression e1, DoubleExpression e2) {
		super(e1, e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.add((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
