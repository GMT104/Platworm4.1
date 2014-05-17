package worms.model;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class WhileStatement extends StatementWithBody {

	private Expression condition;
	
	public WhileStatement(Expression condition, Statement body) {
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


	@Override
	public Class<? extends Type> getInputType() {
		return MyBooleanType.class;
	}

	@Override
	public boolean hasExpressionAsInputToCheck() {
		return true;
	}

	@Override
	public Expression getInputExpression() {
		return condition;
	}


}
