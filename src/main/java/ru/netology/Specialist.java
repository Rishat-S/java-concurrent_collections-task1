package ru.netology;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Specialist implements Runnable {
    public static final int CALL_IS_IN_PROGRESS = 2;
    private boolean isRun;
    private final Queue<Call> calls;

    public Specialist(Queue<Call> calls) {
        this.calls = calls;
        isRun = true;
    }

    public void stopThread() {
        isRun = false;
    }

    @Override
    public void run() {
        while (isRun || !calls.isEmpty()) {
            Call call = calls.poll();
            if (call == null) {
                continue;
            }
            System.out.println(Thread.currentThread().getName() + " handles the call - " + call);
            try {
                TimeUnit.SECONDS.sleep(CALL_IS_IN_PROGRESS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
