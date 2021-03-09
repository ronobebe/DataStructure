package Algorithms.FairDraft.Convertions;

import java.util.*;

public class Binary {

  /**
   * Any number consist of only zeros and ones called binaries Ex : 01110111..... while convert from
   * any base to base binary is basic step of it
   */


  private static final int MINIMUM_BASE = 2;

  private static final int MAXIMUM_BASE = 36;

  public static void main(String[] args) {
    // conversion to get input
    Scanner sc = new Scanner(System.in);

    System.out.println("Please enter the number you wants to convert");

    String inputNumber = sc.next();
    int base1, base2;

    while (true) {
      try {

        System.out.println(
            "Please enter the base you want to convert from "
                + MINIMUM_BASE
                + " to "
                + MAXIMUM_BASE);

        base1 = sc.nextInt();

        if (base1 < 2 || base1 > 36) {
          System.out.println("Invalid Base!");
          continue;
        }

        if (!checkValidNumber(base1, inputNumber)) {
          System.out.println("Number you entered is invalid");
          sc.next();
        }
        System.out.println(
            "Please enter the base you want to convert to " + MINIMUM_BASE + " to " + MAXIMUM_BASE);

        base2 = sc.nextInt();

        if (base2 < 2 || base2 > 36 || base1 == base2) {
          System.out.println("Invalid Base!");
          continue;
        }
        break;

      } catch (InputMismatchException e) {
        System.out.println("Invalid input.");
        sc.next();
      }
    }
    System.out.println("Output is : " + convertAnyBaseTOBinary(base1, base2, inputNumber));
  }

  private static boolean checkValidNumber(int base, String input) {

    final char[] number = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    char[] baseDigits = Arrays.copyOfRange(number, 0, base);

    // Convert character array into set for convenience of contains() method
    HashSet<Character> digitsList = new HashSet<>();
    for (int i = 0; i < baseDigits.length; i++) digitsList.add(baseDigits[i]);

    // Check that every digit in n is within the list of valid digits for that base.
    for (char c : input.toCharArray()) if (!digitsList.contains(c)) return false;

    return true;
  }

  private static String convertAnyBaseTOBinary(int base1, int base2, String input) {

    String output = "";
    int decimal = convertAnyNumberToDecimal(base1,  input);

    if (decimal == 0) return "0";

    while (decimal != 0) {
      int temp = decimal % base2;
      if (temp < 10) output = temp + output;
      else /*if (temp >= 10)*/
        output = (char) (temp + 55) + output; // 65 for A minimum num enter here is 10 so (55+10=65) so constant 55
      decimal /= base2;
    }

    return output;
  }

  private static int convertAnyNumberToDecimal(int base1, String inputNumber) {
    char[] inputArray = inputNumber.toCharArray();
    char b;

    int output = 0, output1;

    for (int i = 0; i < inputArray.length; i++) {
      b = inputArray[i];
      if (b >= 'A' && b <= 'Z') output1 = 10 + (b - 'A'); // 57 char starts from 57
      else output1 = b - '0'; // 48 int starts from 48

      output = output * base1 + output1;
    }

    return output;
  }
}
