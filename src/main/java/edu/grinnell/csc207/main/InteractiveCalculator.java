package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

import java.util.Scanner;
import java.io.PrintWriter;

/**
 * A calculator class that can perform simple operations.
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 */
public class InteractiveCalculator {

  /**
   * Calculates single expressions.
   *
   * @param args
   *    Command line arguments containing operations,
   *    fractions, and string commands.
   */
  public static void main(String[] args) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();

    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);

    pen.println("Enter an expression to evaluate: ");
    pen.print("> ");
    pen.flush();

    String[] expression = (input.nextLine()).split(" ");

    while(!expression[0].equals("QUIT")) {
      parseExpression(expression, calculator, register, pen);
      pen.print("> ");
      pen.flush();
      expression = (input.nextLine()).split(" ");
    } // while
    pen.close();
    input.close();
  } // main(String[])

  /**
   * Parses a string and evaluates the expression if it is valid.
   *
   * @param exp
   *    The expression to evaluate.
   * @param calc
   *    The calculator to evaluate the expression with.
   * @param reg
   *    The register that stores characters to evaluate in expressions.
   * @param pen
   *    The pen that prints the evaluated expression.
   * @return
   *    A boolean representing whether an expression is valid or not.
   */
  public static boolean parseExpression(String[] exp, BFCalculator calc,
      BFRegisterSet reg, PrintWriter pen) {
    String operator = null;
    String fraction = null;
    BigFraction frac = null;

    // Check if "STORE" is the first argument
    if (exp[0].equals("STORE") && isRegister(exp[1])) {
      reg.store(exp[1].charAt(0), calc.get());
      pen.println("STORED");
      calc.clear();
      return true;
    } else {
      calc.clear();
    } // elif

    // Check for invalid flags
    if (!flags(exp, calc, reg)) {
      return false;
    } // if

    // Check if a fraction or register are the first argument
    if (isRegister(exp[0])) {
      calc.add(reg.get(exp[0].charAt(0)));
    } else if (isFraction(exp[0])) {
      calc.add(new BigFraction(exp[0]));
    } // elif

    // Check for normal fraction/register distribution through an
    // expression
    for (int i = 1; i < exp.length - 1; i =+ 2) {
      operator = exp[i];
      fraction = exp[i + 1];

      // Ensure the operator is a mathematical operator
      if (!isOperator(operator)) {
        return false;
      } // if

      // If the value frac is a fraction or register, evaluate
      // it appropriately
      if (isFraction(fraction)) {
        frac = new BigFraction(fraction);
        pen.println("Frac has been assigned.");
      } else if (isRegister(fraction)) {
        if (reg.get(fraction.charAt(0)) != null) {
          frac = reg.get(fraction.charAt(0));
          pen.println("Frac has been registered.");
        } else {
          pen.println("Error: Not a valid register.");
          return false;
        } // elif
      } else {
        pen.println("Error: Not a fraction.");
        return false;
      } // elif
      evaluate(operator, frac, calc);
      pen.println("Got here.");
      pen.println(calc.get().toString());
    } // for
    pen.println(calc.get().toString());
    return true;
  } //parseExpression(String[], BFCalculator, BFRegisterSet, PrintWriter)

  /**
   * Maps a string of expression arguments to parse
   * (for multiple expressions entered in calcluator).
   *
   * @param exp
   *    The expressions to evaluate.
   * @param calc
   *    The calculator to evaluate expressions with.
   * @param reg
   *    The register that stores characters.
   */
  public static void map(String[] exp, BFCalculator calc, BFRegisterSet reg) {
    // IMPLEMENT: map string arrays to parseExpression, then input to parseExpression() call
  } // map(String[], BFCalculator, BFRegisterSet)

  /**
   * Checks edge cases in an expression.
   *
   * @param exp
   *    The expression as a string.
   * @param calc
   *    The BFcalculator object.
   * @param reg
   *    The register set.
   * @return
   *    True or false if the expression is valid.
   */
  public static boolean flags(String[] exp, BFCalculator calc, BFRegisterSet reg) {
    // Case: Parameter is not 3 or 1.
    if (exp.length % 2 == 1) {
      return true;
    } // if

    // Case: Argument is not a register, fraction, or operator
    for (int i = 0; i < exp.length; i++) {
      if (!(isRegister(exp[0]) || isFraction(exp[0]) || isOperator(exp[0]))) {
        return false;
      } // if
    } // for

    // Case: Operator is first argument
    if (isOperator(exp[0])) {
      return false;
    } // if
    return true;
  } // flags(String[], BFCalculator, BFRegister)

  /**
   * Check if the string is a register character.
   *
   * @param reg
   *    A string that represents one lowercase letter register char.
   * @return
   *    A boolean value.
   */
  public static boolean isRegister(String reg) {
    return (reg.length() == 1 && (reg.charAt(0) >= 'a'
            && reg.charAt(0) <= 'z'));
  } // isRegister(String)

  /**
   * Check if the string is a math operator matching
   * +, -, *, or /.
   *
   * @param arg
   *    A string variable.
   * @return
   *    A boolean value.
   */
  public static boolean isOperator(String arg) {
    return (arg.equals("+") || arg.equals("-")
            || arg.equals("/") || arg.equals("*"));
  } // isOperator(String)

  /**
   * Checks if the string is a fraction.
   *
   * @param arg
   *    A string variable.
   * @return
   *    A boolean value.
   */
  public static boolean isFraction(String arg) {
    for (int i = 0; i < arg.length(); i++) {
      if ((i == 0 || i == arg.length() - 1) && arg.charAt(i) == '/') {
        return false;
      } // if

      if (i != 0 && arg.charAt(i) == '-') {
        return false;
      } // if
      
      if ((arg.charAt(i) >= '0') && (arg.charAt(i) <= '9')) {
        return true;
      } // if
    } // for
    return false;
  } // isFraction(String)

  /**
   * Evaluate a fraction expression.
   *
   * @param symbol
   *    The math operator.
   * @param frac
   *    The fraction to evaluate.
   * @param calculator
   *    The BFcalculator that stores the last computed fraction.
   */
  public static void evaluate(String symbol, BigFraction frac, BFCalculator calculator) {
    switch (symbol) {
      case "+":
        calculator.add(frac);
        break;
      case "-":
        calculator.subtract(frac);
        break;
      case "*":
        calculator.multiply(frac);
        break;
      case "/":
        calculator.divide(frac);
        break;
      default:
        break;
    } // switch
  } // evaluate(String[], BigFraction, BFCalculator)
} // class InteractiveCalculator
