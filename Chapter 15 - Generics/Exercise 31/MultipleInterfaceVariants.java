interface Payable {
	float pay();
}

class Employee implements Payable {
	public float monthly;
	public float pay() {
		return monthly;
	}
}

class Hourly extends Employee implements Payable {
	String name;
	float hourly;
	int hoursWorked;
	Hourly(String name, float hourly, int hoursWorked) {
		this.name = name;
		this.hourly = hourly;
		this.hoursWorked = hoursWorked;
	}
	public float pay() {
		System.out.println("Employee name: " + name + ", to pay (this month): $" + (hourly * hoursWorked));
		return hourly * hoursWorked;
	}
}

public class MultipleInterfaceVariants {
	public static void main(String[] args) {
		Hourly h1 = new Hourly("John Smith", 22.5F, 153);	
		Hourly h2 = new Hourly("Jack Jones", 35.2F, 123);
		Hourly h3 = new Hourly("Jane Wright", 41F, 125);
		Hourly[] hourlyArr = new Hourly[] { h1,h2,h3 };
		for(Hourly h : hourlyArr)
			h.pay();
	}
}

/* Output:
Employee name: John Smith, to pay (this month): $3442.5
Employee name: Jack Jones, to pay (this month): $4329.6
Employee name: Jane Wright, to pay (this month): $5125.0
*/