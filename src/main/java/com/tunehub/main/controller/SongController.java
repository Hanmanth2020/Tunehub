package com.tunehub.main.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.main.entities.Song;
import com.tunehub.main.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Song song)
	{
		boolean songStatus = service.songExist(song.getName());
		if(songStatus==false)
		{
			service.addService(song);
			System.out.println("song added");
			
		}
		else {
			System.out.println("song already exist");
		}
		return "adminhome";
		
	}
	
	@GetMapping("/viewsong")
	public String viewsong(Model model)
	{
		boolean premiumuser = false;
		if(premiumuser == true)
		{
			List<Song> songlist = service.fetchAllsongs();
			model.addAttribute("songs", songlist);
			return "displaysongs";
			
		}
		else {
			return "makepayment";
		}
		
	}

}
