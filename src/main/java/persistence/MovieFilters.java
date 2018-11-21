package persistence;

import model.Movie;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieFilters {

    public static Predicate<Movie> releasedIn(int releaseYear) {
        return m -> m.getReleaseYear() == releaseYear;
    }

    public static Predicate<Movie> durationTime(int duration) {
        return m -> m.getDuration() == duration;
    }

    public static Predicate<Movie> filterByActor(String actor) {
        return m -> m.getActors().contains(actor);
    }

    public static List<Movie> filterMovies(List<Movie> movies, Predicate<Movie> predicate) {
        return movies.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
