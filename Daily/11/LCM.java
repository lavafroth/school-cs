import java.util.Scanner;
public class LCM {
    int n1, n2, large, sm, lcm;
    LCM(){n1=n2=large=sm=lcm=0;}
    void AcceptData(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter n1 and n2:");
        n1=s.nextInt();
        n2=s.nextInt();
        large=n1>n2?n1:n2;
        sm=n1>n2?n2:n1;
    }
    int GetLcm(int large, int sm){
        if ((lcm+=large)%sm==0)return lcm;
        else return GetLcm(large, sm);
    }
    void PrintData(){
        System.out.println("n1 = "+n1+"\nn2 = "+n2+"\nlcm = "+GetLcm(n1,n2));
    }
    public static void main(){
        LCM gen = new LCM();
        gen.AcceptData();
        gen.PrintData();
    }
}