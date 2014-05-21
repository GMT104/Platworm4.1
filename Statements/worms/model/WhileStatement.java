package worms.model;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class WhileStatement extends StatementWithBody {

	private Expression condition;
	
	public WhileStatement(BooleanExpression condition, Statement body) {
		super(body);
		this.condition = condition;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		while (((MyBoolean) condition.getValue(activeWorm)).getValue()) {
			for(Statement subStatement:this.getAllSubstatements()){
				subStatement.setHasBeenRunAlready(false);
			}
			getBodyStatement().run(activeWorm,handler);
		}
		this.setHasBeenRunAlready(true);
	}

}
