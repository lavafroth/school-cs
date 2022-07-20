import java.util.Arrays;
public class Revision {
	static int Gcd(int x, int y) { // Hog stack frames
		if(x<y){
		    int swp = y; // O(1) Auxiliary space
		    y = x;
		    x = swp;
		}
	    if(y==x||y==0)return x;
		return Gcd(y, x%y); // O(log{y}(x))
	}
	static int binarySearch(int arr[], int x) {
		int i = arr.length/2;
		if (i==0) return arr[i]==x?x:-9999;
		if(arr[i]>x)return binarySearch(Arrays.copyOfRange(arr,0,i),x);
		return binarySearch(Arrays.copyOfRange(arr,i,arr.length),x);
	}
	int fibo(int n) {
		return (int)(Math.pow(.5+Math.pow(1.25,.5),n)/Math.pow(5,.5));
	}	
	public static void main(String args[]) {
	    int A[] = {0,22,35,45,445,676,23423};
		System.out.println(binarySearch(A, 676));
	}
}

