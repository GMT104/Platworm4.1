package worms.model.programs.parser;

import java.util.ArrayList;
import java.util.List;
import worms.gui.game.IActionHandler;
import worms.model.World;
import worms.model.Worm;

public  abstract class Statement {

	private final List<Statement> subStatements = new ArrayList<Statement>();
	private World world;
	public abstract void execute(Worm activeWorm,IActionHandler handler );
	public List<Statement> getSubStatements() {
		return subStatements;
	}
	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}
	
}
	
