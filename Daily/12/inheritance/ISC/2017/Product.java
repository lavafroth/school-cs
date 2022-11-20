class Product {
  String name;
  int code;
  double amount;

  Product(String n, int c, double p) {
    name = n;
    code = c;
    amount = p;
  }

  void show() {
    System.out.printf("Product details:\nname: %s\ncode: %d\namount: %f\n", name, code, amount);
  }
}
