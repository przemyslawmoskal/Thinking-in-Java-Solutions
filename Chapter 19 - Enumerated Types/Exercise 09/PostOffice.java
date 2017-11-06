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

	enum ReturnAddress {
		MISSING, OK1, OK2, OK3, OK4, OK5
	}

	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ReturnAddress returnAddress;
	static long counter = 0;
	long id = counter++;

	public String toString() {
		return "Mail " + id;
	}

	public String details() {
		return toString() + ", General Delivery: " + generalDelivery + ", Address Scanability: " + scannability
				+ ", Address Readability: " + readability + ", Address Address: " + address + ", Return address: "
				+ returnAddress;
	}

	// Generate test Mail:
	public static Mail randomMail() {
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
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

interface Handler { boolean handle(Mail m); }

public class PostOffice {
	
	enum MailHandler { GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER};

	public static void handle(Mail m, EnumMap<MailHandler, Handler> em) {
		for (Map.Entry<MailHandler, Handler> entry : em.entrySet())
			if (entry.getValue().handle(m))
				return;
		print(m + " is a dead letter");
	}

	public static void main(String[] args) {
		
		EnumMap<MailHandler, Handler> em = new EnumMap<MailHandler, Handler>(MailHandler.class);
		em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
			public boolean handle(Mail m) {
				switch (m.generalDelivery) {
				case YES:
					print("Using general delivery for " + m);
					return true;
				default:
					return false;
				}
			}
		});
		
		em.put(MailHandler.MACHINE_SCAN, new Handler() {
			public boolean handle(Mail m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						print("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		});
		
		em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
			public boolean handle(Mail m) {
				switch (m.readability) {
				case ILLEGIBLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						print("Delivering " + m + " normally");
						return true;
					}
				}
			}
		});
		
		em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
			public boolean handle(Mail m) {
				switch (m.returnAddress) {
				case MISSING:
					return false;
				default:
					print("Returning " + m + " to sender");
					return true;
				}
			}
		});
		
		for (Mail mail : Mail.generator(20)) {
			print(mail.details());
			handle(mail, em);
			print("*****");
		}
	}
}

/* Output:
Mail 0, General Delivery: NO2, Address Scanability: UNSCANNABLE, Address Readability: YES3, Address Address: OK1, Return address: OK1
Delivering Mail 0 normally
*****
Mail 1, General Delivery: NO5, Address Scanability: YES3, Address Readability: ILLEGIBLE, Address Address: OK5, Return address: OK1
Delivering Mail 1 automatically
*****
Mail 2, General Delivery: YES, Address Scanability: YES3, Address Readability: YES1, Address Address: OK1, Return address: OK5
Using general delivery for Mail 2
*****
Mail 3, General Delivery: NO4, Address Scanability: YES3, Address Readability: YES1, Address Address: INCORRECT, Return address: OK4
Returning Mail 3 to sender
*****
Mail 4, General Delivery: NO4, Address Scanability: UNSCANNABLE, Address Readability: YES1, Address Address: INCORRECT, Return address: OK2
Returning Mail 4 to sender
*****
Mail 5, General Delivery: NO3, Address Scanability: YES1, Address Readability: ILLEGIBLE, Address Address: OK4, Return address: OK2
Delivering Mail 5 automatically
*****
Mail 6, General Delivery: YES, Address Scanability: YES4, Address Readability: ILLEGIBLE, Address Address: OK4, Return address: OK4
Using general delivery for Mail 6
*****
Mail 7, General Delivery: YES, Address Scanability: YES3, Address Readability: YES4, Address Address: OK2, Return address: MISSING
Using general delivery for Mail 7
*****
Mail 8, General Delivery: NO3, Address Scanability: YES1, Address Readability: YES3, Address Address: INCORRECT, Return address: MISSING
Mail 8 is a dead letter
*****
Mail 9, General Delivery: NO1, Address Scanability: UNSCANNABLE, Address Readability: YES2, Address Address: OK1, Return address: OK4
Delivering Mail 9 normally
*****
Mail 10, General Delivery: NO3, Address Scanability: YES3, Address Readability: YES4, Address Address: OK5, Return address: OK1
Delivering Mail 10 automatically
*****
Mail 11, General Delivery: NO2, Address Scanability: YES1, Address Readability: YES2, Address Address: OK1, Return address: OK1
Delivering Mail 11 automatically
*****
Mail 12, General Delivery: NO3, Address Scanability: YES4, Address Readability: YES2, Address Address: OK3, Return address: MISSING
Delivering Mail 12 automatically
*****
Mail 13, General Delivery: NO2, Address Scanability: UNSCANNABLE, Address Readability: YES3, Address Address: OK4, Return address: OK3
Delivering Mail 13 normally
*****
Mail 14, General Delivery: YES, Address Scanability: UNSCANNABLE, Address Readability: YES4, Address Address: INCORRECT, Return address: MISSING
Using general delivery for Mail 14
*****
Mail 15, General Delivery: NO5, Address Scanability: YES3, Address Readability: YES3, Address Address: INCORRECT, Return address: OK5
Returning Mail 15 to sender
*****
Mail 16, General Delivery: NO2, Address Scanability: YES4, Address Readability: ILLEGIBLE, Address Address: OK5, Return address: OK3
Delivering Mail 16 automatically
*****
Mail 17, General Delivery: NO5, Address Scanability: YES1, Address Readability: YES3, Address Address: OK2, Return address: MISSING
Delivering Mail 17 automatically
*****
Mail 18, General Delivery: NO1, Address Scanability: YES4, Address Readability: ILLEGIBLE, Address Address: INCORRECT, Return address: OK2
Returning Mail 18 to sender
*****
Mail 19, General Delivery: NO1, Address Scanability: YES4, Address Readability: YES1, Address Address: INCORRECT, Return address: OK3
Returning Mail 19 to sender
*****
*/
