package ru.diman.logger;

import java.util.Map;

public class Logger {

    public void showShortWays (Map<String, Integer> carrierTicket) {

        for (Map.Entry entry: carrierTicket.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue() + " мин.");
        }
    }

    public void showMessage (String message) {
        System.out.println(message);
    }

    public void showDiffValue (int value) {
        System.out.println("Разницу между средней ценой и медианой: " + value);
    }
}
