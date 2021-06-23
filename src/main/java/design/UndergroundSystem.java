package design;

import java.util.HashMap;
import java.util.Map;

/**
 * An underground railway system is keeping track of customer travel times between different stations.
 * They are using this data to calculate the average time it takes to travel from one station to another.
 * -
 * Implement the UndergroundSystem class:
 * * void checkIn(int id, string stationName, int t)
 * - A customer with a card ID equal to id, checks in at the station stationName at time t.
 * - A customer can only be checked into one place at a time.
 * -
 * * void checkOut(int id, string stationName, int t)
 * - A customer with a card ID equal to id, checks out from the station stationName at time t.
 * -
 * * double getAverageTime(string startStation, string endStation)
 * - Returns the average time it takes to travel from startStation to endStation.
 * - The average time is computed from all the previous traveling times from startStation to endStation that
 * happened directly, meaning a check in at startStation followed by a check out from endStation.
 * - The time it takes to travel from startStation to endStation may be different from the time it takes to travel
 * from endStation to startStation.
 * - There will be at least one customer that has traveled from startStation to endStation before getAverageTime is
 * called.
 * -
 * You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1
 * then checks out at time t2, then t1 < t2. All events happen in chronological order.
 * -
 * Tested on Leetcode:
 * Runtime: 85 ms, faster than 95.16% of Java online submissions for Design Underground System.
 * Memory Usage: 51.6 MB, less than 90.04% of Java online submissions for Design Underground System.
 * ***
 * https://leetcode.com/problems/design-underground-system/
 */
class UndergroundSystem {
    private final Map<Integer, Event> users;
    private final Map<String, Map<String, Average>> averages;

    public UndergroundSystem() {
        users = new HashMap<>();
        averages = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (users.containsKey(id)) return;

        users.put(id, new Event(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (!users.containsKey(id)) return;

        final Event arrivalEvent = users.remove(id);
        int tripLength = t - arrivalEvent.time();
        updateAverages(arrivalEvent.stationName(), stationName, tripLength);
    }

    public double getAverageTime(String startStation, String endStation) {
        return averages
                .getOrDefault(startStation, new HashMap<>())
                .getOrDefault(endStation, new Average())
                .get();
    }

    private void updateAverages(String firstStationName, String secondStationName, int tripLength) {
        if (!averages.containsKey(firstStationName)) {
            averages.put(firstStationName, new HashMap<>());
        }

        final Map<String, Average> startStations = averages.get(firstStationName);

        if (!startStations.containsKey(secondStationName)) {
            startStations.put(secondStationName, new Average());
        }

        startStations.get(secondStationName).addRecord(tripLength);
    }
}

record Event(String stationName, int time) { }

// // or
//class Event {
//    private final String stationName;
//    private final int time;
//
//    public Event(String stationName, int time) {
//        this.stationName = stationName;
//        this.time = time;
//    }
//
//    public String getStationName() {
//        return stationName;
//    }
//
//    public int getTime() {
//        return time;
//    }
//}

class Average {
    private long total;
    private long count;

    public void addRecord(int tripLength) {
        ++count;
        total += tripLength;
    }

    public double get() {
        if (count == 0) return 0;
        return total * 1.0 / count;
    }
}
