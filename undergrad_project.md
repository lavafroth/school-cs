# 1. Objective
To create a Collection class with `set` like intersection functionality
# Algorithm
*Constructor:*
* Default constructor: Assigns `100` to length and initializes an array of that length
* Overloaded constructor: Takes an integer formal parameter assigning it to length and
initializes an array of that length truncated to `100` if limit is overflown.

*Member methods:*

`void input()`: Fills the array up with user input

`Collection common(Collection):`
* Initialize a counter to `0`
* Loop through the elements of the current and the parameterized `Collection` arrays
and increment the counter for each occurrence of common elements
* Initialize a final `Collection` with the length of the counter
* Loop through the elements of the current and the parameterized `Collection` arrays and insert the common elements into the array of the final `Collection`
* Return the final `Collection` containing the common elements

`void display()`: Print out the elements of the current `Collection`
# Source Code
```java
import java.util.Scanner;
class Collection {
    int ar[], len;
    Collection() {
        ar = new int[(len = 100)];
        /* If nothing is supplied, default to 100 */
    }
    Collection(int z) {
        ar = new int[(len = z - 100 * (z / 100))];
        /* Limit length to 100 */
    }
    void input() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < len; i++) ar[i] = s.nextInt();
    }
    Collection common(Collection z) {
        int count = 0;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < z.len; j++)
                if (ar[i] == z.ar[j]) count++;
        /* First get the number of elements required to create the new object */
        Collection cmn = new Collection(count--);
        /* Postfix: instantiate Collection with common element count then
        decrement (for zero-indexed iterations later) */
        for (int i = 0; i < len; i++)
            for (int j = 0; j < z.len; j++)
                if (ar[i] == z.ar[j]) cmn.ar[count--] = z.ar[j];
        /* Fill the new Collection object with common elements */
        return cmn;
    }
    void display() {
        for (int i = 0; i < len; i++) System.out.println(ar[i]);
    }
    public static void main(String args[]) {
        Collection uno = new Collection(5), dos = new Collection(5), tre;
        System.out.println("Enter elements of first collection:");
        uno.input();
        System.out.println("Enter elements of second collection:");
        dos.input();
        tre = uno.common(dos);
        System.out.println("Common elements:");
        tre.display();
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`ar` | `int[]` | Array to hold at most `100` elements
`len` | `int` | Stores array length of `ar`
`i` | `int` | Local iterator
`count` | `int` | Local accumulator for keeping a count of common element
`cmn` | `Collection` | Local Collection to store common elements
`uno`, `dos`, `tre` | `Collection` | Collection objects for implementation and demonstration in `main`
`s` | `Scanner` | Scanner object for taking input

# Output
<img src=":/c60e292e352849f4b142a42f7855bd86" style="border-radius:10px">

# 2. Objective
To obtain the transpose of an array by interchanging the elements of the rows and columns.

# Algorithm
Constructors:
`Transarray()`: Default constructor initializes a double dimensional array of dimensions `20` x
`20`
`Transarray(int,int)`: Parameterized constructor initializes a double dimensional array of
the supplied dimensions
Member methods:
`void fillarray()`: Fill the current object's double dimensional array with elements from
the user input
`void transpose(Transarray)`:
1. Create a new double dimensional array with the length equal to the breadth of the parameterized object and the breadth equal to the length of the parameterized object
2. Loop through the object's double dimensional array and store every `(i,j)`th element in the `(j,i)`th index of the new double dimensional array
3. Point the member array of the parameterized object to the new double dimensional array
4. Swap the row and column values of the parameterized object

`void disparray()`: Print the double dimensional array of the current object in matrix
representation
# Source Code
```java
import java.util.Scanner;
class Transarray {
    int M = 20, N = 20, arr[][];
    Transarray() {
        arr = new int[M][N];
        /* Defaults to 20 */
    }
    Transarray(int mm, int nn) {
        arr = new int[M = (mm > 20 ? M : mm)][N = (nn > 20 ? N : nn)];
        /* Check if given length is within bounds.
        If out of bounds, use default values. */
    }
    void fillarray() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) arr[i][j] = s.nextInt();
    }
    void transpose(Transarray A) {
        int t_arr[][] = new int[A.N][A.M];
        for (int i = 0; i < A.N; i++)
            for (int j = 0; j < A.M; j++) t_arr[i][j] = A.arr[j][i];
        /* Row elements become column elements and vice-versa */
        A.arr = t_arr;
        /* Replace original with transposed matrix */
        A.N = A.M - A.N;
        A.N = (A.M -= A.N) + A.N;
        /* Swap order values after transposing */
    }
    void disparray() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
    public static void main() {
        Transarray t = new Transarray(4, 3);
        System.out.print("[4x3 matrix elements]:\n");
        t.fillarray();
        System.out.print("Original:\n");
        t.disparray();
        t.transpose(t);
        System.out.print("Post transposition:\n");
        t.disparray();
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`arr` | `int[][]` | Double dimensional array to store elements of the current matrix
`N` | `int` | Stores the breadth of the current matrix
`M` |  `int` | Stores the length of the current matrix
`t_arr` | `int[][]` | Local double dimensional array to store elements of the transposed array
`t` | `Transarray` | Object for implementation and demonstration in main
`s` | `Scanner` | Scanner object for taking input
`i`,`j` | `int` | Local iterators

# Output
<img src=":/ebc4431fbfc04ff7a588ceae85584d45" style="border-radius:10px">

# 3. Objective
To design an `Array` class with merging functionality

# Algorithm
*Constructor:* Default constructor assigns 0 to array element count and zeroes out the
instance array of length `100`
*Member methods:*

`void getArray()`:
* Take array element count from from user input
* Truncates element count if it overflows the limit of `100`
* Fill the array up with the number of elements equal to the element count from input

`int process(Array,int)`:
* Set the search value of the parameterized Array to the value of the parameterized int
* Initialize the frequency counter to `0`
* Loop through the parameterized `Array` and increment the frequency counter for each occurrence of the search element
* Return the frequency counter
`Array merge(Array)`:
* Instantiate a new `Array` object
* Fill its internal array with all elements of the current `Array` object's internal array
* Fill the remaining space out of 100 with the elements of the parameterized `Array` object's internal array
* Return the new Array object
`void display()`: Display out the elements of the `Array` object's internal array and return
to the next line after every fourth element.
# Source Code
```java
import java.util.Scanner;
class Array {
    int ar[] = new int[100], n, num;
    Array() {
        n = 0;
        for (int i = 0; i < 100; i++) ar[i] = 0;
        /* Zero out the array and the length count */
    }
    void getArray() {
        Scanner s = new Scanner(System.in);
        System.out.print("[element count]: ");
        n = s.nextInt();
        n = n > 100 ? 100 : n;
        /* Limit array length to 100 */
        System.out.println("[elements]: ");
        for (int i = 0; i < n; i++) ar[i] = s.nextInt();
        /* Fill it up with n elements from the user */
    }
    int process(Array B, int k) {
        B.num = k;
        int z = 0;
        for (; z % 100 < B.n; z++)
            if (B.ar[z % 100] == k) z += 100;
        /* Knowing that z < 100,
        we can use the 100th place to keep track of the
        frequency of the element specified in k. */
        return z / 100;
    }
    Array merge(Array a) {
        Array x = new Array();
        for (int i = 0; i < n; i++) x.ar[i] = ar[i];
        /* Fill up with n elements with this array */
        for (int i = n; i < 100; i++) x.ar[i] = a.ar[i - n];
        /* Fill the remaining indices out of 100 with elements
        of the next array. We don't care about overflows. */
        x.n = (n + a.n) > 100 ? 100 : (n + a.n);
        return x;
    }
    void display() {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", ar[i]);
            if (i % 4 == 3) System.out.println();
            /* If the remainder of index divided by 4
            (can only be 0, 1, 2 and 3) is 3, return to the next line. */
        }
        System.out.println();
    }
    public static void main() {
        Scanner s = new Scanner(System.in);
        Array a = new Array(), b = new Array(), c;
        System.out.println("A:");
        a.getArray();
        System.out.println("A:");
        a.display();
        System.out.print("A: [element to look for frequency]: %d\nB:\n", a.process(a, s.nextInt()));
        b.getArray();
        System.out.println("B:");
        b.display();
        c = a.merge(b);
        System.out.println("\nA+B:");
        c.display();
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`ar` | `int[]` | Array of length `100` to store elements
`n` | `int` |  Store how many indices of `ar` are to be used
`num` | `int` |  Store the element whose frequency is to be determined
`i` | `int` |  Local iterator
`s` | `Scanner` |  Scanner object for taking input
`a`, `b`, `c` | `Array` |  Objects for implementation and demonstration in `main`

# Output
<img src=":/d0b3566367274a6c93ed4396ced900c6" style="border-radius:10px">

# 4. Objective
To design a `time` class for time based arithmetic operations

# Algorithm
*Default constructor:* Assigns `0` to hours and minutes fields
*Member methods:*

`void getTime(int,int)`:
* Assign the first parameter to hours field and add the quotient on division of the second parameter by 60 (since 60 minutes = 1 hour)
* Assign the remaining value out of 60 from the second parameter to the minutes field

`void printTime()`: Print out zero padded hours and minutes fields of the current object

`Time sumTime(Time,Time)`:
* Instantiate an new `Time` object
* Use the object's `getTime(int,int)` method to set its time to the sum of hours (plus every truncated `60` from minutes) and remnant minutes of the two parameterized objects

# Source Code
```java
class Time {
    int hrs, min;
    Time() {} // Default values are 0; RAII Patterns
    void getTime(int h, int m) {
        hrs = h + m / 60;
        /* Add m/60 hours if m overflows 59 */
        min = m % 60;
        /* Remnant out of 60 */
    }
    void printTime() {System.out.printf("%02d:%02d\n",hrs,min);}
    /* Zero padded output */
    Time sumTime(Time t1, Time t2) {
        Time ret = new Time();
        ret.getTime(t1.hrs + t2.hrs + (t1.min + t2.min) / 60, (t1.min + t2.min) % 60);
        // Truncate and shift
        return ret;
    }
    public static void main(String args[]) {
        Time t1 = new Time(), t2 = new Time(), t3;
        // demonstration
        t1.getTime(13, 37);
        t2.getTime(16, 69);
        t3 = t1.sumTime(t1, t2);
        t1.printTime();
        t2.printTime();
        t3.printTime();
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`hrs` |`int` |Instance variable to hold the hours field
`min` | `int` |Instance variable to hold the minutes field
`ret` | `Time` | Local variable to store the sum of two `Time` instances
`t1`,`t2`,`t3` | `Time` | Objects for implementation and demonstration in `main`

# Output
<img src=":/e7ceb3041e7e435aaa21cdd276afa1c8" style="border-radius:10px">

# 5. Objective
To implement a `matrix` class to find the difference between two matrices

# Algorithm
*Constructor:* Create a double dimensional array with the supplied length and breadth
truncating them if they exceed the limit of 25

*Member methods:*

`void fillarray()`: Fills the current object's array with elements from user input
`Matrix SubMat(Matrix)`:
1. Instantiate a new matrix of the same dimensions of the parameterized object
2. If the order of the the parameterized object's double dimensional array equals that of the current object
	* Loop through the current double dimensional array of the parameterized and the current object
	* Store their difference in the new matrix
3. If the order of the the parameterized object's double dimensional array does not equal
that of the current object
	* Fill the new matrix with elements of the current matrix
4. Return the new matrix

`void display()`: Display the content of the current object's double dimensional array in a
matrix form.

# Source Code
```java
import java.util.Scanner;
class Matrix {
    int arr[][], m, n;
    Matrix(int mm, int nn) {
        arr = new int[m = (mm > 25 ? 25 : mm)][n = (nn > 25 ? 25 : nn)];
        /* Truncate the dimensions if it exceeds limits.
        Don't have to care about negative values, runtime will handle that.
        */
    }
    void fillarray() {
        System.out.println("[enter matrix elements]:");
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) arr[i][j] = s.nextInt();
    }
    Matrix SubMat(Matrix A) {
        Matrix ret = new Matrix(A.m, A.n);
        /* Different behaviors based on order equality */
        if (A.m == m && A.n == n)
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
		    ret.arr[i][j] = A.arr[i][j] - arr[i][j];
        /* If the order matches, proceed to subtracting the elements */
        else
            for (int i = 0; i < m; i++)
                for (int j = 0; j < m; j++)
		    ret.arr[i][j] = A.arr[i][j];
        /* Otherwise return a copy of the current Matrix */
        return ret;
    }
    void display() {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) System.out.print(arr[i][j] +
                (j == n - 1 ? "\n" : "\t"));
        /* Print out a newline instead of a tab in case of the last
        element for a row to provide the matrix representation. */
    }
    public static void main() {
        Matrix x = new Matrix(3, 3), y = new Matrix(3, 3), z;
        System.out.print("X:");
        x.fillarray();
        System.out.print("\nY:");
        y.fillarray();
        z = x.SubMat(y);
        System.out.println("\nX:");
        x.display();
        System.out.println("\nY:");
        y.display();
        System.out.println("\nY-X:");
        z.display();
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`x`,`y`,`z` | `Matrix` | Objects for implementation and demonstration in `main`
`arr` |`int[][]`| Double dimensional array to store matrix elements
`m` |`int`| Stores the length of the matrix
`n` |`int`| Stores the breadth of the matrix
`s` |`Scanner`| Scanner object for taking input
`i`,|`j`| `int` Local iterators
`ret`| `Matrix`| Local matrix holding differences of other matrices for returning
# Output
<img src=":/44ce5856cc9a4c2588b52307cc2ca54f" style="border-radius:10px">

# 6. Objective
To check for a symmetric matrix, which is equal to its transpose

# Algorithm
1. Start
2. Take matrix size as input
3. Print an error message and exit if input size is out of range
4. Declare a double dimensional array of the size
5. Loop through the matrix to check if the abscissa and the ordinate are the same, if so it is a symmetric matrix
6. Add the left and right diagonal elements to their respective accumulators
7. Print out the accumulators and whether the matrix is symmetric
8. Stop
# Source Code
```java
import java.util.Scanner;
class Symmetric{
public static void main(){
Scanner s = new Scanner(System.in);
System.out.print("[square matrix size (2,10)]: ");
/* Print out the exclusive range */
int M=s.nextInt(),A[][],ld=0,rd=0;
boolean flag=true;
if(M<2||M>10){
System.out.print("Matrix size out of range\n2 < size < 10");
System.exit(0);
/* Blurt out the error message and exit (of equal dimensions)  */
}
A=new int[M][M];
System.out.println("[enter matrix elements]:");
for(int i=0;i<M;i++)for(int j=0;j<M;j++)A[i][j]=s.nextInt();
/* Fill the matrix up with elements from user input*/
for(int i=0;i<M;i++)for(int j=0;j<M;j++)if(A[i][j]!=A[j]
[i])flag=false;
/* If the `(i,j)`th element does not equal the `(j,i)`th element set
the flag to false */
for(int i=0;i<M;i++){
for(int j=0;j<M;j++)System.out.print(A[i][j]+"\t");
System.out.println();
}
System.out.printf("The given matrix is %dsymmetric\n",flag?"":"a");
for(int i=0;i<M;i++){
ld+=A[i][i];
/* It is a left diagonal element if row and column numbers match */
rd+=A[i][M-1-i];
/* It is a right diagonal element if row and column numbers add up
to max index
i + M - 1 - i = M - 1 = Max index from [0, M - 1] */
}
System.out.printf("Left diagonal sum: %d\nRight diagonal sum: %d\n",ld, rd);
}
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`M`| `int` |Stores the size of square matrix
`A` |`int[][]` |`M`x`M` square matrix
`ld` |`int`| To store the sum of the left diagonal
`rd`| `int`| To store the sum of the right diagonal
`flag`| `int`| Flag to store whether the given matrix is symmetric
`i`,`j` |`int`| Local iterators
`s`| `Scanner`| Scanner object for taking input

# Output
<img src=":/d6c29bd2e3c34fed8e9955221b83261b" style="border-radius:10px">

# 7. Objective
To display only the border elements of a matrix

# Algorithm
1. Start
2. Declare a double dimensional array with user input size
3. Take input from the user and fill the array
4. Loop through all the elements to verify if they are border elements if one of the following conditions are met:
	* The abscissa is $0$
	* The ordinate is $0$
	* The abscissa is $1$ less than the maximum row size
	* The abscissa is $1$ less than the maximum column size
5. Print only the elements that satisfy the above conditions
6. Stop
# Source Code
```java
import java.util.Scanner;
class Border {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("[enter matrix dimensions]: ");
        int m = s.nextInt(), n = s.nextInt(), A[][] = new int[m][n];
        /* m is row length, n is column length */
        System.out.println("[enter matrix elements]:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) A[i][j] = s.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) System.out.print((i == 0 || j == 0 || m - i == 1 || n - j == 1 ? A[i][j] : " ") + "\t");
            /* i == 0 => first element of the row
            j == 0 => first element of the column
            i == m - 1 => last element of the row
            i == n - 1 => last element of the column
            */
            System.out.println();
        }
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`m` |`int`| Matrix row length
`n` |`int`| Matrix column length
`A` |`int[][]` |`m` x `n` matrix
`i`,`j` |`int`| Local iterators
`s` |`Scanner` |Scanner object for taking input

# Output
<img src=":/790f5a8b38124ae88036e137e9957efe" style="border-radius:10px">

# 8. Objective
To check whether a given square matrix is a magic square

# Algorithm
1. Start
2. Take square matrix length as input.
3. If the length is greater than 5, print out an out of range error message and exit.
4. Initialize an square matrix of the respective size.
5. Initialize a row/column sum accumulator and two diagonal sum accumulators to 0
6. Fill up the square matrix with user input
7. Print the square matrix out
8. Loop through the columns and accumulate their sum in the row/column accumulator
9. Loop through each row and column
	* Keep adding their values to local accumulators
	* If the current row or column does not add up to the previous accumulator, print out negative message and exit.
	* If an element in the current row or column belongs to any diagonal, add it to the respective diagonal sum accumulator
	* Continue for the next iteration
10. If the diagonal sum accumulators are not equal the to previous accumulator, print out negative message and exit.
11. If the matrix survive all checks, print out positive message.
12. Stop

# Source Code
```java
import java.util.Scanner;
class MagicSquare {
    static void die(boolean good) {
        System.out.printf("It is %da magic matrix\n", good?"":"not ");
        System.exit(0);
        /* Blurt out message and die gracefully */
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("[square matrix size]: ");
        int M = s.nextInt();
        if (M > 5) {
            System.out.print("Matrix size out of range\nsize <= 5");
            System.exit(0);
            /* Complain if size is out of range */
        }
        int A[][] = new int[M][M], acc = 0, dl = 0, dr = 0;
        /* dl and dr are for the sum of diagonal (left and right repectively) */
        System.out.println("[enter matrix elements]:");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++) A[i][j] = s.nextInt();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) System.out.print(A[i][j] + "\t");
            System.out.println();
        }
        /* Print out in matrix form */
        for (int i = 0; i < M; i++) acc += A[0][i];
        /* Take the sum of any row in accumulator to begin with
        then keep checking for subsequent equalities */
        for (int i = 0; i < M; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < M; j++) {
                row += A[i][j];
                col += A[j][i];
            }
            if (row != acc || col != acc) die(false);
            /* If any equalities fail, print out negative and die */
            dl += A[i][i];
            /* It is a left diagonal element if row and column numbers match
             */
            dr += A[i][M - 1 - i];
            /* It is a right diagonal element if row and column numbers add up
            to max index
            i + M - 1 - i = M - 1 = Max index from [0, M - 1] */
        }
        if (dl != acc || acc != dr) die(false);
        /* Diagonal equality is kept at the end as their sum
        accumulates over all the iterations. If kept in the inner loop,
        it may hog more memory for the same calculations M times.
        If diagonal equalities fail, print out negative and die */
        die(true);
        /* If the matrix withstands all checks, print out positive result */
    }
    
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`M`| `int` | Stores the length of the square matrix
`A` | `int[][]` | `M` x `M` square matrix to store the elements of the potential magic square
`acc` |`int`| Accumulator to store the sum of first row for subsequent checks
`dl` |`int` |Stores the sum of left diagonal
`dr` |`int` |Stores the sum of right diagonal
`row`| `int` |Local variable to store the sum of elements of current row
`col`| `int`| Local variable to store the sum of elements of current column
`i`, `j` |`int` |Local iterators
`good` |`boolean` |Local variable to check what message to print out
`s` |`Scanner`| Scanner object for taking input

# Output
<img src=":/5312b30924fe460d9a4f53dd9433c08c" style="border-radius:10px">

# 9. Objective
To find the saddle point of a given matrix
# Algorithm
1. Start
2.  Take the square matrix size as input
3. Ensure that it is greater than 0 otherwise print error message
4. Initialize the matrix
5. Take the matrix elements as input
6. Create arrays for storing minima and maxima
7. Print out the original matrix
8. Take the first element of the each row and column as the base for minimum and maximum
9. Linear search through the matrix and update the minimum and maximum
10. Store the final minimum and maximum in the arrays for later use
11. Loop through each element
	* If the current element is the minimum in its row and the maximum in its column print the element as a saddle point
12. If no saddle point is found print the respective message out.
13. Stop
14. 
# Source Code
```java
import java.util.Scanner;
class SaddlePoint {
    static void die(String msg) {
        System.out.print(msg);
        System.exit(0);
    }
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("[square matrix size]: ");
        int M = s.nextInt();
        if (M < 1) die("Matrix size out of range\nsize > 0");
        /* Error message if matrix size is set to 0 */
        int A[][] = new int[M][M], mins[] = new int[M], maxs[] = new int[M];
        /* mins and maxs are arrays to store the minimum and maximum values
        respecively */
        System.out.println("[enter matrix elements]:");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++) A[i][j] = s.nextInt();
        /* Take the elements of the matrix as input */
        for (int i[]:A) {
            for (int j:i) System.out.print(j + "\t");
            System.out.println();
        }
        /* Print out the original matrix */
        for (int i = 0; i < M; i++) {
            int min = A[i][0], max = A[0][i];
            /* Take the first element of the row
            and column respectively to begin with. */
            for (int j = 0; j < M; j++) {
                if (A[i][j] < min) min = A[i][j];
                if (A[j][i] > max) max = A[j][i];
            }
            /* Linear search through the matrix ... */
            mins[i] = min;
            maxs[i] = max;
            /* ... and store the minimum and maximum variables */
            for (int j = 0; j < M; j++)
                if (mins[i] == A[i][j] && maxs[j] == A[i][j]) die("saddle point: " + maxs[j]);
            /* If the current element is the minimum in its row (i) and
            maximum in its column (j),
            print it as saddle point and exit (knowing that a saddle point
            is unique for a matrix) */
        }
        System.out.println("saddle point not found.");
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`msg` |`String`| Message to print out and immediately exit
`M` |`int`| Stores the length of the square matrix
`A` |`int[][]` |`M` x `M` square matrix
`mins` |`int[]`| Array to store the minima for rows
`maxs` |`int[]`| Array to store the maxima for columns
`i`, `j` |`int` |Local iterators
`min`| `int`| Local variables to store minimum
`max`| `int`| Local variables to store maximum
`s`| `Scanner` |Scanner object for taking input

# Output
<img src=":/45c3515398d04b9cb70bca73d677b051" style="border-radius:10px">

# 10. Objective
To check whether a matrix is upper triangle

# Algorithm
1. Start
2.  Take the square matrix size as input
3. Initialize the matrix
4. Take the matrix elements as input
5. Take a flag for upper triangle validity and assume it to be initially true
6. Loop through the elements of the matrix
	I. If the row index is greater than the column index of the element, it lies in the
lower triangle:
	*  If the element is is non-zero set the flag to false
7. Print out the matrix
8. Print out whether the matrix is an upper triangle one based on the flag's value
9. Stop
# Source Code
```java
import java.util.Scanner;
class UpperTri {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("[square matrix size]: ");
        int M = s.nextInt(), A[][] = new int[M][M];
        boolean flag = true;
        /* i > j below diag
         * i = j on the diag
         * i < j above the diag
         */
        System.out.println("[enter matrix elements]:");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++) A[i][j] = s.nextInt();
        // Loop and take inputs
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++)
                if (i > j)
                    if (A[i][j] != 0) flag = false;
        // Turn the flag false if an element above the diagonal is not 0
        for (int i[]:A) {
            for (int j:i) System.out.print(j + "\t");
            System.out.println();
        }
        System.out.println("The given matrix is %san upper triangle matrix.", flag?"":"not ");
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`M`| `int`| Stores the length of the square matrix
`A`| `int[][]`| `M` x `M` square matrix
`i`, `j`| `int`| Local iterators
`flag`| `boolean`| Flag to store whether the matrix is an upper triangle matrix
`s`| `Scanner`| Scanner object for taking input

