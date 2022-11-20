import java.util.Scanner;

class rec_rev {
  String RecRev(String z) {
    return ".!?".contains(z.charAt(z.length() - 1)) ? szRecRev(z) : "Invalid input.";
  }

  String szRecRev(String z) {
    int len = z.length();
    if (len / 2 == 0) return z;
    return z.charAt(len - 1) + szRecRev(z.substring(1, len - 1)) + z.charAt(0);
  }

  public static void main() {
    System.out.print("[input]: ");
    System.out.print((new rec_rev()).RecRev((new Scanner(System.in)).nextLine()));
  }
}
