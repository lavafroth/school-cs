import java.util.Scanner;
import java.io.*;
class logfile{
    public static void main(String args[]) throws IOException, FileNotFoundException{
        PrintStream o = System.out;
        Scanner s = new Scanner(System.in);
        DataOutputStream fo = new DataOutputStream(new FileOutputStream("logfile.txt"));
        String in;
        int c, l;
        o.println("Enter sentences:");
        while(!(in=s.nextLine()).equals("NULL")){
            c=in.length()+1; /* Accomodating for newline */
            fo.writeBytes(in+'\n');
        }
        o.println("logfile written.");
    }
}
