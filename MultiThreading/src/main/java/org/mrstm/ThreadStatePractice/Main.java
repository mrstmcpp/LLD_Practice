package org.mrstm.ThreadStatePractice;

import static java.lang.Thread.currentThread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = currentThread();
        MyThread t1 = new MyThread(mainThread);
        t1.setName("MYTHREAD-0");
        t1.start();
        System.out.println("Current thread name: " + currentThread().getName() + " " + currentThread().getState());
        for(int i = 0; i < 5; i++){
            if(i == 3){
                t1.join(); // main thread will wait till t1 finishes
            }
            System.out.println("Printing main thread name: " + currentThread().getName() + " " + currentThread().getState());
        }
//        System.out.println("Current thread name: " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        System.out.println("last : Cuurent thread name: " + currentThread().getName() + " " + currentThread().getState());
    }
}
