package com.tunehub.main.services;

import java.util.List;

import com.tunehub.main.entities.Song;

public interface SongService {

	public void addService(Song song);

	public List<Song> fetchAllsongs();
	public boolean songExist(String name);

	public void updateSong(Song s);
	

}
