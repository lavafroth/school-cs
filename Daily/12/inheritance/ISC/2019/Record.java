import java.util.Scanner;

class Record {
  String n[];
  double m[];
  int size;

  Record(int cap) {
    n = new String[size = cap];
    m = new double[size];
  }

  void readvalues() {
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < size; i++) {
      System.out.print("[enter name]: ");
      n[i] = s.nextLine();
      // accept names
      System.out.print("[enter rank]: ");
      m[i] = s.nextDouble();
      // accept rank
      s.nextLine();
    }
  }

  void display() {
    for (int i = 0; i < size; i++) System.out.println("[name]: " + n[i] + " [rank]: " + m[i]);
  }
  // print the name, print the rank, repeat
}
