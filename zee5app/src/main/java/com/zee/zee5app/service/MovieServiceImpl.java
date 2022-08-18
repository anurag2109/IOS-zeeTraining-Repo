package com.zee.zee5app.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.repo.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository; // Interface ref = class object()
	
	@Override
	public Movie insertMovie(Movie movie) throws UnableToGenerateIdException, FileNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

	@Override
	public Optional<Movie> updateMovie(String movieId, Movie movie) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.save(movie));
	}

	@Override
	public Optional<Movie> getMovieByMovieId(String movieId) throws InvalidNameException, InvalidIdException {
		// TODO Auto-generated method stub
		return movieRepository.findById(movieId);
	}

	@Override
	public Optional<List<Movie>> getAllMovies() throws InvalidNameException, InvalidIdException {
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByGenre(String genre) throws InvalidNameException, InvalidIdException, NoDataFoundException {
		return Optional.ofNullable(movieRepository.findAllByGenre(genre));
	}

	@Override
	public Optional<List<Movie>> getAllMoviesByName(String movieName) throws InvalidNameException, InvalidIdException, NoDataFoundException {
		return Optional.ofNullable(movieRepository.findAllByMovieName(movieName));
	}

	@Override
	public String deleteMovieByMovieId(String movieId) throws NoDataFoundException {
		return null;
	}

	@Override
	public Optional<List<Movie>> findByOrderByMovieNameDsc() throws InvalidNameException, InvalidIdException {
		return null;
	}

}
