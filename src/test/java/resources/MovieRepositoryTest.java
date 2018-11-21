package resources;

import model.Genre;
import model.Movie;
import persistence.MovieRepository;


class MovieRepositoryTest {
        MovieRepository testedService = new MovieRepository();

//        @Test
        public void addingMovie(){
                Movie testMovie = new Movie("The Hobbit: An Unexpected Journey", 2012, 169, Genre.FANTASY, null, null, null);
                //TODO : finish test
        }

}