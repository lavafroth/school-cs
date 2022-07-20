public class Link {
  int lnk[], max, end, begin;
  // RAII pattern: Resource allocation is initialization
  Link(int mm) {
    lnk = new int[max=mm];
  }
  public void addlink(int v) {
    if(end==max) {
      System.out.println("OUT OF SIZE ...");
      return;
    }
    lnk[end++] = v;
  }
  public int dellink() {
    if(begin==end) {
      System.out.println("EMPTY ...");
      return 99;
    }
    return lnk[begin++];
  }
  public void display() {
    for(int i=begin; i<end; System.out.println(lnk[i++]));
  }
}
