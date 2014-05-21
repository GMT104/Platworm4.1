package worms.model;

import be.kuleuven.cs.som.annotate.*;


/**
 * A class describing the attributes and actions of a rifle.
 * 
 * @version 2.4
 * @author 	Gertjan Maenhout (2Bbi Computerwetenschappen - Elektrotechniek) & 
 * 			Harald Schafer (2Bbi Elektrotechniek - Computerwetenschappen)
 */
public class Rifle extends Projectile {
	
	/**
	 * Constructor to make a a projectile from rifle.
	 * 
	 * @param 	coordinateX
	 * 			The x coordinate of a projectile from this new rifle.
	 * @param 	coordinateY
	 * 			The y coordinate of a projectile from this new rifle.
	 * @param 	isActive
	 * 			The status of a projectile from this new rifle.
	 * @param 	world
	 * 			The world of a projectile from this new rifle.
	 * @param 	direction
	 * 			The direction of a projectile from this new rifle.
	 *
	 * @post	The new x coordinate of a projectile from this rifle will be equal to the given coordinateX.
	 * 			| new.getCoordinateX() == coordinateX
	 * @post	The new y coordinate of a projectile from this rifle will be equal to the given coordinateY.
	 * 			| new.getCoordinateY() == coordinateY
	 * @post	The new status of a projectile from this rifle will be equal to the given isActive.
	 * 			| new.getStatus() == isActive
	 * @post	The new world of a projectile from this rifle will be equal to the given world.
	 * 			| new.getWorld() == world
	 * @post	The new mass of a projectile from this rifle will be equal to 0.010 kg.
	 * 			| new.getMass() == 0.010
	 * @post	The new radius of a projectile from this rifle will be deduced from the density and the mass,
	 * 			assuming that the projectile is a spherical object.
	 * 			| new.getRadius() == getRadius(0.010)
	 * @post	The new amount of hit points that a worm will lose, if it is hit
	 * 			by a projectile from this rifle, will be equal to 20.
	 * 			| new.getLostHitPoints() == 20
	 * @post	The new amount of action points that a worm will lose, if it fires a projectile from this rifle,
	 * 			will be equal to 10.
	 * 			| new.getCostActionPoints() == 10
	 * @post	The name of this weapon will be set.
	 * 			| new.getName() == 'Rifle'
	 * 
	 * @effect	If one of the given coordinates is not in this world, the projectile from this rifle is terminated.
	 * 			| if (this.isXCoordinateOutOfBounds(coordinateX) || this.isYCoordinateOutOfBounds(coordinateY))
	 * 			|		then this.terminate()
	 * 
	 * @throws 	ModelException
	 * 			The exception is thrown if one or more of the given parameters are illegal 
	 * 			assignments for a projectile from this rifle.
	 * 			| (! isValidCoordinate(coordinateX)) || (! isValidCoordinate(coordinateY))
	 * 			|		|| (! isValidRadius(radius)) 
	 */
	protected Rifle(double coordinateX, double coordinateY, boolean isActive,
			World world, double direction) throws ModelException {
		super(coordinateX, coordinateY, isActive, world, direction,
				0.010,	20, 10);
		this.setName("Rifle");
	}
	
	
	
	
	/**
	 * Returns the force in Newton at which projectiles from a rifle are propelled.
	 * 
	 * @return	Returns the force.
	 * 			| result == 1.5
	 */
	@Basic
	@Raw
	@Immutable
	protected final double getForce() {
		return 1.5;
	}

}
