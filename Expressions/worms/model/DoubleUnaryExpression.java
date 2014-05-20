package worms.model;

import worms.model.Worm;

public abstract class DoubleUnaryExpression extends DoubleExpression {

	private Expression expression;



	public DoubleUnaryExpression(Expression e) {
		this.setExpression(e); 
	}
	
	
	



	public Expression getExpression() {
		return expression;
	}



	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
