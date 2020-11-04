package com.mynotes.samples.softleaks.pubsub;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderManager {

    private List<Order> orders = new ArrayList<>();

    public void pushOrder(Order order){
        synchronized (orders){
            orders.add(order);
        }
    }

    public Optional<Order> pollOrder(){
        synchronized (orders){
            if(orders.size()>0){
                return Optional.of(orders.remove(0)); // Fix is to use remove(0). // Error .get(0)
            }
        }
        return Optional.empty();
    }

    public void displayListSize(){
        System.out.println("Orders in list :"+ orders.size());
    }



}
