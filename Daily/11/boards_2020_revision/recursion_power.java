import java.io.*;
class recursion_power{
    static void find_attend() throws IOException {
        String emp;
        DataInputStream fi = new DataInputStream(new FileInputStream("Attend.txt"));
        try {
            emp = fi.readLine();
            if(fi.readInt()>80) System.out.println(emp);
        }
        catch (EOFException e){
            System.out.print("----------------");
            fi.close();
        }
    }
    public static void main(String args[]){
    }
}