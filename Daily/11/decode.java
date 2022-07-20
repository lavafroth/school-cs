import java.util.Scanner;
class decode{
    static void die(String msg){
        System.out.println(msg);
        System.exit(0);
    }
    public static void main(String args[]){
        System.out.print("[encoded text]: ");
        String in =(new Scanner(System.in)).nextLine(), out="";
        if(in.length()>200)die("length out of bounds.");
        in=in.replace("KK"," ").replace("  "," ");
        System.out.print("decoded text: ");
        for(int x=0;x<in.length();x++){
            char c=in.charAt(x);
            if(Character.isDigit(c))continue;
            if(!Character.isWhitespace(c))c=(char)(65+(c-65+2)%26);
            System.out.print((x==0||in.charAt(x-1)==32)?Character.toUpperCase(c):Character.toLowerCase(c));
        }
        die("");
    }
}
