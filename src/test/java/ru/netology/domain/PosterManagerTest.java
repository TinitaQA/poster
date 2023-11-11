package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();

    @BeforeEach
    public void add() {
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
    }

    @Test
    public void shouldShowAllMoviesDefault() {

        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентльмены", "Человек-невидимка"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllMoviesNumber() {
        PosterManager manager = new PosterManager(7);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой тур");
        manager.addMovie("Номер один");


        String[] expected = {"Бладшот", "Вперёд", "Отель Белград", "Джентльмены", "Человек-невидимка", "Тролли.Мировой тур", "Номер один"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastMovieDefault() {

        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентльмены", "Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastMovieBelowLimit() {

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastMovieAfterLimit() {

        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли.Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли.Мировой тур", "Человек-невидимка", "Джентльмены", "Отель Белград"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}

