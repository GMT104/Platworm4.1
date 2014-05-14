package worms.model;

import worms.model.Worm;

public abstract class UnaryExpression extends Expression {

	private Expression expression;



	public UnaryExpression(Expression e) {
		this.setExpression(e); 
	}
	
	
	
	@Override
	public abstract MyObject getValue(Worm activeWorm);



	public Expression getExpression() {
		return expression;
	}



	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