# Output

---

# 11. Objective
To design a class FiboString to generate Fibonacci strings.
# Algorithm
1. Start
2. Initialize three strings to "a", "b" and "ba"
3. Take the number of iterations n as input
4. If n is greater than 0, print the first string
5. If n is greater than 1, print the second string
6. If n is greater than 2, print the last string
7. Run a loop while n is greater than 3
	* Assign the first string to the second appended to the last
	* Print it out
	* Assign the second string to the last
	* Assign the last string to the second appended to itself
	* Decrement n by 1
8. Stop
# Source Code
```java
import java.util.Scanner;
class FiboString{
    String x,y,z;
    int n;
    FiboString(){
        x="a"; // first
        y="b"; // second
        z="ba"; // third
		// rest
    }
    void accept(){
        System.out.print("Enter number of iterations: ");
        n=(new Scanner(System.in)).nextInt();
		// only need the input once, so, we'll use an anonymous object
    }
    void generate(){
        System.out.print(n>0?x+" "+(n>1?y+" "+(n>2?z+" ":""):""):"");
		// print the first, second and third ones
        for(;n>3;n--){
            System.out.print((x=z+y)+" ");
            y=z;
            z=x;
        }
		// generate the rest from the three
    }
    public static void main(String[]args){
        FiboString n = new FiboString();
        n.accept();
        n.generate();
    }
}
```
# Variable Description Table
Name | Type | Description
-----|------|------------
`x` | `String` | To store first string of the iteration "a"
`y` | `String` | To store second string of the iteration "b"
`z` | `String` | To store third string of the iteration "ba"
`n` | `int` | To store the iterative count
# Output
<img src=":/a00a57fd35e2463a85e510c319162558" style="border-radius:10px">
<img src=":/9f2a0fc35f7546978853e412d9a391a0" style="border-radius:10px">

