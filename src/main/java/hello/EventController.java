package hello;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EventController {

    private Map<String, Event> events = new HashMap<>();

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public Event event(@RequestBody Event event) {
        events.put(event.getId(), event);

        return event;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents(@RequestParam(required = false) String location) {
        ArrayList<Event> filteredEvents = new ArrayList<>();

        if (location == null) {
            filteredEvents.addAll(events.values());
        } else {
            for (Event event : events.values()) {
                if (event.getLocation().equals(location)) {
                    filteredEvents.add(event);
                }
            }
        }

        return filteredEvents;
    }

    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable String eventId) {
        return events.get(eventId);
    }
}
