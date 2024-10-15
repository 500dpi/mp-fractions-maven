/*
 * BFCalculator.java
 *
 * Author: Sara Jaljaa
 * Course: CSC-207-01
 *
 */

package edu.grinnell.csc207.util;

/**
 * A class containing helper methods to manipulate the last computed value.
 */
public class BFCalculator {

  /**
   * The last calculated fraction.
   */
  private BigFraction lastVal;

  /**
   * The default fraction.
   */
  private static final BigFraction DEFAULT = new BigFraction(0, 1);

  /**
   * A constructor to set the last value to the default fraction, 0/1.
   */
  public BFCalculator() {
    lastVal = DEFAULT;
  } // BFCalculator()

  /**
   * The last value computed.
   *
   * @return
   *    Returns the last BigFraction computed.
   */
  @SuppressWarnings("Checkstyle")
  public BigFraction get() {
    if (lastVal == null) {
      lastVal = new BigFraction(0, 1);
    } // if
    return lastVal.reduce();
  } // get()

  /**
   * Adds the last computed value to a fraction.
   *
   * @param val
   *    The fraction to add.
   */
  public void add(BigFraction val) {
    this.lastVal = this.get().add(val);
  } // add(BigFraction)

  /**
   * Subtracts the last computed value from a fraction.
   *
   * @param val
   *    The fraction to subtract.
   */
  public void subtract(BigFraction val) {
    this.lastVal = this.get().subtract(val);
  } // subtract(BigFraction)

  /**
   * Multiplies the last computed value by another fraction.
   *
   * @param val
   *    The multiplier fraction.
   */
  public void multiply(BigFraction val) {
    this.lastVal = this.get().multiply(val);
  } // multiply(BigFraction)

  /**
   * Divides the last computed value by another fraction.
   *
   * @param val
   *    The fraction to divide by.
   */
  public void divide(BigFraction val) {
    this.lastVal = this.get().divide(val);
  } // divide(BigFraction)

  /**
   * Sets the last computed value to the default fraction,
   * 0/1.
   */
  public void clear() {
    this.lastVal = this.get().clear();
  } // clear()
} // class BFCalculator
