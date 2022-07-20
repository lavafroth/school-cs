import java.util.Scanner;
class MatRev {
    int arr[][], m, n;
    MatRev(int mm, int nn) {
        arr= new int[m = mm][n = nn];
    }

    static int reverse(int x) {
        int ret = 0;
        for (; x > 0; x/=10) ret = ret*10+(x%10);
        return ret;
    }

    void fillarray() {
        Scanner s = new Scanner(System.in);
        for(int mm = 0; mm < m; mm++ ) for (int nn = 0; nn < n; nn++ ) arr[mm][nn] = s.nextInt();
    }

    void revMat(MatRev P) {
        if (P.m == this.m && P.n == this.n) for(int mm = 0; mm < P.m; mm++ ) for (int nn = 0; nn < P.n; nn++ ) arr[mm][nn] = reverse(P.arr[mm][nn]);
        else System.out.println("Since the dimensions of the matrices aren't the same,\nthe reversed elements can't be stored in the current object.\nHalting!");        
    }

    void show() {
        for(int mm = 0; mm < m; mm++ ) {
            for (int nn = 0; nn < n; nn++ ) System.out.print(arr[mm][nn]+"\t");
            System.out.print("\n");
        }
    }

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter matrix dimensions");        
        MatRev obj = new MatRev(s.nextInt(),s.nextInt());
        System.out.println("Enter matrix elements");
        obj.fillarray();
        System.out.println("Original matrix elements");
        obj.show();
        obj.revMat(obj);
        System.out.println("Reversed matrix elements");
        obj.show();
    }
}