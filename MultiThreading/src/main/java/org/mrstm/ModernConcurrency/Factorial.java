package org.mrstm.ModernConcurrency;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    private final int n;

    public Factorial(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        Thread.sleep(2000);
        int ans = 1;
        for(int i = 1; i <= n; i++){
            ans *= i;
        }
        System.out.println("Current answer : " + ans);
        return ans;
    }
}