# 12. Objective
To write a program to accept a sentence which may be terminated by either ‘.’ ‘?’ or ‘!’ only. Any 
other character may be ignored. The words may be separated by more than one blank space and 
are in UPPER CASE. The following tasks are then performed:
* Accept the sentence and reduce all the extra blank space between two
words to a single blank space.
* Accept a word from the user which is part of the sentence along with its
position number and delete the word and display the sentence.
# Algorithm
1. Start
2.  Take sentence as a string input
3. Initialize strings stack and word as empty
4. Halt if input does not end with `.`, `?` or `!`
5. Append two spaces to the input to circumvent out of bounds exception while looping
6. Take search term and index as input
7. Initialize iterator to `0`, word count to `1`
8. Run a loop while iterator is less than one less than length
	* If the character at that index is a space and the word is not empty
	* If word count incremented by one does not equal the index and the word is not 
the search term, append it to the stack
	* Empty out the word variable
	* If the character at that index or the next is not a space append it to the word
8. Print out the stack
9. Stop
# Source Code
```java
import java.util.Scanner;
class StringMagic{
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String hay=s.nextLine(),needle,stack="",word="";
		// initilalize everyting on the fly
		if(".?!".indexOf(hay.charAt(hay.length()-1))==-1||!hay.equals(hay.toUpperCase())){
	 // check if the sentence ends with proper punctuations
            System.out.println("Invalid input.");
            System.exit(0);
        };
        hay += "  ";
        System.out.print("[search term] [index]: ");
        needle=s.next();
        for(int i = 0, wc = 1, d = s.nextInt(); i < hay.length()-1 ; ++i){
            if( hay.charAt(i) == 32 && !word.equals("") ){ //if it is a space and word is not empty
                if( wc++ != d && !word.equals(needle) ) stack += word;
                word = ""; // empty the word now
            }
            if(hay.charAt(i)!=32||hay.charAt(i+1)!=32)word+=hay.charAt(i);
			// The ASCII whitespace is represented by 32
        }
        System.out.print(stack);
    }
}
```
# Variable Description Table
Name | Type | Description
-----|------|------------
`hay` |  `String` | To store the input sentence
`needle`  | `String`  |To store the search term
`stack` |  `String` | To store the remnant of the sentence after removal of search term
`word` |  `String` | Serves as a buffer for temporary storage of the current word in the iteration
`i`  | `int` | Iterator
`d` |  `int` | To store index of search term from input
`wc` |  `int` | To keep track of current word count
# Output
<img src=":/e38514531d3e4b2faa70a538c9cd174f" style="border-radius:10px">

