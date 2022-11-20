class MaxArr {
  int a[], size;
  java.util.Scanner sc = new java.util.Scanner(System.in);

  MaxArr(int n) {
    a = new int[size = n];
  }

  void read() {
    System.out.printf("Enter %d elements\n", size);
    for (int i = 0; i < size; i++) a[i] = sc.nextInt();
  }

  void print() {
    for (int i : a) System.out.print(i + "\t");
    System.out.println();
  }

  MaxArr sumOfElements(MaxArr m1) {
    MaxArr large = this.size > m1.size ? this : m1,
        small = large == this ? m1 : this, /* Mod: If one is large, the other has to be small */
        ret = new MaxArr(large.size);
    int x = 0;
    for (x = 0; x < small.size; x++) ret.a[x] = small.a[x] + large.a[x];
    for (; x < large.size; x++) ret.a[x] = large.a[x];
    return ret;
  }

  public static void main() {
    MaxArr mm1 = new MaxArr(5), mm2 = new MaxArr(5), mm3;
    mm1.read();
    mm2.read();
    mm1.print();
    mm2.print();
    mm3 = mm1.sumOfElements(mm2);
    mm3.print();
  }
}
