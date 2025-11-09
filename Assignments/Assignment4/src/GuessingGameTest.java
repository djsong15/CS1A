import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Do NOT change this testing code.
 * 
 * @author Baba Kofi Weusijana
 *
 */
public class GuessingGameTest
{

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception
    {
    }

    private GuessingGame createTestSubject()
    {
        return new GuessingGame();
    }

    /**
     * Test method for {@link GuessingGame#getInput(int, int)}.
     */
    @Test
    public final void testGetInput()
    {
        System.out.println("***** Testing GuessingGame.getInput:");
        GuessingGame gg = createTestSubject();
        int min = 0;
        int max = 1;
        testGetInputWithMinAndMax(gg, min, max);
        min = -64;
        max = 64;
        testGetInputWithMinAndMax(gg, min, max);
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        testGetInputWithMinAndMax(gg, min, max);
    }

    /**
     * @param aGuessingGameObject
     * @param min
     * @param max
     */
    public void testGetInputWithMinAndMax(GuessingGame aGuessingGameObject, int min, int max)
    {
        int result;
        System.out.print("Enter a whole number between " + min + " and " + max + ":");
        result = aGuessingGameObject.getInput(min, max);
        if ((result >= min) && (result <= max))
        {

        } else
        {
            fail(result + " not between " + min + " and " + max + ".");
        }
    }

    /**
     * Test method for {@link java.lang.Object#Object()}.
     */
    @Test
    public final void testObject()
    {
        System.out.println("***** Testing new GuessingGame():");
        GuessingGame gg = createTestSubject();
        assertNotNull(gg);
    }

}
