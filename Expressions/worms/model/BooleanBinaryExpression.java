package worms.model;

import worms.model.Worm;

public abstract class BooleanBinaryExpression extends BooleanExpression {

	
	private Expression leftExpression;
	private Expression rightExpression;
	
	public BooleanBinaryExpression(Expression e1, Expression e2) {
		this.setLeftExpression(e1);
		this.setRightExpression(e2);
	}
		
	@Override
	public abstract MyBoolean getValue(Worm activeWorm);

	public Expression getLeftExpression() {
		return leftExpression;
	}

	public void setLeftExpression(Expression leftExpression) {
		this.leftExpression = leftExpression;
	}

	public Expression getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(Expression rightExpression) {
		this.rightExpression = rightExpression;
	}


}
