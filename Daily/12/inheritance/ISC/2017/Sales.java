class Sales extends Product {
  int day;
  double tax, totamt;

  Sales(String n, int c, double p, int d) {
    super(n, c, p);
    day = d;
  }

  void compute() {
    totamt = day * amount;
    tax = 0.124 * totamt;
    totamt += tax;
  }

  void show() {
    super.show();
    System.out.printf("\nSales:\ndays: %d\ntax: %f\ntotal amount: %f\n", day, tax, totamt);
  }
}
