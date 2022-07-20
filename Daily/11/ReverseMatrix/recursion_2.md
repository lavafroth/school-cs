# LCM Recursion Program

### Source Code

```java
import java.util.Scanner;
public class LCM {
    int n1, n2, large, sm, lcm;
    LCM(){n1=n2=large=sm=lcm=0;}
    void AcceptData(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter n1 and n2:");
        n1=s.nextInt();
        n2=s.nextInt();
        large=n1>n2?n1:n2; // get the largest and smallest
        sm=n1>n2?n2:n1;	   // using ternary
    }
    int GetLcm(int large, int sm){
        if ((lcm+=large)%sm==0)return lcm;
        else return GetLcm(large, sm);
    }
    /* add the largest to lcm till it reaches some multiple of sm
     * using instance variable lcm as an accumulator here
     */
    void PrintData(){
        System.out.println("n1 = "+n1+"\nn2 = "+n2+"\nlcm = "+GetLcm(n1,n2));
    }
    public static void main(){
        LCM gen = new LCM();
        gen.AcceptData();
        gen.PrintData();
    }
}
```

























### Output

![](/home/himadrey/lcm1.png)

![lcm2](/home/himadrey/lcm2.png)

![lcm3](/home/himadrey/lcm3.png)

---































# Armstrong number Recursion Program

### Source Code

```java
import java.util.Scanner;
public class Armstrong {
    long num,cube;
    Armstrong(long nx){
        num=nx;
        cube=0;
    }
    long RecCubeDigit(long q){return q*(++cube==2?q:RecCubeDigit(q));}
    /* reusing instance variable cube here as a counter (zero based).
     * That's why use (cube=0) to zero it out temporarily for mutating cube.
     * If index is 2, you get the cube by multiplying q once more.
     */
    long RecGetDigitSum(long N){
        cube+=(cube=0)+RecCubeDigit(N%10); //add the cube of last digit
        return (N==0)?cube:RecGetDigitSum(N/10); // repeat chopping off last digit
    }
    boolean IsArmstrong(){return RecGetDigitSum(num)==num;}
    // check if sum of cubes returned is the same as initial
    void display(){System.out.print(num+" is "+(IsArmstrong()?"":"not ")+"an Armstrong number.");}
    //ternary based printing
    public static void main(){
        System.out.print("Enter an integer: ");
        Armstrong a=new Armstrong((new Scanner(System.in)).nextInt());
        a.display();
    }
}
```























### Output

![](/home/himadrey/arm1.png)

![arm2](/home/himadrey/arm2.png)

![arm3](/home/himadrey/arm3.png)

---

### 