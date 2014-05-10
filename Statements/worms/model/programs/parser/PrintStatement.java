package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class PrintStatement extends Statement {

	private Expression expression;
	
	public PrintStatement(Expression e) {
		this.expression = e;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
			System.out.println(expression.getValue());
	}

}
