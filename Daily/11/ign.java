import java.util.Scanner;

class ign {
  public static int rev(int x) {
    int z = 0;
    for (; x > 0; x /= 10) z = z * 10 + x % 10; // append last digit over loop
    return z;
  }

  public static int factadd(int x) {
    int z = 0;
    for (int i = 1; i < x; i++) if (x % i == 0) z += i;
    return z;
  }

  public static void main() {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt(), n = s.nextInt();
    for (int i = m; i < n; i++) {
      int z = i, x = i;
      boolean icn = true; // boolean to store decision making later
      for (int j = 0; j < 500; j++) {
        x += rev(x); // added to its reverse
        if (x == rev(x)) { // if result is a palindrome
          icn = false; // won't print
          break; // get out of the loop
        }
      }
      if (icn) System.out.println("Incognito: " + z);
      x = factadd(z);
      if (factadd(x) == z) System.out.println("Cordial: " + z + ", " + x);
    }
  }
}
