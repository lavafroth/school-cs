import java.util.Scanner;

class ess_dee_eyy {
    static Scanner s = new Scanner(System.in);
    static void sort(int[] x) {
        for(int i = 0; i < x.length - 1; i++ ) {
            int min = i;
            for (int j = i + 1; j < x.length; j++) if( x[j] < x[min] ) min = j;
            int tmp = x[min];
            x[min] = x[i];
            x[i] = tmp;
        }
    }
    static void print_array(int[] x){
        for(int i = 0; i < x.length; i++ )System.out.print(x[i]+"\t");
    }
    static void in_array(int[] x){
        for(int i = 0; i < x.length; i++ ) x[i] = s.nextInt();
    }
    public static void main(String args[]){
        int N, M, A[], B[], C[], c_space = 0;
        System.out.print("Enter N: ");
        N = s.nextInt();
        A = new int[N > 20 ? 20 : N];
        System.out.print("Enter M: ");
        M = s.nextInt();
        B = new int[M > 20 ? 20 : M]; //max 20
        C = new int[N+M];
        System.out.println("Enter elements of A: ");
        in_array(A);
        System.out.println("Enter elements of B: ");
        in_array(B);
        sort(A);
        sort(B);
        System.out.println("Sorted elements of A: ");
        print_array(A);
        System.out.println("\nSorted elements of B: ");
        print_array(B);
        System.out.println("");
        outer: for(int i: A){
            for(int j = 0; j < c_space; j++) if(i == C[j]) continue outer;
            C[c_space++] = i;
        }
        outer: for(int i: B){
            for(int j = 0; j < c_space; j++) if(i == C[j]) continue outer;
            C[c_space++] = i;
        }
        System.out.println("Common elements of C: ");
        for(int i = 0; i < c_space; i++ )System.out.print(C[i]+"\t");
    }
}