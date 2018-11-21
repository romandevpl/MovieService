import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.FilterMovieService;
import resources.MovieService;

public class MovieApplication extends Application<MovieConfig> {

    public static void main(String[] args) throws Exception {
        new MovieApplication().run(args);
    }

    @Override
    public void run(MovieConfig config, Environment env) {
        final MovieService movieService = new MovieService();
        final FilterMovieService filterService = new FilterMovieService();
        env.jersey().register(movieService);
        env.jersey().register(filterService);

        env.healthChecks().register("template",
                new MovieCheck(config.getVersion()));
    }
}