package ru.netology.javaqa.services;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Player " + name + " not found");
    }
}
