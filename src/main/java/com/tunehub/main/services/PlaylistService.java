package com.tunehub.main.services;

import java.util.List;

import com.tunehub.main.entities.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylists();
	
	

}
