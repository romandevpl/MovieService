package persistence;

import model.Genre;
import model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static persistence.MovieFilters.*;

public class MovieRepository {
    private static List<Movie> movies = new ArrayList<>();

    static {
        movies.add(new Movie("Avatar", 2009, 162, Genre.ADVENTURE, null, null, Arrays.asList("Sam Worthington")));
        movies.add(new Movie("Shrek", 2001, 90, Genre.ANIMATION, null, null, Arrays.asList("Eddie Murphy")));
        movies.add(new Movie("Matrix", 1999, 136, Genre.ACTION, null, null, Arrays.asList("Keanu Reaves")));
        movies.add(new Movie("Spiderman", 2002, 121, Genre.ACTION, null, null, Arrays.asList("Tobey Maguire")));
    }

    public static Optional<Movie> getById(int id) {
        return movies.stream().filter(m -> m.getId() == id).findFirst();
    }

    public static List<Movie> getByReleaseYear(int year) {
        return filterMovies(movies, releasedIn(year));
    }

    public static List<Movie> getByDuration(int duration) {
        return filterMovies(movies, durationTime(duration));
    }

    public static List<Movie> getByActor(String actor) {
        return filterMovies(movies, filterByActor(actor));
    }


    public static List<Movie> getAll() {
        return movies;
    }

    public static int getCount() {
        return movies.size();
    }

    public static void remove(int index) {
        if (!movies.isEmpty() && getById(index).isPresent()) {
            movies.remove(getById(index).get());
        }
    }

    public static String save(Movie movie) {
        String result;
//        if (movies.get(movie.getId()) != null) {
//            result = "Updated Movie with id=" + movie.getId();
//        } else {
//            result = "Added Movie with id=" + movie.getId();
//        }
        movies.add(movie);
        return "Done";
    }
}
