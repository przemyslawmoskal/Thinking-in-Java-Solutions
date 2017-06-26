package ch06ex08;
import static ptmoskal.Print.*;

class Connection {
	private Connection() { print("Connection()"); }
	static Connection createConnection() {
		return new Connection();
	}
}

public class ConnectionManager {
	static int remaining = 5;
	static void showRemaining() {
		print("Available connections: " + remaining);
	}
	static Connection[] connections = new Connection[5];
	{
	for(Connection c : connections)
		c = Connection.createConnection();
	}
	public static Connection getConnection() {
		if(remaining > 0) {
			print("Creating Connection");
			return connections[--remaining];
		}else
			print("No more connections available!");
			return null;
	}
	public static void main(String[] args) {
		ConnectionManager cm = new ConnectionManager();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
		getConnection();
		showRemaining();
	}

}

/* Output:
Connection()
Connection()
Connection()
Connection()
Connection()
Available connections: 5
Creating Connection
Available connections: 4
Creating Connection
Available connections: 3
Creating Connection
Available connections: 2
Creating Connection
Available connections: 1
Creating Connection
Available connections: 0
No more connections available!
Available connections: 0
*/