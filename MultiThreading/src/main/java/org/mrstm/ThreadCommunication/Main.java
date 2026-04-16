package org.mrstm.ThreadCommunication;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StateResource stateResource = new StateResource(false);

        Producer producer = new Producer(stateResource);
        Consumer consumer = new Consumer(stateResource);

        for(int i = 0; i < 5; i++){
            producer.run();
            Thread.sleep(1000);
            consumer.run();
        }
    }
}
