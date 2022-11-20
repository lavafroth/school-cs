class Number {
  int n;

  Number(int nn) {
    n = nn;
  }

  public int factorial(int n) {
    for (int i = 1; ; i *= n--) {
      if (n == 0) return i;
    }
  }

  public void display() {
    System.out.printf("n = %d\n", n);
  }
}
