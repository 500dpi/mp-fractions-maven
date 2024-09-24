package edu.grinnell.csc207.util;

/*
 * A class to hold a register of BigFractions.
 */
public class BFRegisterSet {

  BigFraction[] objRegister;

  /*
   * Returns a newly constructed register with 
   * 26 BIgFraction objects in an array.
   */
  public BFRegisterSet() {
    objRegister = new BigFraction[26];
  } // BFregisterSet()

/**
   * Stores a BigFraction in some alphabetical index 
   * 0-26 of the register array.
   * 
   * @param register The character to indicate the
   * alphabetical index of the register.
   * @param val The fraction to store.
   */
  public void store(char register, BigFraction val) {
    objRegister[(int) register - 97] = val;
  } // store(char,BigFraction)

/**
   * Returns a BigFraction from the given alphabetical
   * character index (0-26).
   * 
   * @param register The character that indicates the 
   * index of the BIgFraction in the register.
   */
  public BigFraction get(char register) {
    return objRegister[(int) register - 97];
  } // get(char)

/**
   * Returns an empty register that has all of its
   * fractions set to default 0/1.
   */
  public void empty() {
    BigFraction empty = new BigFraction(0, 1);
    for (int i = 0; i < objRegister.length - 1; i++) {
      objRegister[i] = empty;
    } // for
  } // empty()
} // class BFRegisterSet
