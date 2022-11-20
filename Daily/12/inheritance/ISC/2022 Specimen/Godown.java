/* Basic template */
class Godown {
  String item;
  int qty;
  double rate, amt;

  Godown(String SZitem, int Iqty, double Drate) {
    item = SZitem;
    qty = Iqty;
    rate = Drate;
  }

  void display() {
    System.out.printf(
        "Item name: %s\nQuantity: %d\nRate: %f\nAmount: %f\n", item, qty, rate, qty * rate);
  }
}

/* Scanner templates
import java.util.Scanner;
Scanner s = new Scanner(System.in);
    // s.mess_around()
s.close()

/* Anonymous Scanner object
 * ONE SHOT
 * Requires no imports
 * WARNING: This can leak data
   since the object is never
   closed


(new java.util.Scanner(System.in))

/* PrintStream shorthand
 * No imports required

java.io.PrintStream o = System.out;
*/
