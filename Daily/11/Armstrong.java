import java.util.Scanner;

public class Armstrong {
  long num, cube;

  Armstrong(long nx) {
    num = nx;
    cube = 0;
  }

  long RecCubeDigit(long q) {
    return q * (++cube == 2 ? q : RecCubeDigit(q));
  }
  /* reusing instance variable cube here as a counter (zero based).
   * That's why use (cube=0) to zero it out temporarily for mutating cube.
   * If index is 2, you get the cube by multiplying q once more.
   */
  long RecGetDigitSum(long N) {
    cube += (cube = 0) + RecCubeDigit(N % 10); // add the cube of last digit
    return (N == 0) ? cube : RecGetDigitSum(N / 10); // repeat chopping off last digit
  }

  boolean IsArmstrong() {
    return RecGetDigitSum(num) == num;
  }
  // check if sum of cubes returned is the same as initial
  void display() {
    System.out.print(num + " is " + (IsArmstrong() ? "" : "not ") + "an Armstrong number.");
  }
  // ternary based printing
  public static void main() {
    System.out.print("Enter an integer: ");
    Armstrong a = new Armstrong((new Scanner(System.in)).nextInt());
    a.display();
  }
}
