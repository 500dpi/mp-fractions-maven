package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * InteractiveCalculator.java
 *
 * A calculator class that can perform simple operations.
 *
 * @author Sara Jaljaa
 * @course CSC-207-01
 */
public class InteractiveCalculator {

  /**
   * Prints a calculate value from command line arguments.
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

    String expression = input.nextLine();

    while (!expression.equals("QUIT")) {
      if (expression == null || expression == " ") {
        System.err.println("Error: Cannot evaluate non-fraction terms.");
      } // if

      String[] arguments = expression.split(" ");

      if (!(QuickCalculator.allChecks(arguments, register, calculator))) {
        System.err.println("Error: Invalid input.");
      } // if
      calculator.clear();
      expression = input.nextLine();
    } // while
    input.close();
    pen.close();
    register.empty();
    calculator.clear();
  } // main(String[])
} // class InteractiveCalculator
