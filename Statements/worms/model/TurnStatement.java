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
		double angle = ((MyDouble) this.angle.getValue(activeWorm)).getValue();
		if (! activeWorm.canTurn(angle))
			throw new InsufficientActionPointsException("cannot fire");
		handler.turn(activeWorm, angle);
	}



}
