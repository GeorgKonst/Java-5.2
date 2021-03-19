package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.RouteCard;
import ru.netology.repository.RouteCardRepository;

import static org.junit.jupiter.api.Assertions.*;

class RouteCardManagerTest {
    RouteCard card1 = new RouteCard(1, 200, "200", "201", 200);
    RouteCard card2 = new RouteCard(2, 5, "200", "202", 200);
    RouteCard card3 = new RouteCard(3, 100, "203", "201", 200);
    RouteCard card4 = new RouteCard(4, 7, "201", "200", 200);
    RouteCard card5 = new RouteCard(5, 100, "200", "201", 200);
    RouteCardRepository repository = new RouteCardRepository();
    RouteCardManager manager = new RouteCardManager(repository);

    @BeforeEach
    void setup(){
        manager.addRouteCard(card1);
        manager.addRouteCard(card2);
        manager.addRouteCard(card3);
        manager.addRouteCard(card4);
        manager.addRouteCard(card5);
    }

    @Test
    void shouldFindAllFromToAndSorted(){
        RouteCard[] expected = new RouteCard[] {card5, card1};
        RouteCard[] actual = manager.findAll("200", "201");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindAllFromToNotResult(){
        RouteCard[] expected = new RouteCard[0];
        RouteCard[] actual = manager.findAll("200", "203");
        assertArrayEquals(expected, actual);
    }


}