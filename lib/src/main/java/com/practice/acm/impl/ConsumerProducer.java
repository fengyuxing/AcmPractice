package com.practice.acm.impl;

import java.util.Stack;

public class ConsumerProducer {

    public static void main(String[] args) {
        final Queue queue=new FIFOQueue();
        for (int i = 0; i < 5; i++) {
            final Producer producer=new Producer(queue);
            final int finalI = i;
            new Thread(new Runnable() {
                int count;
                @Override
                public void run() {
                    while (true){
                        producer.offer(finalI+"号生产者"+count++);
                        try {
                            Thread.yield();
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        for (int i = 0; i < 2; i++) {
            final Consumer consumer=new Consumer(queue);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            consumer.consume();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
    static class Consumer{
        public Consumer(Queue queue) {
            this.queue = queue;
        }

        Queue queue;
        void consume() throws InterruptedException {
            Object obj=queue.remove();
            System.out.println("消耗:"+obj);
        }
    }

    static class Producer{
        public Producer(Queue queue) {
            this.queue = queue;
        }

        Queue queue;
        void offer(Object obj){
            queue.add(obj);
            System.out.println("生产:"+obj);
        }
    }

     interface Queue{
        void add(Object obj);
         Object remove() throws InterruptedException;
    }
    /**
     * 无限容量，先进先出
     */
    static class FIFOQueue implements  Queue{
        Stack stack=new Stack();


        @Override
        public synchronized void add(Object obj) {
            stack.add(obj);
            notifyAll();
        }

        @Override
        public synchronized Object remove() throws InterruptedException {
            if (stack.isEmpty()){
                wait();
            }
            return stack.pop();
        }
    }

}
