package ru.netology.domain;

import java.util.Arrays;

public class PosterManager {
    private String[] movies = new String[0];
    private int number; // количество фильмов

    public PosterManager(int number) { // конструктор с выбором количества
        this.number = number;
    }

    public PosterManager() { // конструктор с количеством по умолчанию
        this.number = 5;
    }

    public void addMovie(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (movies.length < number) {
            resultLength = movies.length;
        } else {
            resultLength = number;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }
}

