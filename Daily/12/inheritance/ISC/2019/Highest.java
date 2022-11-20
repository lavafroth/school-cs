class Highest extends Record {
  int index = 0;

  Highest(int cap) {
    super(cap);
  }

  void highest() {
    for (int i = 0; i < size; i++) index = m[i] > m[index] ? i : index;
  }
  // linear search through the rank array
  void display() {
    n[index] += " [topmost rank]";
    super.display();
  }
  ;
  // append the "topmost" tag to the name
}
