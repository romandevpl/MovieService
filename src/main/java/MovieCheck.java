import com.codahale.metrics.health.HealthCheck;
import persistence.MovieRepository;

public class MovieCheck extends HealthCheck {

    private final String version;

    public MovieCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (MovieRepository.getCount() == 0) {
            return Result.unhealthy("No movies in DB! Version: " +
                    this.version);
        }
        return Result.healthy("OK with version: " + this.version +
                ". Movies count: " + MovieRepository.getCount());
    }
}
