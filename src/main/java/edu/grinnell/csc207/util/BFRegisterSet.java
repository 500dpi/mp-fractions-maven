package edu.grinnell.csc207.util;

public class BFRegisterSet {

  BigFraction[] objRegister;

  public BFRegisterSet() {
    objRegister = new BigFraction[26];
  } // BFregisterSet()

  public void store(char register, BigFraction val) {
    objRegister[(int) register - 97] = val;
  } // store(char,BigFraction)

  public BigFraction get(char register) {
    return objRegister[(int) register - 97];
  } // get(char)

  public void empty() {
    BigFraction empty = new BigFraction(0, 1);
    for (int i = 0; i < objRegister.length - 1; i++) {
      objRegister[i] = empty;
    }
  }
} // class BFRegisterSet
