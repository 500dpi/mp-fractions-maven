/*
 * BFCalculator.java
 *
 * Author: Sara Jaljaa
 * Course: CSC-207-01
 *
 */

package edu.grinnell.csc207.util;

/**
 * A class containing helper object methods to return the last computed value.
 */
public class BFCalculator {

  /**
   * The last calculated value.
   */
  private BigFraction lastVal;

  /**
   * The default fraction.
   */
  private static final BigFraction DEFAULT = new BigFraction(0, 1);

  /**
   * A constructor to set the last value to a non-null
   * fraction.
   */
  public BFCalculator() {
    lastVal = DEFAULT;
  } // BFCalculator()

  /**
   * Returns the last value computed.
   *
   * @return
   *    Returns the last computed value of the BigFraction.
   */
  @SuppressWarnings("Checkstyle")
  public BigFraction get() {
    if (lastVal == null) {
      lastVal = new BigFraction(0, 1);
    } // if
    return lastVal.reduce();
  } // get()

  /**
   * Returns the last value computed added
   * to another fraction.
   *
   * @param val The fraction to add.
   */
  public void add(BigFraction val) {
    this.lastVal = this.get().add(val);
  } // add(BigFraction)

  /**
   * Returns the last value computed subtracted
   * from another fraction.
   *
   * @param val The fraction to subtract.
   */
  public void subtract(BigFraction val) {
    this.lastVal = this.get().subtract(val);
  } // subtract(BigFraction)

  /**
   * Returns the last value computed multiplied
   * by another fraction.
   *
   * @param val The multiplier fraction.
   */
  public void multiply(BigFraction val) {
    this.lastVal = this.get().multiply(val);
  } // multiply(BigFraction)

  /**
   * Returns the last value computed divided
   * by another fraction.
   *
   * @param val The fraction to divide by.
   */
  public void divide(BigFraction val) {
    this.lastVal = this.get().divide(val);
  } // divide(BigFraction)

  /**
   * Returns the last computed value set to 0/0.
   */
  public void clear() {
    this.lastVal = this.get().clear();
  } // clear()
} // class BFCalculator
