package worms.model;


import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class MoveStatement extends ActionStatement {

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		//TODO checkt niet alleen AP
		if (! activeWorm.canMove())
			throw new InsufficientActionPointsException("cannot move");
		handler.move(activeWorm);
	}




}
