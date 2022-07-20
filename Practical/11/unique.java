    import java.util.Scanner;
    public class unique {
        public static void main() {
            Scanner s = new Scanner(System.in);
            char a,b,c;
            System.out.print("Enter size: ");
            int n = s.nextInt(); // matrix size
            if(n<1||n>10){ // checking range
                System.out.println("Out of range");
                System.exit(0);
            }
            System.out.print("Enter a number: ");
            a = s.next().charAt(0);
            if(!Character.isDigit(a)){ // check digit validity
                System.out.println("Malformed input");
                System.exit(0);
            }
            System.out.print("Enter a letter: ");
            b = s.next().charAt(0);
            if(!Character.isLetter(b)){ // check letter validity 
                System.out.println("Malformed input");
                System.exit(0);
            }
            System.out.print("Enter a symbol: ");
            c = s.next().charAt(0);
            if(Character.isDigit(c)||Character.isLetter(c)||c==32){
                System.out.println("Malformed input");
                System.exit(0);
            }
            /* If it is a digit, letter or whitespace, it is not a symbol */
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //checking symbol's criteria first
                    if(i==j||n-i-j==1)
                        System.out.print(c+" "); // print symbol
                    else if(((i+j<n-1)&&j<i)||(i<j&&(i+j>n-1)))
                        System.out.print(b+" "); // print letter
                    else
                        System.out.print(a+" "); //print digit
                }
                System.out.print("\n"); // Print out in matrix form
            }
        }
    }