class Register {
  String stud[];
  int cap, top;

  Register(int max) {
    top = -1;
    stud = new String[cap = max];
  }

  void push(String n) {
    if (top != cap - 1) stud[++top] = n;
  }

  String pop() {
    return top < 0 ? "" : stud[top--];
  }

  void display() {
    for (int x = 0; x < top + 1; x++) System.out.println(stud[x]);
  }

  public static void main(String args[]) {
    Register reg = new Register(3);
    System.out.println(reg.pop()); /* Should print nothing */
    reg.push("Tyrell Wellick");
    reg.push("Angela Moss");
    reg.push("Darlene Alderson");
    reg.push("Elliot Alderson"); /* Should not work */
    reg.display();
  }
}
