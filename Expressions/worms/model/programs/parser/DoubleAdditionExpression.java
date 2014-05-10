package worms.model.programs.parser;

public class DoubleAdditionExpression extends BinaryExpression {

	
	public DoubleAdditionExpression(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public Double getValue() {
		return ((Double)getLeftExpression().getValue() + (Double)getRightExpression().getValue());
	}

}
