package worms.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TeamTest {

	private World world;
	private Worm John;
	private Worm Fitzgerald;
	
	@Before
	public void setUp() {
		Random random= new Random(4);
		world = new World(2,2,new boolean[][] {	{true, true, true, true},
														{true, true, true, true},
														{true, true, true, true},
														{false, false, false, false}	},random);
		John = new Worm(1,1,0,1,"John",true,world,null);
		Fitzgerald = new Worm(1,1,0,1,"Fitzgerald",true,world,null);
	}

	@Test
	public void testConstructorLegalCase() {
		Team team = new Team("Team");
		assertEquals(team.getName(), "Team");
	}
	
	@Test(expected = ModelException.class)
	public void testConstructorIllegalCaseNameTooShort() {
		new Team("T");
	}
	
	@Test(expected=ModelException.class)
	public void testConstructorIllegalCaseNameNoStartCapital() {
		new Team("team");
	}
	
	@Test(expected=ModelException.class)
	public void testConstructorIllegalCaseNameNotAllLetters() {
		new Team("Team 0/'");
	}
	
	@Test
	public void testGetLivingWorms() {
		Team team = new Team("Team");
		John.joinTeam(team);
		Fitzgerald.joinTeam(team);
		assertTrue(team.getLivingWorms().contains(John));
		assertTrue(team.getLivingWorms().contains(Fitzgerald));
	}
	
	@Test
	public void testRemoveFromTeam() {
		Team team = new Team("Team");
		John.joinTeam(team);
		Fitzgerald.joinTeam(team);
		assertTrue(team.getLivingWorms().contains(John));
		assertTrue(team.getLivingWorms().contains(Fitzgerald));
		
		team.removeFromTeam(Fitzgerald);
		assertTrue(team.getLivingWorms().contains(John));
		assertFalse(team.getLivingWorms().contains(Fitzgerald));
	}
	
}
