package org.mrstm.ThreadCommunication;

public class Consumer implements Runnable{
    private StateResource stateResource;

    public Consumer(StateResource stateResource){
        this.stateResource = stateResource;
    }

    @Override
    public synchronized void run() {
        while(!stateResource.isHasCount()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Consuming : " + stateResource.getCount());
        stateResource.setHasCount(false);
        notify();
    }
}
