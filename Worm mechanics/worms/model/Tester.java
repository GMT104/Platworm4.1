package worms.model;

import static org.junit.Assert.*;

import java.util.Random;

import worms.util.Util;

public class Tester {
	public static void main(String[] args) {
		Facade facade = new Facade();
		Random random= new Random(4);
		final double EPS = Util.DEFAULT_EPSILON;
		
//		
//		World world = new World(2, 2, new boolean[][] {	{true, true, true, true},
//																	{true, true, true, true},
//																	{true, true, true, true},
//																	{false, false, false, false}
//		}, random);
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

	
		
		
		boolean b = true;
		double c = 6;
		
		BooleanExpression e1 = new BooleanLiteralExpression(b);
		DoubleExpression e2 = new DoubleLiteralExpression(c);
		new BooleanOrExpression(e1, e2);
		
		EntityExpression w;
		new IsFoodExpression(w);
	}
}
