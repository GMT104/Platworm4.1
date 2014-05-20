package worms.model;

import worms.model.Worm;

public abstract class DoubleBinaryExpression extends DoubleExpression {

	
	private Expression leftExpression;
	private Expression rightExpression;
	
	public DoubleBinaryExpression(Expression e1, Expression e2) {
		this.setLeftExpression(e1);
		this.setRightExpression(e2);
	}
		
	@Override
	public abstract MyDouble getValue(Worm activeWorm);

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