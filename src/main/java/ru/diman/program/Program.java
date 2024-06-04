package ru.diman.program;

import ru.diman.entity.Flight;
import ru.diman.entity.Tickets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Program {


    public List<Flight> sortByWay(Tickets tickets, String originName, String destinationName) {

        List<Flight> sortTickets = new ArrayList<>();
        for (Flight flight : tickets.getTickets()) {
            if (flight.getOrigin_name().equals(originName) && flight.getDestination_name().equals(destinationName)) {
                sortTickets.add(flight);
            }
        }
        return sortTickets;
    }

    public int findDifferenceValue(int fistValue, int secondValue) {

        return Math.abs(fistValue - secondValue);
    }

    public int findAverage(List<Flight> sortFlight) {

        int priceSum = 0;
        int numberFlights = 0;

        for (Flight flight:sortFlight) {
            priceSum = priceSum + flight.getPrice();
            numberFlights++;
        }
        return (priceSum / numberFlights);
    }

    public int findMedian(List<Flight> sortFlight) {

        ArrayList<Integer> values = new ArrayList<>();

        for (Flight flight:sortFlight) {
            values.add(flight.getPrice());
        }

        Collections.sort(values);

        if (values.size() % 2 != 0) {
            return (values.size() / 2);
        } else {
            int b = values.get(values.size() / 2 - 1);
            int c = values.get((values.size() / 2));
            return (b + c) / 2;
        }
    }

    public HashMap<String, Integer> findShortWay(List<Flight> sortFlight) {

        HashMap<String, Integer> carrierTicket = new HashMap<>();

        for (Flight flight : sortFlight) {
                if (!carrierTicket.containsKey(flight.getCarrier())) {
                    carrierTicket.put(flight.getCarrier(), diff(flight));
                } else {
                    Integer diff = diff(flight);
                    Integer diff1 = carrierTicket.get(flight.getCarrier());
                    if (diff < diff1) {
                        carrierTicket.put(flight.getCarrier(), diff);
                    }
                }
        }
        return carrierTicket;
    }


    private LocalDateTime createDate(String date, String time) {
        String date1 = date + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        return LocalDateTime.parse(date1, formatter);
    }

    public Integer diff(Flight flight) {
        LocalDateTime departureDateTime = createDate(flight.getDeparture_date(), flight.getDeparture_time());
        LocalDateTime arrivalDateTime = createDate(flight.getArrival_date(), flight.getArrival_time());
        return Math.toIntExact(ChronoUnit.MINUTES.between(departureDateTime, arrivalDateTime));
    }
}
