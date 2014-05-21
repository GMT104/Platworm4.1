package worms.model;

import java.util.HashSet;
import java.util.Set;

import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class ToggleWeaponStatement extends ActionStatement {

	@Override
	public void act(Worm activeWorm, IActionHandler handler) {
		handler.toggleWeapon(activeWorm);
	}

	@Override
	public Set<Statement> getAllSubstatements() {
		Set<Statement> set = new HashSet<Statement>();
		set.add(this);
		return set;
	}
	

}
