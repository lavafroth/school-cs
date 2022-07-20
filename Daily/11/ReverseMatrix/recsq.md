### 10. a. Objective: Program to calculate and return the sum of the square of the digits of a number ‘n’ using recursive technique.

#### Source code:

```java
import java.util.Scanner;
class sumSquareRecurse{
    int sumSq(int n){
        return n>0?((int)Math.pow(n%10,2)+sumSq(n/10)):0;
    }
    public static void main(String args[]){
        java.io.PrintStream o = System.out;
        sumSquareRecurse s = new sumSquareRecurse();
        o.print("[number for square sum]: ");
        o.println("sum of squares: "+s.sumSq((new Scanner(System.in)).nextInt()));
    }
}
```

#### Output: 

![](/home/himadrey/dox/rs2.png)

![rs1](/home/himadrey/dox/rs1.png)

### b. Difference between recursion and iteration

| Recursion                                                    | Iteration                                                    |
| :----------------------------------------------------------- | :----------------------------------------------------------- |
| Recursion involves a method (or function if static) calling itself per child node call until it reaches the base case. This involves use of multiple stack frames and thus consumes more stack space due to pushes of each save frame pointer. | Iteration involved performing a particular operation until a condition is met. It does not involve child nodes that call themselves and thus consumes much less stack space. |

---

### 11. a. Objective: Program to accept a product code ‘p’ and check the availability of the product and display with an appropriate message from a file “ABC.DAT” that contains the product code (pc), unit price (up) and quantity(q) for number of items.

#### Source Code:

```java
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
```

#### Output:

![](/home/himadrey/dox/pro1.png)

![](/home/himadrey/dox/pro2.png)

### b. Difference between binary and text file

| Binary file                                                  | Text file                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| A binary file can contain any arbitrary data which may include ASCII, extended ASCII or Unicode data as well as non printable characters. | A text file can only contain Unicode (ASCII being a subset) characters in it. It cannot contain any arbitrary binary data or non printable characters. |

