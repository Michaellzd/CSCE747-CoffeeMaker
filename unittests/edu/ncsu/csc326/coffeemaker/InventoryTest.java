package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author Hetian Li Unit test for inventory class
 */

public class InventoryTest {
	private Inventory inventory;

	@Before
	public void setUp() {
		inventory = new Inventory();
	}

	@Test
	public void TestgetChocolate() {
		try {
			assertEquals(15, inventory.getChocolate());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestsetChocolate() {
		try {
			inventory.setChocolate(10);
			assertEquals(10, inventory.getChocolate());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestsetChocolateBad() {
		try {
			int num = inventory.getChocolate();
			inventory.setChocolate(-1);
			// Num of chocolates should be unchanged
			assertEquals(num, inventory.getChocolate());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestaddChocolate() {
		String added = "1";
		try {
			int bF = inventory.getChocolate();
			inventory.addChocolate(added);
			assertEquals(inventory.getChocolate(), bF + new Integer(added));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestaddChocolateBad() {
		String added = "asdf";
		try {
			int bF = inventory.getChocolate();
			inventory.addChocolate(added);
			assertEquals(inventory.getChocolate(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestaddChocolateBad1() {
		String added = "-1";
		try {
			int bF = inventory.getChocolate();
			inventory.addChocolate(added);
			assertEquals(inventory.getChocolate(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestgetCoffee() {
		try {
			assertEquals(15, inventory.getCoffee());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}

	}

	@Test
	public void TestsetCoffee() {
		try {
			inventory.setCoffee(15);
			assertEquals(15, inventory.getCoffee());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestsetCoffeeBad() {
		try {
			int num = inventory.getCoffee();
			inventory.setCoffee(-1);
			// Num of coffee should be unchanged
			assertEquals(num, inventory.getCoffee());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestaddCoffee() {
		String added = "1";
		try {
			int bF = inventory.getCoffee();
			inventory.addCoffee(added);
			assertEquals(inventory.getCoffee(), bF + new Integer(added));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}

	}

	@Test
	public void TestaddCoffeeBad() {
		String added = "-1";
		try {
			int bF = inventory.getCoffee();
			inventory.addCoffee(added);
			assertEquals(inventory.getCoffee(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestaddCoffeeBad2() {
		String added = "wqe";
		try {
			int bF = inventory.getCoffee();
			inventory.addCoffee(added);
			assertEquals(inventory.getCoffee(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestgetMilk() {
		try {
			assertEquals(15, inventory.getMilk());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestsetMilk() {
		try {
			inventory.setMilk(10);
			assertEquals(10, inventory.getMilk());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestsetMilkBad() {
		try {
			int num = inventory.getMilk();
			inventory.setMilk(-1);
			// Num of milk should be unchanged
			assertEquals(num, inventory.getMilk());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestaddMilk() {
		String added = "1";
		try {
			int bF = inventory.getMilk();
			inventory.addMilk(added);
			assertEquals(inventory.getMilk(), bF + new Integer(added));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestaddMilkBad() {
		String added = "-1";
		try {
			int bF = inventory.getMilk();
			inventory.addMilk(added);
			assertEquals(inventory.getMilk(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestaddMilkBad2() {
		String added = "wqfaf";
		try {
			int bF = inventory.getMilk();
			inventory.addMilk(added);
			assertEquals(inventory.getMilk(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestgetSugar() {
		try {
			assertEquals(15, inventory.getSugar());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}

	}

	@Test
	public void TestsetSugar() {
		try {
			inventory.setSugar(10);
			assertEquals(10, inventory.getSugar());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestsetSugarBad() {
		try {
			int num = inventory.getSugar();
			inventory.setSugar(-1);
			// Num of sugar should be unchanged
			assertEquals(num, inventory.getSugar());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestaddSugar() {
		String added = "1";
		try {
			int bF = inventory.getSugar();
			inventory.addSugar(added);
			assertEquals(inventory.getSugar(), bF + new Integer(added));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	/**
	 * Add sugar
	 * 
	 * This revealed that the amount of sugar being added was only added if the
	 * amount is negative. This is the opposite of how it should be where the amount
	 * of sugar only is added if the amount entered is positive.
	 */
	@Test
	public void TestaddSugarBad() {
		String added = "-1";
		try {
			int bF = inventory.getSugar();
			inventory.addSugar(added);
			assertEquals(inventory.getSugar(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestaddSugarBad2() {
		String added = "fws";
		try {
			int bF = inventory.getSugar();
			inventory.addSugar(added);
			assertEquals(inventory.getSugar(), bF + new Integer(added));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestenoughIngredients() {
		Recipe r = new Recipe();
		Recipe r1 = new Recipe();
		try {
			r.setAmtCoffee("3");
			r.setAmtMilk("1");
			r.setAmtSugar("4");
			r.setAmtChocolate("2");
			assertTrue(inventory.enoughIngredients(r));
			
			r1.setAmtCoffee("100000");
			r1.setAmtMilk("100000");
			r1.setAmtSugar("100000");
			r1.setAmtChocolate("100000");
			assertFalse(inventory.enoughIngredients(r1));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestenoughIngredientsBad() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("0");
			r.setAmtMilk("1");
			r.setAmtSugar("-3");
			r.setAmtChocolate("-4");
			assertFalse(inventory.enoughIngredients(r));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TestuseIngredients() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("2");
			r.setAmtMilk("3");
			r.setAmtSugar("1");
			r.setAmtChocolate("4");
			assertTrue(inventory.useIngredients(r));
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	/**
	 * Use ingredients
	 * 
	 * This revealed that the amount of coffee was being added to the total
	 * inventory instead of subtracted. The fix was to change a += to a -= so that
	 * the coffee being used is correctly subtracted from the inventory.
	 */
	@Test
	public void TestuseIngredients2() {
		Recipe r = new Recipe();
		try {
			int numCoffee = inventory.getCoffee();
			int numMilk = inventory.getMilk();
			int numSugar = inventory.getSugar();
			int numChocolate = inventory.getChocolate();

			r.setAmtCoffee("2");
			r.setAmtMilk("3");
			r.setAmtSugar("1");
			r.setAmtChocolate("4");
			assertTrue(inventory.useIngredients(r));

			assertEquals(numCoffee - 2, inventory.getCoffee());
			assertEquals(numMilk - 3, inventory.getMilk());
			assertEquals(numSugar - 1, inventory.getSugar());
			assertEquals(numChocolate - 4, inventory.getChocolate());
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void TestuseIngredientsBad() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("0");
			r.setAmtMilk("-3");
			r.setAmtSugar("-1");
			r.setAmtChocolate("4");
			assertTrue(inventory.useIngredients(r));
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void TesttoString() {
		assertNotNull(inventory.toString());

	}
}