package worms.model.programs.parser;

import java.util.List;

import worms.model.*;

public class SearchObjectExpression extends UnaryExpression {
	
	public SearchObjectExpression(Expression e) {
		super(e); 
	}

	@Override
	public GameObject getValue(Worm activeWorm) {
		World world = activeWorm.getWorld();
		double direction = activeWorm.getDirection()+ (double) this.getExpression().getValue(activeWorm);
		double step = world.getStep(Worm.getMinimumRadius());
		double x = activeWorm.getCoordinateX();
		double y = activeWorm.getCoordinateY();
		List<GameObject> objects = world.getGameObjects();
		
		objects.remove(activeWorm);
		while(world.isInWorld(x, y, step)) {
			for(GameObject object: objects) { 
				if (GameObject.overlaps(object.getCoordinateX(), object.getCoordinateY(), object.getRadius(), 
						x, y, step)) {
					return object;
				}
			}
			x = x + step*Math.cos(direction);
			y = y + step*Math.sin(direction);
		}
		return null;
	}

}
