package worms.model;

import java.util.Map;

import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class WhileStatement extends StatementWithBody {

	private Expression<MyBoolean> condition;
	
	public WhileStatement(Expression<MyBoolean> condition, Statement body) {
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
	public boolean hasExpressionAsInputToCheck() {
		return true;
	}

	@Override
	public Class<? extends Type> getInputType(Map<String, Type> globals) {
		return MyBoolean.class;
	}

	@Override
	public Expression<? extends Type> getInputExpression() {
		return condition;
	}

}
