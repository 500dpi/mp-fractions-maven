package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * A calculator that takes multiple arguments as input.
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 */
public class QuickCalculator {

  /**
   * Prints a calculated value from expressions entered in command line arguments.
   *
   * @param args
   *    Command line arguments containing operations, fractions,
   *    and string commands.
   */
  public static void main(String[] args) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);
    String[] arguments = null;
    char ch;

    pen.println("Enter an expression to evaluate: ");

    String expression = input.nextLine();

    while (!expression.equals("QUIT")) {
      ;
    } // while

    // while (!expression.equals("QUIT")) {
    //   if (expression.length() == 1 && (expression.charAt(0) <= ' ')) {
    //     System.err.printf("Error: Invalid input: %s.\n", expression);
    //   } else {
    //     arguments = expression.split(" ");

    //     if (!(checkAll(arguments, register, calculator))) {
    //       System.err.printf("Error: Invalid input: %s.\n", expression);
    //     } // if
    //     calculator.clear();
    //   } // elif
    //   expression = input.nextLine();
    //   pen.flush();
    // } // while

    // if (arguments[0].equals("STORE")) {
    //   if (isRegister(arguments[1])) {
    //     register.store(arguments[1].charAt(0), calculator.get());
    //   } // if
    // } // if

    // input.close();
    // register.empty();
    // calculator.clear();
  } // main(String[])

  /**
   * Checks edge-cases and whether there is a register, fraction, and/or symbol present
   * in the command line arguments.
   *
   * @param args
   *    An array of command line arguments
   * @param register
   *    An array of BigFraction to store fractions in.
   * @param calculator
   *    A calculator that stores the last calculated value.
   * @return
   *    A boolean value.
   */
  // public static boolean checkAll(String[] args, BFRegisterSet register, BFCalculator calculator) {
    // PrintWriter pen = new PrintWriter(System.out, true);
    // BigFraction frac;

  //   if (args == null) {
  //     return false;
  //   } // if
    
  //   // Check that there is the correct arguments for an expression
  //   if (args.length % 2 != 1 && !(args[0].equals("STORE"))) {
  //     return false;
  //   } // if

  //   // Check if the argument is a register command
  //   if (args[0].equals("STORE") && isRegister(args[1])) {
  //     register.store(args[1].charAt(0), calculator.get());
  //   }

  //   if (!(isFraction(args[0]) || isSymbol(args[0]) || isRegister(args[0]))) {
  //     return false;
  //   } else if (isFraction(args[0])) {
  //     calculator.add(new BigFraction(args[0]));
  //   } else if (isRegister(args[0])) {
  //     calculator.add(register.get(args[0].charAt(0)));
  //   } // if

  //   if ((args[0].compareTo("STORE") == 0)) {
  //     if (isRegister(args[1])) {
  //       register.store(args[1].charAt(0), calculator.get());
  //     } // if
  //   } // if

  //   for (int i = 1; i < args.length; i += 2) {
  //     if (isFraction(args[i + 1])) {
  //       frac = new BigFraction(args[i + 1]);
  //     } else if (isRegister(args[i + 1]) && register.get(args[i + 1].charAt(0)) != null) {
  //       frac = register.get(args[i + 1].charAt(0));
  //     } else {
  //       return false;
  //     } // if

  //     evaluate(args[i], frac, calculator);
  //   } // for

  //   pen.println(calculator.get().toString());
  //   return true;
  // } // allChecks(String[], BFRegisterSet, BFCalculator)
} // class QuickCalculator
