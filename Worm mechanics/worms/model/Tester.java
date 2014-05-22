package worms.model;

import java.util.Random;

import worms.model.programs.ProgramFactory;
import worms.util.Util;

public class Tester {
	public static void main(String[] args) {
		Facade facade = new Facade();
		Random random= new Random(4);
		final double EPS = Util.DEFAULT_EPSILON;
		
//		
		World world = new World(2, 2, new boolean[][] {	{true, true, true, true},
																	{true, true, true, true},
																	{true, true, true, true},
																	{false, false, false, false}
		}, random);
//		System.out.println(world);
//		
//		Worm testWorm = new Worm(1,-1,0,1,"Bob",true,world);
//		System.out.println(testWorm+""+testWorm.getCoordinateX());
//		testWorm.getStatus();
//		try {
//			Worm cloned = worm.clone();
//			System.out.println(worm.getDirection());
//			System.out.println(cloned.getDirection());
//			System.out.println(worm.getWorld());
//			System.out.println(cloned.getWorld());
//			System.out.println(worm.getProjectile());
//			System.out.println(cloned.getProjectile());
//			worm.selectWeapon();
//			System.out.println(worm.getProjectile());
//			System.out.println(cloned.getProjectile());
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		System.out.println(world.isPassableLocation(-3.997110291772664,6.2725013811295165));
		
		
		boolean b = true;
		double c = 6;
		
		Expression<MyBoolean> e1 = new BooleanLiteralExpression(b);
		Expression<MyDouble> e2 = new DoubleLiteralExpression(c);
		new BooleanOrExpression(e1, e1);
		new DoubleAdditionExpression(e2, e2);
		// Shouldn't work: new BooleanOrExpression(e1, e2);
		
		new VariableExpression<Entity>("es",new Entity());
		Expression<Entity> w = null;
		new IsFoodExpression(w);
		// Shouldn't work: new FireStatement(new VariableExpression<MyBoolean>("Bob",new MyDouble(6)));
		// Shouldn't work: new SearchObjectExpression(w);
		
		new VariableExpression<Entity>("es",new Entity());
		
		// Shouldn't work: new VariableExpression<MyDouble>("es",new Entity());
	
	}
	

	
}
