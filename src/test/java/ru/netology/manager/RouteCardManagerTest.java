package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.RouteCard;
import ru.netology.repository.RouteCardRepository;

import static org.junit.jupiter.api.Assertions.*;

class RouteCardManagerTest {
    RouteCard card1 = new RouteCard(1, 100, "200", "201", 200);
    RouteCard card2 = new RouteCard(2, 101, "200", "202", 200);
    RouteCard card3 = new RouteCard(3, 152, "203", "201", 200);
    RouteCard card4 = new RouteCard(4, 103, "201", "200", 200);
    RouteCard card5 = new RouteCard(5, 174, "200", "201", 200);
    RouteCard card6 = new RouteCard(6, 125, "201", "203", 200);
    RouteCard card7 = new RouteCard(7, 400, "200", "201", 200);
    RouteCard card8 = new RouteCard(8, 307, "200", "201", 200);
    RouteCard card9 = new RouteCard(9, 99, "200", "201", 200);
    RouteCardRepository repository = new RouteCardRepository();
    RouteCardManager manager = new RouteCardManager(repository);

    @Test
    void shouldFindAllFromToAndSorted(){
        manager.addRouteCard(card1);
        manager.addRouteCard(card2);
        manager.addRouteCard(card3);
        manager.addRouteCard(card4);
        manager.addRouteCard(card5);
        manager.addRouteCard(card6);
        manager.addRouteCard(card7);
        manager.addRouteCard(card8);
        manager.addRouteCard(card9);
        RouteCard[] expected = new RouteCard[] {card9, card1, card5, card8, card7};
        RouteCard[] actual = manager.findAll("200", "201");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotCardNotResult(){
        RouteCard[] expected = new RouteCard[0];
        RouteCard[] actual = manager.findAll("200", "203");
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldOneCardNoteResult(){
        manager.addRouteCard(card1);
        RouteCard[] expected = new RouteCard[0];
        RouteCard[] actual = manager.findAll("204", "205");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldOneCardOneResult(){
        manager.addRouteCard(card6);
        RouteCard[] expected = new RouteCard[]{card6};
        RouteCard[] actual = manager.findAll("201", "203");
        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldSixCardOneResult(){
        manager.addRouteCard(card1);
        manager.addRouteCard(card2);
        manager.addRouteCard(card3);
        manager.addRouteCard(card4);
        manager.addRouteCard(card5);
        manager.addRouteCard(card6);
        RouteCard[] expected = new RouteCard[]{card6};
        RouteCard[] actual = manager.findAll("201", "203");
        assertArrayEquals(expected, actual);

    }


}