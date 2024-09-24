package edu.grinnell.csc207.util;

public class BFCalculator {

  public BigFraction last_val;
  private static final BigFraction DEFAULT = new BigFraction(0,1);

  public BFCalculator() {
    last_val = DEFAULT;
  } // BFCalculator()

  public BigFraction get() {
    if (last_val == null) {
      last_val = new BigFraction(0, 1);
    } // if
    return last_val.reduce();
  } // get()

  public void add(BigFraction val) {
    this.last_val = this.get().add(val);
  } // add(BigFraction)

  public void subtract(BigFraction val) {
    this.last_val = this.get().subtract(val);
  } // subtract(BigFraction)

  public void multiply(BigFraction val) {
    this.last_val = this.get().multiply(val);
  } // multiply(BigFraction)

  public void divide(BigFraction val) {
    this.last_val = this.get().divide(val);
  } // divide(BigFraction)

  public void clear() {
    this.last_val = this.get().clear();
  } // clear()
}