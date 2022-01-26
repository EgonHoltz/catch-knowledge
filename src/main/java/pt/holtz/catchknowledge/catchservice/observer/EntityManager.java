package pt.holtz.catchknowledge.catchservice.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityManager {

	Map<String,List<EventListener>> listeners = new HashMap<>();
	
	public EntityManager(String... serviceNames) {
		for (String svcName : serviceNames) {
			this.listeners.put(svcName, new ArrayList<>());
		}
	}
	
	public void subscribe(String svcName, EventListener evntListener) {
		List<EventListener> evntListeners = listeners.get(svcName);
		evntListeners.add(evntListener);
	}
	public void unsubscribe(String svcName, EventListener evntListener) {
		List<EventListener> evntListeners = listeners.get(svcName);
		evntListeners.remove(evntListener);	
	}
	
	public void notify(String svcName, Object svcObject) {
		List<EventListener> evntListeners = listeners.get(svcName);
		for (EventListener listner : evntListeners) {
			listner.update(svcObject);
		}
	}
}
