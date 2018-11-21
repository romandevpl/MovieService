package resources;

import model.Movie;
import persistence.MovieRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies/filter")
public class FilterMovieService {

    public FilterMovieService(){}

    @POST
    @Path("/releaseYear")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> filterMovieByYear(int year) {
        return MovieRepository.getByReleaseYear(year);
    }

    @POST
    @Path("/duration")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> filteMovierByDuration(int duration) {
        return MovieRepository.getByDuration(duration);
    }

    @POST
    @Path("/actor")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> filterMovieByActor(String actor) {
        return MovieRepository.getByActor(actor);
    }
}
