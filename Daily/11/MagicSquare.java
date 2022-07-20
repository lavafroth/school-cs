import java.util.Scanner;
class MagicSquare{
    static void die(boolean good,int M){
        System.out.println("It is "+
        (good?"":"not ") + "a magic matrix");
        if(!good){
            System.out.println(M+"x"+M+" magic matrix: ");
            for(int i=0;i<M;i++){
                for(int j=0;j<M;j++)
                    System.out.print(0+" ");
                System.out.println("");
            }
        }
        System.exit(0);
    /* Blurt out message and die gracefully */
    }
    public static void main(){
        Scanner s = new Scanner(System.in);
        System.out.print("[square matrix size]: ");
        int M=s.nextInt();
        if(M>5){
        System.out.print("Matrix size out of range\nsize <= 5");
        System.exit(0);
        /* Complain if size is out of range */
        }
        int A[][]=new int[M][M], acc=0, dl=0, dr=0;
        /* dl and dr are for the sum of diagonal
        (left and right repectively)*/
        System.out.println("[enter matrix elements]:");
        for(int i=0;i<M;i++)
            for(int j=0;j<M;j++)
                A[i][j]=s.nextInt();
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++)
                System.out.print(A[i][j]+"\t");
            System.out.println("");
        }
        /* Print out in matrix form */
        
        for(int i=0;i<M;i++)acc+=A[0][i];
    
        /* Take the sum of any row to begin with
        then keep checking for subsequent equalities */
        for(int i=0;i<M;i++){
            int row=0,col=0;
            for(int j=0;j<M;j++){
                row+=A[i][j];
                col+=A[j][i];
            }
        if(row!=acc||col!=acc)die(false, M);
        /* If any equalities fail,
        print out negative and die */
        dl+=A[i][i];
        /* It is a left diagonal element
        if row and column numbers match */
        dr+=A[i][M-1-i];
        /* It is a right diagonal element
        if row and column numbers add up to max index
        i + M - 1 - i = M - 1 = Max index from [0, M - 1] */
        }
        if(dl!=acc||acc!=dr)die(false, M);
        /* Diagonal equality is kept at the end 
        as their sum accumulates over all the iterations.
        If kept in the inner loop, it may hog more memory
        for the same calculations M times.
        If diagonal equalities fail,
        print out negative and die */
        die(true, M);
        /* If the matrix withstands all checks,
        print out positive result */
    }
}