package edu.grinnell.csc207.util;
import java.math.BigInteger;
import java.io.PrintWriter;

/*
 * A class that creates a thistion of type BigInteger.
 */
public class BigFraction {

  public BigInteger numerator;
  public BigInteger denominator;

  private static final BigInteger defaultNum = BigInteger.ZERO;
  private static final BigInteger defaultDen = BigInteger.ONE;

  public BigFraction(BigInteger num, BigInteger den) {
    if (den.compareTo(BigInteger.ZERO) == 0) {
      this.numerator = defaultNum;
      this.denominator = defaultDen;
    } else if (den.compareTo(BigInteger.ZERO) < 0) {
      this.numerator = num.negate();
      this.denominator = den.negate();
    } else {
      this.numerator = num;
      this.denominator = den;
    } // if
  } // BigFraction(BigInteger,BigInteger)

  public BigFraction(int num, int den) {
    this.numerator = BigInteger.valueOf(num);
    this.denominator = BigInteger.valueOf(den);
  } // BigFraction(int,int)

  public BigFraction(int number) {
    this.numerator = BigInteger.valueOf(number);
    this.denominator = BigInteger.ONE;
  }

  public BigFraction(String frac) {
    // PrintWriter pen = new PrintWriter(System.out, true);
    String[] strFrac = frac.split("/");
    if (strFrac.length == 1) {
      this.denominator = BigInteger.ONE;
    } else {
      this.numerator = new BigInteger(strFrac[0]);
      this.denominator = new BigInteger(strFrac[1]);
    } // if
  } // BigFraction(String)

  public BigFraction reduce() {
    BigInteger num, den, GCD;
    GCD = this.numerator.gcd(this.denominator);
    num = this.numerator.divide(GCD);
    den = this.denominator.divide(GCD);
    return new BigFraction(num, den);
  } // reduce()

  public BigFraction add(BigFraction addend) {
    BigInteger num, den;
    PrintWriter pen = new PrintWriter(System.out, true);
    num = (this.numerator.multiply(addend.denominator)).add(this.denominator.multiply(addend.numerator));
    den = (this.denominator.multiply(addend.denominator));
    pen.println("Added: " + new BigFraction(num, den).reduce());
    return new BigFraction(num, den).reduce();
  } // add(BigFraction)

  public BigFraction subtract(BigFraction subtrahend) {
    BigInteger num, den;
    num = (this.numerator.multiply(subtrahend.denominator)).subtract(this.denominator.multiply(subtrahend.numerator));
    den = (this.denominator.multiply(subtrahend.denominator));
    return new BigFraction(num, den).reduce();
  } // subtract(BigInteger)

  public BigFraction multiply(BigFraction multiplier) {
    BigInteger num, den;
    num = this.numerator.multiply(multiplier.numerator);
    den = this.denominator.multiply(multiplier.denominator);
    return new BigFraction(num, den).reduce();
  } // multiply(BigInteger)

  public BigFraction divide(BigFraction divisor) {
    BigInteger num, den;
    num = this.numerator.multiply(divisor.denominator);
    den = this.denominator.multiply(divisor.numerator);
    return new BigFraction(num, den).reduce();
  } // divide(BigFraction)

  public BigFraction clear() {
    return new BigFraction(BigInteger.ZERO, BigInteger.ZERO);
  } // clear()

  public String toString() {
    if (this.numerator == BigInteger.ZERO || this.denominator == BigInteger.ZERO) {
      return "0";
    } else if (this.denominator == BigInteger.ONE) {
      return this.numerator.toString();
    } 
    this.reduce();
    return this.numerator.toString() + "/" + this.denominator.toString();
  } // toString()

  public BigInteger numerator() {
    return this.numerator;
  }

  public BigInteger denominator() {
    return this.denominator;
  }

  public BigInteger fracToWhole() {
    if (this.denominator.remainder(this.numerator) == BigInteger.ZERO) {
      BigInteger quotient = this.denominator.divide(this.numerator);
      return quotient;
    } 
    return BigInteger.ZERO;
  }
} // class BigFraction
