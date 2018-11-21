package resources;

import model.Movie;
import persistence.MovieRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies")
public class MovieService {

    public MovieService() {}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Movie getMovie(@PathParam("id") int id) {
        if (MovieRepository.getById(id).isPresent()) {
            return MovieRepository.getById(id).get();
        } else {
            return null;
        }
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getMovies() {
        return MovieRepository.getAll();
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.TEXT_PLAIN)
    public String removeMovie(@PathParam("id") int id) {
        MovieRepository.remove(id);
        return "Movie removed.";
    }

    @POST
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addMovie(Movie movie) {
        return MovieRepository.save(movie);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateMovie(Movie movie, @PathParam("id") int id){
        return MovieRepository.update(movie, id);
    }
}
