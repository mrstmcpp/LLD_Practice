package org.mrstm.ModernConcurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModernConcurrency {
    private final int numberOfThreads = 3;
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
    Factorial factorial1 = new Factorial(10);
    Factorial factorial2 = new Factorial(12);
    Factorial factorial3 = new Factorial(15);

    public void hello() throws Exception {
        executorService.submit(factorial1); // running with ThreadPool
        executorService.submit(factorial2);
        executorService.submit(factorial3);
//        factorial1.call(); // running normally with single thread JVM providing
//        factorial2.call();
//        factorial3.call();
        executorService.shutdown();
        executorService.close();
    }
}
