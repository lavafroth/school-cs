class Test {
  public static void main(String args[]) {
    System.out.print("enter a number: ");
    Series s = new Series((new java.util.Scanner(System.in)).nextInt());
    s.calsum();
    s.display();
  }
}
