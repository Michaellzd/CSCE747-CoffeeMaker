package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**Hetian Li
 *
 */

public class RecipeBookTest {

    private static RecipeBook RECB;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;

    @Before
    public void setUp() throws Exception {
        RECB = new RecipeBook();
        /** @Sarah Heckman
         *
         */

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

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("4");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("1");
        r4.setPrice("65");

        RECB.addRecipe(r1);
        RECB.addRecipe(r2);
    }

    @Test
    public void testGetRecipes() {
        Recipe[] recipes = new Recipe[4];
        recipes[0] = r1;
        recipes[1] = r2;
        assertArrayEquals(recipes, RECB.getRecipes());
    }

    @Test
    public void testAddRecipe() {
        assertTrue(RECB.addRecipe(r3));
    }

    @Test
    public void testAddRecipeBad() {
        assertFalse(RECB.addRecipe(r1));
    }

    @Test
    public void testDeleteRecipe() {
        assertEquals("Coffee", RECB.deleteRecipe(0));
    }

    @Test
    public void testDeleteRecipeBad() {
        RECB.deleteRecipe(0);
        assertNull(RECB.deleteRecipe(0));
    }

    @Test
    public void testEditRecipe(){
        assertEquals("Mocha",RECB.editRecipe(1, r4));
    }

}
}