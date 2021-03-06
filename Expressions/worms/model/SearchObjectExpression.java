package worms.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchObjectExpression extends UnaryExpression<Entity> {
	
	public SearchObjectExpression(Expression<MyDouble> e) {
		super(e); 
	}

	@Override
	public Entity getValue(Worm activeWorm) {

		World world = activeWorm.getWorld();
		double direction = activeWorm.getDirection()+ ((MyDouble) this.getExpression().getValue(activeWorm)).getValue();
		double step = world.getStep(activeWorm.getRadius());
		double x = activeWorm.getCoordinateX();
		double y = activeWorm.getCoordinateY();
		List<GameObject> objects = new ArrayList<GameObject>();
		for(Worm worm: world.getAllWorms()){
			objects.add(worm);
		}
		for(Food food: world.getAllFood()){
			objects.add(food);
		}		
		for (int i=0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Projectile)
				objects.remove(i);
		}
		
		objects.remove(activeWorm);		
		while(world.isInWorld(x, y, step)) {
			for(GameObject object: objects) { 
				if (GameObject.overlaps(object.getCoordinateX(), object.getCoordinateY(), object.getRadius()*0.5, 
						x, y, step)) {
					return new Entity(object);
				}
			}
			x = x + step*Math.cos(direction);
			y = y + step*Math.sin(direction);
		}
		return new Entity(null);
	}

	@Override
	public Class<? extends Type> getReturnType(Map<String, Type> globals) {
		return Entity.class; 
	}

	@Override
	public Class<? extends Type> getInputType() {
		return MyDouble.class;
	}


}
