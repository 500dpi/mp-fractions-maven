package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A class that creates a fraction from two BigIntegers.
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 */
public class BigFraction {

  /**
   * The numerator.
   */
  private BigInteger numerator;

  /**
   * The denominator.
   */
  private BigInteger denominator;

  /**
   * Constructs a BigFraction from two BigIntegers.
   *
   * @param num
   *    The numerator of the fraction.
   * @param den
   *    The denominator of the fraction.
   */
  public BigFraction(BigInteger num, BigInteger den) {
    if (den.compareTo(BigInteger.ZERO) == 0) {
      this.numerator = BigInteger.ZERO;
      this.denominator = BigInteger.ONE;
    } else if (den.compareTo(BigInteger.ZERO) < 0) {
      this.numerator = num.negate();
      this.denominator = den.negate();
    } else {
      this.numerator = num;
      this.denominator = den;
    } // elif
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Constructs a BigFraction from two integers.
   *
   * @param num
   *    The numerator of the fraction.
   * @param den
   *    The denominator of the fraction.
   */
  public BigFraction(int num, int den) {
    this.numerator = BigInteger.valueOf(num);
    this.denominator = BigInteger.valueOf(den);
  } // BigFraction(int, int)

  /**
   * Constructs a BigFraction from a single integer.
   *
   * @param number
   *    The single integer representing the numerator.
   */
  public BigFraction(int number) {
    this.numerator = BigInteger.valueOf(number);
    this.denominator = BigInteger.ONE;
  } // BigFraction(int)

  /**
   * Constructs a BigFraction from string.
   *
   * @param frac
   *    The string consisiting of backslash to indicate
   *    the numerator and denominator.
   */
  public BigFraction(String frac) {
    String[] strFrac = frac.split("/");
    this.numerator = new BigInteger(strFrac[0]);

    if (strFrac.length == 1) {
      this.denominator = BigInteger.ONE;
    } else {
      this.denominator = new BigInteger(strFrac[1]);
    } // elif
  } // BigFraction(String)

  /**
   * Reduces a fraction to its lowest form.
   *
   * @return
   *    A BigFraction that is simplified.
   */
  protected BigFraction reduce() {
    BigInteger gcd = this.numerator.gcd(this.denominator);
    BigInteger num = this.numerator.divide(gcd);
    BigInteger den = this.denominator.divide(gcd);
    return new BigFraction(num, den);
  } // reduce()

  /**
   * Creates a BigFraction with common denominator by cross-multiplying.
   *
   * @param frac
   *    The BigFraction that will be used to find a common denominator
   *    (the giant one).
   * @return
   *    A new BigFraction with a common denominator.
   */
  private BigFraction equiv(BigFraction frac) {
    BigInteger num = this.numerator.multiply(frac.denominator);
    BigInteger den = this.denominator.multiply(frac.denominator);
    return new BigFraction(num, den);
  } // equiv(BigFraction)

  /**
   * Adds two fractions together.
   *
   * @param addend
   *    The fraction to add.
   * @return
   *    A simplified BigFraction that represents the sum.
   */
  public BigFraction add(BigFraction addend) {
    // Create a common denominator
    BigFraction eqDenom = this.equiv(addend);

    // Convert both fractions to have common denominators, then add the two
    BigInteger num = eqDenom.numerator.add(this.denominator.multiply(addend.numerator));
    return new BigFraction(num, eqDenom.denominator).reduce();
  } // add(BigFraction)

  /**
   * Subtracts a fraction from another.
   *
   * @param subtrahend
   *    The fraction to subtract.
   * @return
   *    A simplified BigFraction that represents the difference.
   */
  public BigFraction subtract(BigFraction subtrahend) {
    // Create a common denominator
    BigFraction eqDenom = equiv(subtrahend);

    // Convert both fractions to have common denominators, then subtract the two
    BigInteger num = eqDenom.numerator.subtract(this.denominator.multiply(subtrahend.numerator));
    return new BigFraction(num, eqDenom.denominator).reduce();
  } // subtract(BigFraction)

  /**
   * Multiplies two fractions together.
   *
   * @param multiplier
   *    The fraction to multiply.
   * @return
   *    A simplified BigFraction that represents the product.
   */
  public BigFraction multiply(BigFraction multiplier) {
    BigInteger num = this.numerator.multiply(multiplier.numerator);
    BigInteger den = this.denominator.multiply(multiplier.denominator);
    return new BigFraction(num, den).reduce();
  } // multiply(BigFraction)

  /**
   * Divides one fraction by another.
   *
   * @param divisor
   *    The fraction to divide by.
   * @return
   *    A simplified BigFraction that represents the quotient.
   */
  public BigFraction divide(BigFraction divisor) {
    BigInteger num = this.numerator.multiply(divisor.denominator);
    BigInteger den = this.denominator.multiply(divisor.numerator);
    return new BigFraction(num, den).reduce();
  } // divide(BigFraction)

  /**
   * Clears a fraction by setting it to the default fraction, 0/1.
   *
   * @return
   *    A new BigFraction of the form 0/1.
   */
  protected BigFraction clear() {
    return new BigFraction(BigInteger.ZERO, BigInteger.ONE);
  } // clear()

  /**
   * Converts a BigFraction to a string.
   *
   * @return
   *    The BigFraction as a string.
   */
  public String toString() {
    BigFraction reduced = this.reduce();

    if (reduced.numerator.compareTo(BigInteger.ZERO) == 0) {
      return "0";
    } else if (reduced.denominator.compareTo(BigInteger.ZERO) == 0) {
      return "Undefined";
    } else if (reduced.denominator.compareTo(BigInteger.ONE) == 0) {
      return reduced.numerator.toString();
    } // elif
    return reduced.numerator.toString() + "/" + reduced.denominator.toString();
  } // toString()

  /**
   * The value of the numerator.
   *
   * @return
   *    A BigInteger numerator value.
   */
  public BigInteger numerator() {
    return this.reduce().numerator;
  } // numerator()

  /**
   * The value of the denominator.
   *
   * @return
   *    A BigInteger denominator value.
   */
  public BigInteger denominator() {
    return this.reduce().denominator;
  } // denominator()
} // class BigFraction
