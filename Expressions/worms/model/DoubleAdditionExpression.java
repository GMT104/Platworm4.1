package worms.model;

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


}
