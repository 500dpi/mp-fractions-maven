package edu.grinnell.csc207.util;

/* 
 * A class containing heler object methods to return
 * the last computed value. 
 */
public class BFCalculator {

  public BigFraction last_val;
  private static final BigFraction DEFAULT = new BigFraction(0,1);

  /* 
   * A constructor to set the last value to a non-null
   * fraction.
   */
  public BFCalculator() {
    last_val = DEFAULT;
  } // BFCalculator()

  /* 
   * Returns the last value computed.
   */
  public BigFraction get() {
    if (last_val == null) {
      last_val = new BigFraction(0, 1);
    } // if
    return last_val.reduce();
  } // get()

/**
   * Returns the last value computed added
   * to another fraction.
   * 
   * @param val The fraction to add.
   */
  public void add(BigFraction val) {
    this.last_val = this.get().add(val);
  } // add(BigFraction)

  /**
   * Returns the last value computed subtracted
   * from another fraction.
   * 
   * @param val The fraction to subtract.
   */
  public void subtract(BigFraction val) {
    this.last_val = this.get().subtract(val);
  } // subtract(BigFraction)

  /**
   * Returns the last value computed multiplied
   * by another fraction.
   * 
   * @param val The multiplier fraction.
   */
  public void multiply(BigFraction val) {
    this.last_val = this.get().multiply(val);
  } // multiply(BigFraction)

  /**
   * Returns the last value computed divided
   * by another fraction.
   * 
   * @param val The fraction to divide by.
   */
  public void divide(BigFraction val) {
    this.last_val = this.get().divide(val);
  } // divide(BigFraction)

  /**
   * Returns the last computed value set to 0/0.
   */
  public void clear() {
    this.last_val = this.get().clear();
  } // clear()
} // class BFCalculator