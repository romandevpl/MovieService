package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Movie {
    private int id;
    private String name;
    private int releaseYear;
    private int duration;
    private Genre genre;
    private List<String> directors;
    private List<String> writers;
    private List<String> actors;

    private static final AtomicInteger count = new AtomicInteger(0);

    public Movie(){
        this.id = count.incrementAndGet();
    }

    public Movie(String name, int releaseYear, int duration, Genre genre,
                 List<String> directors, List<String> writers, List<String> actors) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genre = genre;
        this.directors = directors;
        this.writers = writers;
        this.actors = actors;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public int getReleaseYear() {
        return releaseYear;
    }

    @JsonProperty
    public int getDuration() {
        return duration;
    }

    @JsonProperty
    public Genre getGenre() {
        return genre;
    }

    @JsonProperty
    public List<String> getDirectors() {
        return directors;
    }

    @JsonProperty
    public List<String> getWriters() {
        return writers;
    }

    @JsonProperty
    public List<String> getActors() {
        return actors;
    }
}
