package worms.model;

import worms.model.Worm;

public class DoubleAdditionExpression extends BinaryExpression<MyDouble> {
	
	public DoubleAdditionExpression(Expression<MyDouble> e1, Expression<MyDouble> e2) {
		super(e1, e2);
	}

	@Override
	public MyDouble getValue(Worm activeWorm) {
		return MyDoubleType.add((MyDouble) this.getLeftExpression().getValue(activeWorm), 
				(MyDouble) this.getRightExpression().getValue(activeWorm));
	}


}
