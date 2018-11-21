package resources;

import com.codahale.metrics.annotation.Timed;
import model.Movie;
import persistence.MovieRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movie")
public class MovieService {

    public MovieService() {}

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getMovie(@PathParam("id") int id) {
        if (MovieRepository.getById(id).isPresent()) {
            return MovieRepository.getById(id).get();
        } else {
            return null;
        }
    }

    @DELETE
    @Path("/remove/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public String removeMovie(@PathParam("id") int id) {
        MovieRepository.remove(id);
        return "Movie removed.";
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies() {
        return MovieRepository.getAll();
    }

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addMovie(Movie movie) {
        return MovieRepository.save(movie);
    }
}
