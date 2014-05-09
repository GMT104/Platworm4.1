package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class ToggleWeaponStatement extends Statement {

	@Override
	public void execute(Worm activeWorm, IActionHandler handler) {
		handler.toggleWeapon(activeWorm);
	}

}
