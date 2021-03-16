package ru.netology;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PBX implements Runnable {
    public static final int PAUSE_IN_CALLS = 1;
    private static final int CALLS_NUM = 60;
    public static final int NUM_OF_CALLS_WAVES = 2;
    private final Queue<Call> calls;

    public PBX(Queue<Call> calls) {
        this.calls = calls;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_OF_CALLS_WAVES; i++) {
            System.out.println(Thread.currentThread().getName() + ": Calls from subscribers were received");
            for (int j = 0; j < CALLS_NUM; j++) {
                calls.offer(new Call());
            }
            try {
                TimeUnit.SECONDS.sleep(PAUSE_IN_CALLS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
