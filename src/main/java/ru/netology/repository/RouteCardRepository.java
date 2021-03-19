package ru.netology.repository;

import ru.netology.domain.RouteCard;

public class RouteCardRepository {
    public RouteCard[] items = new RouteCard[0];

    public void save(RouteCard item) {
        int length = items.length + 1;
        RouteCard[] tmp = new RouteCard[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public RouteCard[] findAll() {
        return items;
    }

    public RouteCard findById(int id) {
        for (RouteCard item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void removeById(int id) {
        int length = items.length - 1;
        RouteCard[] tmp = new RouteCard[length];
        int index = 0;
        for (RouteCard item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}