package innerclasses;
import innerclasses.controller.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class GreenhouseController {
	public static String[] events;
	public static Long[] times;
	// Reading events names and appropriate times from text file, converting names to corresponding factories' names,
	// adding these factories names to String[]events and times to Long[]times at the same index number:
	public static void readEvents(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src\\" + filename));
		String s;
		String[] allEvents = new String[0];
		Long[] allTimes = new Long[0];
		int index = 0;
		while((s = in.readLine()) != null) {
			String[] pair = s.split("[()]");
			StringBuilder sb = new StringBuilder(pair[0]);
			sb.append("Factory");
			pair[0] = sb.toString();
			Long time = new Long(pair[1]);
			String[] temporaryAllEvents = new String[allEvents.length + 1];
			Long[] temporaryAllTimes = new Long[allTimes.length + 1];
			for(int i = 0; i < allEvents.length; i++) {
				temporaryAllEvents[i] = allEvents[i];
				temporaryAllTimes[i] = allTimes[i];
			}
			temporaryAllEvents[index] = pair[0];
			temporaryAllTimes[index] = time;
			allEvents = temporaryAllEvents;
			allTimes = temporaryAllTimes;
			index++;
		}
		in.close();
		events = allEvents;
		times = allTimes;
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		GreenhouseControls gc = new GreenhouseControls();
		// When new factories created, remember to add them to this array:
		EventFactory[] factories = {
				new BellFactory(),
				new ThermostatNightFactory(),
				new ThermostatDayFactory(),
				new WaterOnFactory(),
				new WaterOffFactory(),
				new LightOnFactory(),
				new LightOffFactory(),
				};
		try {
			readEvents("Actions.txt");
			Event[] eventList = new Event[events.length];
			System.out.println("Events loaded from file: ");
			System.out.println("***********************");
			for(int i = 0; i < events.length; i++) {
				System.out.println(events[i] + " (time: " + times[i] + ")");
			}
			for(int i = 0; i < events.length; i++) {
				for(int j = 0; j < factories.length; j++) {
					if (factories[j].getClass().getSimpleName().equals(events[i])) {
						eventList[i] = factories[j].getEvent(gc, times[i]);
					}
				}
			}
			System.out.println("***********************");
			gc.addEvent(gc.new Restart(2000, eventList));
			if (args.length == 1)
				gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
			gc.run();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

/* Output:
Events loaded from file: 
***********************
BellFactory (time: 100)
ThermostatNightFactory (time: 300)
LightOnFactory (time: 200)
WaterOnFactory (time: 200)
ThermostatDayFactory (time: 600)
LightOffFactory (time: 100)
WaterOffFactory (time: 500)
BellFactory (time: 100)
LightOnFactory (time: 300)
LightOffFactory (time: 300)
***********************
Bing!
Thermostat on night setting
Light is on
Greenhouse water is on
Thermostat on day setting
Light is off
Greenhouse water is off
Bing!
Light is on
Light is off
Restarting system
Terminating
*/
