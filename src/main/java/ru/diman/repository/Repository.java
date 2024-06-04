package ru.diman.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.diman.entity.Tickets;

import java.io.File;
import java.io.IOException;

public class Repository {

    public Tickets readTickets () {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("tickets.json");
            return objectMapper.readValue(file, Tickets.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
