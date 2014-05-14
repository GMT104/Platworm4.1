package worms.model.programs.parser;


import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class MoveStatement extends ActionStatement {

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		handler.move(activeWorm);
	}




}
