package com.mynotes.samples.softleaks.pubsub;

import java.util.Optional;

public class ProcessOrders implements Runnable {

    private OrderManager orderManager;

    public ProcessOrders(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Order> order = orderManager.pollOrder();
            if (!order.isPresent()) {
                // Nothing in list, wait
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                //Do work
                //System.out.println(order.get().getId());
            }
        }
    }
}
