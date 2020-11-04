package com.mynotes.samples.softleaks.pubsub;

public class MainPubSub {

    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        GenerateOrders generateOrders = new GenerateOrders(orderManager);
        ProcessOrders processOrders = new ProcessOrders(orderManager);

        //Generator
        Thread t1 = new Thread(generateOrders);
        t1.start();

        //Processor
        Thread t2 = new Thread(processOrders);
        t2.start();

        //main thread
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orderManager.displayListSize();
            System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
        }
    }

}
