import java.util.Scanner;
class cprime{
    private static boolean cprime(int x){
        int tmp=x;
        do{
            if(!prime(tmp))return false;
            tmp=tmp%10*(int)Math.pow(10,(int)Math.log10(tmp))+tmp/10;// decimal right shift digits
        }while(tmp!=x);
        return true;
    }

    private static boolean prime(int x){
        for(int i=2;i<x;i++)if(x%i==0)return false;
        return true;
    }

    public static void main(String args[]){
        System.out.print("input: ");
        System.out.println("It is "+(cprime((new Scanner(System.in)).nextInt())?"":"not ")+"a circular prime");
    }
}