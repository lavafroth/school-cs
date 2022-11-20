public class unique {
  private static void die(String message) {
    System.out.println(message);
    System.exit(0);
  }

  public static void main() {
    java.util.Scanner s = new java.util.Scanner(System.in);
    char a, b, c;
    System.out.print("Enter size: ");
    int n = s.nextInt(); // matrix size
    if (n < 1 || n > 10) { // checking range
      die("Out of range");
    }
    System.out.print("Enter a number: ");
    a = s.next().charAt(0);
    if (!Character.isDigit(a)) { // check digit validity
      die("Malformed input");
    }
    System.out.print("Enter a letter: ");
    b = s.next().charAt(0);
    if (!Character.isLetter(b)) { // check letter validity
      die("Malformed input");
    }
    System.out.print("Enter a symbol: ");
    c = s.next().charAt(0);
    if (Character.isDigit(c) || Character.isLetter(c) || c == 32) {
      die("Malformed input");
    }
    /* If it is a digit, letter or whitespace, it is not a symbol */
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // checking symbol's criteria first
        if (i == j || n - i - j == 1) System.out.print(c + " "); // print symbol
        else if (((i + j < n - 1) && j < i) || (i < j && (i + j > n - 1)))
          System.out.print(b + " "); // print letter
        else System.out.print(a + " "); // print digit
      }
      System.out.print("\n"); // Print out in matrix form
    }
  }
}
