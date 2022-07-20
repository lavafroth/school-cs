public class Update extends Godown {
  int pur_qty;
  double pur_rate;
  Update(String SZitem, int Iqty, double Drate, int Ipur_qty,
         double Dpur_rate) {
    super(SZitem, Iqty, Drate);
    pur_qty = Ipur_qty;
    pur_rate = Dpur_rate;
  }
  void update() {
    qty += pur_qty;
    rate = pur_rate;
    amt += pur_qty * pur_rate;
  }

  void display() {
    super.display();
    update();
    super.display();
  }
  public static void main(String args[]) {
    Update Udemo = new Update("USB Stick", 1337, 15.99, 10, 16.99);
    Udemo.display();
  }
}
