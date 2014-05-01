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
	
	
	//Ik dacht zo met anonymous classes te werken voor alle gevallen van statements, geen idee of dat werkt of wenselijk is
	// Ik heb dit geschreven als voorbeeld zodat je begrijpt wat ik bedoel.
	Statement forEachStatement = new Statement() {
		private ForeachType type;
		
		public void execute() {
			if (this.type == ForeachType.WORM)
				for(Worm worm: world.getAllWorms()){
					// assign worm to the given name 
					for(Statement subStatement: subStatements){
						subStatement.execute();
					}
				}
			else if (this.type == ForeachType.FOOD)
				for(Food food: world.getAllFood()){
					// assign food to the given name
					for(Statement subStatement: subStatements){
						subStatement.execute();
					}
				}
			else
				for(GameObject gameObject: world.getGameObjects()){
					// assign gameObject to the given name
					for(Statement subStatement: subStatements){
						subStatement.execute();
					}
				}
			
		}
			
		};

}
