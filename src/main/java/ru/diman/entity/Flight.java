package ru.diman.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private String origin;
    private String origin_name;
    private String destination;
    private String destination_name;
    private String departure_date;
    private String departure_time;
    private String arrival_date;
    private String arrival_time;
    private String carrier;
    private Integer stops;
    private Integer price;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("origin", origin)
                .append("origin_name", origin_name)
                .append("destination", destination)
                .append("destination_name", destination_name)
                .append("departure_date", departure_date)
                .append("departure_time", departure_time)
                .append("arrival_date", arrival_date)
                .append("arrival_time", arrival_time)
                .append("carrier", carrier)
                .append("stops", stops)
                .append("price", price)
                .toString();
    }
}
