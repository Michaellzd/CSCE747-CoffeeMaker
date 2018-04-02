package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest {

	private static Recipe r;

	@Before
	public void setUp() throws Exception {
		r = new Recipe();
	}

	@Test
	public void testGetAmtChocolate() {
		r = new Recipe();
		assertEquals(0, r.getAmtChocolate());
	}

	@Test
	public void testSetAmtChocolate() {
		r = new Recipe();
		String added = "1";
		try {
			r.setAmtChocolate(added);
			assertEquals(r.getAmtChocolate(), 1);
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void testSetAmtChocolateBad() {
		r = new Recipe();
		String added = "asdf";
		try {
			r.setAmtChocolate(added);
			assertEquals(r.getAmtChocolate(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testSetAmtChocolateBad1() {
		r = new Recipe();
		String added = "-1";
		try {
			r.setAmtChocolate(added);
			assertEquals(r.getAmtChocolate(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testGetAmtCoffee() {
		r = new Recipe();
		assertEquals(0, r.getAmtCoffee());
	}

	@Test
	public void testSetAmtCoffee() {
		r = new Recipe();
		String added = "1";
		try {
			r.setAmtCoffee(added);
			assertEquals(r.getAmtCoffee(), 1);
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void testSetAmtCoffeeBad() {
		r = new Recipe();
		String added = "asdf";
		try {
			r.setAmtCoffee(added);
			assertEquals(r.getAmtCoffee(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testSetAmtCoffeeBad1() {
		r = new Recipe();
		String added = "-1";
		try {
			r.setAmtCoffee(added);
			assertEquals(r.getAmtCoffee(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testGetAmtMilk() {
		r = new Recipe();
		assertEquals(0, r.getAmtMilk());
	}

	@Test
	public void testSetAmtMilk() {
		r = new Recipe();
		String added = "1";
		try {
			r.setAmtMilk(added);
			assertEquals(r.getAmtMilk(), 1);
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void testSetAmtMilkBad() {
		r = new Recipe();
		String added = "asdf";
		try {
			r.setAmtMilk(added);
			assertEquals(r.getAmtMilk(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testSetAmtMilkBad1() {
		r = new Recipe();
		String added = "-1";
		try {
			r.setAmtMilk(added);
			assertEquals(r.getAmtMilk(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testGetAmtSugar() {
		r = new Recipe();
		assertEquals(0, r.getAmtSugar());
	}

	@Test
	public void testSetAmtSugar() {
		r = new Recipe();
		String added = "1";
		try {
			r.setAmtSugar(added);
			assertEquals(r.getAmtSugar(), 1);
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void testSetAmtSugarBad() {
		r = new Recipe();
		String added = "asdf";
		try {
			r.setAmtSugar(added);
			assertEquals(r.getAmtSugar(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testSetAmtSugarBad1() {
		r = new Recipe();
		String added = "-1";
		try {
			r.setAmtSugar(added);
			assertEquals(r.getAmtSugar(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testGetName() {
		r = new Recipe();
		assertEquals("", r.getName());
	}

	@Test
	public void testSetName() {
		r = new Recipe();
		r.setName("Tea");
		assertEquals("Tea", r.getName());
	}

	@Test
	public void testSetNameBad() {
		r = new Recipe();
		r.setName(null);
		assertEquals("", r.getName());
	}

	@Test
	public void testGetPrice() {
		r = new Recipe();
		assertEquals(0, r.getPrice());
	}

	@Test
	public void testSetPrice() {
		r = new Recipe();
		String added = "1";
		try {
			r.setPrice(added);
			assertEquals(r.getPrice(), 1);
		} catch (Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void testSetPriceBad() {
		r = new Recipe();
		String added = "asdf";
		try {
			r.setPrice(added);
			assertEquals(r.getPrice(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testSetPriceBad1() {
		r = new Recipe();
		String added = "-1";
		try {
			r.setPrice(added);
			assertEquals(r.getPrice(), 0);
			fail("Exception should be thrown");
		} catch (Exception e) {
			// Exception should be thrown
		}
	}

	@Test
	public void testToString() {
		r = new Recipe();
		assertEquals("", r.getName());
		r.setName("Tea");
		assertEquals("Tea", r.getName());
	}

	/**
	 * The portion inside the ternary operator that checks if name == null
	 * will never be hit because the setName() function prevents
	 * the name from being set to null.
	 */
	@Test
	public void testHashCode() {
		r = new Recipe();
		r.setName("");
		int result = r.hashCode();
		int result1 = 31 + r.getName().hashCode();
		assertEquals(result, result1);

		r.setName(null);
		int result2 = r.hashCode();
		int result3 = 31;
		assertEquals(result2, result3);

		r.setName("Coffee");
		int result4 = r.hashCode();
		int result5 = 31 + r.getName().hashCode();
		assertEquals(result4, result5);
	}

	/**
	 * The lines inside the if statement with the condition for name == null will
	 * never be hit because the setName() function prevents the name from being set
	 * to null.
	 */
	@Test
	public void testEquals() {
		Recipe r1 = new Recipe();
		Recipe r2 = new Recipe();
		assertTrue(r1.equals(r2));
		assertFalse(r1.equals(null));

		r1.setName("Coffee");
		assertFalse(r1.equals(r2));

		r2.setName(null);
		assertFalse(r1.equals(r2));

		r1 = new Recipe();
		r2 = new Recipe();
		r1.setName("Coffee");
		r2.setName("Tea");
		assertFalse(r1.equals(r2));
	}
}
