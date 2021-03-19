package ru.netology.manager;

import ru.netology.domain.RouteCard;
import ru.netology.repository.RouteCardRepository;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RouteCardManager {
    private RouteCardRepository repository;

    public RouteCardManager(RouteCardRepository repository) {
        this.repository = repository;
    }

    public void addRouteCard(RouteCard item) {
        repository.save(item);
    }

    public RouteCard[] findAll(String from, String to){
       RouteCard[] result = new RouteCard[0];
       for (RouteCard item : repository.findAll()){
           if (item.getOriginCode().equalsIgnoreCase(from) && item.getDestinationCode().equalsIgnoreCase(to)){
               RouteCard[] tmp = new RouteCard[result.length +1];
               System.arraycopy(result, 0, tmp, 0, result.length);
               tmp[tmp.length-1] = item;
               result = tmp;

           }
       }

       Arrays.sort(result);
       return result;
    }



}