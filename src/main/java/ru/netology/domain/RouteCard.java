package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteCard implements Comparable<RouteCard> {
    private int id;
    private int price;
    private String originCode;
    private String destinationCode;
    private int timeTravel;

    @Override
    public int compareTo(RouteCard o) {
        return price - o.price;
    }
}
