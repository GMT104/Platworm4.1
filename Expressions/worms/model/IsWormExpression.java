package worms.model;

import worms.model.Worm;

public class IsWormExpression extends UnaryExpression {
	
	public IsWormExpression(Expression e) {
		super(e);
	}

	@Override
	public Boolean getValue(Worm activeWorm) {
		if (this.getExpression() == null) {
			System.out.println("Expression is null");
			return false;}	
		return this.getExpression().getValue(activeWorm) instanceof Worm;
	}

}
