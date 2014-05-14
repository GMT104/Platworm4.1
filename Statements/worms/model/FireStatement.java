package worms.model;


import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class FireStatement extends ActionStatement {

	private Expression yieldExpression;

	public FireStatement(Expression yield) {
		this.yieldExpression = yield;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		if (activeWorm.getProjectile().getCostActionPoints() > activeWorm.getActionPoints())
			throw new InsufficientActionPointsException("cannot fire");
		handler.fire(activeWorm, (int) ((double) this.yieldExpression.getValue(activeWorm)));
	}
	

}
