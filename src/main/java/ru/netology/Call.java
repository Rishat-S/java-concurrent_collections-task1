package ru.netology;

import java.util.UUID;

public class Call {
    private final UUID id;

    public Call() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                '}';
    }
}
