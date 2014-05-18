package worms.model;


/**
 * A class describing the attributes and actions of a food.
 * 
 * @version 2.02
 * @author 	Gertjan Maenhout (2Bbi Computerwetenschappen - Elektrotechniek) & 
 * 			Harald Schafer (2Bbi Elektrotechniek - Computerwetenschappen)
 */
public class Food extends GameObject {

	/**
	 * Constructor to make a new food.
	 * 
	 * @param 	coordinateX
	 * 			The x coordinate of this new food.
	 * @param 	coordinateY
	 * 			The y coordinate of this new food.
	 * @param	radius
	 * 			The radius of this new food.
	 * @param 	isActive
	 * 			The status of this new food.
	 * @param 	world
	 * 			The world of this new food.
	 * 
	 * @post	The new x coordinate of this food will be equal to the given coordinateX.
	 * 			| new.getCoordinateX() == coordinateX
	 * @post	The new y coordinate of this food will be equal to the given coordinateY.
	 * 			| new.getCoordinateY() == coordinateY
	 * @post	The new status of this food will be equal to the given isActive.
	 * 			| new.getStatus() == isActive
	 * @post	The new world of this food will be equal to the given world.
	 * 			| new.getWorld() == world
	 * 
	 * @throws	ModelException
	 * 			The exception is thrown if one or more of the given parameters are illegal 
	 * 			assignments for this food.
	 * 			| (! isValidCoordinate(coordinateX)) || (! isValidCoordinate(coordinateY))
	 * 			|		|| (! isValidRadius(radius))
	 */
	protected Food(double coordinateX, double coordinateY, boolean isActive, World world) 
			throws ModelException {
		super(coordinateX, coordinateY, isActive, 0.20,world);
	}

	
	
	
	/**
	 * Returns whether this food has a valid radius.
	 * 
	 * @param	radius
	 * 			The radius that needs to be checked.
	 * 
	 * @return	Returns whether the given radius is positive.
	 * 			| result == (radius > 0)
	 */
	@Override
	protected boolean isValidRadius(double radius) {
		return (radius > 0);
	}

	
	
	
	@Override
	protected Food clone() throws CloneNotSupportedException {
		return (Food) super.clone();
	}
	
}
