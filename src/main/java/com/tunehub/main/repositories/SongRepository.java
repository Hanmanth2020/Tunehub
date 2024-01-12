package com.tunehub.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.main.entities.Song;

public interface SongRepository  extends JpaRepository<Song, Integer>{
	public Song findByName(String name);

}
