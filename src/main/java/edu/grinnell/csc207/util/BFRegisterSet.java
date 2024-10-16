/**
 * BFRegister.java
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 *
 */

package edu.grinnell.csc207.util;

/**
 * A class to hold a register of BigFractions.
 */
public class BFRegisterSet {

  /**
   * An array of BigFractions that make up the register.
   */
  private BigFraction[] objRegister;

  /**
   * The maximum size of the array (all alphabetical
   * characters, exclusive).
   */
  private static final int MAX = 26;

  /**
   * The first value of the alphabet (lowercase a) in ASCII.
   */
  private static final int ASCII_MIN = 97;

  /**
  * Constructs a register with 26 BigFraction objects.
  */
  public BFRegisterSet() {
    this.objRegister = new BigFraction[MAX];
  } // BFregisterSet()

  /**
   * Stores a BigFraction in some alphabetical index
   * 0-26 of the register array.
   *
   * @param register
   *    The character to indicate the alphabetical index of the register.
   * @param val
   *    The fraction to store.
   */
  public void store(char register, BigFraction val) {
    this.objRegister[(int) register - ASCII_MIN] = val;
  } // store(char,BigFraction)

  /**
   * Returns a BigFraction from the given alphabetical
   * character index (0-26).
   *
   * @param register
   *    The character that indicates the index of the
   *    BigFraction in the register.
   * @return
   *    A BigFraction that is located at the register's index.
   */
  public BigFraction get(char register) {
    return this.objRegister[(int) register - ASCII_MIN];
  } // get(char)

  /**
   * Sets all of the register's indices to the default fraction,
   * 0/1.
   */
  public void empty() {
    BigFraction empty = new BigFraction(0, 1);
    for (int i = 0; i < this.objRegister.length - 1; i++) {
      this.objRegister[i] = empty;
    } // for
  } // empty()
} // class BFRegisterSet