# 13. Objective
To make a Caesar shift decoding (the term encryption is incorrectly used in the question) program with a backward shift of 7. The plain text is ended with a space. The spaces in cipher are replaced with QQ before encoding and is printed in 6 character
blocks. The input must be uppercase and less than 100 characters.
# Algorithm
1. Start
2. Take cipher text and shift as input
3. If its length is greater than 100 or it is not uppercase or the shift is greater than 26, throw out error and exit
4. Remove the spaces in the cipher
5. Loop through every character of the cipher text
	* Assign a character type variable to the shifted value of the character of cipher at that
index
	* If the character goes beyond 'Z', shift it backwards by 26
	* Append this character to plain text variable
5. If the plain text does not end with QQ throw error and exit
6. Print out the plain text with the occurrences of QQ replaces with a space
7. Stop
# Source Code
```java
import java.util.Scanner;
class encode{
// A static method for the program to die gracefully on invalid input
static void die(boolean x){
if(x){
System.out.println("Invalid input.");
System.exit(0);
}
}
public static void main(String[]args){
Scanner s=new Scanner(System.in);
System.out.print("[cipher]: ");
String cipher=s.nextLine(),plain="";
char shift;
die(cipher.length()>100||!cipher.equals(cipher.toUpperCase()));
/* Check the length constraints */
/* Print an error and exit */
die((shift=(char)s.nextInt())>26);
cipher=cipher.replace(" ","");
/* Wipe out spaces */
for(char i=0,c=0;i<cipher.length();i++){
c=(char)(cipher.charAt(i)+shift-1);
plain+=(char)(c>90?c-26:c);
}
die(!plain.endsWith("QQ"));
/* The specification mentions ending with QQ */
System.out.print("[plain]\n"+plain.replace("QQ"," "));
}
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`cipher`| `String`| To store cipher text from input
`plain`| `String`| To store plain text after processing
`shift`| `char`| To store the the shift value from input
`i`| `char`| Iterator to loop through the cipher text
`c`| `char`| Local variable to calculate shift
# Output
<img src=":/84417394bdc4418da8a1293ac57e9024" style="border-radius:10px">

# 14. Objective
To write a program that removes subsequent duplicate characters for a string

# Algorithm
1. Start
2. Take a word as input and append a space to circumvent out of bounds exception
3. Run a loop from the beginning to the end of the string
4. If the character at an index is not equal to the character at the next index, print it out
5. Stop
# Source Code
```java
import java.util.Scanner;
class duplicate{
/* Begin main */
	public static void main(String[]args){
	System.out.print("[enter a word]: ");
/* Asking for an input (if that was not obvious and needed a comment) */
	String s=(new Scanner(System.in)).next()+" ";
/* Append a space so that we don't have to perform additional checks for the last input */
	for(int i=0;i<s.length()-1;i++)if(s.charAt(i)!=s.charAt(i+1))System.out.print(s.charAt(i));
/* Loop through the string's characters
 * Is the current character the same as the next one?
 * Yes, then omit it. */
	}
/* End main */
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`s` |`String` |To store user input
`i` |`int` |Iterator

# Output
<img src=":/75528b828d3d4a2f85067958d7ce62ea" style="border-radius:10px">

# 15. Objective
To write a program to input a string (word) and convert it into lowercase letters, count and print
the frequency of each alphabet present in the string.

# Algorithm
1. Start
2.  Take a word as input and convert it to lowercase
3. Run a loop through characters 'a' to 'z'
	* Initialize local counter variable to 0
	* Run a loop from the beginning to the end of the string
		* If the character at an index is equal to the character for the iteration, increment the counter
	* If the count is positive, print it with the associated character
4. Stop
# Source Code
```java
import java.util.Scanner;
class count{

public static void main(String[]args){
System.out.print("Enter a word: ");
String s=(new Scanner(System.in)).next().toLowerCase();
/* Take an input
 * Immediately convert to lowercase */
System.out.println("Alphabet Frequency");
for(char c=97;c<123;c++){
/* Characters 97 through 123 represent ASCII letters (and some punctuations) */
int x=0;
/* x is a counter */
for(int i=0;i<s.length();i++)if(s.charAt(i)==c)x++;
/* If the current character is what we're looking for,
 * increment x */
if(x>0)System.out.println(c+"\t\t"+x);
/* x == 0 would mean 0 occurrences */
}
}
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`s`| `String`| To store word from input
`c`| `char`| Iterator loop through 'a' to 'z'
`x`| `int`| Counter to keep track of occurrences
`i`| `int`| Iterator to loop through the string
# Output
<img src=":/b8b34be9d7554666a458e1f1c4ba03a2" style="border-radius:10px">

# 16. Objective
To create a text file “performance.txt” to store the names and marks obtained in three subjects (Physics, Chemistry and Biology) of each student of her class and calculate the total marks and the average. Finally to out the records in reader mode and display the name total average and grade of each student.

# Algorithm
1. Start
2.  Initialize string variable `data` as placeholder with the top header
3. Declare `float` variables to hold marks for physics, chemistry and biology
4. Declare `char` variable to hold the grades
5. Instantiate a `DataOutputStream` connected to a `FileOutputStream` that opens
`performance.txt`
5. Perform the following while the user does not hit n for a new record query
	* Append the name to `data` from user input
	* Assign marks to the subject variables respectively from user input
	* Calculate the average from the marks
	* Decide the grade based on the average
	* Append the marks, average and grade to `data`
6. Write `data` to the file through the output stream
7. Close the stream
8. Instantiate a `DataInputStream` connected to a `FileInputStream` that opens
`performance.txt`
9. Read while there is data and print it out to the screen
10. Close the input stream
11. Stop
# Source Code
```java
import java.util.Scanner;
import java.io.*;
class education {
    public static void main(String args[]) throws IOException,
        FileNotFoundException {
            PrintStream o = System.out;
            /* Decluttering code */
            Scanner s = new Scanner(System.in);
            String data = "Name\t\tPhy\tChm\tBio\tAvg\tGrade\n";
            /* Initial heading for the file */
            float p, c, b, a;
            /* Physics, Chemistry, Biology, Average */
            DataOutputStream fo = new DataOutputStream(new FileOutputStream("performance.txt"));
            /* Data output stream connected to a file output stream that opens
            "performance.txt" */
            while (true) {
                o.print("[student name]: ");
                s.nextLine(); /* Need to flush stdin (0) otherwise program might miss input */
                data += s.nextLine() + "\t";
                o.print("[physics marks]: ");
                data += (p = s.nextFloat()) + "\t";
                o.print("[chemistry marks]: ");
                data += (c = s.nextFloat()) + "\t";
                o.print("[biology marks]: ");
                data += String.format("%f\t%f\t%c\n", (b = s.nextFloat()), (a = (p + b + c) / 3), (a > 79 ? 'A' : (a > 59 ? 'B' : (a > 39 ? 'C' : 'D'))));
                /*Storing data as tab separated since there is no
                raw work to be done on retrieving them the next time. */
                o.println("new record? (y/n)");
                if (s.next().toLowerCase().charAt(0) == 'n') break;
                /* While the user does not hit n */
            }
            fo.writeBytes(data);
            fo.close();
            DataInputStream fi = new DataInputStream(new FileInputStream("performance.txt"));
            /* Data input stream connected to a file input stream that opens
            "performance.txt" */
            while ((data = fi.readLine()) != null) o.println(data);
            /* Print out data as long as some data exists */
            fi.close();
        }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`data`| `String`| Stores the data to be written to the file during output and temporary data during input
`p`| `float`| Stores the marks for physics
`c`| `float`| Stores the marks for chemistry
`b`| `float`| Stores the marks for biology
`a`| `float`| Stores the average marks
`fo`| `DataOutputStream`| Data output stream to file "performance.txt"
`fi`| `DataInputStream`| Data input stream from file "performance.txt"
`o`| `PrintStream`| Reference to System.out to declutter code
`s`| `Scanner`| Scanner object for reading data from standard input

# Output

<img src=":/01a4c6de194d4ac09fe68e0fb99c3994" style="border-radius:10px">

# 17. Objective
To create a binary file for the following purposes:
i) The binary file must be created to contain employee name, employee code and basic salary. the
program should keep accepting the records till the user enters his choice as 1 and terminate it
when the choice is 2.
ii) Use the file in appropriate mode to retrieve the records and find the following:
DA= 40% of the basic salary
HRA=30% of the basic salary
Gross=Basic salary + DA+HRA
A special allowance of 20% of the gross is calculated if employee code is less than or equal to 15
and the gross is less than or equal to 1500.
in-case the employee code is greater than 15 and the special allowance is Rs. 1000 fixed, then find
the total amount = Gross+Special allowance.
Display the salary of each employee along with the heading in the following format:
Name|Code|Basic Salary|DA|HRA|Salary|Sp. Allowance|Total
-|-|-|-|-|-|-|-|
xxx|xxx|xxx|xxx|xxx|xxx|xxx|xxx|
# Algorithm
1. Start
2.  Initialize string variable data as an empty string
3. Instantiate a `DataOutputStream` connected to a `FileOutputStream` that opens
records.bin
3. Loop while the user does not input `2` as a choice for options
	* Append the employee name to data from user input followed by a comma
	* Append the employee code to data from user input followed by a comma
	* Append the employee salary to data from user input followed by a comma
