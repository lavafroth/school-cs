public class LCM {
  int n1, n2, large, sm, lcm;

  LCM() {
    n1 = n2 = large = sm = lcm = 0;
  }

  void AcceptData() {
    java.util.Scanner s = new java.util.Scanner(System.in);
    System.out.println("Enter n1 and n2:");
    n1 = s.nextInt();
    n2 = s.nextInt();
    large = n1 > n2 ? n1 : n2;
    sm = n1 > n2 ? n2 : n1;
  }

  int GetLcm(int large, int sm) {
    if ((lcm += large) % sm == 0) return lcm;
    return GetLcm(large, sm);
  }

  void PrintData() {
    System.out.printf("n1 = %d\nn2 = %d\nlcm = %d\n", n1, n2, GetLcm(n1, n2));
  }

  public static void main() {
    LCM lcm = new LCM();
    lcm.AcceptData();
    lcm.PrintData();
  }
}
