class sumSquareRecurse {
  static int sumSq(int n) {
    return n > 0 ? ((int) Math.pow(n % 10, 2) + sumSq(n / 10)) : 0;
  }

  public static void main(String args[]) {
    java.io.PrintStream o = System.out;
    o.print("[number for square sum]: ");
    o.println("sum of squares: " + sumSq((new java.util.Scanner(System.in)).nextInt()));
  }
}
