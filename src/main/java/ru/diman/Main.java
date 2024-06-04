package ru.diman;

import ru.diman.entity.Flight;
import ru.diman.entity.Tickets;
import ru.diman.logger.Logger;
import ru.diman.program.Program;
import ru.diman.repository.Repository;

import java.util.HashMap;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        final String ORIGINNAME = "Владивосток";
        final String DESTINATIONNAME = "Тель-Авив";


        Logger logger = new Logger();
        Tickets tickets = new Repository().readTickets();

        if (tickets == null) {
            logger.showMessage("Ошибка чтения файла !");
        } else {

            Program program = new Program();
            List<Flight> sortTickets;

            sortTickets = program.sortByWay(tickets, ORIGINNAME, DESTINATIONNAME);

            HashMap<String, Integer> carrierTicket = program.findShortWay(sortTickets);
            int differentValue = program.findDifferenceValue(program.findAverage(sortTickets), program.findMedian(sortTickets));

            logger.showShortWays(carrierTicket);
            logger.showDiffValue(differentValue);

        }


    }
}
