package org.mrstm.ThreadCommunication;

public class Producer implements Runnable{
    private StateResource stateResource;
    public Producer(StateResource stateResource){
        this.stateResource = stateResource;
    }


    @Override
    public synchronized void run() {
        while(stateResource.isHasCount()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        //produce
        stateResource.setCount(stateResource.getCount() + 1);
        stateResource.setHasCount(true);
        System.out.println("Produced : " + stateResource.getCount());
        notify();
    }
}
