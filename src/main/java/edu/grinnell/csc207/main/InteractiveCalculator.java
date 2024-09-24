package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.*;
import java.util.Scanner;
import java.io.PrintWriter;

public class InteractiveCalculator {

  public static void main(String[] args) {
    BFCalculator calculator = new BFCalculator();
    BFRegisterSet register = new BFRegisterSet();
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner input = new Scanner(System.in);

    pen.println("Enter an expression to evaluate: ");
    pen.flush();

    String user_input = input.nextLine();

    while (!user_input.equals("QUIT")) {
      String[] arguments = user_input.split(" ");

      if (!(allChecks(arguments, register, calculator))) {
        System.err.println("Error: Invalid input.");
      } // if
      calculator.clear();
      user_input = input.nextLine();
    } // while
    input.close();
    register.empty();
    calculator.clear();
  } // main(String[])

  public static boolean regTest(String arg) {
    char[] reg = arg.toCharArray();
    if (arg.length() == 1 && (reg[0] >= 'a' && reg[0] <= 'z')) {
      return true;
    } // if
    return false;
  } // regTest(String)

  public static boolean symTest(String arg) {
    if (arg.equals("+") || arg.equals("-") || arg.equals("/") || arg.equals("*")) {
      return true;
    } // if
    return false;
  } // symTest(String)

  public static boolean fracTest(String arg) {
    char[] frac = arg.toCharArray();
    for (int i = 0; i < frac.length; i++) {
      if (frac[i] == '/' && (i == 0 || i == frac.length - 1)) {
        return false;
      } else if ((frac[i] > '0') && (frac[i] < '9')) {
        return true; 
      } else if (frac[i] == '-' && i != 0) {
        return false;
      } // if
    } // for
    return false;
  } // fracTest(String)
  
  public static boolean allChecks(String[] args, BFRegisterSet register, BFCalculator calculator) {
    PrintWriter pen = new PrintWriter(System.out, true);
    String fraction, symbol;
    BigFraction frac;

    if (!(fracTest(args[0]) || symTest(args[0]) || regTest(args[0]))) {
      return false;
    } else if (fracTest(args[0])) {
      calculator.add(new BigFraction (args[0]));
    } else if (regTest(args[0])) {
      calculator.add(register.get(args[0].charAt(0)));
    } 

    if ((args[0].compareTo("STORE") == 0)) {
      if (regTest(args[1])) {
       register.store(args[1].charAt(0), calculator.get());
      } 
    }

    if (args.length == 1) {
      pen.println(calculator.get().toString());
      return true;
    } else if (args.length < 3) {
      return false;
    }

    for (int i = 1; i < args.length; i += 2) {
      fraction = args[i + 1];
      symbol = args[i];
      if (fracTest(fraction)) {
        frac = new BigFraction(fraction);
      } else if (regTest(fraction) && register.get(fraction.charAt(0)) != null) {
        frac = register.get(fraction.charAt(0));
      } else {
        return false;
      }

      switch (symbol) {
        case "+": calculator.add(frac);
                  break;
        case "-": calculator.subtract(frac);
                  break;
        case "*": calculator.multiply(frac);
                  break;
        case "/": calculator.divide(frac);
                  break;
        default:  break;
      } // switch
    } // for

    calculator.get().reduce();
    pen.println(calculator.get().toString());
    pen.flush();
    return true;
  }
}
