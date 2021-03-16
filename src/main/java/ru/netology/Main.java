package ru.netology;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        Queue<Call> calls = new ConcurrentLinkedQueue<>();
        Specialist spec1 = new Specialist(calls);
        Specialist spec2 = new Specialist(calls);
        Specialist spec3 = new Specialist(calls);

        Thread pbx = new Thread(new PBX(calls), "PBX");
        Thread specialist1 = new Thread(spec1, "Specialist 1");
        Thread specialist2 = new Thread(spec2, "Specialist 2");
        Thread specialist3 = new Thread(spec3, "Specialist 3");

        pbx.start();
        specialist1.start();
        specialist2.start();
        specialist3.start();

        while (pbx.isAlive() && calls.isEmpty());

        System.out.println(calls.size());

        spec1.stopThread();
        spec2.stopThread();
        spec3.stopThread();
    }
}