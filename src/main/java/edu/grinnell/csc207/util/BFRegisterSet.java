package edu.grinnell.csc207.util;

/**
 * A class to hold a register of BigFractions.
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 */
public class BFRegisterSet {

  /**
   * An array of BigFractions that make up the register.
   */
  private BigFraction[] register;

  /**
   * The maximum size of the register (exclusive).
   */
  private static final int MAX = 26;

  /**
  * Constructs an empty register with 26 BigFractions.
  */
  public BFRegisterSet() {
    this.register = new BigFraction[MAX];
    this.empty();
  } // BFregisterSet()

  /**
   * Checks if a character is within the bounds 0-26  (exclusive).
   *
   * @param x
   *    The character's alphabetical index.
   *
   * @return
   *    True or false if x is within bounds.
   */
  protected boolean bounds(int x) {
    return (x >= 0 && x < 26);
  } // bounds(int)

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
    if (bounds(register - 'a')) {
      this.register[(int) (register - 'a')] = val;
    } // if
  } // store(char, BigFraction)

  /**
   * Returns a BigFraction from the index stored.
   *
   * @param register
   *    The character that indicates the index of the
   *    BigFraction in the register.
   * @return
   *    A BigFraction that is located at the register's index.
   */
  public BigFraction get(char register) {
    if (bounds(register - 'a')) {
      return this.register[(int) (register - 'a')];
    } else {
      return null;
    } // elif
  } // get(char)

  /**
   * Sets all of the register's indices to the default fraction,
   * 0/1.
   */
  public void empty() {
    BigFraction empty = new BigFraction(0, 1);
    for (int i = 0; i < this.register.length - 1; i++) {
      this.register[i] = empty;
    } // for
  } // empty()
} // class BFRegisterSet
