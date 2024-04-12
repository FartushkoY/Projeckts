package de.telran.homework_Test.WaitingList;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WaitingList {
    public static void main(String[] args) {
        Map<Integer, String> slotMap = new TreeMap<>();
        slotMap.put(1, "9-00");
        slotMap.put(2, "9-30");
        slotMap.put(3, "10-00");
        slotMap.put(4, "10-30");
        slotMap.put(5, "11-00");
        slotMap.put(6, "11-30");
        slotMap.put(7, "12-00");
        slotMap.put(8, "12-30");

        Map<String, String> patientMap = new HashMap<>();
        patientMap.put("11-00", "Ivanenko");
        patientMap.put("9-00", "Kovalenko");
        patientMap.put("12-30", "Shinkarenko");
        patientMap.put("11-30", "Petrenko");
        patientMap.put("10-00", "Gaidenko");
        patientMap.put("9-30", "Skorik");

        getPatientsQueue(slotMap, patientMap);

    }

    private static void getPatientsQueue(Map<Integer, String> slotMap, Map<String, String> patientMap) {
        Integer slot = slotMap.keySet().iterator().next();
        while (slot != slotMap.size() + 1) {
            Integer nextSlot = slot;
            String time = slotMap.get(nextSlot);
            String patient = patientMap.get(slotMap.get(nextSlot));
            if (patientMap.containsKey(slotMap.get(nextSlot))) {
                System.out.println(time + "  " + patient);
            }
            slot++;
        }
    }
}

