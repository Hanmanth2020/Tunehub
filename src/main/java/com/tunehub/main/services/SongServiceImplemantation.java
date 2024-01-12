package com.tunehub.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.main.entities.Song;
import com.tunehub.main.repositories.SongRepository;

@Service
public class SongServiceImplemantation implements SongService {

	@Autowired
	SongRepository repo;
	@Override
	public void addService(Song song) {
		// TODO Auto-generated method stub
		repo.save(song);
	}
	@Override
	public List<Song> fetchAllsongs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public boolean songExist(String name) {
		// TODO Auto-generated method stub
		Song song = repo.findByName(name);
		if(song == null) {
			return false;
		}
		return true;
	}
	@Override
	public void updateSong(Song song) {
		repo.save(song);
		
	}

}
