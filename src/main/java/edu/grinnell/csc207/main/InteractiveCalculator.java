package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.*;
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

    String user_input = input.nextLine();

    while (!user_input.equals("QUIT")) {
      String[] arguments = user_input.split(" ");

      if (!(QuickCalculator.allChecks(arguments, register, calculator))) {
        System.err.println("Error: Invalid input.");
      } // if
      calculator.clear();
      user_input = input.nextLine();
    } // while
    input.close();
    register.empty();
    calculator.clear();
  } // main(String[])
} // class InteractiveCalculator
