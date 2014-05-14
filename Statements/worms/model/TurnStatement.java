package worms.model;


import worms.gui.game.IActionHandler;
import worms.model.Expression;
import worms.model.Worm;

public class TurnStatement extends ActionStatement {

	private Expression angle;
	
	public TurnStatement(Expression angle) {
		this.angle = angle;
	}

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		if (! activeWorm.canTurn((double) angle.getValue(activeWorm)))
			throw new InsufficientActionPointsException("cannot fire");
		handler.turn(activeWorm, (double) angle.getValue(activeWorm));
	}



}
