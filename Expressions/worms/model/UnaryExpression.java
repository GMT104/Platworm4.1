package worms.model;

public abstract class UnaryExpression<T> extends Expression<T> {

	private Expression<?> expression;



	public UnaryExpression(Expression<?> e) {
		this.setExpression(e); 
	}
	
	



	public Expression<?> getExpression() {
		return expression;
	}



	public void setExpression(Expression<?> expression) {
		this.expression = expression;
	}

}
