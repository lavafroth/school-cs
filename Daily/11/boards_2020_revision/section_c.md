## Section C

#### 10. a.

```java
static double power(int a, int b){
	if (b==0) return 1;
	return a * power(a, --b);
}
```

#### b.

Finite Recursion | Infinite Recursion
--- | ---
Finite recursions terminate once the base case is met. | Infinite recursions never terminate as the base case generally does not exist or is never met. 

#### 11. a.

```java
void find_attend() throws IOException {
	String emp;
	DataInputStream fi = new DataInputStream(new FileInputStream("Attend.txt"));
	try {
	emp = fi.readLine();
	if(fi.readInt()>80) System.out.println(emp);
	}
	catch (EOFException e){
		System.out.print("----------------");
		fi.close();
	}
}
```

#### b. Three classes needed for text file creation:

* `DataOutputStream`
* `FileOutputStream`
* `IOException` abstract class

#### 12. i.

Java API packages are application programming interface packages which provides different methods and classes thereby extending the functionality of a program.

#### ii.

A firewall can be hardware of software which prevents malicious traffic from entering or leaving endpoints and hosts. These also block and alert when a server or endpoint is being port scanned or hammered with directory traversal. Eg: Splunk

#### iii.

Phishing is a technique whereby a malicious actor sends a link to a web page that looks identical to legitimate ones for a user to give in personal details or login credentials.

#### iv.

Augmented reality masks only a part of the user's vision with computer generated media where there exists a marker or a tag. This thereby modifies only a section of the user's reality.

#### v.

Virtual reality masks the whole vision and periphery of a user with computer generated media and "bring" the user to a different reality. This is mainly achieved using the help of a virtual reality headset. 

Uses:

* Medical procedure training as well as deep insights of specific illnesses
* Virtual reality tours of places
* Product demonstrations