package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** Author Hetian Li
 *  Unit test for inventory class
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
    public void TestsetChocolateBad() {
        try {
            inventory.setChocolate(10);
            assertEquals(8, inventory.getChocolate());
        } catch (Exception e) {
            fail("Exception should be thrown");
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
    public void TestgetCoffee() {
        try {
            assertEquals(15, inventory.getCoffee());
        }
        catch (Exception e) {
            fail("Exception should not be thrown");
        }

    }
    @Test
    public void TestgetCoffeeBad() {
        try {
            assertEquals(7, inventory.getCoffee());
        } catch (Exception e) {
            fail("Exception should be thrown");
        }
    }
    @Test
    public void TestgetCoffeeBad2() {
        try {
            assertEquals('a', inventory.getCoffee());
        } catch (Exception e) {
            fail("Exception should be thrown");
        }
    }


    @Test
    public void TestsetCoffee() {
        try {
            inventory.setChocolate(15);
            assertEquals(15, inventory.getChocolate());
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void TestsetCoffeebad() {
        try {
            inventory.setChocolate(5);
            assertEquals(10, inventory.getChocolate());
        } catch (Exception e) {
            fail("Exception should be thrown");
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
        String added = "1";
        String notadded = "2";
        try {
            int bF = inventory.getCoffee();
            inventory.addCoffee(added);
            assertEquals(inventory.getCoffee(), bF + new Integer(notadded));
        } catch (Exception e) {
            fail("Exception should be thrown");
        }

    }

    @Test
    public void TestaddCoffeeBad2() {
        String added = "wqe";
        try {
            int bF = inventory.getCoffee();
            inventory.addCoffee(added);
            assertEquals(inventory.getCoffee(), bF + new Integer(added));
        } catch (Exception e) {
            fail("Exception should be thrown");
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
            inventory.setMilk(10);
            assertEquals(12, inventory.getMilk());
        } catch (Exception e) {
            fail("Exception should be thrown");
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
        String added = "1";
        String notadded = "2";
        try {
            int bF = inventory.getMilk();
            inventory.addMilk(added);
            assertEquals(inventory.getMilk(), bF + new Integer(notadded));
        } catch (Exception e) {
            fail("Exception should be thrown");
        }

    }

    @Test
    public void TestaddMilkBad2() {
        String added = "wqfaf";
        try {
            int bF = inventory.getMilk();
            inventory.addMilk(added);
            assertEquals(inventory.getMilk(), bF + new Integer(added));
        } catch (Exception e) {
            fail("Exception should be thrown");
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
    public void TestgetSugarBad() {
        try {
            assertEquals(16341, inventory.getSugar());
        } catch (Exception e) {
            fail("Exception should be thrown");
        }

    }
    @Test
    public void TestgetSugarBad2() {
        try {
            assertEquals(1, inventory.getSugar());
        } catch (Exception e) {
            fail("Exception should be thrown");
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
            inventory.setSugar(10);
            assertEquals(233, inventory.getSugar());
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

    @Test
    public void TestaddSugarBad() {
        String added = "1";
        String notadded = "2";
        try {
            int bF = inventory.getSugar();
            inventory.addSugar(added);
            assertEquals(inventory.getSugar(), bF + new Integer(notadded));
        } catch (Exception e) {
            fail("Exception should be thrown");
        }

    }

    @Test
    public void TestaddSugarBad2() {
        String added = "fws";
        try {
            int bF = inventory.getSugar();
            inventory.addSugar(added);
            assertEquals(inventory.getSugar(), bF + new Integer(added));
        } catch (Exception e) {
            fail("Exception should be thrown");
        }

    }

    @Test
    public void TestenoughIngredients() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("3");
            r.setAmtMilk("1");
            r.setAmtSugar("4");
            r.setAmtChocolate("2");
            assertTrue(inventory.enoughIngredients(r));
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
            assertTrue(inventory.enoughIngredients(r));
        } catch (Exception e) {
            fail("Exception should be thrown");
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

    @Test
    public void TestuseIngredientsBad() {
        Recipe r = new Recipe();
        try {
            r.setAmtCoffee("0");
            r.setAmtMilk("-3");
            r.setAmtSugar("-1");
            r.setAmtChocolate("4");
            assertTrue(inventory.useIngredients(r));
        } catch (Exception e) {
            fail("Exception should be thrown");
        }

    }

    @Test
    public void TesttoString() {
        assertNotNull(inventory.toString());

    }
}