4. Write data to the file through the output stream
5. Instantiate a DataInputStream connected to a FileInputStream that opens records.bin
6. Print out the output header
7. While there are lines to read
	* Look for each occurrence of a comma and parse the data as the name ( String ), code (`int`) and basic salary (`double`) respectively
	* Calculate the DA as 40% of basic salary
	* Calculate the HRA as 30% of basic salary
	* Calculate the gross salary equal to of basic salary + HRA + DA
	* Calculate the special allowances based on the following conditions
	* If employee code is less than or equal to 15 and the gross is less than or equal to 1500 then special allowances is 20% of gross salary otherwise it is a fixed 1000
	* Calculate the total equal to of gross salary + special allowances
	* Print the records out to the screen
8. Close the input stream
9. Stop
# Source Code
```java
import java.util.Scanner;
import java.io.*;
class employee {
    public staimport java.util.Scanner;
import java.io.*;
class employee {
    public static void main(String args[]) throws IOException,
        FileNotFoundException {
            PrintStream o = System.out;
            /* Decluttering code */
            Scanner s = new Scanner(System.in);
            String data = "";
            DataOutputStream fo = new DataOutputStream(new FileOutputStream("records.bin"));
            do {
                o.print("1. Add records\n2. Exit\n[choice]: ");
                int c = s.nextInt();
                if (c == 2) break;
                if (c != 1) continue;
                o.print("[employee name]: ");
                s.nextLine(); /* Need to flush stdin (0) otherwise program might miss input */
                data += s.nextLine() + ",";
                o.print("[employee code]: ");
                data += s.nextInt() + ",";
                o.print("[basic salary]: ");
                data += s.nextDouble() + "\n";
            } while (true);
            fo.writeBytes(data);
            fo.close();
            DataInputStream fi = new DataInputStream(new FileInputStream("records.bin"));
            /* Data input stream connected to a file input stream that opens
            "records.bin" */
            o.println("Name\tCode\tBasic salary\tDA\tHRA\tSalary\tSp. Allowance\tTotal");
            /* Initial heading for the output */
            while ((data = fi.readLine()) != null) {
                /* Try reading data as long as more exists */
                int index = data.indexOf(","), id;
                double sal, DA, HRA, gross, sp, total;
                String name = data.substring(0, index);
                data = data.substring(index + 1);
                index = data.indexOf(",");
                id = Integer.parseInt(data.substring(0, index));
                data = data.substring(index + 1);
                /* 0 to first index of comma = name
                next index to last index = code
                last index to end = salary
                */
                gross = (sal = Double.parseDouble(data)) + (DA = 0.4 * sal) + (HRA = 0.3 * sal);
                /* Dynamically initializing variables since we only need them for
                printing */
                total = gross + (sp = (id < 16 && gross <= 1501 ? (0.2 * gross) : 1000));
                o.println(name + "\t" + id + "\t" + sal + "\t\t" + DA + "\t" + HRA + "\t" + gross + "\t" + sp + "\t" + total);
                /* Print out in tabular form */
            }
            fi.close();
        }
}tic void main(String args[]) throws IOException,
        FileNotFoundException {
            PrintStream o = System.out;
            /* Decluttering code */
            Scanner s = new Scanner(System.in);
            String data = "";
            DataOutputStream fo = new DataOutputStream(new FileOutputStream("records.bin"));
            do {
                o.print("1. Add records\n2. Exit\n[choice]: ");
                int c = s.nextInt();
                if (c == 2) break;
                if (c != 1) continue;
                o.print("[employee name]: ");
                s.nextLine(); /* Need to flush stdin (0) otherwise program might miss input */
                data += s.nextLine() + ",";
                o.print("[employee code]: ");
                data += s.nextInt() + ",";
                o.print("[basic salary]: ");
                data += s.nextDouble() + "\n";
            } while (true);
            fo.writeBytes(data);
            fo.close();
            DataInputStream fi = new DataInputStream(new FileInputStream("records.bin"));
            /* Data input stream connected to a file input stream that opens
            "records.bin" */
            o.println("Name\tCode\tBasic salary\tDA\tHRA\tSalary\tSp. Allowance\tTotal");
            /* Initial heading for the output */
            while ((data = fi.readLine()) != null) {
                /* Try reading data as long as more exists */
                int index = data.indexOf(","), id;
                double sal, DA, HRA, gross, sp, total;
                String name = data.substring(0, index);
                data = data.substring(index + 1);
                index = data.indexOf(",");
                id = Integer.parseInt(data.substring(0, index));
                data = data.substring(index + 1);
                /* 0 to first index of comma = name
                next index to last index = code
                last index to end = salary
                */
                gross = (sal = Double.parseDouble(data)) + (DA = 0.4 * sal) + (HRA = 0.3 * sal);
                /* Dynamically initializing variables since we only need them for
                printing */
                total = gross + (sp = (id < 16 && gross <= 1501 ? (0.2 * gross) : 1000));
                o.println(name + "\t" + id + "\t" + sal + "\t\t" + DA + "\t" + HRA + "\t" + gross + "\t" + sp + "\t" + total);
                /* Print out in tabular form */
            }
            fi.close();
        }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`data`| `String`| Stores the data to be written to the file during output and temporary data during input
`o`| `PrintStream`| Reference to `System.out` to declutter code
`s`| `Scanner`| Scanner object for reading data from standard input
`fo`| `DataOutputStream`| Data output stream to file "records.bin"
`fi`| `DataInputStream`| Data input stream from file "records.bin"
`index`| `int`| Local variable to keep track of the index of commas
`name`| `String`| Stores employee name
`id`| `int`| Stores employee code
`sal`| `double`| Stores basic salary
`DA`| `double`| Stores the DAimport java.util.Scanner;

`HRA`| `double`| Stores HRA
`gross`| `double`| Stores gross salary
`sp`| `double`| Stores special allowances
`total`| `double`| Stores total salary
# Output
<img src=":/062d0d84cf0b47978aae57fa8a78a900" style="border-radius:10px">

# 18. Objective
To write a program to implement Stack with `pop()`, `push()` and `print()` methods

# Algorithm
*Constructor*:
* Initialize internal array to given capacity
* Initialize stack pointer to `-1`

*Member methods*:

`void push(int v)`:
* If stack pointer is one less than size, print overflow message
* Else
	* Increment stack pointer
	* Set the value of internal array at the stack pointer's index to the supplied value

`int pop()`:
* If stack pointer is negative
	* Print underflow message
	* Return `-9999`
* Else
	* Return the value of internal array at stack pointer
	* Decrement the stack pointer

`void print()`:
* Loop from stack pointer to `0`
* Print the value of internal array at loop index

`void main(String[] args)`:
1. Instantiate a Stack object with size as user supplied input
2. Try popping with no elements to check for underflow condition
3. Push user supplied elements to the Stack object
4. Print the object
5. Try pushing an extra element to check for overflow condition
# Source Code
```java
import java.util.Scanner;
import java.io.PrintStream;
class Stack {
  int internal[], size, stackptr;
  Stack(int size) {
    internal = new int[this.size = size];
    // Set the size
    // Initialize the internal array
    stackptr = -1;
  }
  public void push(int v) {
    if (size - stackptr == 1) System.out.println("overflow: " + v + " not pushed");
    else internal[++stackptr] = v;
    // Increment first, assign
  }
  public int pop() {
    if (stackptr < 0) {
      System.out.println("underflow: returning -9999");
      return -9999;
      // Considering -9999 as error value
    }
    return internal[stackptr--];
    // Return the value at stackptr,
    // then decrement stackptr
  }
  public void print() {
    for (int i = stackptr; i > -1; i--) System.out.println(internal[i]);
    // Loop through and print
  }
  public static void main(String[] args) {
    final Scanner s = new Scanner(System.in);
    final PrintStream o = System.out;
    o.print("[stack size:] ");
    Stack stack = new Stack(s.nextInt());
    stack.pop(); // should error out
    o.print("[enter elements]\n");
    for (int i = 0; i < stack.size; i++) stack.push(s.nextInt());
    stack.print();
    stack.push(7047); // should error out
    s.close();
  }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`internal`| `int[]`| The internal array to hold elements of stack
`size`| `int`| Holds the size
`stackptr`| `int`| Stack pointer pointing to the top of the stack
`i`| `int`| Local iterator
`stack`| `Stack`| Stack object for demonstration
# Output
<img src=":/d43931db47b94e99b4ccf0527ebc3d65" style="border-radius:10px">

# 19. Objective
To implement LinearQ with `insert()`, `delete()` and `print()` methods.

# Algorithm

*Constructor*:
* Initialize internal array to capacity provided

*Member methods*:
`void main(String[] args)`:
* Instantiate `LinearQ` object
* Display a menu
* Read user's choice
* Quit if choice is invalid
* Call respective methods on the object

`void insert(int v)`:
* If rear pointer equals capacity, complain that the queue is full
* Otherwise
* Set the value of internal at the index of rear pointer to the supplied value
* Increment rear pointer

`int delete()`:
* If front pointer equals rear pointer, complain that queue is empty and return `-9999`
* Otherwise
	* Return the value of internal at the index of front pointer
	* Increment the front pointer

`void print()`:
* Loop from front pointer to the rear pointer
* Print the value of internal at the loop index
# Source Code
```java
import java.util.Scanner;
import java.io.Prinimport java.util.Scanner;
import java.io.*;
class employee {
    public static void main(String args[]) throws IOException,
        FileNotFoundException {
            PrintStream o = System.out;
            /* Decluttering code */
            Scanner s = new Scanner(System.in);
            String data = "";
            DataOutputStream fo = new DataOutputStream(new FileOutputStream("records.bin"));
            do {
                o.print("1. Add records\n2. Exit\n[choice]: ");
                int c = s.nextInt();
                if (c == 2) break;
                if (c != 1) continue;
                o.print("[employee name]: ");
                s.nextLine(); /* Need to flush stdin (0) otherwise program might miss input */
                data += s.nextLine() + ",";
                o.print("[employee code]: ");
                data += s.nextInt() + ",";
                o.print("[basic salary]: ");
                data += s.nextDouble() + "\n";
            } while (true);
            fo.writeBytes(data);
            fo.close();
            DataInputStream fi = new DataInputStream(new FileInputStream("records.bin"));
            /* Data input stream connected to a file input stream that opens
            "records.bin" */
            o.println("Name\tCode\tBasic salary\tDA\tHRA\tSalary\tSp. Allowance\tTotal");
            /* Initial heading for the output */
            while ((data = fi.readLine()) != null) {
                /* Try reading data as long as more exists */
                int index = data.indexOf(","), id;
                double sal, DA, HRA, gross, sp, total;
                String name = data.substring(0, index);
                data = data.substring(index + 1);
                index = data.indexOf(",");
                id = Integer.parseInt(data.substring(0, index));
                data = data.substring(index + 1);
                /* 0 to first index of comma = name
                next index to last index = code
                last index to end = salary
                */
                gross = (sal = Double.parseDouble(data)) + (DA = 0.4 * sal) + (HRA = 0.3 * sal);
                /* Dynamically initializing variables since we only need them for
                printing */
                total = gross + (sp = (id < 16 && gross <= 1501 ? (0.2 * gross) : 1000));
                o.println(name + "\t" + id + "\t" + sal + "\t\t" + DA + "\t" + HRA + "\t" + gross + "\t" + sp + "\t" + total);
                /* Print out in tabular form */
            }
            fi.close();
        }
}tStream;
public class LinearQ
{
	private int internal[], front, rear, cap;
	LinearQ(int size)
	{
		internal = new int[cap = size];
		// not initializing front or rear
		// objects will always have member fields with 0 value in Java
	}
	void insert(int v) {
		if (cap == rear) {
			System.out.println("Linear queue is full");
			return;
		}
		internal[rear++] = v;
	}
	int delete() {
		if (front == rear) {
			System.out.println("Linear queue is empty");
			return -9999;
			// Considering error value as -9999
		}
		// If front equals rear but not 0, we're stuck
		// and that's by design
		return internal[front++];
		// Return value pointed to, consequently increment front pointer
	}
	void print() {
		for (int i = front; i < rear; i++) System.out.print(internal[i] + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		final PrintStream o = System.out;
		o.print("Enter a length: ");
		LinearQ q = new LinearQ(s.nextInt());
		/*
		Starting an infinite loop for the
		menu driven approach for this program.
		*/
		for (char i = 0;;) {
			o.print("==========\n1: insert\t2: delete\n3: print\tLiterally anything else: quit\n:");
			i = s.next().charAt(0);
			o.println("==========");
			switch (i)
			{
			case 49:
				o.print("Enter a value: ");
				q.insert(s.nextInt());
				break;
			case 50:
				o.println("returned: " + q.delete());
				break;
			case 51:
				q.print();
				break;
			default:
				System.exit(0);
				/* For literally anything beyond input range, we just exit */
			}
		}
	}
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`internal`| `int[]`| The internal array to hold elements of linear queue
`front`| `int`| Front pointer
`rear`| `int`| Rear pointer
`cap`| `int`| Capacity of the linear queue
`i`| `int`| Local iterator
`q`| `LinearQ`| Linear queue for demonstration
# Output
<img src=":/ec506da62d724e9f94cf20046c07d55c" style="border-radius:10px">
<img src=":/7f34e843e3634d78a00f53a0f42c4f55" style="border-radius:10px">

# 20. Objective
To design an `Employee` class with a `salary` superclass for DA, HRA and salary calculation

# Algorithm
1. Start
2. Instantiate a new `Salary` object with an employee's name, number, designation and basic salary
3. Calcuate DA as 10% of basic salary
4. Calcuate HRA as 15% of basic salary
5. Calcuate salary as basic + DA + HRA
6. Calculate PF as 8% of salary
7. Calculate net salary as salary - PF
8. Display the employee details and the previously calculated results
9. Stop
# Source Code
```java
class Employee {
  long empNo;
  String empName, empDesig;
  Employee() {
	  // Use these default values if nothing is supplied
    empName = "John Doe";
    empDesig = "Programmer";
  }
  Employee(String empName, long empNo, String empDesig) {
	  // set data members to parameters
    this.empName = empName;
    this.empNo = empNo;
    this.empDesig = empDesig;
  }
  void display() {
  	System.out.printf("[employee details]\n[name]: %s\n[designation]: %s\n[number]: %d\n", empName, empDesig, empNo);
  }
}

class Salary extends Employee {
  double basic;
  Salary(String empName, long empNo, String empDesig, double basic) {
    super(empName, empNo, empDesig);
	  // call superclass constructor
    this.basic=basic;
  }
  void calculate() {
    super.display();
	  // display superclass's details first
    System.out.println("[DA]: "+.1*basic+"\n[HRA]: "+.15*basic+"\n[salary]: "+1.25*basic+"\n[PF]: "+.1*basic+"\n[net salary]: "+1.15*basic);
	  // calcualate all the results on the fly
  }
}

class Test {
        public static void main(String args[]) {
                Salary a = new Salary("Tom Holland", 42, "Spider-Man from Earth 616", 889989.00);
                a.calculate();
        }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`empName`|`String`|Employee name
`empNo`|`long`|Employee number
`empDesig`|`String`|Employee designation
`basic`|`double`|Basic salary
`a`|`Salary`|Object for demonstration in `main`

# Output
<img src=":/58320b83d4a444b8b6db371a02ec270f" style="border-radius:10px">

# 21. Objective
To design a `Worker` superclass and a `Wages` subclass for payout calcuation

# Algorithm
1. Start
2. Instantiate a new wages object with name, basic salary, overtime hours and overtime rate
3. Call the base class constructor internally
4. Calculate the overtime as $overtime\ pay = overtime\ hours \times overtime\ rate$
5. Add the overtime pay to the basic
6. Display the worker details
7. Stop
# Source Code
```java
class Worker {
        String name;
        double basic;
        Worker(String name, double basic) {
			// initialize values to parameters
                this.name = name;
                this.basic = basic;
        }
        void display() {
			// display out details
                System.out.println(name+" gets a monthly wage of $"+basic);
        }
}
class Wages extends Worker {
        double hrs, rate, wage;
        Wages(String name, double basic, double hrs, double rate){
                super(name, basic);
                this.hrs = hrs;
                this.rate = rate;
        }
        double overtime() {return hrs * rate;}
	// hours times rate gives overtime payout
        void display() {
                this.basic += overtime();
			// add the overtime amount to the basic to get the final wage
                super.display();
			// call display from superclass for displaying the final result 
        }

}
class Test {
        public static void main(String args[]) {
                Wages entity = new Wages("Spider-Man", 10, 24*7, .1);
                entity.display();
        }
}

```

# Variable Description Table
Name | Type | Description
-|-|-
`name`|`String`|Stores worker's name
`hrs`|`double`|Overtime hours
`rate`|`double`|Overtime rate
`basic`|`double`|Basic wage
`entity`|`Wages`|Object for demonstration in `main`

# Output
<img src=":/1550030ea94e45e9932eb34f60feb764" style="border-radius:10px">

# 22. Objective
To define a superclass `Record` to store the names and ranks of `50` students and a subclass `Rank` to find the highest rank along with the name

# Algorithm
1. Start
2. Read a student's name into a name array
3. Read a student's rank into a rank array
4. Repeat steps 2 and 3 for 50 times
5. Loop through the rank array to find the index of the highest rank
6. Mark the name at that index as the highest ranking
7. Print out all the names and ranks
8. Stop
# Source Code
```java
import java.util.Scanner;
class Record {
        String name[];
        int rank[];
        Record() {
                name = new String[50];
                rank = new int[50];
        }
        void readvalues() {
                Scanner s = new Scanner(System.in);
                for(int i=0;i<name.length;i++){
                        System.out.print("[enter name]: ");
                        name[i]=s.nextLine();
					// accept names
                        System.out.print("[enter rank]: ");
                        rank[i]=s.nextInt();
					// accept rank
                        s.nextLine();
                }
        }
        void display() {for(int i=0;i<name.length;i++)System.out.println("[name]: "+name[i]+" [rank]: "+rank[i]);}
	// print the name, print the rank, repeat
}
class Rank extends Record {
        int index = 0;
        Rank() {super();}
        void highest() {for(int i=0;i<rank.length;i++)index=rank[i]>rank[index]?i:index;}
	// linear search through the rank array
        void display() {name[index]+=" [topmost rank]";super.display();};
	// append the "topmost" tag to the name
}
class Test{
        public static void main(String args[]) {
                Rank entity = new Rank();
                entity.readvalues();
                entity.highest();
                entity.display();
        }
}

```

# Variable Description Table
Name | Type | Description
-|-|-
`name`|`String[]`|Stores the students' names
`rank`|`int[]`|Stores the students' ranks
`index`|`int`|Index of the highest rank
`i`|`int`|Local iterator
`entity`|`Rank`|Object for demonstration in `main`

# Output
<img src=":/2398e0dcfe4a4833ae30ffe47e07406c" style="border-radius:10px">

# 23. Objective
To define a superclass `Detail`  to store the details of a customer and a subclass `Bill` to compute the monthly telephone charge of the customer

# Algorithm
1. Start
2. Instantiate an new `Bill` object, accepting a name, address, phone number, rent and call count
3. Calculate the bill as follows:
	* If call count is greater than 100 add 60 paise to the rent
	* If it is greater than 200, add 20 paise (total 80 added)
	* If it is greater than 300, add 20 paise (total 100 added)
4. Print the customer details and the bill
5. Stop
# Source Code
```java
class Detail {
        String name, address, telno;
	// using a string for telno because of internationalized format
        double rent;
        Detail(String name, String address, String telno, double rent) {
                this.name = name;
                this.address = address;
                this.telno = telno;
                this.rent = rent;
        }
        void show() {System.out.println("[customer details]\n[name]: "+name+"\n[address]: "+address+"\n[telephone number]: "+telno+"\n[rent]: "+rent);}
}

class Bill extends Detail {
        int n;
        double amt;
        Bill(String name, String address, String telno, double rent, int n) {
                super(name, address, telno, rent); // pass on to super class
                this.n = n; // amt is implicitly initialized to 0.0
        }
        void cal() {
                if(n>100)amt+=.6;
                if(n>200)amt+=.2;
                if(n>300)amt+=.2;
        }
        void show() {
                cal();
			// calculate
                super.show();
			// display base class details
			    System.out.println("[bill]: "+amt);
			// display extra details calculated
        }
}

class Test{
	public static void main(String args[]) {
	(new Bill("Elliot Alderson", "1337 Chinatown", "+13133746969", 250, 200)).show();
	}
}

```

# Variable Description Table
Name | Type | Description
-|-|-
`name`|`String`|Customer name
`address`|`String`|Customer address
`rent`|`double`|Telephone rent
`n`|`int`|Call count
`telno`|`String`|To store the telephone number in internationalized format
`amt`|`double`|Total amount

# Output
<img src=":/91dfabbccf0443299844f83f33e483c9" style="border-radius:10px">
<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>

# 24. Objective
To define a superclass `Perimeter` to calculate the perimeter of a parallelogram and a subclass `Area` to compute the area of the parallelogram

# Algorithm
1. Start
2. Instantiate an `Area` object with length, breadth and height
3. Calculate the perimeter $2 \times (length+breadth)$
4. Calculate the area $altitude \times breadth$
5. Display the results out
6. Stop
# Source Code
```java
class Perimeter {
  double a, b;
  Perimeter(double a, double b) {this.a=a; this.b=b;}
  double Calculate() {return 2*(a+b);}
  void show() {System.out.println("[length]: "+a+"\n[breadth]: "+b+"\n[perimeter]: "+Calculate());}
	// call the function while displaying details
}

class Area extends Perimeter {
  double h, b; // altitude, area
  Area(double a, double b, double h) {
    super(a,b);
	  // call base constructor
    this.h=h;
  }
  void doArea() {this.b=super.b*h;} // to eliminate breadth / area confusion
  void show() {super.show();System.out.println("[altitude]: "+h+"\n[area]: "+this.b);}
	// display the base details, then the extra
}

class Test {
  public static void main(String args[]) {
    Area a = new Area(13.7678, 14.3453465, 15.56);
    a.doArea();
    a.show();
  }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`a`|`double`|Length of parallelogram, `Area` instance in `main`
`b`|`double`|Breadth of parallelogram, area in area subclass
`h`|`double`|Altitude of parallelogram

# Output
<img src=":/3269034a62484d78a0ff4fabde026848" style="border-radius:10px">

# 25. Objective
Program to display series for a sequence $\frac{x^2}{1!} + \frac{x^4}{3!} + \frac{x^6}{5!} + ... + \frac{x^n}{(n-1)!}$

# Algorithm
1. Start
2. Accept $x$ and $n$ as parameters
3. Loop from $2$ to $n$ with a step of $2$
4. Calculate $x^{z+1}$ for the current loop control variable $z$
5. Calculate $z!$ by recursively multiplying it with one less than itself until the parameter reaches unity
6. Calculate $\frac{x^{z}}{(z-1)!}$ by dividing the value in step 4 by that of step 5
7. Display the result  and
8. Stop
# Source Code
```java
public class SeriesSum{
	int x, n;
	double sum;
	SeriesSum(int xx, int nn) {x = xx; n = nn;}
	double findfact(int m) {
		return m * (m > 1 ? findfact(m - 1) : 1);
		/* If m hits 1,
		stop recursing. */
	}
	double findpower(int x, int z)	{
		return Math.pow(x, z);
		/* As the technique is not mentioned,
		going with the path of least reistance. */
	}
	void calculate() {
		for (int z = 2; z < n; z+=2) sum += findpower(x, z) / findfact(z-1);
		/* Add x^z/(z-1)! to the accumulator (sum) */
	}
	void display() {
		System.out.println("[series]: " + sum);
	}
	public static void main(String args[]) {
		SeriesSum s = new SeriesSum(2, 13);
		/* using test values instead of Scanner since
		no technique is specified */
		s.calculate();
		s.display();
	}
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`x`| `int`| To store an integer number
`n`| `int`| To store number of terms
`sum`| `double`| Accumulator to store the sum of the sequence
`z`| `int`| Local iterator
`m`| `int`| Parameter whose factorial is to be determined
# Output
<img src=":/f01a01b6b8854a22929f37e4a6d6f69d" style="border-radius:10px">

# 26. Objective
To implement $n \choose r$ using recursion

# Algorithm
1. Start
2.  Read $r$ and $n$  as input from the user.
3. Calculate $n!$ by recursively multiplying it with one less than itself until the parameter reaches unity
4. Calculate $r!$ in the same way
5. Calculate $(n-r)!$ in the same way
6. Calculate $\frac{n!}{r! (n-r)!}$ from the previous results
7. Display the result
8. Stop
# Source Code
```java
import java.util.Scanner;
public class RecFact {
int n,r;
RecFact(){n=r=0;} /* Setting to standard values */
void readnum(){
System.out.print("[enter values of n]: ");
Scanner s=new Scanner(System.in);
n=s.nextInt();
System.out.print("[enter values of r]: ");
r=s.nextInt();
/* Taking the values of n and r as user input */
}
int factorial(int m){return m*(m>1?factorial(m-1):1);}
/* If m hits 1, do not recurse, set 1. */
void factseries(){
System.out.println("nCr = "+(factorial(n)/factorial(r)/factorial(n-r)));
/* Print out n!/(r!(n-r)!) */
}
public static void main(String args[]){
RecFact r = new RecFact();
// call object methods
r.readnum();
r.factseries();
}
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`r`| `int`| Stores the possible choices
`n`| `int`| Stores the number whose factorial is required
`m`| `int`| Parameter whose factorial is to be determined

# Output
<img src=":/05aa1b7a56be4d5dacf53b3503f5f804" style="border-radius:10px">

# 27. Objective
To check for an `Emirp` number, a number which is prime backwards and forwards

# Algorithm
1. Start
2. Read a number from input
3. Reverse the input into `rev` in the following scheme:
	* Loop with the iterator equal to the input while it is not $0$
		* Multiply `rev` by $10$
		* Add the last digit of the iterator to it
		* Divide the iterator by $10$
4. Check if the input is prime by recursively checking all numbers below it as it's factor
5. Check if the reverse is also a prime the same way
6. If the above conditions are met, print a positive result otherwise print a negative result
7. Stop

# Source Code
```java
import java.util.Scanner;
class Emirp {
  int n, rev, f;
  Emirp(int nn) {
    n = nn;
    rev = 0;
    f = 2; /* avoiding 1 as it is a factor of everything */
  }
  int isprime(int x) {
    if (x == f) {
      f = 2;
      return 1;
      /* if f keeps incrementing and finally hits x (as a result of totient)
      return to original state */
    }
    if (x % f++ == 0) {
      f = 2;
      return 0;
      /* postfix, i.e., x%f for now and then increment f
      return to original state */
    }
    return isprime(x);
  }
  void isEmirp() {
    for (int i = n; i != 0; i /= 10) rev = rev * 10 + i % 10;
    /* since both of them have to be true, the sum must be 2 */
    System.out.println(n + " is " + ((isprime(n) + isprime(rev) < 2) ? "not " : "") + "an Emirp number ");
    }
    static void main() {
      Emirp obj = new Emirp((new Scanner(System.in)).nextInt());
      obj.isEmirp();
    }
  }
```

# Variable Description Table
Name | Type | Description
-|-|-
`n`| `int`| Stores the number
`rev`| `int`| Stores the reverse of `n`
`f`| `int`| Stores the divisor
`obj`|`Emirp`|Object for implementation in main
# Output
<img src=":/b410af65e2ff4f2da6c300c62ca6f408" style="border-radius:10px">

# 28. Objective
To calculate the frequency of words that begin with a vowel in a given input sentence

# Algorithm
1. Start
2. Assign $0$ to `freq`
3. Read a string from user input, prepends a whitespace, turn it to lowercase and store it in `str`
4. Print out error messages if the string does not end with a period.
5. Declare a string of all vowels
6. Loop through the characters of `str` from index $1$
7. If the previous character is a whitespace and the current character exists among the vowels, increment `freq`
8. Display out the frequency of words beginning with vowels
9. Stop

# Source Code
```java
import java.util.Scanner;
class VowelWord {
  String str;
  int freq;
  VowelWord() {
    str = "";
    freq = 0;
    /* Setting to standard values */
  }
  void read_str() {
    System.out.print("[enter sentence]: ");
    str = ' ' + (new Scanner(System.in)).nextLine().toLowerCase();
    /* Prepending whitespace to avoid out of bounds exception */
    if (!str.endsWith(".")) {
      System.out.println("Sentence must terminate with a period.");
      System.exit(0);
      /* Error checking
      display out message and exit */
    }
  }
  void freq_vowel() {
    String vowels = "aeiou";

    for (int x = 1; x < str.length(); x++)
      if (str.charAt(x - 1) == 32 && vowels.indexOf(str.charAt(x)) > -1) freq++;

    /* If indexOf returns -1, the character does not belong to vowels.
    If it is anything greater, the character belongs to vowels. */
  }
  void display() {
    System.out.println("[frequency of words beginning with vowels]: " + freq);
  }
  public static void main(String args[]) {
    VowelWord v = new VowelWord();
    v.read_str();
    v.freq_vowel();
    v.display();
  }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`str`| `String`| Stores a sentence
`freq`| `int`| Stores the frequency of words beginning with a vowel
`vowels`| `String`|Stores the vowels
`x`| `int`| Local iterator
`v`| `VowelWord`| Object for implementation and demonstration in `main`
# Output
<img src=":/b5d7af20aa0c4851a9885ccb5ecea8e2" style="border-radius:10px">

# 29. Objective
To count the number of times the words “an” and “and” are present in a given input sentence

# Algorithm
*Constructor*: Assigns $0$ to `countan`, `countand` and `len`

*Member methods*:

`void accept(String)`: Assigns the parameter to text appended and prepended with whitespaces and its length to len

`void checkandfreq(int)`:
* Declare a delimiter set with `" !@#$%^&*_-+=(){}[],'\":;.?/\\|"`
* If the parameter is less than `len` and the index of "and" starting from the parameterized value is greater than `-1`
* If the characters before and after the word are among the delimiters, increment `countand` by `1`
* Call checkandfreq with the found `index + 3` , `3` being the length of "and"

`void checkanfreq(int)` :
* If the parameter is less than `len` and the index of "an" starting from the parameterized
value is greater than `-1`
	* If the characters before and after the word are among the delimiters, increment
`countan` by `1`
	* Call `checkanfreq` with the found `index + 2` , `2` being the length of "an"

`void display()` : Display the frequency of "and" and "an" with `countand` and `countan`

# Source Code
```java
import java.util.Scanner;
class Frequency {
  String text;
  int countand, countan, len;
  Frequency() {
    countan = countand = len = 0;
    /* Setting to standard values */
  }
  void accept(String n) {
    len = (text = " " + n + " ").length();
    /* Prepending and appending whitespace to avoid out of bounds exception */
  }
  void checkandfreq(int x) {
    int index;
    String delim = " !@#$%^&*_-+=(){}[],'\":;.?/\\|";
    if (x < len && (index = text.indexOf("and", x)) > -1) {
      /* If indexOf returns -1, there are no more "and"s.
      If it is anything greater, we get the next potential occurence of "and". */
      if (delim.indexOf(text.charAt(index - 1)) > -1 &&
        delim.indexOf(text.charAt(index + 3)) > -1) countand++;
      /* Verification that it is the word "and":
      If the character before and after belong to the predefiend delimiter set,
      increment the "and" count. */
      checkandfreq(index + 3);
      /* finally recurse */
    }
  }
  void checkanfreq(int x) {
    int index;
    String delim = " !@#$%^&*_-+=(){}[],'\":;.?/\\|";
    if (x < len && (index = text.indexOf("an", x)) > -1) {
      /* If indexOf returns -1, there are no more "an"s.
      If it is anything greater, we get the next potential occurence of "an". */

      if (delim.indexOf(text.charAt(index - 1)) > -1 && delim.indexOf(text.charAt(index + 2)) > -1) countan++;
      /* Verification that it is the word "an":
      If the character before and after belong to the predefiend delimiter set,
      increment the "an" count. */
      checkanfreq(index + 2);
      /* finally recurse */
    }
  }
  void display() {
    System.out.println("[and count]:\t" + countand + "\n[an count]:\t" + countan);
  }
  public static void main(String args[]) {
    Frequency f = new Frequency();
    System.out.print("[input sentence]: ");
    f.accept((new Scanner(System.in)).nextLine());
    f.checkandfreq(0);
    f.checkanfreq(0);
    f.display();
  }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`text`| `String`| Stores the sentence
`countan`| `int`| Stores the frequency of "an"
`countand`| `int`| Stores the frequency of "and"
`len`| `int`| Stores the length of the sentence
`index`| `int`| Local variable to keep track of the index of and
`f`| `Frequency`| Object for implementation and demonstration in `main`
# Output
<img src=":/193031d4b7cb483ba18356f9299d6cc1" style="border-radius:10px">

# 30. Objective
To implement insertion sort

# Algorithm
1. Start
2. Read array size and array elements into `arr`
3. If there is only one element, no sorting is needed
4. Loop through the elements
	* Compare the current element to the ones in the sorted sub-list 
	* Shift back all the elements in the sorted sub-list greater than the current element
	* Insert the current element in the emptied index
5. Print the sorted array
6. Stop
# Source Code
```java
import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("[enter array size]:");
        int A[]=new int[s.nextInt()];
		// using the input size directly, not wasting variables
		System.out.println("[enter array elements]:");
		for(int i=0;i<A.length;A[i++]=s.nextInt());
		// accept inputs from the user
		for(int i=1;i<A.length;++i){
            int j=i-1;
            for(;j>-1&&A[j]>A[i];A[j+1]=A[j--]); // shift the elements to the left
            A[j+1]=A[i];
			// place this variable at the now "emptied" spot
        }
		System.out.println("[sorted array]: ");
		for (int i:A) System.out.println(i);
		// loop through and print out the sorted array
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`s`|`Scanner`|Scanner object to take user input
`i`,`j`|`int`|Local iterator
`A`|`int[]`|Array of user supplied length

# Output
<img src=":/794edd1c47b9488cbb502983f2aa6f4c" style="border-radius:10px">

# 31. Objective
To implement merge sort

# Algorithm
1. Start
2. Read elements into array of input specified size.
3. store the starting index of our array in $p$ and store the last index of array in $r$.
4. Find the middle of the array, $q = \frac{p + r}{2}$ and break the array into two subarrays
6. Continue dividing these 2 subarrays.
6. Once the main array is divided into elementary subarrays, start merging the subarrays.
7. Print the sorted array
8. Stop
# Source Code
```java
import java.util.Scanner;
public class MergeSort {
	  static void merge(int[] A, int lo, int m, int hi) {
        int l[]=new int[m+1-lo],r[]=new int[hi-m],lx=0,rx=0,i=0;
        for (;i<l.length;l[i]=A[lo+i++]);
        for (i=0;i<r.length;r[i++]=A[m+i]);
        for (i=lo;i<hi+1;i++)A[i]=lx<l.length&&rx<r.length?(l[lx]<r[rx]?l[lx++]:r[rx++]):(lx<l.length?l[lx++]:(rx<r.length?r[rx++]:A[i]));
		  // compare the elementary arrays and merge them respectively into the left and right arrays
    }
	static void mergeSort(int[] A, int lo, int hi) {
        if (hi<=lo)return;
        int m=(lo+hi)/2;
		// the mean value of low and high
        mergeSort(A,lo,m);
		// divide the left side
        mergeSort(A,m+1,hi);
		// divide the right side
        merge(A,lo,m,hi);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("[enter array size]:");
        int A[]=new int[s.nextInt()];
		System.out.println("[enter array elements]:");
		for (int i=0;i<A.length;A[i++]=s.nextInt());
		// accept elements from user input
		mergeSort(A,0,A.length-1);
		System.out.println("[sorted array]: ");
		for(int i:A)System.out.println(i);
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`A`|`int[]`|Array of user supplied length
`s`|`Scanner`|Scanner object to take input
`i`|`int`|Local iterator
`lo`,`m`,`hi`|`int`|Store indices of low, medium and high extremes respectively
`l`,`r`|`int[]`|Store the left and right sub-lists respectively
`lx`,`rx`|`int`|Store the indices for the left and right sub-lists  respectively during iterations

# Output
<img src=":/465abab7878f4221b95bf4d43e5ecf4d" style="border-radius:10px">

# 32. Objective
To implement quick sort

# Algorithm
1. Start
2. Read elements into array of input specified size
3. Choose the highest index value has pivot
4. Take two variables to point left and right of the list excluding pivot
5. left points to the low index
6. right points to the high
7. while value at left is less than pivot move right
8. while value at right is greater than pivot move left
9. If both step 5 and step 6 do not match swap left and right
10. If left ≥ right, the point where they met is new pivot
11. Print the sorted array
12. Stop
# Source Code
```java
import java.util.Scanner;
public class QuickSort {
    int A[];
    void accept(){
        Scanner s=new Scanner(System.in);
        System.out.println("[enter array size]: ");
        A=new int[s.nextInt()];
        System.out.println("[enter array elements]: ");
        for (int i=0;i<A.length;A[i++]=s.nextInt());
					// loop and accept elements
    }
    int P(int l,final int r){
        for (int i=l;i<r;i++)if(A[i]<A[r])swap(l++,i);
		// swap the left end and the current iterator for partitioning
        swap(l,r);
        return l;
    }
    void swap(int l,int r){
        int t=A[l]; // use a temporary variable for swapping
        A[l]=A[r];
        A[r]=t;
    }
    void sort(int l,int r){
        if (l<r){
            int p=P(l,r); // pivot based on left and right ends
            sort(l,p-1);
            sort(p+1,r);
        }
    }
    void display(){
        System.out.println("[sorted array]:");
        for(int i:A)System.out.println(i);
		// loop through the sorted array and display it
    }
    public static void main(String[] args) {
            QuickSort q=new QuickSort();
            q.accept();
            q.sort(0,q.A.length-1);
		// beginning to the end
            q.display();
    }
}
```

# Variable Description Table
Name | Type | Description
-|-|-
`A`|`int[]`|Array of user supplied length
`s`|`Scanner`|Scanner object to take input
`i`|`int`|Local iterator
`l`,`r`|`int`|Store indices of left an right extremes respectively
`t`|`int`|Temporary variable
`q`|`QuickSort`|Class instance to call member methods

# Output
<img src=":/d892b437467c42d89052b7c81ae9ebe0" style="border-radius:10px">
