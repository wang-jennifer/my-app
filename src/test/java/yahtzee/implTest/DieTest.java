package yahtzee.implTest;

import org.junit.*;
import yahtzee.Die;
import static org.junit.Assert.*;

/**
 * This class tests the implementation of the Die class.
 */
public class DieTest {

  // tests constructor
  // depends on the hasRolled() and getNumSides() method
  @Test
  public void testConstructor() {
    Die d = new Die(6);
    Die d2 = new Die(100);
    assertFalse(d.hasRolled());
    assertEquals(6, d.getNumSides());
    assertFalse(d2.hasRolled());
    assertEquals(100, d2.getNumSides());
  }

  @Test(expected=IllegalArgumentException.class)
  public void testConstructorZeroSides() {
    Die d = new Die(0);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testConstructorNegSides() {
    Die d = new Die(-20);
  }

  // tests roll()
  //depends on the getRoll() and hasRolled() method
  @Test
  public void testRollOnce() {
    Die d = new Die(6);
    d.roll();
    assertTrue(d.hasRolled());
    assertTrue(d.getRoll() >= 1);
    assertTrue(d.getRoll() <= 6);
  }

  @Test
  public void testRollTwice() {
    Die d = new Die(20);
  }

  @Test
  public void testRollMultTimes() {

  }

  // tests getRoll()

  // test toString
}