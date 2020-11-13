package com.cd.dtstanley.lookify.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.dtstanley.lookify.Models.Song;

	@Repository
	public interface LookifyRepository extends CrudRepository<Song, Long>{ //identify object and type of primary key in diamond
	    // this method retrieves all the songs from the database
		List<Song> findAll();
		//this method finds a song by artist
		List<Song> findByArtistContaining(String artist);
		//this method finds the top 10 songs by rating
		List<Song> findTop10ByOrderByRatingDesc();
	    // this method find a song by their description
//	    List<Song> findByDescriptionContaining(String search);
	    // this method counts how many titles contain a certain string
	    Long countByTitleContaining(String search);
	    // this method deletes a songs that starts with a specific title
	    Long deleteByTitleStartingWith(String search);
	    //this method find a song by the index
	    List<Song> findSongById(Long id);
		Song save(List<Song> song);
	}//end of LookifyRepository

//Get these free with CrudRepository
//C - Create
//R - Read
//U - Update
//D - Delete