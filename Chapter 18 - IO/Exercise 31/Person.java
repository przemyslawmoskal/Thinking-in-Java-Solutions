import nu.xom.*;
import java.io.*;
import java.util.*;

public class Person {
	private String first, last, address;

	public Person(String first, String last, String address) {
		this.first = first;
		this.last = last;
		this.address = address;
	}

	// Produce an XML Element from this Person object:
	public Element getXML() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		Element personAddress = new Element("address");
		personAddress.appendChild(address);
		person.appendChild(firstName);
		person.appendChild(lastName);
		person.appendChild(personAddress);
		return person;
	}

	// Constructor to restore a Person from an XML Element:
	public Person(Element person) {
		first = person.getFirstChildElement("first").getValue();
		last = person.getFirstChildElement("last").getValue();
		address = person.getFirstChildElement("address").getValue();
	}

	public String toString() {
		return first + " " + last + " " + address;
	}

	// Make it human-readable:
	public static void format(OutputStream os, Document doc) throws Exception {
		Serializer serializer = new Serializer(os, "ISO-8859-1");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}

	public static void main(String[] args) throws Exception {
		List<Person> people = Arrays.asList(new Person("Dr. Bunsen", "Honeydew", "1st Street"),
				new Person("Gonzo", "The Great", "2nd Street"), new Person("Phillip J.", "Fry", "3rd Street"));
		System.out.println(people);
		Element root = new Element("people");
		for (Person p : people)
			root.appendChild(p.getXML());
		Document doc = new Document(root);
		format(System.out, doc);
		format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
	}
}

/* Output:
[Dr. Bunsen Honeydew 1st Street, Gonzo The Great 2nd Street, Phillip J. Fry 3rd Street]
<?xml version="1.0" encoding="ISO-8859-1"?>
<people>
    <person>
        <first>Dr. Bunsen</first>
        <last>Honeydew</last>
        <address>1st Street</address>
    </person>
    <person>
        <first>Gonzo</first>
        <last>The Great</last>
        <address>2nd Street</address>
    </person>
    <person>
        <first>Phillip J.</first>
        <last>Fry</last>
        <address>3rd Street</address>
    </person>
</people>
*/