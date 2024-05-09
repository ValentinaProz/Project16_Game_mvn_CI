package ru.netology.javaqa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void shouldFirstPlayerWin() {
        Game game = new Game();
        Player hello32 = new Player(147, "Ира", 84);
        Player tomorrow14 = new Player(15, "Игорь", 77);

        game.register(hello32);
        game.register(tomorrow14);

        int expected = 1;
        int actual = game.round("Ира", "Игорь");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondPlayerWin() {
        Game game = new Game();
        Player tomorrow14 = new Player(15, "Игорь", 77);
        Player hello32 = new Player(147, "Ира", 84);

        game.register(tomorrow14);
        game.register(hello32);

        int expected = 2;
        int actual = game.round("Игорь", "Ира");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldHaveEqualStrength() {
        Game game = new Game();
        Player tomorrow14 = new Player(15, "Игорь", 77);
        Player hello32 = new Player(147, "Ира", 77);

        game.register(tomorrow14);
        game.register(hello32);

        int expected = 0;
        int actual = game.round("Игорь", "Ира");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstPlayerNotExist() {
        Game game = new Game();
        Player tomorrow14 = new Player(15, "Игорь", 77);

        game.register(tomorrow14);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Андрей", "Игорь");
        });
    }

    @Test
    public void shouldSecondPlayerNotExist() {
        Game game = new Game();
        Player tomorrow14 = new Player(15, "Игорь", 77);

        game.register(tomorrow14);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Андрей");
        });
    }
}