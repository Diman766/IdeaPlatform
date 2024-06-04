package ru.diman.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
   private List<Flight> tickets;


   @Override
   public String toString() {
      return new ToStringBuilder(this)
              .append("tickets", tickets)
              .toString();
   }
}
