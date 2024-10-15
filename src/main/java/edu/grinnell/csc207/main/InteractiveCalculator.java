/*
 * InteractiveCalculator.java
 *
 * Author: Sara Jaljaa
 * Course: CSC-207-01
 *
 */

package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
// import edu.grinnell.csc207.util.BigFraction;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * A calculator class that can perform simple operations.
 */
public class InteractiveCalculator {
  /**
  * Prints a calculate value from command line arguments.
  *
  * @param args Command line arguments containing operations,
  * fractions, and string commands.
  */
  public static void main(String[] args) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);

    pen.println("Enter an expression to evaluate: ");

    String userInput = input.nextLine();

    while (!userInput.equals("QUIT")) {
      String[] arguments = userInput.split(" ");

      if (!(QuickCalculator.allChecks(arguments, register, calculator))) {
        System.err.println("Error: Invalid input.");
      } // if
      calculator.clear();
      userInput = input.nextLine();
    } // while
    input.close();
    register.empty();
    calculator.clear();
  } // main(String[])
} // class InteractiveCalculator
