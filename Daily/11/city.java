// read five city names and write them in a file called city.txt
import java.io.*;
import java.util.Scanner;

class city {
  public static void main(String args[]) throws IOException, FileNotFoundException {
    DataOutputStream fo = new DataOutputStream(new FileOutputStream("city.txt"));
    PrintStream o = System.out;
    Scanner s = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
      o.print("[city name]: ");
      fo.writeBytes(s.nextLine() + "\n");
    }
    fo.close();
    o.print("File successfully written.");
  }
}
