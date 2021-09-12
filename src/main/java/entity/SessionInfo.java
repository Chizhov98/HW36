package entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SessionInfo {
    @Getter
    private static int counter = 0;
    private static List<Visit> lastVisits = new ArrayList<>();
    private static int maxListSize = 3;

    public static void countIncrement() {
        counter++;
    }

    public static void addNewVisit(Visit visit) {
        if (lastVisits.size() < maxListSize) {
            lastVisits.add(visit);
        } else {
            lastVisits.remove(0);
            lastVisits.add(visit);
            lastVisits.sort(Comparator.comparing(Visit::getDate));
        }
    }

    public static List<Visit> getVisitsList() {
        List<Visit> result = new ArrayList<>();
        for (Visit elem : lastVisits) {
            result.add(new Visit(elem));
        }
        return result;
    }
}
