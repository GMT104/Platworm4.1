package worms.model.programs.parser;

import java.util.List;

import worms.model.*;

public class SearchObjectExpression extends UnaryExpression {
	
	public SearchObjectExpression(Expression e) {
		super(e); 
	}

	@Override
	public GameObject getValue(Worm activeWorm) {
		System.out.println("Active worm: "+activeWorm);
		System.out.println("Searching object");

		World world = activeWorm.getWorld();
		double direction = activeWorm.getDirection()+ (double) this.getExpression().getValue(activeWorm);
		double step = world.getStep(activeWorm.getRadius());
		double x = activeWorm.getCoordinateX();
		double y = activeWorm.getCoordinateY();
		List<GameObject> objects = world.getGameObjects();
		System.out.println("Objects: "+objects);
		
		for (int i=0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Projectile)
				objects.remove(i);
		}
		
		objects.remove(activeWorm);
		
		while(world.isInWorld(x, y, step)) {
			for(GameObject object: objects) { 
				if (GameObject.overlaps(object.getCoordinateX(), object.getCoordinateY(), object.getRadius(), 
						x, y, step)) {
					System.out.println("Object found");
					System.out.println("object: "+object);
					return object;
				}
			}
			x = x + step*Math.cos(direction);
			y = y + step*Math.sin(direction);
		}
		return null;
	}

}
