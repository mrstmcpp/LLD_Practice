package org.mrstm.ThreadStatePractice;

public class MyThread extends Thread{
    private Thread mainThread;
    public MyThread(Thread thread){
        this.mainThread = thread;
    }

    @Override
    public void run() {
//        System.out.println("Currently running MyThread "+ MyThread.currentThread().getName() + " " + MyThread.currentThread().getState());
        try {

            Thread.sleep(1000);
            System.out.println("Currently running MyThread "+ Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            for(int i = 0; i < 7; i++){
                System.out.println(i);
                System.out.println("Thread "+ mainThread.getName() + " " + mainThread.getState());

                Thread.sleep(1000);
            }
            System.out.println("Finished running "+ Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
