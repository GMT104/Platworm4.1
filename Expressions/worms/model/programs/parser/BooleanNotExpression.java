package worms.model.programs.parser;

public class BooleanNotExpression extends UnaryExpression {

	public BooleanNotExpression(Expression e) {
		super(e);
	}

	@Override
	public Boolean getValue() {
		return (! (Boolean)getExpression().getValue());
	}

}
