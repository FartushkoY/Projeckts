package de.telran.practice_lesson_11;

import java.util.Comparator;

public class Transport implements Comparable<Transport>{
    private String name;
    private int priorityLevel;
    private TransportTypes type;

    public Transport(String name, int priorityLevel, TransportTypes type) {
        this.name = name;
        this.priorityLevel = priorityLevel;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", type=" + type +
                '}';
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public TransportTypes getType() {
        return type;
    }

    public void setType(TransportTypes type) {
        this.type = type;
    }

    @Override
    public int compareTo(Transport o) {
        return Integer.compare(this.priorityLevel, o.priorityLevel);
    }

    public static class comparatorRushHour implements Comparator<Transport> {

        @Override
        public int compare(Transport o1, Transport o2) {
            if (o1.getType().equals(TransportTypes.AUTO) || o1.getType().equals(TransportTypes.SERVICE)) {
                o1.setPriorityLevel(3);
            }
            if (o2.getType().equals(TransportTypes.AUTO) || o2.getType().equals(TransportTypes.SERVICE)) {
                o2.setPriorityLevel(3);
            }
            return Integer.compare(o1.getPriorityLevel(), o2.getPriorityLevel());
        }
    }

    public static class comparatorAlarm implements Comparator<Transport> {

        @Override
        public int compare(Transport o1, Transport o2) {
            if (o1.getType().equals(TransportTypes.SERVICE)) {
                o1.setPriorityLevel(1);
            }
            if (o2.getType().equals(TransportTypes.SERVICE)) {
                o2.setPriorityLevel(1);
            }
            if (o1.getType().equals(TransportTypes.AMBULANCE)) {
                o1.setPriorityLevel(2);
            }
            if (o2.getType().equals(TransportTypes.AMBULANCE)) {
                o2.setPriorityLevel(2);
            }
            if (o1.getType().equals(TransportTypes.AUTO) || o1.getType().equals(TransportTypes.BUS)) {
                o1.setPriorityLevel(3);
            }
            if (o2.getType().equals(TransportTypes.AUTO) || o2.getType().equals(TransportTypes.BUS)) {
                o2.setPriorityLevel(3);
            }
            return Integer.compare(o1.getPriorityLevel(), o2.getPriorityLevel());
        }
    }



}
