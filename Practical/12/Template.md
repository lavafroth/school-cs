Template

## Objective

_To check if a number is an ore number, a xylem or a phloem number._

## Algorithm

_main_
* Start
* Take integer input from the user
* If integer supplied is negative, convert it to positive
* Call respective functions for checking ore, xylem, phloem numbers
* Stop

_Xylem/Phloem checking function:_
* Assign the last digit of the number to the sum of extremes, 0 to the sum of means
* Keep a backup of the original number for later printing
* Divide the number by 10
* Loop while the number is more than 9
	* Add the last digit to the sum of means
	* Divide the number by 10
* Add the remaining value (leading digit) of the number to the sum of extremes
* If the sum of extremes equals the sum of means, print it to be a xylem number, otherwise a phloem number

_Ore checking function:_
* Initialize counter to 1 and harmonic sum of factors to 1.0 (since 1 is a factor of anything)
* Loop from 2 to one more than the number
	* If the loop index divides the number
		* Increment the counter
		* Print the factor (loop index)
		* Add its reciprocal to the harmonic sum
* If the counter divided by the harmonic sum yields an integer (no fractional part, `n%10` is `0` ), print it to be an ore number, otherwise not.

## Source Code

```java
import java.util.Scanner;
class xpo {
    static void x(int v) {
        int e = v%10, m = 0, original = v;//extreme, mean, original
        v /= 10; // do not need the last digit anymore
        for(; v > 9; v /= 10) m += v%10; // 10 digit number, greater than 9
        e += v; // leading digit is now left
        System.out.println("The sum of extreme digits: " + e
            + "\nThe sum of mean digits: " + m + "\n"
            + original + " is a " + (e == m ? "xylem" : "phloem") + " number.");
    }

    static void o(int v) {
        int count = 1; // a number will have at least 1 factor
        double f = 1.0; // 1.0 divides everything
        System.out.print("The factors are: 1 ");
        for(int d = 2; d < v+1; d++) { // start after 1 till v itself
            if(v%d == 0){
                count++; // increment counter
                System.out.print(d + " ");
                f += (1.0 / (double)d);
            }
        }
        System.out.println("\n" + v + " is "
            + ((count / f)%1.0 == 0 ? "" : "not ") // mod 1.0 will give fractional part
            +"an ore number.");
    }

    public static void main() {
        System.out.print("Enter a number: ");
        int i = (new Scanner(System.in)).nextInt();
        if(i < 0) i =- i; // convert to positive
        o(i);
        x(i);
    }
}
```

## Variable Description Table

| Name | Type | Description |
| - | - | - |
| `e` | `int` | Holds the sum of extremes |
| `m` | `int` | Holds the sum of means |
| `v` | `int` | Value passed to check functions |
| `counter` | `int` | Counter for the number of factors |
| `f` | `double` | Sum of reciprocals are stored |
| `i` | `int` | Input from user in `main` |

### Output

![Screenshot_20210924_093735.png](/_resources/ccf2a08d807349c4adb12a872445d6e6.png)
![Screenshot_20210924_093703.png](/_resources/43670064b4b8435e96af862874aed67f.png)
![Screenshot_20210924_093638.png](/_resources/6b6823c1c04740bdbc568f3b4e74b65e.png)
![Screenshot_20210924_093532.png](/_resources/b9ca7987475440a79479f0baf07bc24c.png)
![Screenshot_20210924_093431.png](/_resources/cf8767474ab24afaa8164e862eed00f5.png)
