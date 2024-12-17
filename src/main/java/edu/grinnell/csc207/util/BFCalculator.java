package edu.grinnell.csc207.util;

/**
 * Calculates fraction expressions.
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 */
public class BFCalculator {

  /**
   * The last calculated fraction.
   */
  private BigFraction current;

  /**
   * A constructor to set the last value to the default fraction.
   */
  public BFCalculator() {
    current = null;
  } // BFCalculator()

  /**
   * The last value computed.
   *
   * @return
   *    Returns the last BigFraction computed.
   */
  public BigFraction get() {
    if (current == null) {
      current = new BigFraction(0, 1);
    } // if
    return current.reduce();
  } // get()

  /**
   * Adds the last computed value to a fraction.
   *
   * @param val
   *    The fraction to add.
   */
  public void add(BigFraction val) {
    this.current = this.get().add(val);
  } // add(BigFraction)

  /**
   * Subtracts the last computed value from a fraction.
   *
   * @param val
   *    The fraction to subtract.
   */
  public void subtract(BigFraction val) {
    this.current = this.get().subtract(val);
  } // subtract(BigFraction)

  /**
   * Multiplies the last computed value by another fraction.
   *
   * @param val
   *    The multiplier fraction.
   */
  public void multiply(BigFraction val) {
    this.current = this.get().multiply(val);
  } // multiply(BigFraction)

  /**
   * Divides the last computed value by another fraction.
   *
   * @param val
   *    The fraction to divide by.
   */
  public void divide(BigFraction val) {
    this.current = this.get().divide(val);
  } // divide(BigFraction)

  /**
   * Sets the last computed value to the default fraction,
   * 0/1.
   */
  public void clear() {
    this.current = this.get().clear();
  } // clear()
} // class BFCalculator
