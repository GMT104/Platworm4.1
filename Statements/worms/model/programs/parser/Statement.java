package worms.model.programs.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import worms.model.Food;
import worms.model.GameObject;
import worms.model.World;
import worms.model.Worm;
import worms.model.programs.ProgramFactory.ForeachType;

public  abstract class Statement {

	private final List<Statement> subStatements = new ArrayList<Statement>();
	private World world;
	public abstract void execute();
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
	
