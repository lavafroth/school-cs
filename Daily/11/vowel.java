import java.io.*;
import java.util.Scanner;
class vowel{
    public static void main(String args[]) throws IOException,FileNotFoundException {
        DataOutputStream fo = new DataOutputStream(new FileOutputStream("vowel.txt"));
        PrintStream o = System.out;
        o.print("[sentence]: ");
        String s = (new Scanner(System.in)).nextLine()+' ';
        for(int i=0;i<s.length();i=s.indexOf(' ',i)+1){
            String word = s.substring(i,s.indexOf(' ',i));
            if("aeiou".indexOf(Character.toLowerCase(word.charAt(0)))>-1) fo.writeBytes(word+'\n');
        }
        fo.close();
        o.print("File successfully written.");
    }
}
