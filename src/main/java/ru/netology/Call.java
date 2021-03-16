package ru.netology;

public class Call {
    private static int count = 0;
    private final int id;

    public Call() {
        id = ++count;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                '}';
    }
}
