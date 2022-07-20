import java.util.Scanner;
public class recurse{
    static long fact(long n){
        return n*(n==1?1:fact(n-1));
    }
    static double pow(long base, int dex){ //base and index
        // if index is 1 it needs last order base
        return base*(dex==1?1:pow(base,dex-1));
    }
    static double series(long n, double sum){
        return sum+(n==0?0:(pow(n,2)/fact(n)+series(n-1,sum))); // previous sum + (x^2)/x! + next
    }
    static double series(long n){
        return series(n,0); // method overloading to keep initial sum as 0
    }
    public static void main(){
        System.out.print("Enter a limit: "); //take some user input
        System.out.println("Sum of sequence (series) = "+series((new Scanner(System.in)).nextLong()));
    }
}