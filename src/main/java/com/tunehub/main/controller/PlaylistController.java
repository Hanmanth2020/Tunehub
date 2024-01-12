package com.tunehub.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.main.entities.Playlist;
import com.tunehub.main.entities.Song;
import com.tunehub.main.services.PlaylistService;
import com.tunehub.main.services.SongService;


@Controller
public class PlaylistController {
	@Autowired
	SongService songservice;
	@Autowired
	PlaylistService playlistservice;

	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		List<Song> songList= songservice.fetchAllsongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}

	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		playlistservice.addPlaylist(playlist);
		List<Song> songList = playlist.getSongs();
		
		for(Song s : songList) {
			s.getPlaylist().add(playlist);
			
			//update song object in database
			songservice.updateSong(s);
		}
		return "adminhome";
	}
	
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model) {
		List<Playlist> allPlaylists = playlistservice.fetchAllPlaylists();
		model.addAttribute("allPlaylists",allPlaylists);
		return "displayplaylist";
	}
	

}
