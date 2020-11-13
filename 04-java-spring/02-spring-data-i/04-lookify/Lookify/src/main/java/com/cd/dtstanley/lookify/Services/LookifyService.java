package com.cd.dtstanley.lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cd.dtstanley.lookify.Models.Song;
import com.cd.dtstanley.lookify.Repositories.LookifyRepository;

@Service
public class LookifyService {


	// adding the Lookify repository as a dependency
	   private final LookifyRepository lookRepository;

	   //connecting the Lookify service and repository
	    public LookifyService(LookifyRepository lookRepository) {
	        this.lookRepository = lookRepository;
	    }
	   
	    // returns all the songs
	    public List<Song> allSongs() {
	    	return lookRepository.findAll();
	    }
	    
    
	    // retrieves a song
	    public Song findSongByIndex(Long index) {
//	        if (index < Song.size()){
//	            return Song.get(index);
	    	Optional<Song> optionalLang = lookRepository.findById(index);
	    	if(optionalLang.isPresent()) {
	    		return optionalLang.get();
	        }else{
	            return null;
	        }
	    }

	    // creates a song
	    public Song createSong(Song song) {
	        return lookRepository.save(song);
	 //       return this.LookifyRepository.save(song);
	    }
	  
//	    //update a song by calling a service
//	    public Song updateSong(Song updSong) {
//	    	return LookifyRepository.save(updSong);
//	    	}
//	    
	    //delete a song by calling a service
	    public String deleteSong(Long id) {
	    	lookRepository.deleteById(id);
	    	return "Song ID: " + id + "has been deleted.";
	    }
	    
	    //search for songs by artist
	    public List<Song> songsContainingArtist(String artist){
	    	return lookRepository.findByArtistContaining(artist);
	    }
	    
	    //search for top songs by rating
	    public List<Song> topTenByRating(){
	    	return lookRepository.findTop10ByOrderByRatingDesc();
	    }

	   
}//end of LookifyService
