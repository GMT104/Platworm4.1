package worms.model;

import worms.gui.game.IActionHandler;
import worms.model.Worm;


public class JumpStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		if  ( 0 >= activeWorm.getActionPoints())
			throw new InsufficientActionPointsException("cannot jump");
		handler.jump(activeWorm);
	}

}
