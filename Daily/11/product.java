import java.util.Scanner;
import java.io.*;
class product{
    static PrintStream o = System.out;
    void findpro(int p) throws FileNotFoundException, IOException{
        DataInputStream fi = new DataInputStream(new FileInputStream("ABC.DAT"));
        String s;
        int index;
        for(;(s=fi.readLine())!=null;index=0){
            int pc = Integer.parseInt(s.substring(0,(index=s.indexOf(","))));
            if(pc == p){
                o.println("product id: "+p+"\nunit price: "+s.substring(index+1,(index=s.indexOf(",",index+1)))+"\nquantity: "+s.substring(index+1));
                return;
            }
        }
        fi.close();
        o.println("product not found.");
    }
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Scanner s = new Scanner(System.in);
        product p = new product();
        o.print("[product id:] ");
        p.findpro(s.nextInt());
    }
}
