package worms.model;

public abstract class EntityUnaryExpression extends EntityExpression{

	private Expression expression;



	public EntityUnaryExpression(Expression e) {
		this.setExpression(e); 
	}
	
	
	



	public Expression getExpression() {
		return expression;
	}



	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
