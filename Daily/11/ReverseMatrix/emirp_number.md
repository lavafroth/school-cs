#### Objective: To check if a number is prime and so is its reverse
#### Source Code:
```java
class Emirp{
	int n,rev,f;
	Emirp(int nn){
		n=nn;
		rev=0;
		f=2;
	}
	int isprime(int x){
		if(x==f){
			f=2;
			return 1;
		}
		/* if f keeps incrementing and finally hits x
		(as a result of totient), return to original state */
		if(x%f++==0){
		/* postfix, i.e., x%f for now and then increment f */
			f=2;
			/* return to original state */
			return 0;
		}
		return isprime(x);
	}
	void isEmirp(){
		for(int i=n;i!=0;i/=10)rev=rev*10+i%10;
		/* since both of them have to be true, the sum must be 2 */
		System.out.println(n+" is "+((isprime(n)+isprime(rev)<2)?"not":"")
		+"an Emirp number");
	}
	public static void main(){
		Emirp obj=new Emirp(22);
		obj.isEmirp();
	}
}
```