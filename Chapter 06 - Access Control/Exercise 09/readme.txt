Create in access/local directory in your CLASSPATH:

// access/local/PackagedClass.java
package access.local;

class PackagedClass {
	public PackagedClass() {
		System.out.println("Creating a packaged class");
	}
}

Then, in another directrory create the file below and explain why compiler
generates error. Would making Foreign class part of access.local change anything?


// access/foreign/Foreign.java
package access.foreign;
import access.local.*;

public class Foreign {
	public static void main(String[] args) {
		PackagedClass pc = new PackagedClass();
	}
}

Chapter 06 Exercise 09