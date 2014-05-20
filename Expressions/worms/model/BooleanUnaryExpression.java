package worms.model;

import worms.model.Worm;

public abstract class BooleanUnaryExpression extends BooleanExpression {

	private Expression expression;



	public BooleanUnaryExpression(Expression e) {
		this.setExpression(e); 
	}
	
	



	public Expression getExpression() {
		return expression;
	}



	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
