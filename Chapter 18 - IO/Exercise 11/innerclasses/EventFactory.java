package innerclasses;
import innerclasses.controller.*;

public interface EventFactory {
	Event getEvent(GreenhouseControls gc, Long time);
}

class BellFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new Bell(time);
	}
}

class LightOnFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new LightOn(time);
	}
}

class LightOffFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new LightOff(time);
	}
}

class WaterOnFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new WaterOn(time);
	}
}

class WaterOffFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new WaterOff(time);
	}
}

class ThermostatNightFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new ThermostatNight(time);
	}
}

class ThermostatDayFactory implements EventFactory {
	public Event getEvent(GreenhouseControls gc, Long time) {
		return gc.new ThermostatDay(time);
	}
}