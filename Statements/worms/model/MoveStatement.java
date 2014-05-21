package worms.model;


import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class MoveStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		if (! activeWorm.canMove())
			throw new InsufficientActionPointsException("cannot move");
		handler.move(activeWorm);
	}


}
