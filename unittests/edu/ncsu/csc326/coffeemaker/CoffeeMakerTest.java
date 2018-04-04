package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertNotNull;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

/**
 * 
 * @author Sarah Heckman
 *
 *         Unit tests for CoffeeMaker class.
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

		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");

		// Set up for r4
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
	 * Adds inventory to coffee maker
	 */
	public void testAddInventory() {
		try {
			String inv = cm.checkInventory();
			String[] invParts = inv.split(": ");
			int coffee = Integer.parseInt(invParts[1].split("\n")[0]);
			int milk = Integer.parseInt(invParts[2].split("\n")[0]);
			int sugar = Integer.parseInt(invParts[3].split("\n")[0]);
			int chocolate = Integer.parseInt(invParts[4].split("\n")[0]);

			cm.addInventory("5", "8", "2", "4");

			String inv1 = cm.checkInventory();
			String[] invParts1 = inv1.split(": ");
			int coffee1 = Integer.parseInt(invParts1[1].split("\n")[0]);
			int milk1 = Integer.parseInt(invParts1[2].split("\n")[0]);
			int sugar1 = Integer.parseInt(invParts1[3].split("\n")[0]);
			int chocolate1 = Integer.parseInt(invParts1[4].split("\n")[0]);

			assertEquals(coffee1, coffee + 5);
			assertEquals(milk1, milk + 8);
			assertEquals(sugar1, sugar + 2);
			assertEquals(chocolate1, chocolate + 4);
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	/**
	 * Adds inventory to coffee maker with invalid inputs
	 */
	public void testAddInventoryBad() {
		try {
			cm.addInventory("0", "0", "0", "0");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}

		try {
			cm.addInventory("4", "1", "2", "3");
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}

		try {
			cm.addInventory("-4", "1", "2", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("xcvb", "1", "2", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("2", "-1", "2", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("2", "gfds", "2", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("2", "1", "-2", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("2", "1", "qwer", "3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("2", "1", "5", "-3");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}

		try {
			cm.addInventory("2", "1", "5", "poiu");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			// success if thrown
		}
	}

	/**
	 * Returns change of purchase
	 */
	public void testMakeCoffee() {
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		try {
			cm.addInventory("50", "50", "50", "50");
		} catch (InventoryException e) {
			fail("Could not add inventory");
		}

		cm.addRecipe(r2);
		assertEquals(125, cm.makeCoffee(0, 200));
	}

	/**
	 * Returns change of purchase
	 */
	public void testMakeCoffeeBad() {
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		// recipe is null, return amtPaid
		assertEquals(1234, cm.makeCoffee(3, 1234));
	}

	/**
	 * Returns change of purchase
	 */
	public void testMakeCoffeeBad1() {
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		try {
			Recipe r = new Recipe();
			r.setName("Mashed potatoes");
			r.setAmtChocolate("100000");
			r.setAmtCoffee("100000");
			r.setAmtMilk("100000");
			r.setAmtSugar("100000");
			r.setPrice("1");
			cm.addRecipe(r);
			// Not enough ingredients, return amtPaid
			assertEquals(32104, cm.makeCoffee(0, 32104));
		} catch (Exception e) {
			fail("Could not create recipe");
		}
	}

	/**
	 * Returns change of purchase
	 */
	public void testMakeCoffeeBad2() {
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		try {
			cm.addInventory("50", "50", "50", "50");
		} catch (InventoryException e) {
			fail("Could not add inventory");
		}

		try {
			Recipe r = new Recipe();
			r.setName("Meatloaf");
			r.setAmtChocolate("1");
			r.setAmtCoffee("1");
			r.setAmtMilk("1");
			r.setAmtSugar("1");
			r.setPrice("10");
			cm.addRecipe(r);
			// Too expensive, return amtPaid
			assertEquals(4, cm.makeCoffee(0, 4));
		} catch (Exception e) {
			fail("Could not create recipe");
		}
	}

	/**
	 * Returns the list of recipes
	 */
	public void testGetRecipes() {
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		cm.addRecipe(r4);
		cm.addRecipe(r2);
		cm.addRecipe(r1);
		cm.addRecipe(r3);

		assertEquals(cm.getRecipes().length, 4);
		assertEquals(cm.getRecipes()[0], r4);
		assertEquals(cm.getRecipes()[1], r2);
		assertEquals(cm.getRecipes()[2], r1);
		assertEquals(cm.getRecipes()[3], r3);
	}

	/**
	 * Add and delete recipes
	 * 
	 * This revealed that once a recipe is removed from the recipe book, another
	 * recipe cannot be added to the same spot again. So if you add 2 recipes,
	 * remove then 2nd, add a 3rd... that recipe will be put into the 3rd spot
	 * instead of the second. This was because when a recipes was deleted the index
	 * is occupied was filled with a new blank recipe instead of null.
	 */
	public void testAddAndDeleteRecipes() {
		// First delete all the recipes from previous tests
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		cm.addRecipe(r1); // [r1, null, null, null]
		assertFalse(cm.addRecipe(r1)); // [r1, null, null, null]
		cm.addRecipe(r2); // [r1, r2, null, null]
		cm.deleteRecipe(1); // [r1, null, null, null]
		assertEquals(null, cm.deleteRecipe(2)); // Bad
		assertEquals("Coffee", cm.getRecipes()[0].getName());
		cm.addRecipe(r3); // [r1, r3, null, null]
		cm.addRecipe(r2); // [r1, r3, r2, null]
		cm.deleteRecipe(0); // [null, r3, r2, null]
		assertEquals("Latte", cm.getRecipes()[1].getName());
		cm.addRecipe(r1); // [r1, r3, r2, null]
		cm.addRecipe(r4); // [r1, r3, r2, r4]
		assertEquals("Hot Chocolate", cm.getRecipes()[3].getName());

		numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}
		cm.addRecipe(r1);
		Recipe r5 = new Recipe();
		r5 = new Recipe();
		try {
			r5.setName("Coffee");
			r5.setAmtChocolate("0");
			r5.setAmtCoffee("3");
			r5.setAmtMilk("1");
			r5.setAmtSugar("1");
			r5.setPrice("50");
		} catch (Exception e) {
		}
		assertFalse(cm.addRecipe(r5));
	}

	/**
	 * Add invalid recipes
	 */
	public void testAddInvalidRecipes() {
		Recipe r = new Recipe();
		r.setName("Hot Chocolate");

		// invalid price
		try {
			r.setPrice("-50");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Price must be a positive integer", e.getMessage());
		}

		// invalid coffee unit
		try {
			r.setAmtCoffee("-7");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}

		// invalid milk unit
		try {
			r.setAmtMilk("-2");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}

		// invalid sugar unit
		try {
			r.setAmtSugar("-4");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}

		// invalid chocolate unit
		try {
			r.setAmtChocolate("-42222");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}

		// invalid price type
		try {
			r.setPrice("-50");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Price must be a positive integer", e.getMessage());
		}

		// invalid coffee unit type
		try {
			r.setAmtCoffee("a");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}

		// invalid milk unit type
		try {
			r.setAmtMilk("#");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}

		// invalid sugar unit type
		try {
			r.setAmtSugar("wew");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}

		// invalid chocolate unit type
		try {
			r.setAmtChocolate(";;;");
			fail("Something went wrong");
		} catch (RecipeException e) {
			// Good
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}
	}

	/**
	 * Edit recipes
	 * 
	 * This revealed that the name of the new recipe was being set to an empty
	 * string.
	 */
	public void testEditRecipe() {
		// First delete all the recipes from previous tests
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		// Add Coffee recipe
		cm.addRecipe(r1);
		assertEquals("Coffee", cm.getRecipes()[0].getName());
		// Edit Coffee recipe to be Mocha recipe
		String recipeName = cm.editRecipe(0, r2);
		assertEquals("Coffee", recipeName);
		assertEquals("Coffee", cm.getRecipes()[0].getName());
	}

	/**
	 * Edit recipes with an empty recipe list
	 * 
	 */
	public void testEditRecipeNull() {
		// First delete all the recipes from previous tests
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		// Edit null recipe
		String recipeName = cm.editRecipe(0, r2);
		assertEquals(null, recipeName);
	}

	/**
	 * Check inventory
	 * 
	 */
	public void testCheckInventory() {
		// First delete all the recipes from previous tests
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		// Check inventory with starting values
		String inventory = cm.checkInventory();
		assertNotNull(inventory);
		assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", inventory);

		// Check inventory with added inventory
		try {
			cm.addInventory("5", "8", "2", "4");
			String inventory2 = cm.checkInventory();
			assertNotNull(inventory2);
			assertEquals("Coffee: 20\nMilk: 23\nSugar: 17\nChocolate: 19\n", inventory2);
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	/**
	 * Add invalid inventory
	 */
	public void testAddInvalidInventory() {
		// First delete all the recipes from previous tests
		int numRecipes = cm.getRecipes().length;
		for (int i = 0; i < numRecipes; i++) {
			cm.deleteRecipe(i);
		}

		// Check inventory with added inventory
		try {
			cm.addInventory("-1", "1", "1", "1");
		} catch (InventoryException e) {
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}
		try {
			cm.addInventory("1", "-1", "1", "1");
		} catch (InventoryException e) {
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}
		try {
			cm.addInventory("1", "1", "-1", "1");
		} catch (InventoryException e) {
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}
		try {
			cm.addInventory("1", "1", "1", "-1");
		} catch (InventoryException e) {
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}

		try {
			cm.addInventory("a", "1", "1", "1");
		} catch (InventoryException e) {
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}
		try {
			cm.addInventory("1", "apls", "1", "1");
		} catch (InventoryException e) {
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}
		try {
			cm.addInventory("1", "1", "^^", "1");
		} catch (InventoryException e) {
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}
		try {
			cm.addInventory("1", "1", "1", "..w");
		} catch (InventoryException e) {
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}
	}
}
