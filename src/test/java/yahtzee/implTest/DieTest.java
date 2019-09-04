package yahtzee.implTest;

import org.junit.*;
import yahtzee.Die;
import static org.junit.Assert.*;

/**
 * This class tests the implementation of the Die class.
 */
public class DieTest {
  // sets up tests for roll() and getRoll()
  private void rollDie(int numRolls, int numSides) {
    Die d = new Die(numSides);
    for (int i = 1; i <= numRolls; i++) {
      d.roll();
    }
    assertTrue(d.getRoll() >= 1);
    assertTrue(d.getRoll() <= numSides);
  }

  // sets up tests for hasRolled()
  private void testHasRolled(int numRolls, int numSides) {
    Die d = new Die(numSides);
    if (numRolls == 0) {
      assertFalse(d.hasRolled());
    } else {
      for (int i = 1; i <= numRolls; i++) {
        d.roll();
      }
      assertTrue(d.hasRolled());
    }
  }

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
    rollDie(1, 6);
    rollDie(1, 15);
    rollDie(1, 35);
    rollDie(1, 58);
  }

  @Test
  public void testRollTwice() {
    rollDie(2, 6);
    rollDie(2, 60);
    rollDie(2, 160);
    rollDie(2, 500);
  }

  @Test
  public void testRollMultTimes() {
    rollDie(3, 6);
    rollDie(10, 3);
    rollDie(80, 1);
    rollDie(250, 50);
  }

  // tests getRoll()
  @Test
  public void testGetRoll() {
    Die d = new Die(1);
    assertEquals(0, d.getRoll());
    d.roll();
    assertEquals(1, d.getRoll());
    rollDie(1, 3);
    rollDie(6, 6);
  }

  // tests getNumSides()
  @Test
  public void testGetNumSides() {
    Die d1 = new Die(1);
    assertEquals(1, d1.getNumSides());
    Die d2 = new Die(6);
    assertEquals(6, d2.getNumSides());
    Die d3 = new Die(189);
    assertEquals(189, d3.getNumSides());
  }

  // test hasRolled()
  @Test
  public void testHasRolledZeroTimes() {
    testHasRolled(0, 1);
    testHasRolled(0, 6);
    testHasRolled(0, 15);
    testHasRolled(0, 123);
  }

  @Test
  public void testHasRolledOnce() {
    testHasRolled(1, 1);
    testHasRolled(1, 60);
    testHasRolled(1, 156);
    testHasRolled(1, 12);
  }

  @Test
  public void testHasRolledMultTimes() {
    testHasRolled(2, 1);
    testHasRolled(50, 6);
    testHasRolled(12, 16);
    testHasRolled(876, 78);
  }

  // test toString
  // depends on the getRoll() method
  @Test
  public void testToStringNoRolls() {
    Die d1 = new Die(6);
    Die d2 = new Die(1);
    Die d3 = new Die(60);
    assertEquals("no rolls yet", d1.toString());
    assertEquals("no rolls yet", d2.toString());
    assertEquals("no rolls yet", d3.toString());
  }

  @Test
  public void testToStringOneRoll() {
    Die d1 = new Die(6);
    d1.roll();
    assertEquals("current roll: " + d1.getRoll(), d1.toString());
    Die d2 = new Die(1);
    d2.roll();
    assertEquals("current roll: 1", d2.toString());
  }

  @Test
  public void testToStringMultRolls() {
    Die d = new Die(8);
    for (int i = 1; i <= 10; i++) {
      d.roll();
      assertEquals("current roll: " + d.getRoll(), d.toString());
    }
  }
}