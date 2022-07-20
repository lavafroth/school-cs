## Recursive String Reversing Program

#### Source Code

```java
import java.util.Scanner;
class rec_rev{
    String RecRev(String szOrig){
        if(szOrig.endsWith(".")||szOrig.endsWith("!")||szOrig.endsWith("?"))return szRecRev(szOrig);
        return "Invalid input.";
    }
    String szRecRev(String z){
        int len=z.length();
        if(len/2==0)return z;
        return z.charAt(len-1) + szRecRev(z.substring(1,len-1)) + z.charAt(0);
    }
    public static void main(){
        rec_rev RecRev = new rec_rev();
        System.out.print("[input]: ");
        System.out.print(RecRev.RecRev((new Scanner(System.in)).nextLine()));
    }
}
```

