package yahtzee;

import java.util.Random;

/**
 * This class is a mutable roll-able six-faced Die, whose value is based on the
 * top-facing value of a roll.
 */
public class Die {
  private int face; // top-facing value of this Die
  private final int numSides; // number of sides for this Die

  /**
   * Constructs a new Die with the given number of positive sides, and a default top-facing value
   * as 0.
   * @param numSides number of sides for this Die
   * @throws IllegalArgumentException if numSides <= 0
   */
  public Die(int numSides) {
    if (numSides <= 0) {
      throw new IllegalArgumentException("number of sides must be a positive integer");
    }
    this.numSides = numSides;
  }

  /**
   * rolls this Die and sets the top-facing value to the new roll value
   */
  public void roll() {
    Random r = new Random();
    this.face = r.nextInt(this.numSides) + 1;
  }

  /**
   * returns the most recent rolled value. If this Die has not been rolled yet,
   * then returns 0
   * @return the most recent roll or 0 if this has not been rolled yet
   */
  public int getRoll() {
    return this.face;
  }

  /**
   * returns the number of sides for this Die
   * @return the number of sides for this Die
   */
  public int getNumSides() {
    return this.numSides;
  }

  /**
   * returns whether or not this Die has been rolled yet
   * @return true if this Die has been rolled, false otherwise
   */
  public boolean hasRolled() {
    return this.face != 0;
  }

  /**
   * returns a String representation of this, determined by its most recent roll. If this
   * has not been rolled yet, then returns "no rolls yet".
   * @return String representation of this, given its most recent top-facing value. If this
   * has not been rolled yet, returns "no rolls yet"
   */
  public String toString() {
    if (this.face == 0) {
      return "no rolls yet";
    }
    return "current roll: " + this.getRoll();
  }
}