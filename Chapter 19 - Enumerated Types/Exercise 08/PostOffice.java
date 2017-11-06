// Modeling a post office.
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

class Mail {
	// The NO's lower the probability of random selection:
	enum GeneralDelivery {
		YES, NO1, NO2, NO3, NO4, NO5
	}

	enum Scannability {
		UNSCANNABLE, YES1, YES2, YES3, YES4
	}

	enum Readability {
		ILLEGIBLE, YES1, YES2, YES3, YES4
	}

	enum Address {
		INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
	}
	
	enum ForwardAddress {
		INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
	}

	enum ReturnAddress {
		MISSING, OK1, OK2, OK3, OK4, OK5
	}

	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ForwardAddress forwardAddress;
	ReturnAddress returnAddress;
	static long counter = 0;
	long id = counter++;

	public String toString() {
		return "Mail " + id;
	}

	public String details() {
		return toString() + ", General Delivery: " + generalDelivery + ", Address Scanability: " + scannability
				+ ", Address Readability: " + readability + ", Address Address: " + address + ", Forward Address: " + forwardAddress + ", Return address: "
				+ returnAddress;
	}

	// Generate test Mail:
	public static Mail randomMail() {
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
		m.forwardAddress = Enums.random(ForwardAddress.class);
		m.returnAddress = Enums.random(ReturnAddress.class);
		return m;
	}

	public static Iterable<Mail> generator(final int count) {
		return new Iterable<Mail>() {
			int n = count;

			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					public boolean hasNext() {
						return n-- > 0;
					}

					public Mail next() {
						return randomMail();
					}

					public void remove() { // Not implemented
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

public class PostOffice {
	enum MailHandler {
		GENERAL_DELIVERY {
			boolean handle(Mail m) {
				switch (m.generalDelivery) {
				case YES:
					print("Using general delivery for " + m);
					return true;
				default:
					return false;
				}
			}
		},
		MACHINE_SCAN {
			boolean handle(Mail m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						switch (m.forwardAddress) {
						case INCORRECT: 
							return false;
						default:
							print("Delivering " + m + " automatically (forward address)");
							return true;
						}
						
					default:
						print("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		},
		VISUAL_INSPECTION {
			boolean handle(Mail m) {
				switch (m.readability) {
				case ILLEGIBLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						switch (m.forwardAddress) {
						case INCORRECT: 
							return false;
						default:
							print("Delivering " + m + " normally (forward address)");
							return true;
						}
						
					default:
						print("Delivering " + m + " normally");
						return true;
					}
				}
			}
		},
		RETURN_TO_SENDER {
			boolean handle(Mail m) {
				switch (m.returnAddress) {
				case MISSING:
					return false;
				default:
					print("Returning " + m + " to sender");
					return true;
				}
			}
		};
		abstract boolean handle(Mail m);
	}

	static void handle(Mail m) {
		for (MailHandler handler : MailHandler.values())
			if (handler.handle(m))
				return;
		print(m + " is a dead letter");
	}

	public static void main(String[] args) {
		for (Mail mail : Mail.generator(20)) {
			print(mail.details());
			handle(mail);
			print("*****");
		}
	}
}

/* Output:
Mail 0, General Delivery: NO2, Address Scanability: UNSCANNABLE, Address Readability: YES3, Address Address: OK1, Forward Address: OK5, Return address: OK5
Delivering Mail 0 normally
*****
Mail 1, General Delivery: NO4, Address Scanability: UNSCANNABLE, Address Readability: YES2, Address Address: INCORRECT, Forward Address: OK2, Return address: MISSING
Delivering Mail 1 normally (forward address)
*****
Mail 2, General Delivery: NO3, Address Scanability: YES4, Address Readability: YES4, Address Address: OK3, Forward Address: OK1, Return address: OK1
Delivering Mail 2 automatically
*****
Mail 3, General Delivery: NO2, Address Scanability: YES3, Address Readability: YES1, Address Address: OK4, Forward Address: INCORRECT, Return address: MISSING
Delivering Mail 3 automatically
*****
Mail 4, General Delivery: NO2, Address Scanability: YES3, Address Readability: YES1, Address Address: OK5, Forward Address: OK4, Return address: OK2
Delivering Mail 4 automatically
*****
Mail 5, General Delivery: YES, Address Scanability: YES4, Address Readability: ILLEGIBLE, Address Address: OK4, Forward Address: OK4, Return address: MISSING
Using general delivery for Mail 5
*****
Mail 6, General Delivery: NO1, Address Scanability: YES4, Address Readability: YES4, Address Address: OK6, Forward Address: OK4, Return address: OK5
Delivering Mail 6 automatically
*****
Mail 7, General Delivery: YES, Address Scanability: YES2, Address Readability: YES1, Address Address: INCORRECT, Forward Address: INCORRECT, Return address: OK2
Using general delivery for Mail 7
*****
Mail 8, General Delivery: NO4, Address Scanability: YES1, Address Readability: YES2, Address Address: INCORRECT, Forward Address: OK4, Return address: OK5
Delivering Mail 8 automatically (forward address)
*****
Mail 9, General Delivery: NO1, Address Scanability: YES4, Address Readability: YES1, Address Address: OK5, Forward Address: OK1, Return address: OK1
Delivering Mail 9 automatically
*****
Mail 10, General Delivery: NO3, Address Scanability: YES4, Address Readability: YES2, Address Address: OK3, Forward Address: OK3, Return address: OK2
Delivering Mail 10 automatically
*****
Mail 11, General Delivery: NO4, Address Scanability: YES3, Address Readability: YES1, Address Address: INCORRECT, Forward Address: OK4, Return address: OK5
Delivering Mail 11 automatically (forward address)
*****
Mail 12, General Delivery: YES, Address Scanability: YES4, Address Readability: YES2, Address Address: INCORRECT, Forward Address: OK3, Return address: OK2
Using general delivery for Mail 12
*****
Mail 13, General Delivery: NO1, Address Scanability: YES3, Address Readability: YES1, Address Address: OK3, Forward Address: OK3, Return address: OK4
Delivering Mail 13 automatically
*****
Mail 14, General Delivery: NO3, Address Scanability: YES3, Address Readability: YES1, Address Address: OK4, Forward Address: OK2, Return address: MISSING
Delivering Mail 14 automatically
*****
Mail 15, General Delivery: NO1, Address Scanability: YES4, Address Readability: ILLEGIBLE, Address Address: INCORRECT, Forward Address: OK2, Return address: OK1
Delivering Mail 15 automatically (forward address)
*****
Mail 16, General Delivery: NO1, Address Scanability: YES1, Address Readability: YES3, Address Address: OK5, Forward Address: OK4, Return address: OK2
Delivering Mail 16 automatically
*****
Mail 17, General Delivery: NO5, Address Scanability: YES1, Address Readability: ILLEGIBLE, Address Address: OK3, Forward Address: OK4, Return address: OK1
Delivering Mail 17 automatically
*****
Mail 18, General Delivery: NO3, Address Scanability: YES3, Address Readability: YES2, Address Address: INCORRECT, Forward Address: OK1, Return address: OK2
Delivering Mail 18 automatically (forward address)
*****
Mail 19, General Delivery: NO2, Address Scanability: YES3, Address Readability: ILLEGIBLE, Address Address: OK1, Forward Address: OK4, Return address: MISSING
Delivering Mail 19 automatically
*****
*/