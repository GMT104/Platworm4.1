package worms.model;

import be.kuleuven.cs.som.annotate.*;


/**
 * A class describing the attributes and actions of a bazooka.
 * 
 * @version 2.7
 * @author 	Gertjan Maenhout (2Bbi Computerwetenschappen - Elektrotechniek) & 
 * 			Harald Schafer (2Bbi Elektrotechniek - Computerwetenschappen)
 */
public class Bazooka extends Projectile {
	

	/**
	 * Constructor to make a a projectile from bazooka.
	 * 
	 * @param 	coordinateX
	 * 			The x coordinate of a projectile from this new bazooka.
	 * @param 	coordinateY
	 * 			The y coordinate of a projectile from this new bazooka.
	 * @param 	isActive
	 * 			The status of a projectile from this new bazooka.
	 * @param 	world
	 * 			The world of a projectile from this new bazooka.
	 * @param 	direction
	 * 			The direction of a projectile from this new bazooka.
	 *
	 * @post	The new x coordinate of a projectile from this bazooka will be equal to the given coordinateX.
	 * 			| new.getCoordinateX() == coordinateX
	 * @post	The new y coordinate of a projectile from this bazooka will be equal to the given coordinateY.
	 * 			| new.getCoordinateY() == coordinateY
	 * @post	The new status of a projectile from this bazooka will be equal to the given isActive.
	 * 			| new.getStatus() == isActive
	 * @post	The new world of a projectile from this bazooka will be equal to the given world.
	 * 			| new.getWorld() == world
	 * @post	The new mass of a projectile from this bazooka will be equal to 0.300 kg.
	 * 			| new.getMass() == 0.300
	 * @post	The new radius of a projectile from this bazooka will be deduced from the density and the mass,
	 * 			assuming that the projectile is a spherical object.
	 * 			| new.getRadius() == getRadius(0.300)
	 * @post	The new amount of hit points that a worm will lose, if it is hit
	 * 			by a projectile from this bazooka, will be equal to 80.
	 * 			| new.getLostHitPoints() == 80
	 * @post	The new amount of action points that a worm will lose, if it fires a projectile from this bazooka,
	 * 			will be equal to 50.
	 * 			| new.getCostActionPoints() == 50
	 * @post	The name of this weapon will be set.
	 * 			| new.getName() == 'Bazooka'
	 * 
	 * @effect	If one of the given coordinates is not in this world, the projectile from this bazooka is terminated.
	 * 			| if (this.isXCoordinateOutOfBounds(coordinateX) || this.isYCoordinateOutOfBounds(coordinateY))
	 * 			|		then this.terminate()
	 * 
	 * @throws 	ModelException
	 * 			The exception is thrown if one or more of the given parameters are illegal 
	 * 			assignments for a projectile from this bazooka.
	 * 			| (! isValidCoordinate(coordinateX)) || (! isValidCoordinate(coordinateY))
	 * 			|		|| (! isValidRadius(radius)) 
	 */
	protected Bazooka(double coordinateX, double coordinateY, boolean isActive,
			World world, double direction) throws ModelException {
		super(coordinateX, coordinateY, isActive, world, direction,
				0.300, 80, 50);
		this.setName("Bazooka");
	}
	
	
	
	
	/**
	 * Returns the force in Newton at which projectiles from 
	 * a bazooka are propelled, respectively to the propulsion yield.
	 * 
	 * @return	Returns the force.
	 * 			| result == (2.5 + this.getYield()*0.07)
	 */
	@Raw
	protected double getForce() {
		return (2.5 + this.getYield()*0.07);
	}

}
