import java.util.Scanner;
class rec_rev{
    char cLast;
    String RecRev(String z){
        return (z.endsWith(".")||z.endsWith("!")||z.endsWith("?")) ? szRecRev(z):"Invalid input.";
    }
    String szRecRev(String z){
        int len = z.length();
        if(len / 2 == 0)return z;
        return z.charAt(len-1) + szRecRev(z.substring(1, len - 1)) + z.charAt(0);
    }
    public static void main(){
        rec_rev RecRev = new rec_rev();
        System.out.print("[input]: ");
        System.out.print(RecRev.RecRev((new Scanner(System.in)).nextLine()));
    }
}