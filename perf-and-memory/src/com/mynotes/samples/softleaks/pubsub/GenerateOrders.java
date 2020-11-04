package com.mynotes.samples.softleaks.pubsub;

import java.util.UUID;

public class GenerateOrders implements Runnable {

    private OrderManager orderManager;

    public GenerateOrders(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //To Slow things down
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
            orderManager.pushOrder(new Order(UUID.randomUUID().toString()));
        }
    }
}
