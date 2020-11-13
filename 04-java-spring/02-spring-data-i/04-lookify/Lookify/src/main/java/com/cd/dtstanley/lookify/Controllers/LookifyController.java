package com.cd.dtstanley.lookify.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cd.dtstanley.lookify.Models.Song;
import com.cd.dtstanley.lookify.Services.LookifyService;

@Controller
// @RequestMapping("/songs")
public class LookifyController { 	//Create an app for manipulating playlists

	@Autowired		//injecting our service thru a shortcut process
	private LookifyService lookService;	//injecting our service 
	
	//navigate user to home page
	@RequestMapping("")
	public String Index() {
		return "/songs/index.jsp";
	}
	
	//Have a dashboard that shows all the songs
	@RequestMapping("/dashBoard")
    public String start(Model viewModel, @ModelAttribute("song") Song song) {
		List<Song> thisSong = this.lookService.allSongs();
		viewModel.addAttribute("song", thisSong);
		System.out.println("controller output: " + this.lookService.allSongs());
//    return "redirect:/Song/new";
//    return "/Song/newLang.jsp";
    return "/songs/dashBoard.jsp";
	}
	
	//show one song
    @RequestMapping("/thisSong/{id}")
    public String pres(@PathVariable("id") Long id, Model viewModel) {
    	viewModel.addAttribute("song", this.lookService.findSongByIndex(id));
    	return "/songs/dashBoard.jsp";
    }

	//show only one song
    @RequestMapping("/showOne/{id}")
    public String presOne(@PathVariable("id") Long id, Model viewModel) {
    	viewModel.addAttribute("song", this.lookService.findSongByIndex(id));
    	return "/songs/showOne.jsp";
    }

	//Be able to add new songs on a separate page
    @RequestMapping(value="/add")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/songs/newSong.jsp";
		}else {
			lookService.createSong(song);
    	return "redirect:/";
		}
    }

	//Be able to delete songs from the dashbaord
    //Retrieve and delete from database
    @GetMapping("/delete/{id}")
    public String SongDelete(@PathVariable("id") Long id) {
    	this.lookService.deleteSong(id);
    	System.out.println("Song Deleted");
    	return "redirect:/dashBoard";
    }

	//Be able to search by artist name for songs
    @RequestMapping("/search")
    public String Search(@RequestParam(value="artist") String artist, Model viewModel) {
    	if (artist != null) {
    	viewModel.addAttribute("song", lookService.songsContainingArtist(artist));
    	viewModel.addAttribute("artist", artist);
    	System.out.println("output from line 84 of controller: " + lookService.songsContainingArtist(artist));
    	System.out.println("output from line 85 of controller -artist: " + artist);
    	}else {
    		System.out.println("artist = null: " + artist);
    		viewModel.addAttribute("song", lookService.allSongs());
    	}
    	
    	return "songs/searchResults.jsp";
    }

	//See top ten songs in database
    @RequestMapping("/topTen")
    public String TopTen(Model viewModel) {
    	viewModel.addAttribute("song", lookService.topTenByRating());
    	return "/songs/topTResults.jsp";
    }
	//have validations with error messages on song submission.
	
	
}//end of LookifyController class
