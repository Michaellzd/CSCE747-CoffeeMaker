package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

/**
 * 
 * @author Sarah Heckman
 *
 * Unit tests for CoffeeMaker class.
 */
public class CoffeeMakerTest extends TestCase {
	
	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	/**
	 * Setup of tests
	 */
	protected void setUp() throws Exception {
		cm = new CoffeeMaker();
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
		
		super.setUp();
	}
	
	/**
	 * Already existed.
	 * Adds inventory to coffee maker
	 */
	public void testAddInventory() {
		try {
			cm.addInventory("4","7","0","9");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	
	/**
	 * Already existed.
	 * Adds inventory to coffee maker with invalid inputs
	 */
	public void testAddInventoryException() {
		try {
			cm.addInventory("4", "-1", "asdf", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			//success if thrown
		}
	}
	
	/**
	 * Already existed.
	 * Returns change of purchase
	 */
	public void testMakeCoffee() {
		cm.addRecipe(r1);
		assertEquals(25, cm.makeCoffee(0, 75));
	}
	
	/**
	 * Add and delete recipes
	 * 
	 * This revealed that once a recipe is removed from the recipe book, another
	 * recipe cannot be added to the same spot again. So if you add 2 recipes, remove then 2nd, add a 3rd...
	 * that recipe will be put into the 3rd spot instead of the second.
	 * This was because when a recipes was deleted the index is occupied was filled with a new blank
	 * recipe instead of null.
	 */
	public void testAddAndDeleteRecipes() {
		// First delete all the recipes from previous tests
		int numRecipes = cm.getRecipes().length;
		for(int i=0; i<numRecipes; i++) {
			cm.deleteRecipe(i);
		}
		
		cm.addRecipe(r1); // [r1, null, null, null]
		cm.addRecipe(r2); // [r1, r2, null, null]
		cm.deleteRecipe(1); // [r1, null, null, null]
		assertEquals("Coffee", cm.getRecipes()[0].getName());
		cm.addRecipe(r3); // [r1, r3, null, null]
		cm.addRecipe(r2); // [r1, r3, r2, null]
		cm.deleteRecipe(0); // [null, r3, r2, null]
		assertEquals("Latte", cm.getRecipes()[1].getName());
		cm.addRecipe(r1); // [r1, r3, r2, null]
		cm.addRecipe(r4); // [r1, r3, r2, r4]
		assertEquals("Hot Chocolate", cm.getRecipes()[3].getName());
	}

}
