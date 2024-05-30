package com.practice.acm.impl;

public class MultiThreadPrint {
    public static void main(String[] args) {
        new PrintThread(1).start();
        new PrintThread(2).start();
        new PrintThread(3).start();
    }

    static class PrintThread extends Thread {
        static Integer totalLock = 1;
        int startNum;
        int increaseNum = 3;

        public PrintThread(int startNum) {
            super("t"+startNum );
            this.startNum = startNum;
        }

        @Override
        public void run() {
            while (totalLock < 100) {
                synchronized (PrintThread.class) {
                    while (totalLock % increaseNum != startNum % increaseNum) {//不满足打印数字的条件
                        try {
                            PrintThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(getName() + ":" + totalLock);
                synchronized (PrintThread.class) {
                    totalLock++;
                    PrintThread.class.notifyAll();
                }
            }
        }
    }
}
