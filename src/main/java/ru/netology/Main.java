package ru.netology;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Call> calls = new ConcurrentLinkedQueue<>();
        Specialist spec1 = new Specialist(calls);
        Specialist spec2 = new Specialist(calls);
        Specialist spec3 = new Specialist(calls);
        Specialist spec4 = new Specialist(calls);
        Specialist spec5 = new Specialist(calls);

        Thread pbx = new Thread(new PBX(calls), "PBX");

        Thread specialist1 = new Thread(spec1, "Specialist 1");
        Thread specialist2 = new Thread(spec2, "Specialist 2");
        Thread specialist3 = new Thread(spec3, "Specialist 3");
        Thread specialist4 = new Thread(spec3, "Specialist 4");
        Thread specialist5 = new Thread(spec3, "Specialist 5");

        pbx.start();
        specialist1.start();
        specialist2.start();
        specialist3.start();
        specialist4.start();
        specialist5.start();

        while (pbx.isAlive()) ;

        spec1.stopThread();
        spec2.stopThread();
        spec3.stopThread();
        spec4.stopThread();
        spec5.stopThread();
    }
}